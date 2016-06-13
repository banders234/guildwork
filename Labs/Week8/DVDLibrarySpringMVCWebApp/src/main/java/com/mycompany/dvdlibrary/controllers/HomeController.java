/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.controllers;

import com.mycompany.dvdlibrary.dao.DVDDao;
import com.mycompany.dvdlibrary.dto.DVD;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping({"*"})
public class HomeController {
    private DVDDao dvdDao;
    
    @Inject
    public HomeController(DVDDao dvdDao) {
        this.dvdDao = dvdDao;
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String home(Map<String, Object> model) {
        List<DVD> dvds = dvdDao.getAll();
        DVD dvd = new DVD();
        model.put("dvds", dvds);
        model.put("dvd", dvd);     
        return "home";
    }
}
