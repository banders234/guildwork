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
public class Note {
    private Integer id;
    private String noteText;
    private Integer dvdId;
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
     * @return the noteText
     */
    public String getNoteText() {
        return noteText;
    }

    /**
     * @param noteText the noteText to set
     */
    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    /**
     * @return the dvdId
     */
    public Integer getDvdId() {
        return dvdId;
    }

    /**
     * @param dvdId the dvdId to set
     */
    public void setDvdId(Integer dvdId) {
        this.dvdId = dvdId;
    }
}
