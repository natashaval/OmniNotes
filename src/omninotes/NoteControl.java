/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omninotes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Natasha
 */

// Controller
public class NoteControl {
    DBConnection db = new DBConnection();
    Connection conn = null;
    
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
    
    public NoteControl(){
        conn = db.newConnection();
    }
    
    public void openMainMenu(){} // tidak tahu karena boundary
    
    public LinkedList<Note> getNotes(){
        LinkedList<Note> myNotes = new LinkedList<Note>();
        try{
            Statement stmt = conn.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from post");                         
            while(rs.next()){                
                Note note = new Note();
                note.setNoteId(rs.getInt(1));
                note.setTitle(rs.getString(2));
                note.setContent(rs.getString(3));                                
                myNotes.add(note);
            }
        }catch(Exception e) {
            System.out.println(e);
        }        
        return myNotes;        
    }
}
