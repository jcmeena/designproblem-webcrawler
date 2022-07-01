package com.example.webcrawler.api;

import com.example.webcrawler.internal.domain.Link;
import com.example.webcrawler.internal.domain.SiteContent;
import com.example.webcrawler.internal.storage.CrawlerResultStore;
import com.example.webcrawler.internal.storage.UnprocessedLinkQueue;
import com.example.webcrawler.internal.worker.WebCrawlerWorker;

import java.util.List;

public class WebCrawlerServiceImpl  implements WebCrawlerService{
    private int size = 50;
    @Override
    public void setResultLimit(int size){
        this.size = size;
    }
    @Override
    public List<SiteContent> searchText(String searchString, List<String> seedUrls) {

        // initialize the queue
        UnprocessedLinkQueue queue = UnprocessedLinkQueue.getInstance();
        seedUrls.forEach(e -> queue.addLinkToUnprocessedQueue(e));

        CrawlerResultStore resultStore  = CrawlerResultStore.getInstance();

        // visit all the link
        while(queue.hasNext()){

            WebCrawlerWorker worker  = new WebCrawlerWorker();
            Link link = queue.next();
            //System.out.println("queue link " + link.getUrl());
            worker.processRequest(link,searchString);
            if(resultStore.size() > size){
                System.out.println("Breaking on condition of the resultStore");
                break;
            }
        }
        return resultStore.getResults();
    }
}
