/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omninotes;

import java.util.Date;

/**
 *
 * @author Natasha
 */
public class Note {
    private Integer noteId;
    private String title;
    private String content;
    private Date createdDate;
    private Boolean isChecklist;
    private Integer isActive;
    private Boolean inTrash;
    private Boolean isArchived;

    Note() {
        
    }

    public void addTitle(Integer noteId, String title){}
    public void addAttachment(Integer noteId, Attachment attachment){}
    public void addReminder(Integer noteId, Reminder reminder){}
    public void enableChecklist(Integer noteId) {}
    
    
    public Note(Integer noteId, String title, String content, Date createdDate, Boolean isChecklist, Integer isActive, Boolean inTrash, Boolean isArchived) {
        this.noteId = noteId;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.isChecklist = isChecklist;
        this.isActive = isActive;
        this.inTrash = inTrash;
        this.isArchived = isArchived;
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

    public Boolean getIsChecklist() {
        return isChecklist;
    }

    public void setChecklist(Boolean isChecklist) {
        this.isChecklist = isChecklist;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Boolean getInTrash() {
        return inTrash;
    }

    public void setInTrash(Boolean inTrash) {
        this.inTrash = inTrash;
    }

    public Boolean getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(Boolean isArchived) {
        this.isArchived = isArchived;
    }
    
}
