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
public interface NoteState {
    public void deleteNote();
    public void removeNote();
    public void archiveNote();
    public void unArchiveNote();
}
