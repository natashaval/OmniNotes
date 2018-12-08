/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import Views.ArchiveUI;
import Views.ArchiveUI;
import Configs.DBConnection;
import Configs.DBConnection;
import Models.Category;
import Views.MainMenuUI;
import Views.MainMenuUI;
import Models.Note;
import Models.Note;
import Views.TrashUI;
import Views.TrashUI;
import java.sql.PreparedStatement;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.concurrent.Task;

/**
 *
 * @author Natasha
 */

// Controller
public class NoteController {
    DBConnection db = new DBConnection();
    Connection conn = null;
    
    public void createNew() {}
    public void edit(Integer noteId) {}      
    public List<Note> search(String keyword) {return null; }
    public List<Note> filter (Integer categoryId) {return null; }
    public void restore(Note note) {}
    public void delete(Note note){}
    public List<Note> getActiveNotes(){return null;}    
    
    public LinkedList<Note> getArchive(){    
      LinkedList<Note> myNotes = new LinkedList<Note>();
        try{
            Statement stmt = conn.createStatement();  
            ResultSet res=stmt.executeQuery("select * from post where is_archive = 1");                         
            
            while(res.next()){
                Note note = new Note();                
                note.setNoteId(res.getInt(1));
                note.setTitle(res.getString(2));
                note.setContent(res.getString(3));   
                note.setIsArchived(res.getInt(4));
                note.setLocation(res.getString(10));
//                System.out.println(res.getString(10));
                note.setTag(res.getString(12));
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
            ResultSet res=stmt.executeQuery("select * from post where is_trash = 1");                         
            
            while(res.next()){
                Note note = new Note();                
                note.setNoteId(res.getInt(1));
                note.setTitle(res.getString(2));
                note.setContent(res.getString(3));   
                note.setIsArchived(res.getInt(4));
                note.setLocation(res.getString(10));
                note.setTag(res.getString(12));
                myNotes.add(note);  
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        return myNotes;
    }
    
    public NoteController(){
        conn = db.newConnection();
    }
    
    public void openMainMenu(){
        MainMenuUI mm = new MainMenuUI();
        mm.setVisible(true);
    }
    
    //returns LinkedList of notes, get active notes
    public LinkedList<Note> getNotes() {
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
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }                    
        return myNotes;              
    }
    
    
    public LinkedList<Note> sortNotes(Integer sortby) throws Exception{
        LinkedList<Note> myNotes = new LinkedList<Note>();

        String sql = null;
        switch (sortby){
            case 1: sortby = 1;
                sql = "select * from post where is_active = 1 order by title asc";
                break;
            case 2: sortby = 2;
                sql = "select * from post where is_active = 1 order by title desc";
                break;
            case 3: sortby = 3;
                sql = "select * from post where is_active = 1 order by created_date asc";
                break;
            case 4: sortby = 4;
                sql = "select * from post where is_active = 1 order by created_date desc";
                break;                
        }
        
        Statement stmt = null;
        stmt = conn.createStatement();
        ResultSet res = stmt.executeQuery(sql);
        
        while (res.next()) {
            Note note = new Note();                
            note.setNoteId(res.getInt(1));
            note.setTitle(res.getString(2));
            note.setContent(res.getString(3));   
            note.setIsArchived(res.getInt(4));
            note.setLocation(res.getString(10));
            note.setTag(res.getString(12));
            note.setCategoryId(res.getString(11));
            myNotes.add(note);                
        }
        return myNotes;
    }
    
        public LinkedList<Note> getNotesFromCategory(int catId) throws Exception {
        String sql = "select * from post where id_category = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, catId);       
        ResultSet res = preparedStatement.executeQuery(); 
        
        LinkedList<Note> notes = new LinkedList();
        
        while (res.next()) {
            System.out.println("ya");
            Note note = new Note();
            note.setNoteId(res.getInt(1));
            note.setTitle(res.getString(2));
            note.setContent(res.getString(3));   
            note.setIsArchived(res.getInt(4));
            note.setLocation(res.getString(10));
            note.setTag(res.getString(12));
            notes.add(note);
        }
                
        return notes;        
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
