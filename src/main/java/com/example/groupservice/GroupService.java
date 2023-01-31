package com.example.groupservice;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
    public String getId(String userProfile) {
        Response req;
        String id = "";
        try {
            String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36";

            req = Jsoup.connect("https://m.facebook.com/login/async/?refsrc=https%3A%2F%2Fm.facebook.com%2F&lwv=100")
                    .userAgent(userAgent)
                    .method(Method.POST).data("email", "asd").data("pass", "asd")
                    .followRedirects(true).execute();

            Document d = Jsoup.connect("https://facebook.com/" + userProfile).userAgent(userAgent)
                    .cookies(req.cookies()).get();
            Elements metaTags = d.head().select("meta[content]");
            for (Element metaTag : metaTags) {
                if (metaTag.attr("content").contains("profile")) {
                    return metaTag.attr("content").split("profile", 0)[1].substring(1);
                }
            }
            if(id.equals("")){
                return d.head().toString();
            }
            return id;
        } catch (Exception e) {

            return e.toString();
        }
    }
}
