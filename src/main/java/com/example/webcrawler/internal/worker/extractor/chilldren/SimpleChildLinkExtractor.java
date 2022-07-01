package com.example.webcrawler.internal.worker.extractor.chilldren;

import com.example.webcrawler.internal.domain.Link;
import com.example.webcrawler.internal.worker.extractor.filter.SimpleUrlFilter;
import com.example.webcrawler.internal.worker.extractor.filter.UrlFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleChildLinkExtractor implements ChildLinkExtractor {
    private String urlMatchingPattern = "(www|http:|https:)+[^\\s]+[\\w]";

    public List<Link> extractLink(String content){
        UrlFilter urlFilter = new SimpleUrlFilter() ;

        Pattern pattern = Pattern.compile(urlMatchingPattern);
        Matcher matcher = pattern.matcher(content);
        List<Link> childLinks =  new ArrayList<>();
        while(matcher.find()){
            String actualURL = matcher.group();
            actualURL = actualURL.contains("\"") ? actualURL.substring(0, actualURL.indexOf('\"')) : actualURL;
            actualURL= actualURL.contains(" ") ? actualURL.substring(0, actualURL.indexOf(' ')) : actualURL;
            boolean goodUrl = actualURL != null && !actualURL.isEmpty() && urlFilter.isAllowedFilter(actualURL);

            if(goodUrl){
                childLinks.add(new Link(actualURL));
            }
//            else{
//                System.out.println("childLink ignored : " + actualURL);
//            }
        }
       // System.out.println("childLink size : " + childLinks.size());
        return childLinks;
    }
}
