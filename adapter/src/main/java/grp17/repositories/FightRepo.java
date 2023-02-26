package grp17.repositories;

import grp17.out.web.FightDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FightRepo extends JpaRepository<FightDB, Long> {
}
