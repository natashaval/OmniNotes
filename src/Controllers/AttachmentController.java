/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Attachment;
import Views.AttachmentUI;
import Views.NoteFormEditorUI;
import java.io.File;
import java.io.FileFilter;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Natasha
 */

public class AttachmentController {
    
    public NoteFormEditorUI nfeUI = null;
    AttachmentUI aui = null;
    
    public AttachmentController(){}

    public AttachmentController(NoteFormEditorUI aThis) {
        nfeUI = new NoteFormEditorUI();
        this.nfeUI = aThis;
        int noteId = this.nfeUI.getNoteId();
        System.out.println(noteId);
    }
    
    public void addPhoto(){
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Photos", "jpg", "jpeg", "png");
        this.openAttachmentChooser(filter);
    }
    
    public void addVideo(){
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Videos", "mp4", "mpeg", "wav");
        this.openAttachmentChooser(filter);
    }
    
    public void addFile(){
        FileNameExtensionFilter filter = null;
        this.openAttachmentChooser(filter);
    }
    
    public void addAudio(){
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Audios", "mp3", "mp2");
        this.openAttachmentChooser(filter);
    }
    
    public void addSketch(){
        FileNameExtensionFilter filter = null;
        this.openAttachmentChooser(filter);
    }
    
    public void addLocation() {
        
    }
    
    public void selectFile(int ret, JFileChooser fc) {
        String fileName = "", filePath = "";
        
        System.out.println("note id in ac " + this.nfeUI.getNoteId());
        
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            fileName = file.getName();
            filePath = file.getAbsolutePath();
//            System.out.println(fileName);
//            System.out.println(filePath);
//            System.out.println("Clicked on attachment!");   
//            System.out.println(this.getFileExtension(file));
               
            Attachment a = new Attachment(fileName, filePath, this.getFileExtension(file));
            
            this.setAttachment(a);
            
        }  
    }
    
    public String test = "huy";
    
    public void openAttachmentUI(){
        aui = new AttachmentUI(this);
        aui.setVisible(true);
//        JDialog dialog = new JDialog();
//        final JFileChooser fc = new JFileChooser();        
//        int ret = fc.showOpenDialog(dialog);
//        String fileName = "", filePath = "";
//        
//        if (ret == JFileChooser.APPROVE_OPTION) {
//            File file = fc.getSelectedFile();
//            fileName = file.getName();
//            filePath = file.getAbsolutePath();
//            System.out.println(fileName);
//            System.out.println(filePath);
//            System.out.println("Clicked on attachment!");            
//        }  
    }
    
    public void setAttachment(Attachment a) {
        this.nfeUI.setAttachment(a.getLocation(), a.getName(), a.getFileType());
    }
    
    private void openAttachmentChooser(FileNameExtensionFilter filter) {
        JDialog dialog = new JDialog();
        final JFileChooser fc = new JFileChooser();                  
        if (filter != null) {
            
        }
        fc.setFileFilter(filter);
                
        int ret = fc.showOpenDialog(dialog);
        this.selectFile(ret, fc);
    }
    
    
    private String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
    
}
