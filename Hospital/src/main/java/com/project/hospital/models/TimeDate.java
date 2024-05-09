package com.project.hospital.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.sql.Time;
import java.util.Date;

@Embeddable
public class TimeDate {
    private Time time;
    @Temporal(TemporalType.DATE)
    private Date date;

    public TimeDate() {}

    public TimeDate(Time time, Date date) {
        this.time = time;
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
