/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.dao;


import com.mycompany.dvdlibrary.dto.Note;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author apprentice
 */
public class NoteDaoImpl implements NoteDao {
    private static final String SQL_INSERT_NOTE = "INSERT INTO note (note_text, dvd_id) VALUES (?, ?)";
    private static final String SQL_UPDATE_NOTE = "UPDATE note SET note_text = ?, dvd_id = ? WHERE id = ?";
    private static final String SQL_DELETE_NOTE = "DELETE FROM note where id = ?";
    private static final String SQL_GET_NOTE = "SELECT * FROM note where id = ?";
    private static final String SQL_GET_NOTE_LIST  = "SELECT * FROM note WHERE dvd_id = ?";
    private static final String SQL_DELETE_NOTES_ON_DVD = "DELETE FROM note WHERE dvd_id = ?";
    private JdbcTemplate jdbcTemplate;
    
    public NoteDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public Note create(Note note) {
        jdbcTemplate.update(SQL_INSERT_NOTE, 
                note.getNoteText(), 
                note.getDvdId());
        Integer id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        note.setId(id);
        return note;
    }

    @Override
    public Note get(Integer id) {
        return jdbcTemplate.queryForObject(SQL_GET_NOTE, new NoteMapper(), id);
    }

    @Override
    public List<Note> list(Integer id) {
        return jdbcTemplate.query(SQL_GET_NOTE_LIST, new NoteMapper(), id);
    }

    @Override
    public void update(Note note) {
        jdbcTemplate.update(SQL_UPDATE_NOTE, 
                note.getNoteText(),
                note.getDvdId(),
                note.getId());
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update(SQL_DELETE_NOTE, id);
    }
    @Override
    public void deleteOnDvd(Integer id) {
        jdbcTemplate.update(SQL_DELETE_NOTES_ON_DVD, id);
    }
    
    private static final class NoteMapper implements RowMapper<Note> {
        @Override
        public Note mapRow(ResultSet rs, int i) throws SQLException {
            
            Note note = new Note();
            note.setId(rs.getInt("id"));
            note.setNoteText(rs.getString("note_text"));
            note.setDvdId(rs.getInt("dvd_id"));
            
            
            return note;
        }
    }
}
