package tn.esprit.myapplication.items;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ChatMessageModel implements Serializable {
    public static ArrayList<ChatMessageModel> messageArrayList = new ArrayList<>();

    private int id;
    private String message;
    private int senderId;
    private int receiverId;
    private Date time;

    public ChatMessageModel() {
    }

    public ChatMessageModel(String message, int senderId, int receiverId, Date time) {
        this.message = message;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.time = time;
    }

    public ChatMessageModel(String message, int senderId, Date time) {
        this.message = message;
        this.senderId = senderId;
        this.time = time;
    }

    public ChatMessageModel(int id, String message, int senderId, int receiverId, Date time) {
        this.id = id;
        this.message = message;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.time = time;
    }

    @Override
    public String toString() {
        return "ChatMessageModel{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", time=" + time +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
