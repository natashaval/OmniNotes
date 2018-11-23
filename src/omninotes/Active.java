/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omninotes;

/**
 *
 * @author adis
 */
public class Active implements NoteState {
//    user defined
    private Note context = null;
    
    public Active(Note note){
        System.out.println("Note is in Active state");
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
        System.out.println("Note archived -- from Active.java");
    }

    @Override
    public void unArchiveNote() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
