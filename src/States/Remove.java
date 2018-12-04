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
public class Remove implements NoteState{
    
    public Remove(Note note){
        this.context = note;
    }

    @Override
    public void deleteNote() {
        System.out.println("delete note");
    }

    @Override
    public void removeNote() {
        System.out.println("remove note");
    }
    
    private Note context = null;

    @Override
    public void archiveNote() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unArchiveNote() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
