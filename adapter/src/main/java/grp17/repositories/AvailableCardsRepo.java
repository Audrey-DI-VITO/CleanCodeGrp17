package grp17.repositories;

import grp17.enums.e_Rarity;
import grp17.out.web.AvailableCardsDB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AvailableCardsRepo extends JpaRepository<AvailableCardsDB, Long> {
    List<AvailableCardsDB> findByRarity(e_Rarity rarity);

    @Override
    Optional<AvailableCardsDB> findById(Long id);
}
