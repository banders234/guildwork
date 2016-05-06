/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.baseballleague;

import java.util.List;

/**
 *
 * @author apprentice
 */
public interface PlayerDao {

    Player create(Player player);

    void delete(Player player);

    List<Player> find(String lastName);

    List<Player> getAll();

    int getCount();

    List<Player> getPlayersOnTeam(Team team);

    void update(Player myPlayer);
    
}
