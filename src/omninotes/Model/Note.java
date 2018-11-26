/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omninotes.Model;

import java.util.Date;
import omninotes.Active;
import omninotes.NoteState;

/**
 *
 * @author Natasha
 */
public class Note {
    private Integer noteId;
    private String title;
    private String content;
    private Date createdDate;
    private int isChecklist;
    private int isActive;
    private int inTrash;
    private int isArchived;

    public Note() {
       currentState = new Active(this);
    }

    public void addTitle(Integer noteId, String title){}
    public void addAttachment(Integer noteId, Attachment attachment){}
    public void addReminder(Integer noteId, Reminder reminder){}
    public void enableChecklist(Integer noteId) {}
    
    
    public Note(Integer noteId, String title, String content, Date createdDate, int isChecklist, Integer isActive, int inTrash, int isArchived) {
        this.noteId = noteId;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.isChecklist = isChecklist;
        this.isActive = isActive;
        this.inTrash = inTrash;
        this.isArchived = isArchived;
            
        currentState = new Active(this);
        
    }

    
    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getIsChecklist() {
        return isChecklist;
    }

    public void setChecklist(int isChecklist) {
        this.isChecklist = isChecklist;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public int getInTrash() {
        return inTrash;
    }

    public void setInTrash(int inTrash) {
        this.inTrash = inTrash;
    }

    public int getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(int isArchived) {
        this.isArchived = isArchived;
        currentState.archiveNote();
    }
    
    
    
    //    User defined properties & methods 
    //    State design pattern   
    
    private NoteState currentState = null;

    public void setState(NoteState newState){
        this.currentState = newState;                
    }
    
    
}
