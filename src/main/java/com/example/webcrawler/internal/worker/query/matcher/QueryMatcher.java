package com.example.webcrawler.internal.worker.query.matcher;

public interface QueryMatcher {
    boolean matchesQuery(String searchQuery , String content);

}
