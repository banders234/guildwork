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
    HashMap<String, ArrayList> studentInfo = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    ConsoleIO console = new ConsoleIO();
    public void currentStudents() {
        ArrayList<Double> currentGrades = new ArrayList<>();
        currentGrades.add(89.0);
        currentGrades.add(76.0);
        currentGrades.add(45.0);
        currentGrades.add(82.0);
        studentInfo.put("Bob Jenkins", currentGrades);
    }
    public void viewUI() {
        String student;
        int choice;
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
                    student = promptForStudentName();
                    ArrayList<Double> newGrades = new ArrayList<>();
                    promptForAddStudentGrades(student, newGrades, false);
                    addStudent(student, newGrades);
                    break;
                case 3:
                    viewStudents();
                    student = promptForStudentName();
                    removeStudent(student);
                    break;
                case 4:
                    viewStudents();
                    student = promptForStudentName();
                    viewStudentScores(student);
                    break;
                case 5:
                    viewStudents();
                    student = promptForStudentName();
                    viewStudentAverage(student);
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
                    student = promptForStudentName();
                    addGradesCurrentStudent(student);
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    System.out.println("===============");
                    break;
            }
        } while (choice != 9);
    }
    
    public void promptForAddStudentGrades(String student, ArrayList<Double> newGrades, boolean current) {
        int counter = 1;
        double grade = 0;
        if(!studentInfo.containsKey(student) || current == true) {
            System.out.println("Enter grades (enter -1 to quit)");
            while (grade >= 0) {
                grade = console.getDouble("Enter grade " + counter + ":");
                if (grade >= 0) {
                    newGrades.add(grade);
                    counter++;
                }
            }  
        }
        else {
            console.print("Student already exists!");
            console.print("=======================");
            String choice = console.getString("Would you like to add student with the same name? (yes or no)");
            if ("yes".equals(choice)) {
                boolean valid = false;
                counter = 1;
                while (!valid) {
                    String studentNum = student + " " + counter;
                    if (!studentInfo.containsKey(studentNum)) {
                        student = studentNum;
                        System.out.println("Enter grades (enter -1 to quit)");
                        counter = 1;
                        while (grade >= 0) {
                            grade = console.getDouble("Enter grade " + counter + ":");
                            if (grade >= 0) {
                                newGrades.add(grade);
                                counter++;
                            }
                        }
                        valid = true;
                    }
                    counter++;
                }
            }
            else if ("no".equals(choice)) {
                newGrades = studentInfo.get(student);
            }
            else {
                console.print("Invalid choice!");
            }           
        }
        addStudent(student, newGrades);
    }
    public String promptForStudentName() {
        String firstName, lastName, studentName;
        firstName = console.getString("Enter first name: ");
        lastName=console.getString("Enter last name:");
        studentName = firstName + " " + lastName;
        return studentName;
    }
    public void addStudent(String student, ArrayList grades) {
        studentInfo.put(student, grades);
    }
    
    public void removeStudent(String student) {
        studentInfo.remove(student);
    }
    
    public void viewStudents() {
        Collection<String> studentNames = studentInfo.keySet();
        System.out.println("List of Students:");
        System.out.println("=================");
        for (String studentName : studentNames) {
            System.out.println(studentName);
        }
    }
    
    public void viewStudentScores(String student) {
        try {
            ArrayList<Double> quizGrades = studentInfo.get(student);
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
    public void addGradesCurrentStudent(String student) {
        viewStudentScores(student);
        boolean valid = false;
        ArrayList<Double> newGrades = new ArrayList<>();
        while (!valid) {
            int choice = console.getInt("1. Add grades to list 2. Overwrite current list");
            switch (choice) {
                case 1:
                    newGrades = studentInfo.get(student);
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
        promptForAddStudentGrades(student, newGrades, true);
        
    }
    
    public void viewStudentAverage(String student) {
        try {
            ArrayList<Double> quizGrades = studentInfo.get(student);
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
        Collection<ArrayList> studentGrades = studentInfo.values();
        for (ArrayList studentGrade : studentGrades) {
            studentAverage = getGradeAverage(studentGrade);
            classSum+= studentAverage;
        }
        classAverage = classSum/studentInfo.size();
        System.out.println("The class average is " + classAverage + ".");
        console.print("===============================================");
    }
    
    public void getHighestAverage() {
        double studentAverage;
        double high = 0;
        Collection<String> students = studentInfo.keySet();
        String highestStudent = "";
        for (String student : students) {
            studentAverage = getGradeAverage(studentInfo.get(student));
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
        double studentAverage;
        double low = 100000;
        Collection<String> students = studentInfo.keySet();
        String lowestStudent = "";
        for (String student : students) {
            studentAverage = getGradeAverage(studentInfo.get(student));
            if (studentAverage < low) {
                low = studentAverage;
                lowestStudent = student;
            }
            else if (studentAverage == low) {
                lowestStudent = lowestStudent + "/" + student;
            }
        }
        console.print("The student with the lowest average is " + lowestStudent + " with " + low + ".");
    }
}
