/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.dto;

/**
 *
 * @author apprentice
 */
public class Genre {
    public Integer id;
    public String genreName;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the genre
     */
    public String getGenreName() {
        return genreName;
    }

    /**
     * @param genreName the genre to set
     */
    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
