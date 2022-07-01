package com.example.webcrawler.internal.storage;

import com.example.webcrawler.internal.domain.Link;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class UnprocessedLinkQueue implements Iterator<Link> {

    private static class UnprocessedLinkQueueSingleton{
        private static final UnprocessedLinkQueue instance =  new UnprocessedLinkQueue();
    }
    public static UnprocessedLinkQueue getInstance(){
        return UnprocessedLinkQueueSingleton.instance;
    }
    private Queue<Link> unprocessedLinkQueue ;
    private UnprocessedLinkQueue(){
        this. unprocessedLinkQueue =  new LinkedList<>();
    }
    public void addLinkToUnprocessedQueue(String url){
//        System.out.println("In addLinkToUnprocessedQueue -> " + url);
        boolean isUnvisitedLink = ! VisitedLinkStore.getInstance().isVisited(url) ;
        if(isUnvisitedLink){
            unprocessedLinkQueue.offer(new Link(url));
        }
//        System.out.println("unprocessed queue size : " + unprocessedLinkQueue.size());
    }

    public Link removeLinkFromUnprocessedQueue(){
        return unprocessedLinkQueue.poll();
    }

    @Override
    public boolean hasNext() {
        return !unprocessedLinkQueue.isEmpty();
    }
    @Override
    public Link next() {
        return unprocessedLinkQueue.poll();
    }





}
