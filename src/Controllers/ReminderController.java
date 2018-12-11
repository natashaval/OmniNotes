/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Reminder;
import Views.NoteFormEditorUI;
import Views.ReminderUI;
import java.util.Date;

/**
 *
 * @author Natasha
 */
public class ReminderController {

    private NoteFormEditorUI nfeui = new NoteFormEditorUI();   
    private Reminder reminder = null;
    
    public ReminderController(NoteFormEditorUI aThis) {
//        this.nfeui = new NoteFormEditorUI();
        this.nfeui = aThis;
        reminder = new Reminder();
    }

    public ReminderController() { }

    
    public void addDate(String date) {
        reminder.setReminderDate(date);        
    }
    
    public void setTime(String time) {
//        concat date and time
        reminder.setReminderDate(reminder.getReminderDate() + time);      

    }
    
    public void addRepeat(Integer number) {
        reminder.setRepeat(number.toString());
        this.nfeui.setReminder(reminder.getReminderDate(), reminder.getRepeat());
    }
    
    public void openReminderUI() {
        ReminderUI rui = new ReminderUI(this);
    }
    
}
