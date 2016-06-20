/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.dao;

import com.mycompany.dvdlibrary.dto.Genre;
import com.mycompany.dvdlibrary.dto.Note;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author apprentice
 */
public class GenreDaoImpl implements GenreDao {
    private static final String SQL_CREATE_GENRE = "INSERT INTO genre (genre_name) VALUES (?)";
    private static final String SQL_GET_GENRES_ON_DVD = "SELECT genre.genre_name FROM dvd_genre JOIN genre ON genre.id = dvd_genre.genre_id WHERE dvd_id = ? ";
    private static final String SQL_GET_GENRE_NAMES = "SELECT genre_name FROM genre";
    private static final String SQL_GET_GENRE = "SELECT genre_name FROM genre WHERE id = ?";
    private static final String SQL_GET_GENRE_ID = "SELECT id FROM genre WHERE genre_name = ?";
    private static final String SQL_GET_GENRE_COUNT = "SELECT COUNT(*) FROM dvd_genre JOIN genre ON genre.id = dvd_genre.genre_id WHERE genre.genre_name = ?";
    private static final String SQL_CREATE_DVD_GENRE_LINK = "INSERT INTO dvd_genre (dvd_id, genre_id) VALUES (?,?)";
    private static final String SQL_DELETE_GENRE_ON_DVD = "DELETE FROM dvd_genre WHERE dvd_id = ?";
    private JdbcTemplate jdbcTemplate;
    
    public GenreDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Genre get(Integer id) {
       return jdbcTemplate.queryForObject(SQL_GET_GENRE, new GenreMapper());
    }

    @Override
    public List<String> getOnDvd(Integer id) {
         List<String> genreList = jdbcTemplate.queryForList(SQL_GET_GENRES_ON_DVD, String.class, id);
         return genreList;
    }

    @Override
    public List<String> list() {
        return jdbcTemplate.queryForList(SQL_GET_GENRE_NAMES, String.class);
    }

    @Override
    public Map<String, Integer> genreCount() {
       List<String> genreList = jdbcTemplate.queryForList(SQL_GET_GENRE_NAMES, String.class);
       Map<String, Integer> genreCounts = new HashMap<>();
       for (String g : genreList) {
           Integer count = jdbcTemplate.queryForObject(SQL_GET_GENRE_COUNT, Integer.class, g);
           genreCounts.put(g, count);
       }
       return genreCounts;
    }

    @Override
    public void create(String genreName) {
        jdbcTemplate.update(SQL_CREATE_GENRE, genreName);
    }

    @Override
    public void createDvdGenreLink(String genre, Integer dvdId) {
        Integer genreId = jdbcTemplate.queryForObject(SQL_GET_GENRE_ID, Integer.class, genre);
        jdbcTemplate.update(SQL_CREATE_DVD_GENRE_LINK, dvdId, genreId);
    }

    @Override
    public void deleteOnDvd(Integer dvdId) {
        jdbcTemplate.update(SQL_DELETE_GENRE_ON_DVD, dvdId);
    }
    private static final class GenreMapper implements RowMapper<Genre> {
        @Override
        public Genre mapRow(ResultSet rs, int i) throws SQLException {
            
            Genre genre = new Genre();
            genre.setId(rs.getInt("id"));
            genre.setGenreName(rs.getString("note_text"));
            
            
            return genre;
        }
    }
}
