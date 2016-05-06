/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary;

import java.util.List;

/**
 *
 * @author apprentice
 */
public class DVDController {
    private DVD dvd = new DVD();
    ConsoleIO console = new ConsoleIO();
    private DVDLibrary dvdlib = new DVDLibrary();
    
    public void run() {
        firstChoice();
    }
    private void printUI() {
        console.print("Initial Menu:");
        console.print("\tPlease select the operation you wish to perform:");
        console.print("\t\t1. Add DVD");
        console.print("\t\t2. Delete DVD");
        console.print("\t\t3. Find DVD by title");
        console.print("\t\t4. Display DVD Count");
        console.print("\t\t5. List All DVDs");
        console.print("\t\t6. Exit");
    }
    
    private int userChoice() {
        int choice;
        choice = console.getIntOneLine("> ");
        return choice;
    }
    
    private void firstChoice() {
        int choice;
        do {
            printUI();
            choice = userChoice();
            switch (choice) {
                case 1:
                    dvd = dvdInfo();
                    dvdlib.create(dvd);
                    break;
                case 2:
                    deleteAddress();
                    break;
                case 3:
                    find();
                    break;
                case 4:
                    getCount();
                    break;
                case 5:
                    listAll();
                    break;
                case 6:
                    console.print("Goodbye!");
                    break;
                default:
                    console.print("Invalid choice!");
                    break;
            }
        } while(choice != 7);
    }
    
    
    public DVD dvdInfo() {
        

        String title, releaseDate, mpaa, director, studio;
        int userRating;
        title = console.forceString("Please Enter Title: ");
        releaseDate = console.forceString("Please Enter Release Date: ");
        mpaa = console.forceString("Please Enter MPAA Rating: ");
        director = console.forceString("Please Enter Director: ");
        studio = console.forceString("Please Enter Studio: ");
        userRating = console.getIntMinMax("Please Enter User Rating (1-10):", 1, 10);
        dvd.setTitle(title);
        dvd.setReleaseDate(releaseDate);
        dvd.setMpaa(mpaa);
        dvd.setDirector(director);
        dvd.setStudio(studio);
        dvd.setUserRating(userRating);
        return dvd;
    }
    
    public List<DVD> find() {
        List<DVD> myDvds;
        String lastName = console.getStringOneLine("Please enter title of DVD to find: ");
        myDvds = dvdlib.find(lastName);
        return myDvds;
    }
    public void deleteAddress() {
        List<DVD> myDvds;
        myDvds = find();
        display(myDvds);
        if (myDvds.size() > 0) {
            int choice = console.getIntMinMax("Enter number of the DVD you wish to delete:", 0, myDvds.size());
            dvd = myDvds.get(choice -1);
            dvdlib.delete(dvd);
        }
        else {
            console.print("No DVDs found by that title!");
        }
    }
    
    public void getCount() {
        console.print("There are " + dvdlib.getCount() + " DVDs in the dvd library.");
    }
    
    public void listAll() {
        List<DVD> dvds = dvdlib.getAll();
        display(dvds);
    }
    public void edit() {
        List<DVD> myDVDs = find();
        display(myDVDs);
        int choice = console.getIntMinMax("Enter number of the DVD you wish to edit: ", 0, myDVDs.size() -1);
        dvd = myDVDs.get(choice -1);
        dvd = dvdInfo();
        dvdlib.update(dvd);
        
    }
    
    public void display(List<DVD> myDvds) {
        int counter = 1;
        for (DVD d : myDvds) {
            console.print("DVD " + counter);
            console.print(d.getTitle());
            console.print("Released " + d.getReleaseDate());
            console.print("Rated " + d.getMpaa());
            console.print("Director: " + d.getDirector());
            console.print("Studio: " + d.getStudio());
            console.print("User Rating: " + d.getUserRating() + "/10");
            counter++;
        }
        
    }
}
