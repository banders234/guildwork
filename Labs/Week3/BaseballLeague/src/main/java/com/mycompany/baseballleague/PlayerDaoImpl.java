/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.baseballleague;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class PlayerDaoImpl implements PlayerDao {
    private List<Player> players = decode();
    private int nextId = 1;
    
    @Override
    public Player create(Player player) {
        boolean valid=false;
        List<Integer> idList = new ArrayList<>();
        for (Player myPlayer : players) {
            idList.add(myPlayer.getId());
        }
        while (!valid) {
            if (!idList.contains(nextId)) {
                player.setId(nextId);
                valid=true;
            }
            else{
                nextId++;
            }
        }
        nextId++;
        players.add(player);
        encode();
        return player;
    }
    
    @Override
    public void delete(Player player) {
        players.remove(player);
        encode();
    }
    
    @Override
    public void update(Player myPlayer) {
        for (Player player : players)  {
            if (myPlayer.getId() == player.getId()) {
                players.remove(player);
                players.add(myPlayer);
                break;
            }
        }
        encode();
    }
    
    @Override
    public List<Player> find(String lastName) {
        List<Player> playerList = new ArrayList<>();
        Player player = new Player();
        for (Player a : players) {
            if ((a.getLastName()).equals(lastName)) {
                playerList.add(a);
            }
        }
        return playerList;
    }
    
    @Override
    public List<Player> getPlayersOnTeam(Team team) {
        List<Player> teamPlayers = new ArrayList<>();
        for(Player myPlayer : players) {
            if (myPlayer.getTeamId() == team.getId()) {
                teamPlayers.add(myPlayer);
            }
        }
        return teamPlayers;
    }
    
    @Override
    public int getCount() {
        return players.size();
    }
    
    @Override
    public List<Player>  getAll() {
        
        return players;
    }
    
    
    private void encode() {
        final String TOKEN = "::";

        try {
                PrintWriter out = new PrintWriter(new FileWriter("players.txt"));
                for (Player myPlayer : players) {
                    out.print(myPlayer.getId());
                    out.print(TOKEN);
                                        
                    out.print(myPlayer.getFirstName());
                    out.print(TOKEN);
                    
                    out.print(myPlayer.getLastName());
                    out.print(TOKEN);

                    out.print(myPlayer.getTeamId());
                    out.println();
                      
                }
                out.flush();
                out.close();
            } catch(IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }


    }
    
    private List<Player> decode() {
        List<Player> playerList = new ArrayList();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("players.txt")));

            while (sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                String[] stringParts= currentLine.split("::");
                Player myPlayer = new Player();

                int id = Integer.parseInt(stringParts[0]);

                myPlayer.setId(id);
                myPlayer.setFirstName(stringParts[1]);
                myPlayer.setLastName(stringParts[2]);
                myPlayer.setTeamId(Integer.parseInt(stringParts[3]));


                playerList.add(myPlayer);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return playerList;
    }
    
}
