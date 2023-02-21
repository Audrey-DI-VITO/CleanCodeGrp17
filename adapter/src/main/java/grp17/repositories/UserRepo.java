package grp17.repositories;

import grp17.in.persistance.PlayerDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<PlayerDB, Long> {

}
