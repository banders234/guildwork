/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.baseballleague.dao;

import com.mycompany.baseballleague.dto.Player;
import com.mycompany.baseballleague.dto.Team;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface TeamDao {

    Team create(Team team);

    void delete(Team team);

    List<Team> find(String name);

    Team findByTeamId(Player player);

    List<Team> getAll();

    int getCount();

    void update(Team myTeam);
    
}
