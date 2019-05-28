package by.dulik.RentApartmentsParser.service;

import by.dulik.RentApartmentsParser.entity.Rent;
import by.dulik.RentApartmentsParser.entity.onliner.ApartmentsItem;
import by.dulik.RentApartmentsParser.entity.onliner.OnlinerRent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class OnlinerRentParser extends BaseRentParser {
    protected OnlinerRentParser(ResourceLoader resourceLoader, ResponseStringBuilder responseStringBuilder) {
        super(resourceLoader, responseStringBuilder);
    }

    @Override
    public ArrayList<Rent> parsingRent() {
        String jsonString = StringEscapeUtils.unescapeJson(getResponseBody());
        ArrayList<Rent> rents = new ArrayList<>();
        OnlinerRent onlinerRent = null;
        try {
            onlinerRent = new ObjectMapper().readValue(jsonString, OnlinerRent.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert onlinerRent != null;
        for (ApartmentsItem item : onlinerRent.getApartments()) {
            rents.add(new Rent(Integer.toString(item.getId()), item.getPhoto(), item.getUrl(), item.getPrice().getConverted().getBYN().getAmount(), item.getPrice().getConverted().getUSD().getAmount(), "", item.getLocation().getAddress(), item.getLastTimeUp(), getParsingSite()));
        }
        return rents;
    }

    @Override
    public String getParsingSite() {
        return "onliner";
    }

    @Override
    String getInitParsUrl() {
        return "https://ak.api.onliner.by/search/apartments?rent_type%5B%5D=1_room&rent_type%5B%5D=2_rooms&price%5Bmin%5D=50&price%5Bmax%5D=250&currency=usd&only_owner=true&bounds%5Blb%5D%5Blat%5D=53.78442244692782&bounds%5Blb%5D%5Blong%5D=27.413028708853112&bounds%5Brt%5D%5Blat%5D=54.0200294305704&bounds%5Brt%5D%5Blong%5D=27.711908525658554&_=0.8234181880816038";
    }

}
