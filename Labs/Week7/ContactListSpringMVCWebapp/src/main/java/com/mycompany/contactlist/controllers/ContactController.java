/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contactlist.controllers;

import com.mycompany.contactlist.dao.ContactDao;
import com.mycompany.contactlist.dto.Contact;
import java.util.Map;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping(value="/contact")
public class ContactController {
    
    private ContactDao contactDao;
    
    @Inject
    public ContactController(ContactDao dao) {
        this.contactDao = dao;
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("contact") Contact contact, BindingResult result, Map<String, Object> model) {
        if (result.hasErrors()) {
            model.put("contact", contact);
            return "home";
        }
        contactDao.add(contact);
        
        return "redirect:/";
    }
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public String edit(@ModelAttribute Contact contact, Map<String, Object> model) {
        Contact myContact = contactDao.get(contact.getId());
        model.put("contact", myContact);
        return "edit";
    }
    @RequestMapping(value="/delete", method=RequestMethod.GET)
    public String delete(@ModelAttribute Contact contact) {
        contactDao.remove(contact);
        return "redirect:/";
    }
    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String update(@ModelAttribute Contact contact) {
        contactDao.update(contact);
        return "redirect:/";
    }
    @RequestMapping(value="/show", method=RequestMethod.GET)
    public String show(Map<String, Object> model, @ModelAttribute Contact contact) {
        Contact myContact = contactDao.get(contact.getId());
        model.put("contact", myContact);
        return "show";
    }
}
