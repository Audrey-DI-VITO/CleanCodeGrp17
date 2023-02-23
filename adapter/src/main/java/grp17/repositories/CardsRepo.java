package grp17.repositories;

import grp17.in.persistance.CardsDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsRepo extends JpaRepository<CardsDB, Long> {
}
