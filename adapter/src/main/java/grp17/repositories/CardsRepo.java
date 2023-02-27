package grp17.repositories;

import grp17.out.web.CardsDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardsRepo extends JpaRepository<CardsDB, Long> {
    List<CardsDB> findByDeckId(Long deck_id);

    List<CardsDB> findByAvc_Id(Long id);
}
