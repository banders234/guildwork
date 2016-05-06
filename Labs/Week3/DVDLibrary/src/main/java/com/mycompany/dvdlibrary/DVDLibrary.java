/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class DVDLibrary {
    List<DVD> dvds = decode();
    private int nextId = 1;
    
    public DVD create(DVD dvd) {
        
        dvd.setId(nextId);
        
        nextId++;
        dvds.add(dvd);
        encode();
        return dvd;
    }
    
    public void delete(DVD dvd) {
        dvds.remove(dvd);
        encode();
    }
    
    public void update(DVD dvd) {
        for (DVD myDvd : dvds)  {
            if (myDvd.getId() == dvd.getId()) {
                dvds.remove(myDvd);
                dvds.add(dvd);
            }
        }
        encode();
    }
    
    public List<DVD> find(String title) {
        List<DVD> dvdl = new ArrayList<>();
        DVD dvd = new DVD();
        for (DVD d : dvds) {
            if ((d.getTitle()).equals(title)) {
                dvdl.add(d);
            }
        }
        return dvdl;
    }
    
    
    public int getCount() {
        return dvds.size();
    }
    
    public List<DVD>  getAll() {
        
        return dvds;
    }
        private void encode() {
        final String TOKEN = "::";

        try {
                PrintWriter out = new PrintWriter(new FileWriter("dvds.txt"));
                for (DVD myDvd : dvds) {
                    out.print(myDvd.getId());
                    out.print(TOKEN);
                                        
                    out.print(myDvd.getTitle());
                    out.print(TOKEN);
                    
                    out.print(myDvd.getReleaseDate());
                    out.print(TOKEN);

                    out.print(myDvd.getMpaa());
                    out.print(TOKEN);

                    out.print(myDvd.getDirector());
                    out.print(TOKEN);

                    out.print(myDvd.getStudio());
                    out.print(TOKEN);

                    out.print(myDvd.getUserRating());
                    out.print(TOKEN);

                }
                out.flush();
                out.close();

            } catch(IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }


    }
    
    private List<DVD> decode() {
        List<DVD> studentList = new ArrayList();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("dvds.txt")));

            while (sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                String[] stringParts= currentLine.split("::");
                DVD myDvd = new DVD();

                int id = Integer.parseInt(stringParts[0]);

                myDvd.setId(id);
                myDvd.setTitle(stringParts[1]);
                myDvd.setReleaseDate(stringParts[2]);
                myDvd.setMpaa(stringParts[3]);
                myDvd.setDirector(stringParts[4]);
                myDvd.setStudio(stringParts[5]);
                myDvd.setUserRating(Integer.parseInt(stringParts[6]));


                studentList.add(myDvd);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        return studentList;
        }
}
