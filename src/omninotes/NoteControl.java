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
    public LinkedList<Note> getArchive(){    
      LinkedList<Note> myNotes = new LinkedList<Note>();
        try{
            Statement stmt = conn.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from post where is_archive = 1");                         
            
            while(rs.next()){
                Note note = new Note();
                note.setNoteId(rs.getInt(1));
                note.setTitle(rs.getString(2));
                note.setContent(rs.getString(3));   
                note.setIsArchived(rs.getInt(4));
                myNotes.add(note);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        return myNotes;
    }
    
    public LinkedList<Note> getTrash(){
        LinkedList<Note> myNotes = new LinkedList<Note>();
        try{
            Statement stmt = conn.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from post where is_trash = 1");                         
            
            while(rs.next()){
                Note note = new Note();
                note.setNoteId(rs.getInt(1));
                note.setTitle(rs.getString(2));
                note.setContent(rs.getString(3));   
                note.setIsArchived(rs.getInt(4));
                myNotes.add(note);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        return myNotes;
    }
    
    public NoteControl(){
        conn = db.newConnection();
    }
    
    public void openMainMenu(){
        MainMenuUI mm = new MainMenuUI();
        mm.setVisible(true);
    }
    
    //returns LinkedList of notes, get active notes
    public LinkedList<Note> getNotes(){
        LinkedList<Note> myNotes = new LinkedList<Note>();
        try{
            Statement stmt = conn.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from post where is_active = 1");                         
            while(rs.next()){                
                Note note = new Note();
                note.setNoteId(rs.getInt(1));
                note.setTitle(rs.getString(2));
                note.setContent(rs.getString(3));   
                note.setIsArchived(rs.getInt(4));
                myNotes.add(note);
            }
        }catch(Exception e) {
            System.out.println(e);
        }        
        return myNotes;        
    }
    
    public void openArchiveUI(){
        ArchiveUI archive = new ArchiveUI();
        archive.setVisible(true);
    }
    
    public void openTrashUI(){
        TrashUI trash = new TrashUI();
        trash.setVisible(true);
    }
}
