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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dvd") DVD dvd, BindingResult result, Map<String, Object> model) {
        if (result.hasErrors()) {
            model.put("dvds", dvdDao.getAll());
            model.put("dvd", dvd);
            return "home";    
        }
        dvd.setNoteList(Arrays.asList(dvd.getNotes().split(",")));
        dvdDao.create(dvd);
        return "redirect:/";
    }
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public String edit(@ModelAttribute DVD dvd, Map<String, Object> model) {
        DVD myDvd = dvdDao.get(dvd.getId());
        model.put("myDvd", myDvd);
        return "edit";
    }
    @RequestMapping(value="/delete", method=RequestMethod.GET)
    public String delete(@RequestParam("id") int id) {
        DVD myDvd = dvdDao.get(id);
        dvdDao.delete(myDvd);
        return "redirect:/";
    }
    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String update(@Valid @ModelAttribute DVD dvd, Map<String, Object> model) {
        dvd.setNoteList(Arrays.asList(dvd.getNotes().split(",")));
        dvdDao.update(dvd);
        return "redirect:/";
    }
    @RequestMapping(value="/show", method=RequestMethod.GET)
    public String show(Map<String, Object> model, @ModelAttribute DVD dvd) {
        DVD myDvd = dvdDao.get(dvd.getId());
        model.put("dvd", myDvd);
        return "show";
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
