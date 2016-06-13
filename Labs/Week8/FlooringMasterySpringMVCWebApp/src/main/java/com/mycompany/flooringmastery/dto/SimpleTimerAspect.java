/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dto;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

public class SimpleTimerAspect {
    
    public Object timer(ProceedingJoinPoint jp) {

        Object returnValue = null;
        try {
            System.out.println(jp.getSignature().getName());
            Long start = System.currentTimeMillis();

            returnValue = jp.proceed();
            Long end = System.currentTimeMillis();

            System.out.println("----------------------------");
            if (jp.getSignature().getDeclaringTypeName().contains("Order")) {
                if (jp.getSignature().getName().contains("decode")) {
                    System.out.println("Reading Orders took " + (end - start) + " milliseconds.");
                }
                else {
                    System.out.println("Writing Orders took " + (end - start) + " milliseconds.");
                }
            }
            else if (jp.getSignature().getDeclaringTypeName().contains("Product")) {
                System.out.println("Reading Products took " + (end - start) + " milliseconds.");
            } 
            else if (jp.getSignature().getDeclaringTypeName().contains("Tax")) {
                System.out.println("Reading States took " + (end - start) + " milliseconds.");
            }
            

        } catch (Throwable ex) {
            Logger.getLogger(SimpleTimerAspect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return returnValue;
    }
    
    
}
