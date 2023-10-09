package tn.esprit.myapplication.items;


import java.util.Date;

public class ChatMessageModel {
    private String message;
    private String senderId;
    private Date time;

    public ChatMessageModel() {
    }

    public ChatMessageModel(String message, String senderId, Date time) {
        this.message = message;
        this.senderId = senderId;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public Date getDate() {
        return time;
    }

    public void setDate(Date time) {
        this.time = time;
    }
}
