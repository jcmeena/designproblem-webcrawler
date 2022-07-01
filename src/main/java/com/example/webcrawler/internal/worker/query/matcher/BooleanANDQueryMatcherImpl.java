package com.example.webcrawler.internal.worker.query.matcher;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BooleanANDQueryMatcherImpl implements QueryMatcher{
    public boolean matchesQuery(String searchString,String content ){
        // delimiter  space
        List<String> tokens = getTokensFromSearchQuery(searchString," ");
        return  matchesBooleanANDQuery(tokens, content);
    }
    private List<String> getTokensFromSearchQuery(String searchString , String delimiter){
        StringTokenizer tokenizer = new StringTokenizer(searchString,delimiter);
        List<String> tokenList = new ArrayList<>();
        while( tokenizer.hasMoreTokens()){
            tokenList.add(tokenizer.nextToken().toLowerCase());
        }
        return tokenList;
    }
    public boolean matchesBooleanANDQuery(List<String> tokens, String content){
        String normalizedContent = content.toLowerCase();
        // performs Boolean AND query
        for(String token  : tokens ){

            if(! content.contains(token ) ) {
               // System.out.println("token does not matches " + token  );
                return false;
            }
//            else{
//                System.out.println("token matches ======= >>>>>>>>>>" + token  );
//            }

        }
        return true;
    }
}
