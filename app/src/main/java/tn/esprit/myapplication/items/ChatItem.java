package tn.esprit.myapplication.items;

import java.time.LocalDate;
import java.util.Date;

public class ChatItem {

    String name;
    int image;

    String text;

    String date;

    public ChatItem(String name, int image, String text, String date) {
        this.name = name;
        this.image = image;
        this.text = text;
        this.date = date;
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
}
