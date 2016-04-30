/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.statecapitals;
import java.util.HashMap;
/**
 *
 * @author apprentice
 */
public class App {
    public static HashMap<String, String> stateCapitals = new HashMap<>();
    public static void main(String[] args) {
        StateCapitals state = new StateCapitals();
        state.putCapitals();
        stateCapitals = state.getCapitals();
        state.printStateCapitals(stateCapitals);
        state.printStateCapitalsMinPop(stateCapitals);
    }
    
}
