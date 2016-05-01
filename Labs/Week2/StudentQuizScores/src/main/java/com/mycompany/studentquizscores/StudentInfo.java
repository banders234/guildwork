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
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class StudentInfo implements Serializable {
    
    HashMap<Integer, Student> studentInfo = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    ConsoleIO console = new ConsoleIO();
    public void currentStudents() {
        ArrayList<Double> currentGrades = new ArrayList<>();
        currentGrades.add(89.0);
        currentGrades.add(76.0);
        currentGrades.add(45.0);
        currentGrades.add(82.0);
        Student bobJenkins = new Student("Bob Jenkins",currentGrades);
        studentInfo.put(1001, bobJenkins);
    }
    public void loadFile(){
        

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
    public void writeFile() {
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

        
    
    public void viewUI() {
        loadFile();
        String studentName;
        int choice;
        int studentID;
        do {
            console.print("What would you like to do?");
            console.print("1. View Students ");
            console.print("2. Add Student ");
            console.print("3. Remove Student ");
            console.print("4. View Scores for a Student ");
            console.print("5. View Average ");
            console.print("6. View Class Average ");
            console.print("7. View Highest/Lowest Average ");
            console.print("8. Add Grades to Current Student");
            console.print("9. Exit ");
            choice = console.getIntWithDef("Enter number for choice", 10);
            switch(choice) {
                case 1:
                    viewStudents();
                    break;
                case 2:
                    studentName = promptForStudentName();
                    studentID = makeStudentID();
                    ArrayList<Double> newGrades = new ArrayList<>();
                    promptForAddStudentGrades(studentName, studentID, newGrades, false);
                    break;
                case 3:
                    viewStudents();
                    studentID = promptForStudentID();
                    removeStudent(studentID);
                    break;
                case 4:
                    viewStudents();
                    studentID = promptForStudentID();
                    viewStudentScores(studentID);
                    break;
                case 5:
                    viewStudents();
                    studentID= promptForStudentID();
                    viewStudentAverage(studentID);
                    break;
                case 6:
                    getClassAverage();
                    break;
                case 7:
                    getHighestAverage();
                    getLowestAverage();
                    break;
                case 8:
                    viewStudents();
                    studentID = promptForStudentID();
                    addGradesCurrentStudent(studentID);
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    writeFile();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    System.out.println("===============");
                    break;
            }
        } while (choice != 9);
    }
    
    public void promptForAddStudentGrades(String studentName, Integer studentID, ArrayList<Double> newGrades, boolean current) {
        int counter = 1;
        double grade = 0;
        if(!studentInfo.containsKey(studentID) || current == true) {
            System.out.println("Enter grades (enter blank to quit)");
            while (grade >= 0) {
                grade = console.getDoubleAcceptBlank("Enter grade " + counter + ":");
                if (grade >= 0) {
                    newGrades.add(grade);
                    counter++;
                }
            }  
        }
        Student student = new Student(studentName, newGrades);
        addStudent(studentID, student);
    }
    public String promptForStudentName() {
        String firstName, lastName, studentName;
        firstName = console.getString("Enter first name: ");
        lastName=console.getString("Enter last name:");
        studentName = firstName + " " + lastName;
        return studentName;
    }
    
    public int promptForStudentID() {
        int studentID;
        studentID = console.getInt("Please enter valid studentID: ");
        return studentID;
    }
    public int makeStudentID() {
        int counter = 1000;
        boolean valid = false;
        int studentID = 1000;
        while (!valid) {
            if (!studentInfo.containsKey(counter)) {
                studentID = counter;
                valid = true;
                
            }
            counter ++;
        }
        return studentID;
    }
    public void addStudent(int studentID, Student student) {
        studentInfo.put(studentID, student);
    }
    
    public void removeStudent(int studentID) {
        studentInfo.remove(studentID);
    }
    
    public void viewStudents() {
        Collection<Integer> studentIDs = studentInfo.keySet();
        System.out.println("List of Students:");
        System.out.println("=================");
        for (Integer studentID : studentIDs) {
            System.out.println(studentID + " " + studentInfo.get(studentID).getName());
        }
    }
    
    public void viewStudentScores(int studentID) {
        try {
            ArrayList<Double> quizGrades = studentInfo.get(studentID).getQuizScores();
            String student = studentInfo.get(studentID).getName();
            System.out.println("Scores for " + student + ": ");
            console.print("=========================");
            for (double quizGrade : quizGrades) {
            System.out.println(quizGrade);
            }
        } catch(Exception e) {
            console.print("Student does not exist!");
            console.print("=========================");
        }
        
    }
    public void addGradesCurrentStudent(int studentID) {
        viewStudentScores(studentID);
        boolean valid = false;
        ArrayList<Double> newGrades = new ArrayList<>();
        while (!valid) {
            int choice = console.getInt("1. Add grades to list 2. Overwrite current list");
            switch (choice) {
                case 1:
                    newGrades = (studentInfo.get(studentID)).getQuizScores();
                    valid = true;
                    break;
                case 2:
                    newGrades = new ArrayList<>();
                    break;
                default:
                    console.print("Invalid choice!");
                    break;
            }
        }
        String studentName = studentInfo.get(studentID).getName();
        promptForAddStudentGrades(studentName, studentID, newGrades, true);
        
    }
    
    public void viewStudentAverage(int studentID) {
        try {
            ArrayList<Double> quizGrades = (studentInfo.get(studentID)).getQuizScores();
            String student = studentInfo.get(studentID).getName();
            System.out.println(student + "'s Average: ");
            double average = getGradeAverage(quizGrades);
            System.out.println(average);
        } catch(Exception e) {
            console.print("Student does not exist!");
            console.print("=======================");
        }
            
        
    }
    public double getGradeAverage(ArrayList<Double> quizGrades) {
        int sum = 0;
        double average;
        for (Double grade: quizGrades) {
            sum += grade;
        }
        average = sum/quizGrades.size();
        return average;
    }
    public void getClassAverage() {
        double classAverage =0;
        double classSum =0;
        double studentAverage;
        Collection<Student> studentGrades = studentInfo.values();
        for (Student studentGrade : studentGrades) {
            studentAverage = getGradeAverage(studentGrade.getQuizScores());
            classSum+= studentAverage;
        }
        classAverage = classSum/studentInfo.size();
        System.out.println("The class average is " + classAverage + ".");
        console.print("===============================================");
    }
    
    public void getHighestAverage() {
        double studentAverage;
        double high = 0;
        String student;
        Collection<Integer> studentIDs = studentInfo.keySet();
        String highestStudent = "";
        for (Integer studentID : studentIDs) {
            student = (studentInfo.get(studentID)).getName();
            studentAverage = getGradeAverage(studentInfo.get(studentID).getQuizScores());
            if (studentAverage > high) {
                high = studentAverage;
                highestStudent = student;
            }
            else if (studentAverage == high) {
                highestStudent = highestStudent + "/" + student;
            }
        }
        console.print("The student with the highest average is " + highestStudent + " with " + high + ".");
    }
    public void getLowestAverage() {
        String student;
        double studentAverage;
        double low = 100000;
        Collection<Integer> studentIDs = studentInfo.keySet();
        String lowestStudent = "";
        for (Integer studentID : studentIDs) {
            studentAverage = getGradeAverage(studentInfo.get(studentID).getQuizScores());
            if (studentAverage < low) {
                low = studentAverage;
                student = (studentInfo.get(studentID)).getName();
                lowestStudent = student;
            }
            else if (studentAverage == low) {
                student = (studentInfo.get(studentID)).getName();
                lowestStudent = lowestStudent + "/" + student;
            }
        }
        console.print("The student with the lowest average is " + lowestStudent + " with " + low + ".");
    }
}
