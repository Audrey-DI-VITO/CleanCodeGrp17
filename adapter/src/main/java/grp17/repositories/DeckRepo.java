package grp17.repositories;

import grp17.in.persistance.DeckDB;
import grp17.in.persistance.PlayerDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepo extends JpaRepository<DeckDB, Long> {
    DeckDB findDeckByNameAndPlayerPseudo(String name, String pseudo);

    DeckDB findByPlayer(PlayerDB player);
}
