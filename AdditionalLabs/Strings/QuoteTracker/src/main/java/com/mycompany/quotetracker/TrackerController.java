/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quotetracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.*;
/**
 *
 * @author apprentice
 */
public class TrackerController {
    ConsoleIO console = new ConsoleIO();
    
    public void run() {
        String symbol;
        symbol=console.getString("Enter stock symbol: ");
        try {
            URL quote = new URL("http://finance.google.com/finance/info?q=NASDAQ%3a" + symbol);
            BufferedReader in = new BufferedReader(new InputStreamReader(quote.openStream()));
            String inputLine, str="";
            while ((inputLine= in.readLine()) !=null) {
                str+=inputLine;
                
            }
            str=str.substring(4,str.length()-1);
            JsonElement jelement = new JsonParser().parse(str);
            JsonObject jobject = jelement.getAsJsonObject();
            String lastStockPrice = jobject.get("l").toString();
            String change = jobject.get("c").toString();
            String changePercent = jobject.get("cp").toString();
            console.print("");
            console.print("The last stock price of " + symbol + " was " + lastStockPrice.substring(1, lastStockPrice.length()-1));
            console.print("It is " + change.substring(1, change.length()-1) + " today.");
            console.print("The percentage change is " + changePercent.substring(1, changePercent.length()-1) + "%.");
        in.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(TrackerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TrackerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
