/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentquizscores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public class StudentInfoRW {
    ConsoleIO console = new ConsoleIO();
    public void loadFile (HashMap <Integer, Student> studentInfo) {
        try {
            File toRead=new File("idsAndNames.ser");
            FileInputStream fis= new FileInputStream(toRead);
            ObjectInputStream ois= new ObjectInputStream(fis);
            HashMap<Integer,String> idsAndNames=(HashMap<Integer,String>)ois.readObject();
            ois.close();
            fis.close();
            File toRead2=new File("idsAndGrades.ser");
            FileInputStream fis2= new FileInputStream(toRead2);
            ObjectInputStream ois2= new ObjectInputStream(fis2);
            HashMap<Integer,Object> idsAndGrades=(HashMap<Integer, Object>)ois2.readObject();
            ois2.close();
            fis2.close();
            Collection<Integer> ids = idsAndGrades.keySet();
            for (int id : ids) {
                ArrayList<Double> grades = (ArrayList<Double>) idsAndGrades.get(id);
                String studentName=idsAndNames.get(id);
                Student student = new Student(studentName, grades);
                studentInfo.put(id, student);
            }
        }
        catch(IOException | ClassNotFoundException e) {
            System.out.println("File read error!");
        }  
    }
    public void writeFile(HashMap <Integer, Student> studentInfo) {
        HashMap<Integer, ArrayList<Double>> idsGrades = new HashMap<>();
        HashMap<Integer, String> idsNames = new HashMap<>();
        ArrayList<Double> grades;
        String studentName;
        Collection<Integer> ids = studentInfo.keySet();
        for (int id : ids) {
            grades = studentInfo.get(id).getQuizScores();
            studentName = studentInfo.get(id).getName();
            idsGrades.put(id, grades);
            idsNames.put(id, studentName);
        }
        try
        (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("idsAndGrades.ser"))) {
            os.writeObject(idsGrades);
        }
        catch(Exception ex){
            console.print("File write error!");
        }
        try
        (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("idsAndNames.ser"))) {
            os.writeObject(idsNames);
            os.close();
        }
        catch(Exception ex){
            console.print("File write error!");
        }
    }  
}
