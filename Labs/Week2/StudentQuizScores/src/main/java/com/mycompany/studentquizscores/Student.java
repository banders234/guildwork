/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentquizscores;
import java.util.ArrayList;
/**
 *
 * @author apprentice
 */
public class Student {
    String name;
    ArrayList quizScores;
    public Student(String name, ArrayList quizScores) {
        this.name = name;
        this.quizScores = quizScores;
    }
    
    public ArrayList getQuizScores(){
        return quizScores;
    }
    
    public String getName() {
        return name;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setQuizScores(ArrayList quizScores) {
        this.quizScores = quizScores;
    }
}
