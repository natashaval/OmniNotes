/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omninotes;

import java.util.List;

/**
 *
 * @author Natasha
 */

// Controller
public class NoteControl {
    public void createNew() {}
    public void edit(Integer noteId) {}
    public void sort() {}
    public List<Note> search(String keyword) {return null; }
    public List<Note> filter (Integer categoryId) {return null; }
    public void restore(Note note) {}
    public void delete(Note note){}
    public List<Note> getActiveNotes(){return null;}
    public List<Note> getTrash(){return null;}
    public List<Note> getArchive(){return null;}
    
    public void openMainMenu(){} // tidak tahu karena boundary
}
