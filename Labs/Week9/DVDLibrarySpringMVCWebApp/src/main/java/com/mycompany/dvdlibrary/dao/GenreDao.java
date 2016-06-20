/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.dao;

import com.mycompany.dvdlibrary.dto.Genre;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface GenreDao {
    public Genre get(Integer id);
    public List<String> getOnDvd(Integer id);
    public List<String> list();
    public Map<String, Integer> genreCount();
    public void create(String genre);
    public void createDvdGenreLink(String genre, Integer dvdId);
    public void deleteOnDvd(Integer dvdId);
}
