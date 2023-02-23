package grp17.repositories;

import grp17.in.persistance.PlayerDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepo extends JpaRepository<PlayerDB, Long> {
    List<PlayerDB> findByPseudo(String pseudo);
}
