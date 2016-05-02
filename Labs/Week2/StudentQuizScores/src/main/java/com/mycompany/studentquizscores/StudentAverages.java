/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentquizscores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public class StudentAverages {
    ConsoleIO console = new ConsoleIO();
    public void viewStudentAverage(int studentID, HashMap<Integer, Student> studentInfo) {
        
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
    public void getClassAverage(HashMap<Integer, Student> studentInfo) {
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
    
    public void getHighestAverage(HashMap<Integer, Student> studentInfo) {
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
    public void getLowestAverage(HashMap<Integer, Student> studentInfo) {
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
