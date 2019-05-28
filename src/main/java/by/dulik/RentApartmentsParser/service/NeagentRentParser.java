package by.dulik.RentApartmentsParser.service;

import by.dulik.RentApartmentsParser.entity.Rent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Service
public class NeagentRentParser extends BaseRentParser {
    protected NeagentRentParser(ResourceLoader resourceLoader, ResponseStringBuilder responseStringBuilder) {
        super(resourceLoader, responseStringBuilder);
    }

    @Override
    String getInitParsUrl() {
        return "http://neagent.by/board/minsk/?catid=1&roomCount=1,2&priceMax=550&currency=1";
    }

    @Override
    public ArrayList<Rent> parsingRent() {
        ArrayList<Rent> rents = new ArrayList<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        Date createTime = new Date();
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DATE, -1);
        Date yesterday = c.getTime();

        String strParse = getResponseBody();
        Document doc = Jsoup.parse(strParse);
        Elements imd = doc.select("div.imd");
        for (Element element : imd) {
            String id = element.attr("id");
            Element a = element.selectFirst("div.imd_photo").selectFirst("a");
            String href = a.attr("href");
            String src = a.select("img").attr("src");
            if (src.substring(0, 2).equals("//")) {
                src = src.substring(2);
            }
            Element mdHead = element.selectFirst("div.imd_mid").selectFirst("div.md_head");
            String strDate = mdHead.selectFirst("i").ownText();
            Element imdMess = mdHead.selectFirst("div.imd_mess");
            String title = imdMess.ownText();

            strDate = strDate.replaceFirst("сегодня в", simpleDateFormat2.format(today));
            strDate = strDate.replaceFirst("вчера в", simpleDateFormat2.format(yesterday));
            strDate = strDate.replaceFirst("поднято ", "");
            try {
                createTime = simpleDateFormat.parse(strDate);
            } catch (ParseException e) {
                System.out.println("При парсинге даты произошла ОШИБКА: " + e.getMessage());
                e.printStackTrace();
            }
            rents.add(new Rent(id, src, href, "", "", title, "", createTime, getParsingSite()));
        }

//        Pattern pattern = Pattern.compile("(class=\"imd.+?id=\"n)(\\d+?)(\".+?<a href=\")(.+?)(\"><img\\s+src=\"//)(.+?)(\".+?<i>)(.+?)(<br>.+?\\s{14}+)(.+?)(\\s{2}+</div>|<span\\sstyle)", Pattern.DOTALL);
//        Matcher matcher = pattern.matcher(strParse);
//
//        boolean one = true;
//        while (matcher.find()) {
//            String strCreateTime = matcher.group(8);
//            strCreateTime = strCreateTime.replaceFirst("сегодня в", simpleDateFormat2.format(today));
//            strCreateTime = strCreateTime.replaceFirst("вчера в", simpleDateFormat2.format(yesterday));
//            strCreateTime = strCreateTime.replaceFirst("поднято ", "");
//            try {
//                createTime = simpleDateFormat.parse(strCreateTime);
//            } catch (ParseException e) {
//                System.out.println("При парсинге даты произошла ОШИБКА: " + e.getMessage());
//                e.printStackTrace();
//            }
//            String testStrUrl = matcher.group(4);
//            if (testStrUrl.length() > 3000 && one) {
//                System.out.println("Invalid body:" + System.lineSeparator() + strParse);
//                one = false;
//            }
//            rents.add(new Rent(matcher.group(2), matcher.group(6), testStrUrl, "", "", matcher.group(10), "", createTime, getParsingSite()));
//        }
        return rents;
    }

    @Override
    public String getParsingSite() {
        return "neagent";
    }
}
