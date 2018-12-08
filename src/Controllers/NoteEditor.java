/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import States.Active;
import States.Active;
import States.Archive;
import States.Archive;
import Models.Category;
import Models.Category;
import Configs.DBConnection;
import Configs.DBConnection;
import Configs.HTTPRequest;
import Models.Attachment;
import Models.Location;
import Views.MainMenuUI;
import Views.MainMenuUI;
import Models.Note;
import Models.Note;
import Views.NoteFormEditorUI;
import Views.NoteFormEditorUI;
//import com.sun.xml.internal.bind.v2.TODO;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

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
//   saves new note
    public void saveNote(Note note) throws Exception {
        String sql = "INSERT INTO post (title, content, created_date, location, tag, attachment_path, attachment_type)" +
        "VALUES (?, ?, ?, ?, ?)";    
        java.sql.Date sqlDate = new java.sql.Date(note.getCreatedDate().getTime());

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, note.getTitle());
        preparedStatement.setString(2, note.getContent());
        preparedStatement.setDate(3, sqlDate);
        preparedStatement.setString(4, note.getLocation());
        preparedStatement.setString(5, note.getTag());
        preparedStatement.setString(6, note.getAttachment().getLocation());
        preparedStatement.setString(7, note.getAttachment().getFileType());

        preparedStatement.executeUpdate();        
    
    }
//    update current note
    public void updateNote(Note note) throws Exception {
        String sql = "UPDATE post SET title = ?, content = ?, location = ?, tag = ?, attachment_path = ?, attachment_type = ? WHERE id_note = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, note.getTitle());
        preparedStatement.setString(2, note.getContent());
        preparedStatement.setString(3, note.getLocation());
        preparedStatement.setString(4, note.getTag());        
        preparedStatement.setString(5, note.getAttachment().getLocation());
        preparedStatement.setString(6, note.getAttachment().getFileType());
        
        preparedStatement.setInt(7, note.getNoteId());   
        
        System.out.println("updated " + note.getAttachment().getLocation());
        
        preparedStatement.executeUpdate();     
        
    }
    
    public void saveNote(String title, String content, String mode, int noteId){
        
    }
    
    public void addReminder(Note note){}
    
    public void openNoteEditorUI(String mode) {
        NoteFormEditorUI nfe = new NoteFormEditorUI();
        nfe.setVisible(true);
        nfe.setMode(mode);
    }
    
    public void instantiateNote(String title, String content, String mode, int noteId, String location, Category c, String tag,
        String fileName, String fileLocation, String fileType) {
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        Date date = new Date();
        note.setCreatedDate(date);
        note.setNoteId(noteId);        
        note.setLocation(location);
        note.setTag(tag);
        
        Attachment a = new Attachment(fileName, fileLocation, fileType);
        note.setAttachment(a);
        try {
            //update note
            if ("update".equals(mode)) {
                this.updateNote(note);
            } else {  //insert new note
                this.saveNote(note);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());            
        }


    }
    
    public void openNoteEditorUI(Note note, String mode) {
        NoteFormEditorUI nfe = new NoteFormEditorUI();
        Category cat = null;
        
        CategoryController cc = new CategoryController();
        System.out.println("fiiiiid");
//        find category attach to note
        try {
            cat = cc.findCategory(note.getCategoryId()); // returns category
        } catch (Exception ex) {
            Logger.getLogger(NoteEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (cat == null) {
            cat = new Category();
            cat.setName("None");
            cat.setRed(-1); cat.setGreen(-1); cat.setBlue(-1);
        }
        
        
        nfe.setInput(note.getTitle(), note.getContent(), note.getIsArchived(), note.getTag(), note.getLocation(), cat.getName(), cat.getRed(), cat.getGreen(), cat.getBlue());
        System.out.println("ooooo");
        nfe.setVisible(true);
        nfe.setMode(mode);
        nfe.setNoteId(note.getNoteId());
        nfe.setInTrash(note.getInTrash());
        nfe.setIsArchived(note.getIsArchived());
    }
    
    public void unArchiveNote(Note note) {        
//        note.setState(new Archive(note));
        
        String sql = "UPDATE post SET is_archive = 0, is_active = 1 WHERE id_note = ?";
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, note.getNoteId());        
            preparedStatement.executeUpdate();            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        note.setState(new Active(note));
        System.out.println("Note has been unarchived");
        NoteController nc = new NoteController();
        nc.openArchiveUI();
    }
    
    public void addChecklist() {}

    public void closeNoteEditorUI(){
        
    }
        
    
    public void archiveNote(int noteId) {
        Note note = new Note();
        note.archive();
        
        String sql = "UPDATE post SET is_archive = 1, is_active = 0 WHERE id_note = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, noteId);        
            preparedStatement.executeUpdate();            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }              
    }

    public void removeNote(int noteId) throws Exception {
        String sql = "UPDATE post set is_active = 0, is_archive = 0 ,is_trash = 1 WHERE id_note = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, noteId);        
        preparedStatement.executeUpdate(); 
    }
    
    public void deleteNote(int noteId) throws Exception {
        String sql = "UPDATE post set is_deleted = 1, is_trash = 0 WHERE id_note = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, noteId);        
        preparedStatement.executeUpdate(); 
    }
    
    public void updateRemovedNote(int noteId, String title, String content) throws Exception {
        String sql = "UPDATE post set title = ?, set content = ? WHERE id_note = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, noteId);     
        preparedStatement.setString(2, title);        
        preparedStatement.setString(3, content);        

        preparedStatement.executeUpdate(); 
    
    
    }
    
    public LinkedList<Location> searchLocation(String query) throws IOException, JSONException{
        HTTPRequest req = null;
        try {
            req = new HTTPRequest("http://dev.virtualearth.net/REST/v1/Locations?query="+URLEncoder.encode(query, "UTF-8")+"&key=AiOtGAc694vVDVHMbMauu_fkxtvhvUX4tjpHuN76_h0nUGc-e2Ov7quNYMpA9Vnk");
            req.setMethod("GET");
        } catch (Exception ex) {
            Logger.getLogger(HTTPRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return req.getResponse();
    }
    
    public void restoreNote(int noteId) throws Exception {
        String sql = "UPDATE post set is_active = 1, is_trash = 0 WHERE id_note = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, noteId);       
        preparedStatement.executeUpdate(); 
    }



}
