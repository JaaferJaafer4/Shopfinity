package tn.esprit.myapplication.items;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ChatItem implements Serializable {
    private static ChatItem selectedProfile = new ChatItem();

    int id;
    String name;
    int image;

    String text;

    String date;

    public ChatItem() {

    }

    public ChatItem(int id, String name, int image, String text, String date) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.text = text;
        this.date = date;
    }

    public ChatItem(String name, int image, String text, String date) {
        this.name = name;
        this.image = image;
        this.text = text;
        this.date = date;
    }

    @Override
    public String toString() {
        return "ChatItem{" +
                "name='" + name + '\'' +
                ", image=" + image +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static ChatItem getSelectedProfile() {
        return selectedProfile;
    }

    public static void setSelectedProfile(ChatItem selectedProfile) {
        ChatItem.selectedProfile = selectedProfile;
    }
}
