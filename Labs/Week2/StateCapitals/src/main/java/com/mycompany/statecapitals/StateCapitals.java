/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.statecapitals;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class StateCapitals {
    HashMap<String, Capital> stateCapitals= new HashMap<>();
    Scanner sc = new Scanner(System.in);
    public void putCapitals() {
        Capital denver = new Capital("Denver", 682000, 155);
        stateCapitals.put("Colorado", denver);
        Capital juneau = new Capital("Juneau", 32167, 3255);
        stateCapitals.put("Alaska", juneau);
        Capital montgomery = new Capital("Montgomery", 205764, 155);
        stateCapitals.put("Alabama", montgomery);
        Capital phoenix = new Capital("Phoenix", 1455632,475);
        stateCapitals.put("Arizona", phoenix);
        Capital sacramento = new Capital("Sacramento", 466488, 97);
        stateCapitals.put("California", sacramento);
        Capital littleRock = new Capital("Little Rock", 193524,116);
        stateCapitals.put("Arkansas", littleRock);
        
    }
    public void printCapitals(HashMap stateCapitals) {
        Collection<String> capitals = stateCapitals.values();
        System.out.println("CAPITALS: ");
        System.out.println("===========");
        for( String capital : capitals) {
            System.out.println(capital);
            
        }
    }
    public void capitalInfo() {
        Capital denver = new Capital("Denver", 682000, 155);
        Capital juneau = new Capital("Juneau", 32167, 3255);
        Capital montgomery = new Capital("Montgomery", 205764, 155);
        Capital phoenix = new Capital("Phoenix", 1455632,475);
        Capital sacramento = new Capital("Sacramento", 466488, 97);
        Capital littleRock = new Capital("Little Rock", 193524,116);
    }
    public void printStates(HashMap stateCapitals) {
        Collection<String> states = stateCapitals.keySet();
        System.out.println("STATES: ");
        System.out.println("========");
        for (String state : states) {
            System.out.println(state);
        }
    }
    public void printStateCapitals(HashMap stateCapitals) {
        Collection<String> states = stateCapitals.keySet();
        System.out.println(" STATE/CAPITAL PAIRS: ");
        System.out.println("======================");
        String capitals = "";
        Capital capital = null;
        for (String state : states) {
            capital = (Capital) stateCapitals.get(state);
            System.out.println(state + " - " + capital.getName() + " " + capital.getPopulation() + " " + capital.getSquareMileage());
        }
    }
    public void printStateCapitalsMinPop(HashMap stateCapitals) {
        Collection<String> states = stateCapitals.keySet();
        System.out.println("Please enter the lower limit for capital city popualtion: ");
        int minPop = Integer.parseInt(sc.next());
        System.out.println(" LISTING CAPITALS WITH POPULATIONS GREATER THAN " + minPop + ":");
        System.out.println("======================");
        Capital capital;
        for (String state : states) {
            capital = (Capital) stateCapitals.get(state);
            if (capital.population > minPop) {
                System.out.println(state + " - " + capital.getName() + " | Pop: " + capital.getPopulation() + " | Area: " + capital.getSquareMileage() + " sq mi");
            }
        }
    }
    
    public HashMap getCapitals() {
        return stateCapitals;
    }
}
