/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.dao;

import com.mycompany.dvdlibrary.dto.DVD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class DVDDaoObImpl implements DVDDao {
    
    private static final String SQL_INSERT_DVD = "INSERT INTO dvd (title, release_date, director, studio, user_rating, mpaa, imdb_id, poster_link, metascore, "
                                                            + "plot, imdb_votes, imdb_rating, awards, actors) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_DVD = "UPDATE dvd SET title = ?, release_date = ?, mpaa = ?, director = ?, studio = ?, user_rating = ?, imdb_id = ?, poster_link = ?, "
                                                + "metascore = ?, plot= ?, imdb_votes = ?, imdb_rating = ?, awards = ?, actors = ? WHERE id = ?";
    private static final String SQL_DELETE_DVD = "DELETE FROM dvd where id = ?";
    private static final String SQL_GET_DVD = "SELECT * FROM dvd WHERE id = ?";
    private static final String SQL_GET_DVD_LIST  = "SELECT * FROM dvd ORDER BY title";
    private static final String SQL_GET_DVD_COUNT = "SELECT COUNT(*) FROM dvd";
    private static final String SQL_GET_DVD_AVERAGE_AGE = "SELECT AVG(DATEDIFF(?, release_date)) FROM dvd";
    private static final String SQL_GET_NOTE_COUNT = "SELECT COUNT(*) FROM note"; 
    private static final String SQL_GET_DVD_LESS_THAN_AGE = "SELECT DATEDIFF(?, release_date) AS age FROM dvd HAVING age < ?";
    private static final String SQL_GET_NEWEST_DVD = "SELECT MAX(release_date) FROM dvd";
    private static final String SQL_GET_OLDEST_DVD = "SELECT MIN(release_date) FROM dvd";
    private static final String SQL_GET_DVDS_ON_DATE = "SELECT * FROM dvd WHERE release_date = ?";
    private static final String SQL_SEARCH_DVD_DIRECTOR  = "SELECT * FROM dvd WHERE director LIKE ?";
    private static final String SQL_SEARCH_DVD_STUDIO  = "SELECT * FROM dvd WHERE studio LIKE ?";
    private static final String SQL_SEARCH_DVD_MPAA  = "SELECT * FROM dvd  WHERE mpaa LIKE ?";
    private static final String SQL_SEARCH_DVD_TITLE  = "SELECT * FROM dvd  WHERE title LIKE ?";
    
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private JdbcTemplate jdbcTemplate;
    
    public DVDDaoObImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public DVD create(DVD dvd) {
        jdbcTemplate.update(SQL_INSERT_DVD, 
                dvd.getTitle(),
                dvd.getReleaseDate(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getUserRating(),
                dvd.getMpaa(),
                dvd.getImdbId(),
                dvd.getPosterLink(),
                dvd.getMetascore(),
                dvd.getPlot(),
                dvd.getImdbVotes(),
                dvd.getImdbRating(),
                dvd.getAwards(),
                dvd.getActors());
        Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        dvd.setId(id);
        return dvd;
    }

    @Override
    public void update(DVD dvd) {
        jdbcTemplate.update(SQL_UPDATE_DVD, 
                dvd.getTitle(),
                dvd.getReleaseDate(),
                dvd.getMpaa(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getUserRating(),
                dvd.getImdbId(),
                dvd.getPosterLink(),
                dvd.getMetascore(),
                dvd.getPlot(),
                dvd.getImdbVotes(),
                dvd.getImdbRating(),
                dvd.getAwards(),
                dvd.getActors(),
                dvd.getId());
    }

    @Override
    public void delete(DVD dvd) {
        jdbcTemplate.update(SQL_DELETE_DVD, dvd.getId());
    }

    @Override
    public DVD get(Integer id) {
        return jdbcTemplate.queryForObject(SQL_GET_DVD, new DvdMapper(), id);
    }

    @Override
    public List<DVD> getAll() {
        return jdbcTemplate.query(SQL_GET_DVD_LIST, new DvdMapper());
    }

    @Override
    public double findAverageAge() {
        Date date = new Date();
        String dateString = sdf.format(date);
        return jdbcTemplate.queryForObject(SQL_GET_DVD_AVERAGE_AGE, Double.class, dateString)/365;
    }

    @Override
    public double findAverageNotes() {
        Double noteCount =  jdbcTemplate.queryForObject(SQL_GET_NOTE_COUNT, Double.class);
        Double dvdCount = jdbcTemplate.queryForObject(SQL_GET_DVD_COUNT, Double.class);
        return noteCount/dvdCount;
    }

    @Override
    public List<DVD> findByAge(int years) {
        return jdbcTemplate.query(SQL_GET_DVD_LESS_THAN_AGE, new DvdMapper(), years*365);        
    }

    @Override
    public List<DVD> findByDirector(String director) {
        return jdbcTemplate.query(SQL_SEARCH_DVD_DIRECTOR, new DvdMapper(), "%" + director + "%");
    }

    @Override
    public List<DVD> findByMPAA(String mpaa) {
        return jdbcTemplate.query(SQL_SEARCH_DVD_MPAA, new DvdMapper(), "%" + mpaa + "%");
    }

    @Override
    public List<DVD> findByStudio(String studio) {
        return jdbcTemplate.query(SQL_SEARCH_DVD_STUDIO, new DvdMapper(), "%" + studio + "%");
    }

    @Override
    public List<DVD> findByTitle(String title) {
        return jdbcTemplate.query(SQL_SEARCH_DVD_TITLE, new DvdMapper(), "%" + title + "%");
    }

    @Override
    public List<DVD> findNewest() {
        String date = jdbcTemplate.queryForObject(SQL_GET_NEWEST_DVD, String.class);
        return jdbcTemplate.query(SQL_GET_DVDS_ON_DATE, new DvdMapper(), date);
    }

    @Override
    public List<DVD> findOldest() {
        String date = jdbcTemplate.queryForObject(SQL_GET_OLDEST_DVD, String.class);
        return jdbcTemplate.query(SQL_GET_DVDS_ON_DATE, new DvdMapper(), date);
    }


    @Override
    public int getCount() {
        return jdbcTemplate.queryForObject(SQL_GET_DVD_COUNT, Integer.class);
    }

    
    private static final class DvdMapper implements RowMapper<DVD> {
        @Override
        public DVD mapRow(ResultSet rs, int i) throws SQLException {
            
            DVD dvd = new DVD();
            dvd.setId(rs.getInt("id"));
            dvd.setTitle(rs.getString("title"));
            dvd.setReleaseDate(rs.getDate("release_date"));
            dvd.setDirector(rs.getString("director"));
            dvd.setStudio(rs.getString("studio"));
            dvd.setMpaa(rs.getString("mpaa"));
            dvd.setUserRating(rs.getInt("user_rating"));
            dvd.setImdbId(rs.getString("imdb_id"));
            dvd.setPosterLink(rs.getString("poster_link"));
            dvd.setPlot(rs.getString("plot"));
            dvd.setMetascore(rs.getInt("metascore"));
            dvd.setImdbVotes(rs.getLong("imdb_votes"));
            dvd.setImdbRating(rs.getDouble("imdb_rating"));
            dvd.setAwards(rs.getString("awards"));
            dvd.setActors(rs.getString("actors"));
            return dvd;
        }
    }
    
}
