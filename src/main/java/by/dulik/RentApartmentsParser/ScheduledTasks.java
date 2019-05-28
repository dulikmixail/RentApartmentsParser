package by.dulik.RentApartmentsParser;

import by.dulik.RentApartmentsParser.bot.Bot;
import by.dulik.RentApartmentsParser.entity.Rent;
import by.dulik.RentApartmentsParser.service.KufarRentParser;
import by.dulik.RentApartmentsParser.service.NeagentRentParser;
import by.dulik.RentApartmentsParser.service.OnlinerRentParser;
import by.dulik.RentApartmentsParser.service.RentParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private final OnlinerRentParser onlinerRentParser;
    private final NeagentRentParser neagentRentParser;
    private final KufarRentParser kufarRentParser;
    private Bot bot;


    @Autowired
    public ScheduledTasks(Bot bot, OnlinerRentParser onlinerRentParser, KufarRentParser kufarRentParser, NeagentRentParser neagentRentParser) {
        this.bot = bot;
        this.onlinerRentParser = onlinerRentParser;
        this.kufarRentParser = kufarRentParser;
        this.neagentRentParser = neagentRentParser;

    }

    private void sendMassageToTelegram(RentParser rentParser) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yy hh:mm", new Locale("ru"));
        ArrayList<Rent> newRent = rentParser.getNewRent();
        if (newRent.size() != 0) {
            for (Rent rent :
                    newRent) {
                System.out.println(rent.getInnerId() + " " + rent.getUrl());
                StringBuilder stringBuilder = new StringBuilder();
                if (!rent.getPhoto().equals("")) {
                    stringBuilder.append("Фото: ").append(rent.getPhoto()).append(System.lineSeparator()).append(System.lineSeparator());
                }
                stringBuilder.append(rent.getTitle()).append(System.lineSeparator());
                if (rent.getCreateTime() != null) {
                    stringBuilder.append("Опубликованно: ").append(dateFormat.format(rent.getCreateTime())).append(System.lineSeparator());
                }

                stringBuilder.append("Ссылка: ").append(rent.getUrl()).append(System.lineSeparator());
                if (!rent.getPriceUsd().equals("")) {
                    stringBuilder.append("Цена (USD): ").append(rent.getPriceUsd()).append(System.lineSeparator());
                }
                if (!rent.getPriceByn().equals("")) {
                    stringBuilder.append("Цена (BYN): ").append(rent.getPriceByn()).append(System.lineSeparator());
                }

                bot.sendTextAllMuteUsers(stringBuilder.toString());
            }
        }
    }

    @Scheduled(fixedRate = 15000, initialDelay = 5000)
    public void reportCurrentTime1() {
        sendMassageToTelegram(kufarRentParser);
    }

    @Scheduled(fixedRate = 15000, initialDelay = 10000)
    public void reportCurrentTime2() {
        sendMassageToTelegram(onlinerRentParser);
    }

    @Scheduled(fixedRate = 15000, initialDelay = 15000)
    public void reportCurrentTime3() {
        sendMassageToTelegram(neagentRentParser);
    }
}
