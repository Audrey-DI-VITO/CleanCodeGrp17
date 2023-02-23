package grp17.out.web;

import grp17.Cards;
import grp17.Player;
import grp17.enums.e_Pack;
import grp17.in.persistance.CardsDB;
import grp17.in.persistance.PlayerDB;
import grp17.repositories.CardsRepo;
import grp17.repositories.DeckRepo;
import grp17.repositories.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/card")
public class CardsController {
    @Autowired
    PlayerRepo playerRepo;

    @Autowired
    CardsRepo cardsRepo;

    @Autowired
    DeckRepo deckRepo;

    @GetMapping("/pack_opening/{pack_type}")
    public ResponseEntity pack_opening(@PathVariable String pack_type, @RequestBody Player p) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Cards cards = new Cards();
        List<Cards> lCards = cards.opening(e_Pack.valueOf(pack_type.toUpperCase()));
        List<PlayerDB> pDB = playerRepo.findByPseudo(p.getPseudo());
        pDB.get(0).setToken(pDB.get(0).getToken() - 2);
        playerRepo.save(pDB.get(0));

        for (Cards card : lCards) {
            CardsDB cardsDB = new CardsDB();
            cardsDB.setHero(card.getHero());
            cardsDB.setSpeciality(card.getHero().getSpeciality());
            cardsDB.setRarity(card.getRarity());
            cardsDB.setLevel(1);

            cardsDB.setDeck(deckRepo.findByPlayer(pDB.get(0)));
            cardsDB.setDeck(pDB.get(0).getId_deck().get(0));
            cardsRepo.save(cardsDB);
        }
        return ResponseEntity.ok("Test en cours");
    }
}
