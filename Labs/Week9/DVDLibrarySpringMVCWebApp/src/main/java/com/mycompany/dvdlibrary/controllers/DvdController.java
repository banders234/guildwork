/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.controllers;


import com.mycompany.dvdlibrary.dao.DVDDao;
import com.mycompany.dvdlibrary.dao.GenreDao;
import com.mycompany.dvdlibrary.dao.NoteDao;
import com.mycompany.dvdlibrary.dto.DVD;
import com.mycompany.dvdlibrary.dto.Note;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
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
import org.json.*;
/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping(value="/dvd")
public class DvdController {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private DVDDao dvdDao;
    private NoteDao noteDao;
    private GenreDao genreDao;
    @Inject
    public DvdController(DVDDao dao, NoteDao noteDao, GenreDao genreDao) {
        this.dvdDao = dao;
        this.noteDao = noteDao;
        this.genreDao = genreDao;
    }
    
    @RequestMapping(value="", method=RequestMethod.POST)
    @ResponseBody
    public DVD create(@Valid @RequestBody DVD dvd) {
        DVD myDvd = dvdDao.create(dvd);
        List<Note> noteObjectList = new ArrayList();
        for (String myNote : dvd.getNoteList()) {
            Note note = new Note();
            note.setDvdId(myDvd.getId());
            note.setNoteText(myNote);
            note=noteDao.create(note);
            noteObjectList.add(note);
        }
        myDvd.setNoteObjectList(noteObjectList);
        return myDvd;
    }
    @RequestMapping(value="/search/link", method=RequestMethod.POST)
    @ResponseBody
    public DVD createFromLink(@RequestBody DVD dvd) {
        DVD myDvd = dvdDao.create(dvd);
        List<Note> noteObjectList = new ArrayList();
        if (dvd.getNoteList() != null) {
            for (String myNote : dvd.getNoteList()) {
                Note note = new Note();
                note.setDvdId(myDvd.getId());
                note.setNoteText(myNote);
                note=noteDao.create(note);
                noteObjectList.add(note);
            }
        }
        List<String> myGenreList = dvd.getGenreList();
        List<String> genreList = genreDao.list();
        for(String genre : myGenreList) {
            if (!genreList.contains(genre)) {
                genreDao.create(genre);
            }
            genreDao.createDvdGenreLink(genre, dvd.getId());
        }
        myDvd.setNoteObjectList(noteObjectList);
        return myDvd;
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
        noteDao.deleteOnDvd(id);
        genreDao.deleteOnDvd(id);
    }
    
    @RequestMapping(value="", method=RequestMethod.PUT)
    @ResponseBody
    public DVD update(@Valid @RequestBody DVD dvd) {
        List<Note> noteObjectList = noteDao.list(dvd.getId());
        System.out.println(dvd.getId());
        for (Note note : noteObjectList) {
            noteDao.delete(note.getId());
        }
        for (String myNote : dvd.getNoteList()) {
            Note note = new Note();
            note.setDvdId(dvd.getId());
            note.setNoteText(myNote);
            note=noteDao.create(note);
            noteObjectList.add(note);
        }
        dvdDao.update(dvd);
        
        return dvd;
    }
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public DVD show(@PathVariable("id") Integer id) {
        DVD myDvd = dvdDao.get(id);
        List<Note> noteList = noteDao.list(id);
        List<String> myNoteStringList = new ArrayList();
        for (Note note : noteList) {
            myNoteStringList.add(note.getNoteText());
        }
        myDvd.setNoteList(myNoteStringList);
        List<String> genreList = genreDao.getOnDvd(id);
        myDvd.setGenreList(genreList);
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
    @RequestMapping(value="/link", method=RequestMethod.PUT)
    @ResponseBody
    public DVD link(@RequestBody DVD dvd) {
        DVD myDvd = dvdDao.get(dvd.getId());
        myDvd.setImdbId(dvd.getImdbId());
        myDvd.setDirector(dvd.getDirector());
        myDvd.setTitle(dvd.getTitle());
        myDvd.setReleaseDate(dvd.getReleaseDate());
        myDvd.setMpaa(dvd.getMpaa());
        myDvd.setPosterLink(dvd.getPosterLink());
        myDvd.setGenreList(dvd.getGenreList());
        System.out.println(dvd.getImdbRating());
        genreDao.deleteOnDvd(dvd.getId());
        List<String> myGenreList = dvd.getGenreList();
        List<String> genreList = genreDao.list();
        for(String genre : myGenreList) {
            if (!genreList.contains(genre)) {
                genreDao.create(genre);
            }
            genreDao.createDvdGenreLink(genre, dvd.getId());
        }
        myDvd.setPlot(dvd.getPlot());
        myDvd.setAwards(dvd.getAwards());
        myDvd.setImdbRating(dvd.getImdbRating());
        myDvd.setCountry(dvd.getCountry());
        myDvd.setImdbVotes(dvd.getImdbVotes());
        myDvd.setMetascore(dvd.getMetascore());
        myDvd.setActors(dvd.getActors());
        System.out.println(dvd.getActors());
        dvdDao.update(myDvd);
        System.out.println(dvd.getImdbId());
        return myDvd;
    }
    
    
    @RequestMapping(value="/stats", method=RequestMethod.GET)
    public String stats(Map <String, Object> model) {
        if (!dvdDao.getAll().isEmpty()) {
            DVD newest = dvdDao.findNewest().get(0);
            DVD oldest = dvdDao.findOldest().get(0);
            double averageAge = dvdDao.findAverageAge();
            double averageNotes = dvdDao.findAverageNotes();
            Map<String,Integer> genreCount = genreDao.genreCount();
            int count = dvdDao.getCount();
            model.put("count", count);        
            model.put("newest", newest);
            model.put("oldest", oldest);
            model.put("averageAge", averageAge);
            model.put("averageNotes", averageNotes);
            model.put("genreCount", genreCount);
        }
        else {
            model.put("averageAge", 0);
        }
        
        
        return "stats";
    }
    @RequestMapping(value="/search", method=RequestMethod.POST)
    public String search(@RequestParam("srch-type") String searchType, @RequestParam("srch-term") String searchValue, Map<String, Object> model) {
        List<DVD> dvds = new ArrayList();
        switch(searchType) {
            case "All":
                try {
                    searchValue=URLEncoder.encode(searchValue, "UTF-8");
                    URL quote = new URL("http://www.omdbapi.com/?s=" + searchValue);
                    BufferedReader in = new BufferedReader(new InputStreamReader(quote.openStream()));
                    String inputLine, str="";
                    while ((inputLine= in.readLine()) !=null) {
                        str+=inputLine;
                    }
                    System.out.println(str);
                    JSONObject obj = new JSONObject(str);
                    JSONArray arr = obj.getJSONArray("Search");
                    for (int i = 0; i < arr.length(); i++) {
                        DVD myDVD = new DVD();
                        myDVD.setImdbId(arr.getJSONObject(i).getString("imdbID"));
                        myDVD.setTitle(arr.getJSONObject(i).getString("Title"));
                        myDVD.setPosterLink(arr.getJSONObject(i).getString("Poster"));
                        myDVD.setYear(arr.getJSONObject(i).getString("Year"));
                        dvds.add(myDVD);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(DvdController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
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
        return "searchresults";
    }
}
