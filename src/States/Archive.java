/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package States;

import Models.Note;

/**
 *
 * @author adis
 */
public class Archive implements NoteState{
//        user defined properties
    private Note context = null;
    
    public Archive(Note note){
        System.out.println("Note is in archive state");
        this.context = note;
    }

    @Override
    public void deleteNote() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeNote() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void archiveNote() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unArchiveNote() {
        this.context.setState(new Active(context));
    }
    
}
