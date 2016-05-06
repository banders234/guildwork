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
public class TeamDaoImpl implements TeamDao {
    private List<Team> teams = decode();
    private int nextId = 1;
    
    @Override
    public Team create(Team team) {
        boolean valid=false;
        List<Integer> idList = new ArrayList<>();
        for (Team myTeam : teams) {
            idList.add(myTeam.getId());
        }
        while (idList.contains(nextId)) {
            nextId++;
        }
        team.setId(nextId);
        teams.add(team);
        encode();
        return team;
    }
    
    @Override
    public void delete(Team team) {
        teams.remove(team);
        encode();
    }
    
    @Override
    public void update(Team myTeam) {
        for (Team team : teams)  {
            if (myTeam.getId() == team.getId()) {
                teams.remove(team);
                teams.add(myTeam);
                break;
            }
        }
        encode();
    }
    
    @Override
    public List<Team> find(String name) {
        List<Team> teamList = new ArrayList<>();
        Team team = new Team();
        for (Team a : teams) {
            if ((a.getName()).equals(name)) {
                teamList.add(a);
            }
        }
        return teamList;
    }
    
    @Override
    public Team findByTeamId(Player player) {
        Team team = new Team();
        for (Team t : teams) {
            if ((player.getTeamId()) == t.getId()) {
                return t;
            }
        }
        
        return team;
    }
    
    @Override
    public int getCount() {
        return teams.size();
    }
    
    @Override
    public List<Team>  getAll() {
        
        return teams;
    }
    
    
    private void encode() {
        final String TOKEN = "::";

        try {
                PrintWriter out = new PrintWriter(new FileWriter("teams.txt"));
                for (Team myTeam : teams) {
                    out.print(myTeam.getId());
                    out.print(TOKEN);
                                        
                    out.print(myTeam.getLocation());
                    out.print(TOKEN);
                    
                    out.print(myTeam.getName());
                    out.println();

                      
                }
                out.flush();
                out.close();
            } catch(IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }


    }
    
    private List<Team> decode() {
        List<Team> teamList = new ArrayList();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("teams.txt")));

            while (sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                String[] stringParts= currentLine.split("::");
                Team myTeam = new Team();

                int id = Integer.parseInt(stringParts[0]);

                myTeam.setId(id);
                myTeam.setLocation(stringParts[1]);
                myTeam.setName(stringParts[2]);


                teamList.add(myTeam);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teamList;
    }
}
