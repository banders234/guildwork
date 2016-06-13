/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.dao;

import com.mycompany.dvdlibrary.dto.DVD;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface DVDDao {

    DVD create(DVD dvd);

    void delete(DVD dvd);

    double findAverageAge();

    double findAverageNotes();

    List<DVD> findByAge(int years);

    List<DVD> findByDirector(String director);

    List<DVD> findByMPAA(String mpaa);

    List<DVD> findByStudio(String studio);

    List<DVD> findByTitle(String title);

    DVD findNewest();

    DVD findOldest();

    List<DVD> getAll();

    int getCount();

    void update(DVD dvd);
    
    DVD get(int id);
}
