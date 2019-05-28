package by.dulik.RentApartmentsParser.service;

import by.dulik.RentApartmentsParser.entity.Rent;

import java.util.ArrayList;

public interface RentParser {
    ArrayList<Rent> parsingRent();

    ArrayList<Rent> getNewRent();
}
