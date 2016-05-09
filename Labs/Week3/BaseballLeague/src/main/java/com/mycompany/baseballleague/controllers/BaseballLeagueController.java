/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.baseballleague.controllers;

import com.mycompany.baseballleague.dto.Team;
import com.mycompany.baseballleague.dto.Player;
import com.mycompany.baseballleague.dao.PlayerDaoImpl;
import com.mycompany.baseballleague.dao.TeamDaoImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class BaseballLeagueController {
    private ConsoleIO console = new ConsoleIO();
    private Team team = new Team();
    private Player player = new Player();
    private TeamDaoImpl catalog = new TeamDaoImpl();
    private PlayerDaoImpl roster = new PlayerDaoImpl();
    public void run() {
        userChoice();
    }
    
    private void displayMenu() {
        console.print("1. Add Team");
        console.print("2. Add Player");
        console.print("3. List All Teams");
        console.print("4. List All Players");
        console.print("5. Edit Team");
        console.print("6. Trade Player ");
        console.print("7. Delete Team");
        console.print("8. Delete Player");
        console.print("9. Exit");
    }
    
    private void userChoice() {
        int choice =0;
        do{
            displayMenu();
            choice = console.getIntOneLine("Choose an option: ");
            switch(choice) {
                case 1:
                    addTeam();
                    break;
                case 2:
                    addPlayer();
                    break;
                case 3:
                    listAllTeams();
                    break;
                case 4:
                    listAllPlayers();
                    break;
                case 5:
                    editTeam();
                    break;
                case 6:
                    tradePlayer();
                    break;
                case 7:
                    deleteTeam();
                    break;
                case 8:
                    deletePlayer();
                    break;
                case 9:
                    console.print("Goodbye!");
                    break;
                default:
                    console.print("Invalid choice!");
                    break;
            }
            
            
        } while(choice!=9);
    }
    
    private void addTeam() {
        Team myTeam = new Team();
        String location = console.getString("Enter team location: ");
        String name = console.getString("Enter team name: ");
        myTeam.setName(name);
        myTeam.setLocation(location);
        catalog.create(myTeam);
    }
    
    private void addPlayer() {
        String search;
        Player myPlayer = new Player();
        List<Team> teams = catalog.getAll();
        List<Team> fteams = new ArrayList<>();
        if (teams.size() > 0) {
            String firstName = console.forceString("Enter first name: ");
            String lastName = console.forceString("Enter last name: ");
            console.print("You must add this player to a team.");
            fteams = teamSearch(fteams, teams);
            if (fteams.size() > 0) {
                teams = fteams;
            }
            else {
                console.print("No team by that name exists. Displaying all teams.");
            }
            int teamChoice = console.getIntOneLine("Choose team to add player to (with team number): ");
            Team myTeam = teams.get(teamChoice -1);
            int teamId = myTeam.getId();
            myPlayer.setFirstName(firstName);
            myPlayer.setLastName(lastName);
            myPlayer.setTeamId(teamId);
            roster.create(myPlayer);
        }
        
        else {
            console.print("You must add a team before you can add a player!");
        }
    }

    private List<Team> teamSearch(List<Team> fteams, List<Team> teams) {
        String search;
        console.print("Would you like to...");
        console.print("1. Search for team by name");
        console.print("2. List all teams");
        int choice = console.getIntMinMax("> ", 1, 2);
        switch(choice) {
            case 1:
                search = console.forceString("Please enter name or location.");
                fteams=catalog.find(search);
                displayTeams(fteams);
                break;
            case 2:
                fteams=teams;
                displayTeams(teams);
                break;
            default:
                
        }
        return fteams;
    }
    
    private List<Player> playerSearch(List<Player> fplayers, List<Player> players) {
        String search;
        console.print("Would you like to...");
        console.print("1. Search for player by last name");
        console.print("2. List all players");
        int choice = console.getIntMinMax("> ", 1, 2);
        switch(choice) {
            case 1:
                search = console.getString("Please enter last name.");
                fplayers=roster.find(search);
                displayPlayers(fplayers);
                break;
            case 2:
                fplayers=players;
                displayPlayers(fplayers);
                break;
            default:
                
        }
        return fplayers;
    }
    private void listAllTeams() {
        List<Team> teams;
        teams = catalog.getAll();
        displayTeams(teams);
    }
    
    private void listAllPlayers() {
        List<Player> players;
        players = roster.getAll();
        displayPlayers(players);
    }
    
    private void displayTeams(List<Team> teamd) {
        int counter = 1;
        for (Team t : teamd) {
            console.print("Team " + counter);
            console.print(t.getLocation() + " " + t.getName());
            console.print("");
            counter++;
        }
        
    }
    
    private void displayPlayers(List<Player> playerd) {
        int counter = 1;
        for (Player p : playerd) {
            console.print("Player " + counter);
            console.print(p.getFirstName() + " " + p.getLastName());
            team=catalog.findByTeamId(p);
            console.print("Team: " + team.getLocation() + " " + team.getName());
            console.print("");
            counter++;
        }
        
    }
    
    private void editTeam() {
        String location, name;
        List<Team> teams=catalog.getAll();
        List<Team> fteams=new ArrayList<>();
        fteams = teamSearch(fteams, teams);
        if (fteams.size() > 0) {
            teams = fteams;
        }
        else {
            console.print("A team by that name does not exist!");
        }
        int teamChoice = console.getIntOneLine("Choose team to edit (by number): ");
        Team myTeam = teams.get(teamChoice-1);
        console.print("Would you like to edit...");
        console.print("1. Location");
        console.print("--or--");
        console.print("2. Name");
        console.print("--or--");
        console.print("3. Both");
        int editChoice = console.getIntMinMax("Enter choice: ", 1, 3);
        switch (editChoice) {
            case 1:
                location=console.getStringOneLine("Enter new location: ");
                myTeam.setLocation(location);
                catalog.update(myTeam);
                break;
            case 2:
                name=console.getStringOneLine("Enter new name:");
                myTeam.setName(name);
                catalog.update(myTeam);
                break;
            case 3:
                location=console.getStringOneLine("Enter new location: ");
                name=console.getStringOneLine("Enter new name:");
                myTeam.setName(name);
                myTeam.setLocation(location);
                catalog.update(myTeam);
                break;
            default:
                console.print("Invalid entry!");
                break;
        }
    }
    
    private void tradePlayer() {
        List<Player> players = roster.getAll();
        List<Team> teams=catalog.getAll();
        List<Player> fplayers=new ArrayList<>();
        fplayers = playerSearch(fplayers, players);
        if (fplayers.size() > 0) {
            players = fplayers;
        }
        else {
            console.print("A player by that name does not exist!");
            displayPlayers(players);
        }
        int playerChoice = console.getIntMinMax("Choose player by number: ", 1, players.size());
        player = players.get(playerChoice-1);
        Team myTeam = catalog.findByTeamId(player);
        String playerName = player.getFirstName() + " " + player.getLastName();
        String teamName= myTeam.getLocation() + " " + myTeam.getName();
        console.print(playerName + "'s current team is the " + teamName + ".");
        List<Team> fteams=new ArrayList<>();
        fteams = teamSearch(fteams, teams);
        if (fteams.size() > 0) {
            teams = fteams;
        }
        else {
            console.print("A team by that name does not exist!");
        }
        int teamChoice=console.getIntMinMax("Choose new team by number: ", 1, teams.size());
        myTeam = teams.get(teamChoice -1);
        player.setTeamId(myTeam.getId());
        roster.update(player);
    }
    
    private void deleteTeam() {
        
        List<Team> teams=catalog.getAll();
        List<Team> fteams=new ArrayList<>();
        fteams = teamSearch(fteams, teams);
        if (fteams.size() > 0) {
            teams = fteams;
        }
        else {
            console.print("A team by that name does not exist!");
        }
        int teamChoice = console.getIntMinMax("Choose team to delete (by number): ", 1, teams.size());
        team = teams.get(teamChoice-1);
        List<Player> playersOnTeam = roster.getPlayersOnTeam(team);
        if (playersOnTeam.size() > 0) {
            int choice, counter=0;

            console.print("You must reassign or delete all players on this team before deleting!");
            displayPlayers(playersOnTeam);
            console.print("Would you like to...");
            console.print("1. Proceed");
            console.print("2. Cancel");
            choice = console.getIntMinMax("> ", 1, 2);
            
            switch (choice) {
                case 1:
                    while (counter < playersOnTeam.size()) {
                        Player myPlayer = new Player();
                        myPlayer = playersOnTeam.get(counter);
                        console.print(myPlayer.getFirstName() + " " + myPlayer.getLastName());
                        console.print("Would you like to...");
                        console.print("1. Trade");
                        console.print("2. Delete");
                        choice = console.getIntMinMax("> ", 1, 2);
                        switch(choice) {
                            case 1:
                                fteams=new ArrayList<>();
                                fteams = teamSearch(fteams, teams);
                                if (fteams.size() > 0) {
                                teams = fteams;
                                }
                                else {
                                console.print("A team by that name does not exist!");
                                }
                                teamChoice=console.getIntMinMax("Choose new team by number: ", 1, teams.size());
                                Team myTeam = teams.get(teamChoice -1);
                                myPlayer.setTeamId(myTeam.getId());
                                roster.update(myPlayer);
                                break;
                            case 2:
                                roster.delete(myPlayer);
                                console.print("Player deleted!");
                                break;
                            default:
                                break;
                        }
                        counter++;
                    }
                    break;
                case 2:
                    console.print("Action canceled!");
                    break;
                default:
                    console.print("Error!");
                    break;
            }
        }
        else{
            catalog.delete(team);
            console.print("Team deleted!");
        }
    }
    
    private void deletePlayer() {
        List<Player> players=roster.getAll();
        List<Player> fplayers=new ArrayList<>();
        fplayers = playerSearch(fplayers, players);
        if (fplayers.size() > 0) {
            players = fplayers;
        }
        else {
            console.print("A player by that name does not exist!");
            displayPlayers(players);
        }
        int playerChoice = console.getIntMinMax("Choose player to delete (by number): ", 1, players.size());
        player = players.get(playerChoice-1);
        roster.delete(player);
    }
}
