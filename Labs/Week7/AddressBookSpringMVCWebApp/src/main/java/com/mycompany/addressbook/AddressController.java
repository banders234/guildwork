/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbook;

import com.mycompany.addressbook.dao.AddressDao;
import com.mycompany.addressbook.dto.Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
@RequestMapping(value="/address")
public class AddressController {
    private AddressDao addressDao;
    
    @Inject
    public AddressController(AddressDao dao) {
        this.addressDao = dao;
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("address") Address address, BindingResult result, Map<String, Object> model) {
        if (result.hasErrors()) {
            List<Address> addresses = addressDao.list();
            model.put("addresses", addresses);
            model.put("address", address);
            return "home";
        }
        addressDao.create(address);
        
        return "redirect:/";
    }
    @RequestMapping(value="/show", method=RequestMethod.GET)
    public String show(@RequestParam("id") int id, Map<String, Object> model) {
        Address address = addressDao.get(id);
        
        model.put("address", address);
        
        return "show";
    }
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public String edit(@RequestParam("id") int id, Map<String, Object> model) {
        Address address = addressDao.get(id);
        
        model.put("address", address);
        
        return "edit";
    }
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public String editSubmit(@Valid @ModelAttribute("address") Address address, BindingResult result, Map<String, Object> model) {
        if (result.hasErrors()) {
            model.put("address", address);
            return "edit";
        }
        addressDao.update(address);
        model.put("address", address);
        
        return "redirect:/";
    }
    @RequestMapping(value="/delete", method=RequestMethod.GET)
    public String delete(@RequestParam("id") int id, Map<String, Object> model) {

        addressDao.delete(id);
        
        return "redirect:/";
    }
    @RequestMapping(value="/table", method=RequestMethod.GET)
    public String fullTable(Map<String, Object> model) {
        
        List<Address> addresses = addressDao.list();
        model.put("addresses", addresses);
        return "fulltable";
    }
    @RequestMapping(value="/search", method=RequestMethod.POST)
    public String search(@RequestParam("searchType") String searchType, @RequestParam("searchValue") String searchValue, Map<String, Object> model) {
        List<Address> addresses = new ArrayList();
        switch(searchType) {
            case "city":
                addresses = addressDao.searchByCity(searchValue);
                break;
            case "state":
                addresses = addressDao.searchByState(searchValue);
                break;
            case "lastName":
                addresses = addressDao.searchByLastName(searchValue);
                break;
            case "zip":
                addresses = addressDao.searchByZip(searchValue);
                break;
            default:
                break;
        }
        if (addresses.isEmpty()) {
            model.put("emptyMessage", "No records match that search value!");
        }
        model.put("addresses", addresses);
        return "fulltable";
    }
}
