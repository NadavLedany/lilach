package org.cshaifasweng.winter.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private boolean purchased;
    private String description;

    private boolean email;

    private String answer;
    private Double compensation = 0.0;

    private  boolean isOpen;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date complaintOpen;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date complaintClose;

    public Complaint() {
    }

    public Complaint(String description, boolean email) {
        this.description = description;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Double getCompensation() {
        return compensation;
    }

    public void setCompensation(Double compensation) {
        this.compensation = compensation;
    }

    private void getOpenTime(){
        complaintOpen = new Date();
        String StrDateFormat =  "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(StrDateFormat);
        String formattedDate= dateFormat.format(complaintOpen);

    }
    private void getCloseTime(){
        complaintClose = new Date();
        String StrDateFormat =  "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(StrDateFormat);
        String formattedDate= dateFormat.format(complaintClose);

    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Date getComplaintOpen() {
        return complaintOpen;
    }

    public void setComplaintOpen(Date complaintOpen) {
        this.complaintOpen = complaintOpen;
    }

    public Date getComplaintClose() {
        return complaintClose;
    }

    public void setComplaintClose(Date complaintClose) {
        this.complaintClose = complaintClose;
    }
}
