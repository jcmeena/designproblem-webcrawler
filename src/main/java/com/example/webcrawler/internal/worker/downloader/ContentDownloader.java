package com.example.webcrawler.internal.worker.downloader;

public interface ContentDownloader {
    String extractContentFromLink(String urlToVisit);
}
