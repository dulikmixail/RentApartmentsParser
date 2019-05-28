package by.dulik.RentApartmentsParser.service;

import by.dulik.RentApartmentsParser.entity.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.util.ArrayList;

public abstract class BaseRentParser implements RentParser {

    private final String parsUrl;
    private RentBufferService rentBufferService;
    private ResourceLoader resourceLoader;
    private ResponseStringBuilder responseStringBuilder;

    @Autowired
    protected BaseRentParser(ResourceLoader resourceLoader, ResponseStringBuilder responseStringBuilder) {
        this.resourceLoader = resourceLoader;
        this.responseStringBuilder = responseStringBuilder;
        this.rentBufferService = new RentBufferService();
        this.parsUrl = getInitParsUrl();
    }

    abstract String getInitParsUrl();

    String getResponseBody() {
        StringBuilder content = new StringBuilder();
        Resource resource = resourceLoader.getResource(parsUrl);
        try {
            content = responseStringBuilder.getStringBuilderHttps(resource.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    @Override
    abstract public ArrayList<Rent> parsingRent();

    abstract public String getParsingSite();

    public ArrayList<Rent> getNewRent() {
        return rentBufferService.findNewRent(parsingRent());
    }
}
