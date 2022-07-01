package com.example.webcrawler.internal.domain;

public class SiteContent extends Link{

    private String content;

    public SiteContent(String url, String content) {
        super(url);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
