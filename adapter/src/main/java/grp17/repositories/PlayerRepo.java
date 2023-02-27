package grp17.repositories;

import grp17.out.web.PlayerDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepo extends JpaRepository<PlayerDB, Long> {
    PlayerDB findByPseudo(String pseudo);

    @Query("SELECT p FROM PlayerDB p WHERE p.pseudo <> ?1")
    List<PlayerDB> findAllExceptPlayer(String player_name);
}
