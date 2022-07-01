package com.example.webcrawler.api;

import com.example.webcrawler.internal.domain.SiteContent;

import java.util.List;

public interface WebCrawlerService {
    void setResultLimit(int size);

    List<SiteContent> searchText(String searchString, List<String> seedUrls);

}
