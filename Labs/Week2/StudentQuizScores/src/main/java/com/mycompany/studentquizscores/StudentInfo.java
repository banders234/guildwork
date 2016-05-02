/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentquizscores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class StudentInfo {
    StudentInfoRW rw = new StudentInfoRW();
    HashMap<Integer, Student> studentInfo = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    ConsoleIO console = new ConsoleIO();
    StudentAverages sa = new StudentAverages();
    
    public void viewUI() {
        rw.loadFile(studentInfo);
        String studentName;
        int choice;
        int studentID;
        do {
            console.print("What would you like to do?");
            console.print("1. View Students ");
            console.print("2. Add Student ");
            console.print("3. Remove Student ");
            console.print("4. View Scores for a Student ");
            console.print("5. View Average for a Student ");
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
                    sa.viewStudentAverage(studentID, studentInfo);
                    break;
                case 6:
                    sa.getClassAverage(studentInfo);
                    break;
                case 7:
                    sa.getHighestAverage(studentInfo);
                    sa.getLowestAverage(studentInfo);
                    break;
                case 8:
                    viewStudents();
                    studentID = promptForStudentID();
                    addGradesCurrentStudent(studentID);
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    rw.writeFile(studentInfo);
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
        if(studentInfo.containsKey(studentID)) {
            studentInfo.remove(studentID);
        }
        else {
            console.print("Student does not exist!");
            console.print("=======================");
        }
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
    public HashMap<Integer, Student> getStudentInfo() {
        return studentInfo;
    }
}
