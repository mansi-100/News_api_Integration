package com.example.news_api;

public class news {
    String description,title;
    String country;
    String imageUrl; // Add this field for the image URL

    public news(String description, String title, String imageUrl, String country) {
        this.description = description;
        this.title = title;
        this.imageUrl = imageUrl;
        this.country=country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
