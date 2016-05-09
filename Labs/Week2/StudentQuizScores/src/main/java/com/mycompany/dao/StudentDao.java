/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class StudentDao {
    List<Student> students = decode();
    private int nextId = 1;
    
    public Student create(Student student) {
        List<Integer> idList = new ArrayList<>();
        for (Student myStudent : students) {
            idList.add(myStudent.getId());
        }
        while (idList.contains(nextId)) {
            nextId++;
        }
        student.setId(nextId);
        students.add(student);
        encode();
        return student;
    }
    
    public void delete(Student student) {
        students.remove(student);
        encode();
    }
    
    public void update(Student student) {
        for (Student myStudent : students)  {
            if (myStudent.getId() == student.getId()) {
                students.remove(myStudent);
                students.add(student);
            }
        }
        encode();
    }
    
    public List<Student> find(String lastName) {
        List<Student> studentl = new ArrayList<>();
        Student student = new Student();
        for (Student s : students) {
            if ((s.getLastName()).equals(lastName)) {
                studentl.add(s);
            }
        }
        return studentl;
    }
    
    public Student findStudentById(int id) {
        Student student = new Student();
        for (Student myStudent : students){
            if (myStudent.getId() == id) {
                return myStudent;
            }
        }
        return student;
    }
    
    public boolean checkIfIdExists(int id) {
        for (Student myStudent : students)  {
            if (id == myStudent.getId()) {
                return true;
            }
        }
        return false;
    }
    
    public int getCount() {
        return students.size();
    }
    
    public List<Student>  getAll() {
        
        return students;
    }
    public void encode() {

        final String TOKEN = "::";
        final String TOKEN2 = "--";
        try {
            PrintWriter out = new PrintWriter(new FileWriter("students.txt"));
            for (Student myStudent : students) {
                int id = myStudent.getId();
                String listString = "";
                List<Double> arr = myStudent.getQuizScores();
                for (Double i : arr) {
                    String str = String.valueOf(i);
                    listString += str + TOKEN2;
                }
                out.print(id);
                out.print(TOKEN);
                out.print(myStudent.getFirstName());
                out.print(TOKEN);

                out.print(myStudent.getLastName());
                out.print(TOKEN);

                out.println(listString);
            }
            out.flush();
            out.close();
        } catch (Exception ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Student> decode() {
        List<Student> studentList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("students.txt")));
            String TOKEN2 = "--";
            while (sc.hasNextLine()) {
                Student myStudent = new Student();
                String currentLine = sc.nextLine();
                String[] stringParts = currentLine.split("::");

                int id = Integer.parseInt(stringParts[0]);

                String firstName = stringParts[1];
                String lastName = stringParts[2];
                ArrayList<String> sgrades = new ArrayList<>(Arrays.asList(stringParts[3].split(TOKEN2)));
                ArrayList<Double> grades = new ArrayList<>();
                for (String s : sgrades) {
                    grades.add(Double.parseDouble(s));
                }
                myStudent.setId(id);
                myStudent.setFirstName(firstName);
                myStudent.setLastName(lastName);
                myStudent.setQuizScores(grades);
                
                studentList.add(myStudent);
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studentList;
    }
    
}
