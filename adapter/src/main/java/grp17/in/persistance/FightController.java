package grp17.in.persistance;

import grp17.Cards;
import grp17.Hero;
import grp17.out.web.CardsDB;
import grp17.out.web.FightDB;
import grp17.out.web.PlayerDB;
import grp17.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fight")
public class FightController {
    @Autowired
    PlayerRepo playerRepo;

    @Autowired
    DeckRepo deckRepo;

    @Autowired
    CardsRepo cardsRepo;

    @Autowired
    AvailableCardsRepo avcRepo;

    @Autowired
    FightRepo fightRepo;

    @PostMapping("/start")
    public ResponseEntity startBattle(@RequestBody Map<String, Object> body) {
        FightDB f = new FightDB();
        Hero h = new Hero();
        Hero h2 = new Hero();

        CardsDB nCardsDB = new CardsDB();
        nCardsDB.setAvc(cardsRepo.findById(((Number) body.get("my_card")).longValue()).get().getAvc());
        h.setSpeciality(avcRepo.findById(nCardsDB.getAvc().getId()).get().getSpecialities());
        h.setPv_hero(avcRepo.findById(nCardsDB.getAvc().getId()).get().getSpecialities().getPv_spe());
        h.setName_hero(avcRepo.findById(nCardsDB.getAvc().getId()).get().getName_hero());

        Cards card = new Cards();

        CardsDB nCardsDB2 = new CardsDB();
        nCardsDB2.setAvc(cardsRepo.findById(((Number) body.get("opponent_card")).longValue()).get().getAvc());
        h2.setSpeciality(avcRepo.findById(nCardsDB2.getAvc().getId()).get().getSpecialities());
        h2.setPv_hero(avcRepo.findById(nCardsDB2.getAvc().getId()).get().getSpecialities().getPv_spe());
        h2.setName_hero(avcRepo.findById(nCardsDB2.getAvc().getId()).get().getName_hero());
        Cards card2 = new Cards();

        card.setHero(h);
        card2.setHero(h2);

        Long idDeckDB = cardsRepo.findByAvc_Id(nCardsDB.getAvc().getId()).get(0).getDeck().getId();
        f.setPlayer(playerRepo.findById(deckRepo.findById(idDeckDB).get().getPlayer().getId()).get());
        idDeckDB = cardsRepo.findByAvc_Id(nCardsDB.getAvc().getId()).get(0).getDeck().getId();
        f.setOpponent(playerRepo.findById(deckRepo.findById(idDeckDB).get().getPlayer().getId()).get());
        f.setPlayerCard(card);
        f.setOpponentCard(card2);

        return ResponseEntity.ok(f.battle());
    }

    // see opponents
    @GetMapping(value="/see_opponents/{player_name}")
    public ResponseEntity<List<PlayerDB>> see_opponents(@PathVariable String player_name) {
        return ResponseEntity.ok(playerRepo.findAllExceptPlayer(player_name));
    }
}
