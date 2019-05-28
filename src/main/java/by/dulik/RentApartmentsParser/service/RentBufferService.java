package by.dulik.RentApartmentsParser.service;

import by.dulik.RentApartmentsParser.entity.Rent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

class RentBufferService {

    private static final int DEFAULT_MAX_SIZE = 5_000;
    private static final int MAX_LIMIT_SIZE = 100_000;
    private static final int MIN_LIMIT_SIZE = 100;

    private Rent lastRent;

    RentBufferService() {
        lastRent = new Rent();
    }

    ArrayList<Rent> findNewRent(ArrayList<Rent> receivedRents) {
        ArrayList<Rent> findNewRent = receivedRents.stream().filter(rent -> rent.getCreateTime().after(lastRent.getCreateTime())).sorted(Comparator.comparing(Rent::getCreateTime)).collect(Collectors.toCollection(ArrayList::new));
        lastRent = receivedRents.stream().max(Comparator.comparing(Rent::getCreateTime)).orElse(lastRent);
        return findNewRent;
    }
}
