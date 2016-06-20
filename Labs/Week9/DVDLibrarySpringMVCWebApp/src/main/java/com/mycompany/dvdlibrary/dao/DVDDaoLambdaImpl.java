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
public class DVDDaoLambdaImpl implements DVDDao {
    List<DVD> dvds = decode();
    private int nextId = 1;
    
    @Override
    public DVD create(DVD dvd) {
        List<Integer> idList = new ArrayList<>();
        for (DVD myDvd : dvds) {
            idList.add(myDvd.getId());
        }
        while (idList.contains(nextId)) {
            nextId++;
        }
        dvd.setId(nextId);
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
    public DVD get(Integer id) {
        for (DVD dvd : dvds) {
            if (dvd.getId() == id) {
                return dvd;
            }
        }
        return null;
    }
    
    @Override
    public List<DVD> findByTitle(String title) {
        return dvds.stream()
                .filter(d -> d.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<DVD> findByAge(int years) {
        Date date = new Date();
        double milliInDay = (1000*60*60*24*365);
        return dvds.stream()
                .filter(d -> (((date.getTime() - d.getReleaseDate().getTime())/milliInDay)/365) < years)
                .collect(Collectors.toList());
        }
    
    
    @Override
    public List<DVD> findByMPAA(String mpaa) {
        
        return dvds.stream()
                .filter(d -> d.getMpaa().equalsIgnoreCase(mpaa))
                .collect(Collectors.toList());
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
        
        return dvds
                .stream()
                .filter(d -> d.getStudio().equalsIgnoreCase(studio))
                .collect(Collectors.toList());
    }
    
    @Override
    public double findAverageAge() {
        Date date = new Date();
        double milliInDay = (1000*60*60*24);
        return dvds
                .stream()
                .mapToDouble(d-> ((date.getTime() - d.getReleaseDate().getTime())/milliInDay)/365)
                .average()
                .getAsDouble();
    }
    
    @Override
    public List<DVD> findNewest() {
        DVD dvd = dvds
                .stream()
                .max(Comparator.comparing(DVD::getReleaseDate))
                .get();
        return dvds
                .stream()
                .filter(d -> d.getReleaseDate() == dvd.getReleaseDate())
                .collect(Collectors.toList());
    }
    
    @Override
    public List<DVD> findOldest() {
        DVD dvd = dvds
                .stream()
                .min(Comparator.comparing(DVD::getReleaseDate))
                .get();
        return dvds
                .stream()
                .filter(d -> d.getReleaseDate() == dvd.getReleaseDate())
                .collect(Collectors.toList());
    }
    
    @Override
    public double findAverageNotes() {
        try {
            return dvds
                .stream()
                .filter(d -> d.getNoteList() != null)
                .mapToInt(d-> (d.getNoteList().size()))
                .average()
                .getAsDouble();
        } catch(Exception e) {
            
        }
        return 0;
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
            PrintWriter out = new PrintWriter(new FileWriter("/home/apprentice/ProgramData/DVDLibrary/dvds.txt"));
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
                if (myDvd.getNoteList() != null) {
                    if (myDvd.getNoteList().isEmpty()) {
                        out.print("none");
                    }
                    for (String n: myDvd.getNoteList()) {
                        out.print(n);
                        out.print("--");
                    }
                }
                out.println();

            }
            out.flush();
            out.close();

        } catch(IOException ex) {
            System.out.println("File error!");
        }


    }
    
    private List<DVD> decode() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        List<DVD> studentList = new ArrayList();
        try {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
            Scanner sc = new Scanner(new BufferedReader(new FileReader("/home/apprentice/ProgramData/DVDLibrary/dvds.txt")));
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
                List<String> notes = new ArrayList();
                System.out.println(stringParts.length);
                if (stringParts.length > 7) {
                    if (stringParts[7].equals("empty")) {
                        myDvd.setNoteList(notes);
                    }
                    else {
                        notes = Arrays.asList(stringParts[7].split("--"));
                        myDvd.setNoteList(notes);
                    }
                }
                myDvd.setNoteList(notes);
                studentList.add(myDvd);
            }
        } catch (FileNotFoundException ex) {
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
