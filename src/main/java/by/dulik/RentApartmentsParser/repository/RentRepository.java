package by.dulik.RentApartmentsParser.repository;

import by.dulik.RentApartmentsParser.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, Long> {
}
