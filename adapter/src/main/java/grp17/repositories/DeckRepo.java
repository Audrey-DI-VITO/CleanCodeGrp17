package grp17.repositories;

import grp17.in.persistance.DeckDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepo extends JpaRepository<DeckDB, Long> {

}
