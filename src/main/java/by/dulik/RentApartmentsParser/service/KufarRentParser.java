package by.dulik.RentApartmentsParser.service;

import by.dulik.RentApartmentsParser.entity.Rent;
import by.dulik.RentApartmentsParser.entity.kufar.AdsItem;
import by.dulik.RentApartmentsParser.entity.kufar.KufarRent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class KufarRentParser extends BaseRentParser {
    protected KufarRentParser(ResourceLoader resourceLoader, ResponseStringBuilder responseStringBuilder) {
        super(resourceLoader, responseStringBuilder);
    }

    @Override
    String getInitParsUrl() {
        return "https://re.kufar.by/api/search/search?cat=1010&cmp=0&cur=USD&gts=c-minsk&prc=r%3A150%2C250&rms=v.or%3A2%2C1&rnt=1&typ=let";
    }

    @Override
    public ArrayList<Rent> parsingRent() {
        String jsonString = getResponseBody();
        ArrayList<Rent> rents = new ArrayList<>();
        KufarRent kufarRents = null;
        try {
            kufarRents = new ObjectMapper().readValue(jsonString, KufarRent.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert kufarRents != null;
        for (AdsItem adsItem : kufarRents.getAds()) {
            String photo = "";
            if (adsItem.getImages().size() > 0) {
                String id = adsItem.getImages().get(0).getId();
                photo = "https://content.kufar.by/line_thumbs_2x/" + id.substring(0, 2) + "/" + id + ".jpg";
            }

            rents.add(new Rent(Integer.toString(adsItem.getAdId()), photo, "https://re.kufar.by/vi/" + adsItem.getAdId(), adsItem.getPriceByn().substring(0, adsItem.getPriceByn().length() - 2), adsItem.getPriceUsd().substring(0, adsItem.getPriceUsd().length() - 2), adsItem.getSubject(), adsItem.getAddress(), adsItem.getListTime(), getParsingSite()));
        }
        return rents;
    }

    @Override
    public String getParsingSite() {
        return "kufar";
    }
}
