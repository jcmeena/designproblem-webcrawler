package com.example.webcrawler.internal.worker.extractor.filter;

public interface UrlFilter {
    boolean isAllowedFilter(String url);
}
