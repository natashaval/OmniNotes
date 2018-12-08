/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Natasha
 */
public class Attachment {
    
    private Integer attachmentId;
    private String name;
    private String location;
    private String fileType;

    public Attachment(Integer attachmentId, String name, String location, String fileType) {
        this.attachmentId = attachmentId;
        this.name = name;
        this.location = location;
        this.fileType = fileType;
    }
    
    public Attachment(String name, String location, String fileType) {
        this.attachmentId = attachmentId;
        this.name = name;
        this.location = location;
        this.fileType = fileType;
    }
    
    public Attachment() { }


    public Integer getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Integer attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    
    
    
    
}
