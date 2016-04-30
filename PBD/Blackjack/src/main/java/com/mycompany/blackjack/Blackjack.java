/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blackjack;
import java.util.Random;
/**
 *
 * @author apprentice
 */
public class Blackjack {
    Random rand = new Random();
    ConsoleIO console = new ConsoleIO();
    
    
    public void startBlackJack() {
        String choice;
        int userTotal, dealerTotal, userCard1, userCard2, dealerCard1, dealerCard2;
        userCard1 = rand.nextInt(10)+2;
        userCard2 = rand.nextInt(10)+2;
        console.printString("You get a " + userCard1 + " and a " + userCard2);
        userTotal = getTotal(userCard1, userCard2);
        console.printString("");
        console.printString("Your total is " + userTotal + ".");
        if (userTotal == 21) {
            console.printString("Your total is 21, you win!");
        }
        else{
        
            dealerCard1 = rand.nextInt(10)+2;
            dealerCard2 = rand.nextInt(10)+2;
            console.printString("The dealer has a " + dealerCard1 + " showing, and a hidden card.");
            console.printString("His total is hidden, too.");
            dealerTotal = getTotal(dealerCard1, dealerCard2);
            do {
                choice = console.getString("Would you like to \"hit\" or \"stay\"?");
                if ("hit".equals(choice)) {
                    userTotal=hit(1, userTotal);
                }
                else {
                    console.printString("You choose to stay!");
                }
            } while("hit".equals(choice) && userTotal < 21);
            if (userTotal>21) {
                console.printString("You bust! Dealer wins!");
            }
            else {
                dealersTurn(dealerCard1, dealerCard2, dealerTotal, userTotal);
            }
        }
    }
    public int getTotal (int card1, int card2) {
        int total;
        total = card1 + card2;
        return total;
    }
    public int getDealerCards() {
        int card1, card2, total;
        card1 = rand.nextInt(10) + 2;
        card2 = rand.nextInt(10) + 2;
        console.printString("The dealer has a " + card1 + " showing, and a hidden card too.");
        total = card1 + card2;
        return total;
    }
    public int hit(int player,int total) {
        int card = rand.nextInt(10) + 1;
        total += card;
        if (player == 1) {
            console.printString("You drew a " + card + ".");
            console.printString("Your total is " + total + ".");
        }
        else if (player == 2) {
            console.printString("He draws a " + card + ".");
            console.printString("His total is " + total + ".");
        }
        
        return total;
    }
    public void dealersTurn(int dealerCard1, int dealerCard2, int dealerTotal, int userTotal) {
        int dealerChoice = 0;
        console.printString("Okay, dealer's turn.");
        console.printString("His hidden card was a " + dealerCard2);
        console.printString("His total was " + dealerTotal + ".");
        while (dealerChoice != 2) {
            if (dealerTotal <= userTotal && dealerTotal < 17) {
                dealerChoice = rand.nextInt(2) + 1;
            }
            else if (dealerTotal < 17) {
                dealerChoice = 1;
            }
            else {
                dealerChoice = 2;
            }
            if (dealerChoice == 1) {
                System.out.println("Dealer chooses to hit");
                dealerTotal = hit(2,dealerTotal);
            }
            if (dealerChoice == 2) {
                System.out.println("Dealer stays.");
            }
        }
        console.printString("Dealer total is " + dealerTotal + ".");
        console.printString("Your total is " + userTotal + ".");
        console.printString("");
        if (userTotal > dealerTotal) {
            console.printString("YOU WIN!");
        }
        else if (userTotal < dealerTotal) {
            console.printString("Dealer Wins!");
        }
        else if (userTotal == dealerTotal) {
            console.printString("It's a tie!");
        }
    }
    
}
