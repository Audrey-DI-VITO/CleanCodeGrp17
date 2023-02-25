package grp17.repositories;

import grp17.out.web.PlayerDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepo extends JpaRepository<PlayerDB, Long> {
    PlayerDB findByPseudo(String pseudo);
}
