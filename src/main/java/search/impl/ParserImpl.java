package search.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import search.Parser;
import vo.Program;
import search.impl.WebSpiderImpl;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParserImpl implements Parser {

    @Override
    public Program parseHtml(String html) {
        Program program = new Program();
        try {
            Document doc = Jsoup.parse(new URL("http://studies.ku.dk"+html),10000);
            //项目名称
            Elements elements = doc.select("div");//得到table标签内的元素
            Elements linktext = elements.select("#main-content > h1");//得到带h1标签的元素
            //System.out.println(linktext);
            if(linktext.text() != null) {
                program.setProgramName(linktext.text());
                //System.out.println(program.getProgramName());可以
            }else {
                program.setProgramName("NULL");
            }

            //得到随机的id
            String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
            program.setId(uuid);
            //学校名称
            String university = "University of Copenhagen";
            program.setUniversity(university);
            //所在国家地区
            String country = "Copenhagen";
            program.setCountry(country);

            //开设学院
            String school = "null";
            program.setSchool(school);
            //学位
            String degree = "Master";
            program.setDegree(degree);
            //邮箱
            String email = "studentservices@science.ku.dk";
            program.setEmail(email);
            //电话
            String phone = "Tel. +45 35 33 35 33";
            program.setPhoneNumber(phone);
            //地址
            String address = "DK-1171 Copenhagen ";
            program.setLocation(address);
            //有奖ddl
            String ddl1 = "null";
            program.setDeadlineWithAid(ddl1);
            //无奖ddl
            String ddl2 = "null";
            program.setDeadlineWithoutAid(ddl2);
            //项目主页地址
            String home ="http://studies.ku.dk"+html;
            program.setHomepage(home);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return program;
    }
}
