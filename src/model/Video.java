package model;

import util.DateUtil;

import java.util.Date;

public class Video {
    private String title;
    private String description;
    private int duration; // em minutos
    private String category;
    private Date publicationDate;

    public Video(String title, String description, int duration, String category, Date publicationDate) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.category = category;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public String getCategory() {
        return category;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return title + ";" + description + ";" + duration + ";" + category + ";" + DateUtil.toString(publicationDate);
    }
}