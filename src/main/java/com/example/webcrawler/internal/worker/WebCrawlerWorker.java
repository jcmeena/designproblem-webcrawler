package com.example.webcrawler.internal.worker;

import com.example.webcrawler.internal.domain.Link;
import com.example.webcrawler.internal.domain.SiteContent;
import com.example.webcrawler.internal.storage.CrawlerResultStore;
import com.example.webcrawler.internal.storage.UnprocessedLinkQueue;
import com.example.webcrawler.internal.storage.VisitedLinkStore;
import com.example.webcrawler.internal.worker.downloader.ContentDownloader;
import com.example.webcrawler.internal.worker.downloader.SimpleContentDownloader;
import com.example.webcrawler.internal.worker.extractor.chilldren.ChildLinkExtractor;
import com.example.webcrawler.internal.worker.extractor.chilldren.SimpleChildLinkExtractor;
import com.example.webcrawler.internal.worker.query.matcher.BooleanANDQueryMatcherImpl;
import com.example.webcrawler.internal.worker.query.matcher.QueryMatcher;

import java.util.List;

public class WebCrawlerWorker {


    public void processRequest(Link link, String searchString) {
        // crawl one link
        // save the url to visited

        // download the content
        ContentDownloader contentDownloader =  new SimpleContentDownloader();
        String content = contentDownloader.extractContentFromLink(link.getUrl());
        boolean badLinkSource  = content == null || content.isEmpty();
        if(!badLinkSource){
            // search the string
            QueryMatcher matcher  = new BooleanANDQueryMatcherImpl();

            // match the searchString
            boolean isMatch = matcher.matchesQuery(searchString,content);
            if(isMatch){
                // matched then add to stored results
                SiteContent sc =  new SiteContent(link.getUrl(), content);
                CrawlerResultStore.getInstance().addNewResult(sc);
            }
            // not matched then ignore

            // save this link to visited link store
            VisitedLinkStore.getInstance().addLinkToSet(link);

            // find the child links
            ChildLinkExtractor childLinkExtractor = new SimpleChildLinkExtractor();
            List<Link> childLinks = childLinkExtractor.extractLink(content);

            // add child links to UnprocessedQueue
            childLinks.forEach( e -> UnprocessedLinkQueue.getInstance().addLinkToUnprocessedQueue(e.getUrl()));

        }

    }
}
