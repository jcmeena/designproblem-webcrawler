package com.example.webcrawler.internal.storage;

import com.example.webcrawler.internal.domain.SiteContent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CrawlerResultStore {
    private Queue<SiteContent> resultStore  ;
    private CrawlerResultStore(){
        resultStore  = new LinkedList<>();
    }
    private static  class  QueryResultStoreSingleton {
        private static final CrawlerResultStore instance = new CrawlerResultStore();
    }
    public static CrawlerResultStore getInstance(){
        return QueryResultStoreSingleton.instance;
    }

    public void addNewResult( SiteContent siteContent){
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

        resultStore.add(siteContent);
        System.out.println(resultStore.peek());
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public List<SiteContent> getResults(){
        List<SiteContent> result =  new ArrayList<>(resultStore.size());
        resultStore.forEach(e-> result.add(e));
        return result;
    }
    public int size(){
        return resultStore.size();
    }


}
