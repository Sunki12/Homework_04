package search.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import search.Parser;
import search.WebSpider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebSpiderImpl implements WebSpider {
    @Override
    public Parser getParser() {
        return new ParserImpl();
    }

    @Override
    public List<String> getHtmlFromWeb(){
        List<String> lists = new ArrayList<>();
        String url = "http://studies.ku.dk/masters/programmes/";
        try {
            Document doc = Jsoup.connect(url)
                    .data("query", "Java")
                    .userAgent("Mozilla")
                    .cookie("auth", "token")
                    .timeout(30000)
                    .post();
            //System.out.println(doc);
            Elements elements = doc.select("table");//得到table标签内的元素
            //System.out.println(elements);
            Elements programlinks = elements.select("a");//得到带a标签的元素
            //System.out.println(programlinks);
            for (Element e : programlinks) {
                String element = e.attr("href");
                lists.add(element);

            }//得到项目的地址/masters/
            for(String programlist:lists){
                //System.out.println(programlist);
            }//得到装着项目地址的lists

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lists;
    }
}
