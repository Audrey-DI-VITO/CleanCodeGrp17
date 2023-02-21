package grp17.repositories;

import grp17.in.persistance.DeckDB;
import grp17.in.persistance.PlayerDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<PlayerDB, Long> {
    @Transactional
    default PlayerDB saveUserWithDeck(PlayerDB p, DeckDB deck) {
        p.setDeck(deck);
        return save(p);
    }

    List<PlayerDB> findByPseudo(String pseudo);
}
