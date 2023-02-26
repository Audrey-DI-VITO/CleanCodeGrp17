package grp17.in.persistance;

import grp17.Cards;
import grp17.Fight;
import grp17.Hero;
import grp17.out.web.AvailableCardsDB;
import grp17.out.web.CardsDB;
import grp17.out.web.FightDB;
import grp17.out.web.PlayerDB;
import grp17.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity startBattle() {
        FightDB f = new FightDB();
        Hero h = new Hero();
        Hero h2 = new Hero();

        CardsDB nCardsDB = new CardsDB();
        nCardsDB.setAvailable_card_id(cardsRepo.findById(45L).get().getAvailable_card_id());
        h.setSpeciality(avcRepo.findById(nCardsDB.getAvailable_card_id().getId()).get().getSpecialities());
        h.setPv_hero(avcRepo.findById(nCardsDB.getAvailable_card_id().getId()).get().getSpecialities().getPv_spe());
        h.setName_hero(avcRepo.findById(nCardsDB.getAvailable_card_id().getId()).get().getName_hero());

        Cards card = new Cards();


        CardsDB nCardsDB2 = new CardsDB();
        nCardsDB2.setAvailable_card_id(cardsRepo.findById(2L).get().getAvailable_card_id());
        h2.setSpeciality(avcRepo.findById(nCardsDB2.getAvailable_card_id().getId()).get().getSpecialities());
        h2.setPv_hero(avcRepo.findById(nCardsDB2.getAvailable_card_id().getId()).get().getSpecialities().getPv_spe());
        h2.setName_hero(avcRepo.findById(nCardsDB2.getAvailable_card_id().getId()).get().getName_hero());
        Cards card2 = new Cards();

        card.setHero(h);
        card2.setHero(h2);

        f.setPlayerCard(card);
        f.setOpponentCard(card2);

        /*CardsDB cardsDB = new CardsDB();
        cardsDB.getAvailable_card_id().setHero(cardsRepo.findById(1L).get().getAvailable_card_id().getHero());
        System.out.println(cardsDB.getHero().getName_hero());
        f.setPlayerCard(cardsDB);

        cardsDB.setHero(cardsRepo.findById(2L).get().getAvailable_card_id().getHero());
        */
        return ResponseEntity.ok(f.battle());
    }
}
