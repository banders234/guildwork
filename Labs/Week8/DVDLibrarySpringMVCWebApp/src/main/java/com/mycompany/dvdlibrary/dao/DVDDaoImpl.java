/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.dao;

import com.mycompany.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class DVDDaoImpl implements DVDDao {
    List<DVD> dvds = decode();
    private int nextId = 1;
    
    @Override
    public DVD create(DVD dvd) {
        
        dvd.setId(nextId);
        if (dvd.getNotes() == null) {
            dvd.setNoteList(new ArrayList());
        }
        nextId++;
        dvds.add(dvd);
        encode();
        return dvd;
    }
    
    @Override
    public void delete(DVD dvd) {
        dvds.remove(dvd);
        encode();
    }
    
    @Override
    public void update(DVD dvd) {
        for (DVD myDvd : dvds)  {
            if (myDvd.getId() == dvd.getId()) {
                dvds.remove(myDvd);
                dvds.add(dvd);
            }
        }
        encode();
    }
    @Override
    public DVD get(int id) {
        for (DVD dvd : dvds) {
            if (dvd.getId() == id) {
                return dvd;
            }
        }
        return null;
    }
    @Override
    public List<DVD> findByTitle(String title) {
        List<DVD> dvdl = new ArrayList<>();
        DVD dvd = new DVD();
        for (DVD d : dvds) {
            if ((d.getTitle()).equals(title)) {
                dvdl.add(d);
            }
        }
        return dvdl;
    }
    
    @Override
    public List<DVD> findByAge(int years) {
        List<DVD> dvdl = new ArrayList();
        Date date = new Date();
        for (DVD d : dvds) {
            long diff = date.getTime() - d.getReleaseDate().getTime();
            double diffInDays = (diff/(1000*60*60*24));
            double diffInYears = diffInDays/365;
            if (diffInYears < years) {
                dvdl.add(d);
            }
        }
        return dvdl;
    }
    
    @Override
    public List<DVD> findByMPAA(String mpaa) {
        
        List<DVD> dvdl = new ArrayList();
        for (DVD d : dvds) {
            if (mpaa.equals(d.getMpaa())) {
                dvdl.add(d);
            }
        }
        
        return dvdl;
    }
    
    @Override
    public List<DVD> findByDirector(String director) {
        return dvds
                .stream()
                .filter(d -> d.getDirector().equalsIgnoreCase(director))
                .sorted(Comparator.comparing(d -> d.getMpaa()))
                .collect(Collectors.toList());
        
        
    }
    
    @Override
    public List<DVD> findByStudio(String studio) {
        
        List<DVD> dvdl = new ArrayList();
        for (DVD d : dvds) {
            if (studio.equalsIgnoreCase(d.getStudio())) {
                dvdl.add(d);
            }
        }
        
        return dvdl;
    }
    
    @Override
    public double findAverageAge() {
        double average, sum = 0;
        Date date = new Date();
        for (DVD d : dvds) {
            long diff = date.getTime() - d.getReleaseDate().getTime();
            double diffInDays = (diff/(1000*60*60*24));
            double diffInYears = diffInDays/365;
            sum += diffInYears;
        }
        average = sum/dvds.size();
        return average;
    }
    
    @Override
    public DVD findNewest() {
        DVD myDvd = new DVD();
        Date date = new Date();
        if (dvds.size() > 0) {
            long lowestDiff = date.getTime() - dvds.get(0).getReleaseDate().getTime();
            for (DVD d : dvds) {
                long diff = date.getTime() - d.getReleaseDate().getTime();
                if (diff < lowestDiff) {
                    myDvd = d;
                }
            }
        }
        return myDvd;
    }
    
    @Override
    public DVD findOldest() {
        DVD myDvd = new DVD();
        Date date = new Date();
        long highestDiff = 0;
        for (DVD d : dvds) {
            long diff = date.getTime() - d.getReleaseDate().getTime();
            if (diff > highestDiff) {
                myDvd = d;
            }
        }
        return myDvd;
    }
    
    @Override
    public double findAverageNotes() {
        double average, sum = 0;
        for (DVD d : dvds) {
            sum+= d.getNoteList().size();
        }
        average = sum/dvds.size();
        
        return average;
    }
    
    @Override
    public int getCount() {
        return dvds.size();
    }
    
    @Override
    public List<DVD>  getAll() {
        
        return dvds;
    }
        private void encode() {
        final String TOKEN = "::";
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        try {
                PrintWriter out = new PrintWriter(new FileWriter("dvds.txt"));
                for (DVD myDvd : dvds) {
                    out.print(myDvd.getId());
                    out.print(TOKEN);
                                        
                    out.print(myDvd.getTitle());
                    out.print(TOKEN);
                    
                    out.print(sdf.format(myDvd.getReleaseDate()));
                    out.print(TOKEN);

                    out.print(myDvd.getMpaa());
                    out.print(TOKEN);

                    out.print(myDvd.getDirector());
                    out.print(TOKEN);

                    out.print(myDvd.getStudio());
                    out.print(TOKEN);

                    out.print(myDvd.getUserRating());
                    out.print(TOKEN);
                    
                    if (myDvd.getNotes().isEmpty()) {
                        out.print("none");
                    }
                    for (String n: myDvd.getNoteList()) {
                        out.print(n);
                        out.print("--");
                    }
                    out.println();

                }
                out.flush();
                out.close();

            } catch(IOException ex) {
                System.out.println("File write error!");
            }


    }
    
    private List<DVD> decode() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
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
                String str = stringParts[2];
                System.out.println(str);
                System.out.println();
                Date date = sdf.parse(str);
                myDvd.setReleaseDate(date);
                myDvd.setMpaa(stringParts[3]);
                myDvd.setDirector(stringParts[4]);
                myDvd.setStudio(stringParts[5]);
                myDvd.setUserRating(Integer.parseInt(stringParts[6]));
                
                List<String> notes;
                
                if (stringParts[7].equals("empty")) {
                    notes = new ArrayList();
                    myDvd.setNoteList(notes);
                }
                else {
                    notes = Arrays.asList(stringParts[7].split("--"));
                    myDvd.setNoteList(notes);
                }
                studentList.add(myDvd);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File read error!");
        }
        catch (ParseException pe) {
            System.out.println("Date saved is in invalid format!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
        }
}
