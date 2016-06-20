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
@RequestMapping(value="/address")
public class AddressController {
    private AddressDao addressDao;
    
    @Inject
    public AddressController(AddressDao dao) {
        this.addressDao = dao;
    }
    
    @RequestMapping(value="", method=RequestMethod.POST)
    @ResponseBody
    public Address create(@Valid @RequestBody Address address) {
        return addressDao.create(address);
        
    }
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Address show(@PathVariable("id") int id) {
        Address address = addressDao.get(id);
        
        return address;
    }
    
    @RequestMapping(value="", method=RequestMethod.PUT)
    @ResponseBody
    public Address edit(@Valid @RequestBody Address address) {
        addressDao.update(address);
        return address;
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
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id") int id) {
        
        addressDao.delete(id);
        
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
