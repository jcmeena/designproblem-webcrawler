package com.example.webcrawler.client;

import com.example.webcrawler.api.WebCrawlerService;
import com.example.webcrawler.api.WebCrawlerServiceImpl;
import com.example.webcrawler.internal.domain.SiteContent;

import java.util.Arrays;
import java.util.List;

public class WebCrawlerClient {
    public static void main(String[] args) {
        WebCrawlerService service = new WebCrawlerServiceImpl();
        List<String> seedUrls = Arrays.asList(  "https://www.bbc.com/sport","https://www.bbc.com", "https://www.uefa.com");
        String searchString = "Football Chelsea " ;
        service.setResultLimit(3);
        List<SiteContent> results =service.searchText(searchString, seedUrls);

        for (SiteContent result : results) {
            System.out.println(result.getUrl());
        }
        System.out.println("Results found : " + results.size());

    }
}
