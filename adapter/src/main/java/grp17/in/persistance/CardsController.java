package grp17.in.persistance;

import grp17.enums.e_Pack;
import grp17.enums.e_Rarity;
import grp17.out.web.AvailableCardsDB;
import grp17.out.web.CardsDB;
import grp17.out.web.DeckDB;
import grp17.out.web.PlayerDB;
import grp17.repositories.AvailableCardsRepo;
import grp17.repositories.CardsRepo;
import grp17.repositories.DeckRepo;
import grp17.repositories.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.security.SecureRandom;
import java.util.ArrayList;
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

    @Autowired
    AvailableCardsRepo availableCardsRepo;

    @GetMapping("/pack_opening/{pack_type}")
    public ResponseEntity pack_opening(@PathVariable String pack_type, @RequestBody PlayerDB p) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        PlayerDB pDB = playerRepo.findByPseudo(p.getPseudo());
        List<String> lCardDB = new ArrayList<>();
        if(pack_type.equals(e_Pack.DIAMOND.name().toLowerCase())) {
            for(int i = 0; i < 5; i++) {
                this.saveCardInDB(pack_type, lCardDB, pDB);
            }
            pDB.setToken(pDB.getToken() - 2);
        } else if(pack_type.equals(e_Pack.SILVER.toString().toLowerCase())) {
            for(int i = 0; i < 2; i++) {
                this.saveCardInDB(pack_type, lCardDB, pDB);
            }
            pDB.setToken(pDB.getToken() - 1);
        }

        if(pDB.getToken() >= 0) {
            playerRepo.save(pDB);
            return ResponseEntity.accepted().body("Voici les cartes que vous avez obtenus : \n\n"+lCardDB);
        }

        return ResponseEntity.ok("Vous n'avez pas assez de jetons pour ouvrir un pack.");
    }

    private void saveCardInDB(String pack_type, List<String> lCardDB, PlayerDB p) {
        CardsDB cardsDB = new CardsDB();
        e_Rarity rarity_card = cardsDB.opening(e_Pack.valueOf(pack_type.toUpperCase()));

        List<AvailableCardsDB> lAvcDB = availableCardsRepo.findByRarity(rarity_card);

        PlayerDB playerDB = playerRepo.findByPseudo(p.getPseudo());
        DeckDB deckDB = new DeckDB();
        deckDB.setId(playerDB.getId_deck().get(0).getId());

        SecureRandom sRand = new SecureRandom();

        int selectedCard = sRand.nextInt(lAvcDB.size());
        cardsDB.setAvc(lAvcDB.get(selectedCard));
        lCardDB.add(lAvcDB.get(selectedCard).toString());
        cardsDB.setDeck(deckDB);
        cardsRepo.save(cardsDB);
    }
}
