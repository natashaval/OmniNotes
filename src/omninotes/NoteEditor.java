/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omninotes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Natasha
 */

// Controller
public class NoteEditor {    
     
    DBConnection db = new DBConnection();
    Connection conn = null;
    MainMenuUI mm = null;
    
    public NoteEditor(MainMenuUI mm){
        this.mm = mm;
        conn = db.newConnection();
    }
    
    public NoteEditor(){
        conn = db.newConnection();
    }
        
    public void categorize(Note note, Category category) {
        
    }
    
    public void uncategorize(Note note){
        
    }
    
    public void addTag(String content) {
        
    }
    
    public void shareNote(Note note){
        
    }
    
    public void archiveNote(Note note){
        
    }
    
    public void removeNote(Note note){
        
    }
    
    public void discardChanges(Note note){
        
    }
    
    public void saveNote(Note note, String mode){
        String sql;
               
        try{            
    
            if ("update".equals(mode)) {
            sql = "UPDATE post SET title = ?, content = ? WHERE id_note = ?";
            
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, note.getTitle());
            preparedStatement.setString(2, note.getContent());
            preparedStatement.setInt(3, note.getNoteId());            
            preparedStatement.executeUpdate();       
            
            }else{
                sql = "INSERT INTO post (title, content, created_date)" +
                "VALUES (?, ?, ?)";    

                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, note.getTitle());
                preparedStatement.setString(2, note.getContent());
                java.sql.Date sqlDate = new java.sql.Date(note.getCreatedDate().getTime());
                preparedStatement.setDate(3, sqlDate);
                preparedStatement.executeUpdate();        

                }             
        }
        catch(SQLException e){
            System.out.println(e.getCause());
            System.out.println(conn);
        }      
    }
    
    public void saveNote(String title, String content, String mode, int noteId){
        
    }
    
    public void addReminder(Note note){}
    
    public void openNoteEditorUI(String mode) {
        NoteFormEditorUI nfe = new NoteFormEditorUI();
        System.out.println("hehe");
        nfe.setVisible(true);
        nfe.setMode(mode);
    }
    
    public void instantiateNote(String title, String content, String mode, int noteId) {
        if ("".equals(title.trim()) || "".equals(content.trim())) {
            return;
        }
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        Date date = new Date();
        note.setCreatedDate(date);
        note.setNoteId(noteId);        
        this.saveNote(note, mode);
    }
    
    public void openNoteEditorUI(Note note, String mode) {
        NoteFormEditorUI nfe = new NoteFormEditorUI();
        nfe.setInput(note.getTitle(), note.getContent(), note.getIsArchived());
        nfe.setVisible(true);
        nfe.setMode(mode);
        nfe.setNoteId(note.getNoteId());
    }
    
    public void unArchiveNote(Note note) {}
    
    public void addChecklist() {}

    public void closeNoteEditorUI(){
        
    }
        
    
    void archiveNote(int noteId) {
        Note note = new Note();
        note.setState(new Active(note));
        
        String sql = "UPDATE post SET is_archive = 1, is_active = 0 WHERE id_note = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, noteId);        
            preparedStatement.executeUpdate();            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        note.setState(new Archive(note));
       
    }


}
