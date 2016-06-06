/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.dto;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author apprentice
 */
public class DVD {
    private int id;
    
    @NotEmpty
    private String title;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @NotNull
    private Date releaseDate;
    
    @NotEmpty
    private String mpaa;
    private String director;
    private String studio;
    
    @NotNull
    @Digits(integer=2, fraction=0)
    private Integer userRating;
    
    private String notes;
    
    public List<String> noteList;

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the releaseDate
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * @return the mpaa
     */
    public String getMpaa() {
        return mpaa;
    }

    /**
     * @param mpaa the mpaa to set
     */
    public void setMpaa(String mpaa) {
        this.mpaa = mpaa;
    }

    /**
     * @return the studio
     */
    public String getStudio() {
        return studio;
    }

    /**
     * @param studio the studio to set
     */
    public void setStudio(String studio) {
        this.studio = studio;
    }

    /**
     * @return the userRating
     */
    public Integer getUserRating() {
        return userRating;
    }

    /**
     * @param userRating the userRating to set
     */
    public void setUserRating(Integer userRating) {
        this.userRating = userRating;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return the noteList
     */
    public List<String> getNoteList() {
        return noteList;
    }

    /**
     * @param noteList the noteList to set
     */
    public void setNoteList(List<String> noteList) {
        this.noteList = noteList;
    }
    
}
