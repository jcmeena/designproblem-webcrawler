package com.example.webcrawler.internal.worker.extractor.chilldren;

import com.example.webcrawler.internal.domain.Link;

import java.util.List;

public interface ChildLinkExtractor {
    List<Link> extractLink(String content);
}
