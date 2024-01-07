package br.com.bgs.consultanfe.services;

import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RequestJsoupService {

    public void requestAddress(String url){
        try{
            Connection connection = Jsoup.connect(url);
            connection.userAgent("Mozilla");
            connection.timeout(5000);

            Document document = connection.get();
        }catch (HttpStatusException ex) {
            //...
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
