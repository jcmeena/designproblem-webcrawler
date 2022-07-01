package com.example.webcrawler.internal.worker.extractor.filter;

import java.util.Arrays;
import java.util.List;

public class SimpleUrlFilter implements UrlFilter{
    @Override
    public boolean isAllowedFilter(String url) {
        List<String> ignoredFiles =  Arrays.asList(".css", ".js", ".png" ,".jpg", ".jpeg",".svg");
        for (String s :ignoredFiles  ) {
            if(url.contains(s)){
                return false;
            }

        }
        List<String> allowedEndings = Arrays.asList(".htm", ".html", ".txt");
        for (String s :allowedEndings  ) {
            if(url.contains(s)){
                return true;
            }

        }
        return false;
    }
}
