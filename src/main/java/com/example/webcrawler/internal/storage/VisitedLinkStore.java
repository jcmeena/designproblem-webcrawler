package com.example.webcrawler.internal.storage;

import com.example.webcrawler.internal.domain.Link;

import java.util.HashSet;
import java.util.Set;

public class VisitedLinkStore {
    private static class VisitedLinkStoreSingleton{
        private static final VisitedLinkStore instance =  new VisitedLinkStore();
    }
    private Set<Link> links  ;

    private VisitedLinkStore(){
        links = new HashSet<>();
    }


    public static VisitedLinkStore getInstance(){
        return VisitedLinkStoreSingleton.instance;
    }

    public void addLinkToSet( Link link){
        this.links.add(link);
    }

    boolean isVisited(String  url){
        return links.contains(new Link(url));
    }
}
