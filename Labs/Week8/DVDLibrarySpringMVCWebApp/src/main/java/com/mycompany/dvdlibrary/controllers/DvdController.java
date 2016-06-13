/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.controllers;


import com.mycompany.dvdlibrary.dao.DVDDao;
import com.mycompany.dvdlibrary.dto.DVD;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping(value="/dvd")
public class DvdController {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private DVDDao dvdDao;
    @Inject
    public DvdController(DVDDao dao) {
        this.dvdDao = dao;
    }
    
    @RequestMapping(value="", method=RequestMethod.POST)
    @ResponseBody
    public DVD create(@Valid @RequestBody DVD dvd) {
        dvd.setNoteList(Arrays.asList(dvd.getNotes().split(",")));
        return dvdDao.create(dvd);
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public String edit(@ModelAttribute DVD dvd, Map<String, Object> model) {
        DVD myDvd = dvdDao.get(dvd.getId());
        model.put("dvd", myDvd);
        return "edit";
    }
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id") int id) {
        DVD myDvd = dvdDao.get(id);
        dvdDao.delete(myDvd);
    }
    
    @RequestMapping(value="", method=RequestMethod.PUT)
    @ResponseBody
    public DVD update(@Valid @RequestBody DVD dvd) {
        dvd.setNoteList(Arrays.asList(dvd.getNotes().split(",")));
        dvdDao.update(dvd);
        return dvd;
    }
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public DVD show(@PathVariable("id") int id) {
        DVD myDvd = dvdDao.get(id);
        return myDvd;
    }
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(@Valid @ModelAttribute DVD dvd) {
        dvdDao.create(dvd);
        return "redirect:/";
    }
    @RequestMapping(value="/discard", method=RequestMethod.POST)
    public String discard() {
        return "redirect:/";
    }
    @RequestMapping(value="/table", method=RequestMethod.GET)
    public String table(Map<String, Object> model) {
        
        List<DVD> dvds = dvdDao.getAll();
        model.put("dvds", dvds);
        
        return "fulltable";
    }
    
    
    
    @RequestMapping(value="/stats", method=RequestMethod.GET)
    public String stats(Map <String, Object> model) {
        DVD newest = dvdDao.findNewest();
        DVD oldest = dvdDao.findOldest();
        double averageAge = dvdDao.findAverageAge();
        double averageNotes = dvdDao.findAverageNotes();
        int count = dvdDao.getCount();
        
        
        model.put("count", count);        
        model.put("newest", newest);
        model.put("oldest", oldest);
        model.put("averageAge", averageAge);
        model.put("averageNotes", averageNotes);
        
        return "stats";
    }
    @RequestMapping(value="/search", method=RequestMethod.POST)
    public String search(@RequestParam("searchType") String searchType, @RequestParam("searchValue") String searchValue, Map<String, Object> model) {
        List<DVD> dvds = new ArrayList();
        switch(searchType) {
            case "age":
                dvds = dvdDao.findByAge(Integer.parseInt(searchValue));
                break;
            case "mpaa":
                dvds = dvdDao.findByMPAA(searchValue);
                break;
            case "studio":
                dvds = dvdDao.findByStudio(searchValue);
                break;
            case "title":
                dvds = dvdDao.findByTitle(searchValue);
                break;
            case "director":
                dvds = dvdDao.findByDirector(searchValue);
                break;
            default:
                break;
        }
        if (dvds.isEmpty()) {
            model.put("emptyMessage", "No records match that search value!");
        }
        model.put("dvds", dvds);
        return "fulltable";
    }
}
