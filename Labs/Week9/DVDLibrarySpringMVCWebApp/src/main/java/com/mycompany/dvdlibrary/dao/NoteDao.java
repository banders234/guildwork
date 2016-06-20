/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.dao;

import com.mycompany.dvdlibrary.dto.Note;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface NoteDao {
    public Note create(Note note);
    public Note get(Integer id);
    public List<Note> list(Integer id);
    public void update(Note note);
    public void delete(Integer id);
    public void deleteOnDvd(Integer id);
}
