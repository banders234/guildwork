/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.dao.StudentDao;
import com.mycompany.dto.Student;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author apprentice
 */
public class StudentInfoController {
    ConsoleIO console = new ConsoleIO();
    StudentDao sis = new StudentDao();
    public void viewUI() {
        Student student = new Student();
        String studentName;
        int choice;
        int studentID;
        do {
            console.print("What would you like to do?");
            console.print("1. View Students ");
            console.print("2. Add Student ");
            console.print("3. Remove Student ");
            console.print("4. View Scores for a Student ");
            console.print("5. Add Grades to Current Student ");
            console.print("6. View Average for a Student ");
            console.print("7. View Class Average ");
            console.print("8. View Highest/Lowest Average ");
            console.print("9. Exit ");
            choice = console.getIntWithDef("Enter number for choice", 10);
            switch(choice) {
                case 1:
                    viewStudents();
                    break;
                case 2:
                    String firstName = promptForFirstName();
                    String lastName = promptForLastName();
                    ArrayList<Double> newGrades = new ArrayList<>();
                    Student myStudent = new Student();
                    myStudent.setFirstName(firstName);
                    myStudent.setLastName(lastName);
                    myStudent.setQuizScores(newGrades);
                    sis.create(myStudent);
                    promptForAddStudentGrades(myStudent);
                    break;
                case 3:
                    viewStudents();
                    studentID = promptForStudentID();
                    student = sis.findStudentById(studentID);
                    sis.delete(student);
                    break;
                case 4:
                    viewStudentScores();
                    break;
                case 5:
                    viewStudents();
                    studentID = promptForStudentID();
                    addGradesCurrentStudent(studentID);
                    break;
                case 6:
                    viewStudents();
                    studentID= promptForStudentID();
                    student = sis.findStudentById(studentID);
                    viewStudentAverage(student);
                    break;
                case 7:
                    getClassAverage();
                    break;
                case 8:
                    getHighestAverage();
                    getLowestAverage();
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
    
    public void promptForAddStudentGrades(Student myStudent) {
        List<Double> newGrades = myStudent.getQuizScores();
        int counter = 1;
        double grade = 0;
        System.out.println("Enter grades (enter blank to quit)");
        while (grade >= 0) {
            grade = console.getDoubleAcceptBlank("Enter grade " + counter + ":");
            if (grade >= 0) {
                newGrades.add(grade);
                counter++;
            }
        }
        myStudent.setQuizScores(newGrades);
        sis.update(myStudent);
    }
    public String promptForFirstName() {
        String firstName;
        firstName = console.getString("Enter first name: ");
        return firstName;
    }
    
    public String promptForLastName() {
        String lastName;
        lastName=console.getString("Enter last name:");
        return lastName;
    }
    
    public int promptForStudentID() {
        int studentID;
        studentID = console.getInt("Please enter valid studentID: ");
        return studentID;
    }
    public void addStudent(Student student) {
        sis.create(student);
    }
    
    public void removeStudent(Student student) {
        sis.delete(student);
    }
    public void viewStudents() {
        System.out.println("List of Students:");
        System.out.println("=================");
        List<Student> studentList = sis.getAll();
        for (Student myStudent : studentList) {
            System.out.println(myStudent.getId() + " " + myStudent.getFirstName() + " " + myStudent.getLastName());
        }
    }
    
    public void viewStudentScores() {
        try {
            viewStudents();
            int id = console.getInt("Select a student by id:");
            boolean check = sis.checkIfIdExists(id);
            if (check) {
                Student myStudent = sis.findStudentById(id);
                List<Double> quizGrades = myStudent.getQuizScores();
                String student = myStudent.getFirstName() + " " + myStudent.getLastName();
                System.out.println("Scores for " + student + ": ");
                console.print("=========================");
                for (double quizGrade : quizGrades) {
                System.out.println(quizGrade);
            }
            }
            else {
                 console.print("Student does not exist!");
                 console.print("=========================");
            }
            
            
            
        } catch(Exception e) {
            console.print("Student does not exist!");
            console.print("=========================");
        }
        
    }
    public void addGradesCurrentStudent(int studentID) {
        Student myStudent = sis.findStudentById(studentID);
        boolean valid = false;
        List<Double> newGrades = new ArrayList<>();
        while (!valid) {
            int choice = console.getInt("1. Add grades to list 2. Overwrite current list");
            switch (choice) {
                case 1:
                    newGrades = myStudent.getQuizScores();
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
        promptForAddStudentGrades(myStudent);
        
    }
    public void viewStudentAverage(Student student) {
        
        try {
            List<Double> quizGrades = student.getQuizScores();
            String studentName = student.getFirstName() + " " + student.getLastName();
            System.out.println(studentName + "'s Average: ");
            double average = getGradeAverage(quizGrades);
            System.out.println(average);
        } catch(Exception e) {
            console.print("Student does not exist!");
            console.print("=======================");
        }
            
        
    }
    public double getGradeAverage(List<Double> quizGrades) {
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
        List<Student> students = sis.getAll();
        for (Student student : students) {
            studentAverage = getGradeAverage(student.getQuizScores());
            classSum+= studentAverage;
        }
        int count = sis.getCount();
        classAverage = classSum/count;
        System.out.println("The class average is " + classAverage + ".");
        console.print("===============================================");
    }
    
    public void getHighestAverage() {
        double studentAverage;
        double high = 0;
        String studentName;
        List<Student> students = sis.getAll();
        String highestStudent = "";
        for (Student student : students) {
            studentName = student.getFirstName() + " " + student.getLastName();
            studentAverage = getGradeAverage(student.getQuizScores());
            if (studentAverage > high) {
                high = studentAverage;
                highestStudent = studentName;
            }
            else if (studentAverage == high) {
                highestStudent = highestStudent + " & " + studentName;
            }
        }
        console.print("The student with the highest average is " + highestStudent + " with " + high + ".");
    }
    public void getLowestAverage() {
        String studentName;
        double studentAverage;
        double low = 100000;
        List<Student> students = sis.getAll();
        String lowestStudent = "";
        for (Student student : students) {
            studentAverage = getGradeAverage(student.getQuizScores());
            if (studentAverage < low) {
                low = studentAverage;
                studentName = student.getFirstName() + " " + student.getLastName();
                lowestStudent = studentName;
            }
            else if (studentAverage == low) {
                studentName = student.getFirstName() + " " + student.getLastName();
                lowestStudent = lowestStudent + "/" + studentName;
            }
        }
        console.print("The student with the lowest average is " + lowestStudent + " with " + low + ".");
    }
}
