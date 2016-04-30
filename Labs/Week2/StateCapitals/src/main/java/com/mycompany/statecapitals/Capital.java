/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.statecapitals;
import java.util.HashMap;
import java.util.Collection;
/**
 *
 * @author apprentice
 */
public class Capital {
    String name;
    int population;
    int squareMileage;
    StateCapitals state = new StateCapitals();
    HashMap <String, String> stateCapital = state.getCapitals();
    public Capital(String name, int population, int squareMileage) {
        this.name = name;
        this.population = population;
        this.squareMileage = squareMileage;
    }
    public void capitalInfo() {
        stateCapital.get(this.name);
        

    }
            
    public void setPopulation(int population) {
        this.population = population;
    }
    public void setSquareMileage(int squareMileage) {
        this.squareMileage = squareMileage;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPopulation() {
        return population;
    }
    public int getSquareMileage() {
        return squareMileage;
    }
    public String getName() {
        
        return name;
    }
}
