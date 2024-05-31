package com.example.news_api.model;

import java.util.List;

public class newsResponse {
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public static class Article {
        private String title;
        private String description;
        private String urlToImage;
        // You can include other properties such as author, publishedAt, etc. if needed

        // Getters and setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrlToImage() {
            return urlToImage;
        }

        public void setUrlToImage(String url) {
            this.urlToImage = urlToImage;
        }
    }
}


//https://newsapi.org/v2/everything?q=Apple&from=2024-05-30&apiKey=fbbe764ae7ef457bb85f903e486425d7