/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author apprentice
 */
public class DVD {
    private Integer id;
    
    @NotEmpty(message="You must enter a title!")
    private String title;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="EST")
    @NotNull(message="You must enter a date!")
    private Date releaseDate;
    
    private String actors;
    private String dateString;
    private String country;
    private String posterLink;
    private Long imdbVotes;
    private Double imdbRating;
    private String awards;
    private Integer metascore;
    private String plot;
    private String imdbId;
    private List<String> genreList;
    private String year;
    
    @NotEmpty(message="You must enter an MPAA rating!")
    @NotNull(message="You must enter an MPAA rating!")
    private String mpaa;
    
    @NotEmpty(message="You must enter a Director!")
    @NotNull(message="You must enter a Director!")
    private String director;
    private String studio;
    
    @NotNull(message="You must enter a user rating!")
    @Digits(integer=2, fraction=0)
    private Integer userRating;
    
    private String notes;
    
    private List<String> noteList;

    private List<Note> noteObjectList;
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

    /**
     * @return the dateString
     */
    public String getDateString() {
        return dateString;
    }

    /**
     * @param dateString the dateString to set
     */
    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    /**
     * @return the noteObjectList
     */
    public List<Note> getNoteObjectList() {
        return noteObjectList;
    }

    /**
     * @param noteObjectList the noteObjectList to set
     */
    public void setNoteObjectList(List<Note> noteObjectList) {
        this.noteObjectList = noteObjectList;
    }

    /**
     * @return the imdbId
     */
    public String getImdbId() {
        return imdbId;
    }

    /**
     * @param imdbId the imdbId to set
     */
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    /**
     * @return the posterLink
     */
    public String getPosterLink() {
        return posterLink;
    }

    /**
     * @param posterLink the posterLink to set
     */
    public void setPosterLink(String posterLink) {
        this.posterLink = posterLink;
    }

    /**
     * @return the imdbVotes
     */
    public Long getImdbVotes() {
        return imdbVotes;
    }

    /**
     * @param imdbVotes the imdbVotes to set
     */
    public void setImdbVotes(Long imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    /**
     * @return the imdbRating
     */
    public Double getImdbRating() {
        return imdbRating;
    }

    /**
     * @param imdbRating the imdbRating to set
     */
    public void setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
    }

    /**
     * @return the awards
     */
    public String getAwards() {
        return awards;
    }

    /**
     * @param awards the awards to set
     */
    public void setAwards(String awards) {
        this.awards = awards;
    }

    /**
     * @return the metascore
     */
    public Integer getMetascore() {
        return metascore;
    }

    /**
     * @param metascore the metascore to set
     */
    public void setMetascore(Integer metascore) {
        this.metascore = metascore;
    }

    /**
     * @return the plot
     */
    public String getPlot() {
        return plot;
    }

    /**
     * @param plot the plot to set
     */
    public void setPlot(String plot) {
        this.plot = plot;
    }


    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the genreList
     */
    public List<String> getGenreList() {
        return genreList;
    }

    /**
     * @param genreList the genreList to set
     */
    public void setGenreList(List<String> genreList) {
        this.genreList = genreList;
    }

    /**
     * @return the actors
     */
    public String getActors() {
        return actors;
    }

    /**
     * @param actors the actors to set
     */
    public void setActors(String actors) {
        this.actors = actors;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }
    
}
