package com.example.webcrawler.internal.worker.downloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class SimpleContentDownloader implements ContentDownloader{
    public String extractContentFromLink(String urlToVisit)  {
        String result  = "";
        try{
            URL url = new URL(urlToVisit);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine = in.readLine();
            while(inputLine  != null){
                result += inputLine;
                inputLine = in.readLine();
            }
            in.close();
        } catch (IOException e){
            e.printStackTrace();
        }
       // System.out.println("Visited Link : "+urlToVisit+"\n");
      //  System.out.println(result+"\n\n");


        return result;

    }
}
