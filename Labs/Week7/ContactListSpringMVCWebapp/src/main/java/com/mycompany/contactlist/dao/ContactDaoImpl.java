/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.contactlist.dao;

import com.mycompany.contactlist.dto.Contact;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class ContactDaoImpl implements ContactDao {
    
    List<Contact> data = new ArrayList();
    
    private int nextId = 1;
    
    @Override
    public Contact add(Contact contact) {
        List<Integer> idList = new ArrayList();
        for (Contact myContact : data) {
            idList.add(myContact.getId());
        }
        while(true) {
            if (!idList.contains(nextId)) {
                break;
            }
            nextId++;
        }
        contact.setId(nextId);
        data.add(contact);
        return contact;
    }

    @Override
    public void update(Contact contact) {
        for (Contact myContact : data) {
            if (contact.getId() == myContact.getId()) {
                data.remove(myContact);
                data.add(contact);
                break;
            }
        }        
    }

    @Override
    public void remove(Contact contact) {
        for (Contact myContact : data) {
            if (myContact.getId() == contact.getId()) {
                data.remove(myContact);
                break;
            }
        }        
    }

    @Override
    public Contact get(Integer id) {
        for (Contact myContact : data) {
            if (myContact.getId() == id) {
                return myContact;
            }
        }
        return null;
    }

    @Override
    public List<Contact> list() {
        return new ArrayList(data);
    }
    
}
