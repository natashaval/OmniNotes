/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author Natasha
 */
public class Reminder {
    private Integer reminderId;
    private Date reminderDate;
    private Integer repeat;

    public Reminder(Integer reminderId, Date reminderDate, Integer repeat) {
        this.reminderId = reminderId;
        this.reminderDate = reminderDate;
        this.repeat = repeat;
    }

    public Integer getReminderId() {
        return reminderId;
    }

    public void setReminderId(Integer reminderId) {
        this.reminderId = reminderId;
    }

    public Date getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(Date reminderDate) {
        this.reminderDate = reminderDate;
    }

    public Integer getRepeat() {
        return repeat;
    }

    public void setRepeat(Integer repeat) {
        this.repeat = repeat;
    }

    
    
    
}
