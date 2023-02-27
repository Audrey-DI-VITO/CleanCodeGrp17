package grp17.in.persistance;

import grp17.out.web.AvailableCardsDB;
import grp17.out.web.CardsDB;
import grp17.out.web.PlayerDB;
import grp17.repositories.AvailableCardsRepo;
import grp17.repositories.CardsRepo;
import grp17.repositories.DeckRepo;
import grp17.repositories.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deck")
public class DeckController {
    @Autowired
    PlayerRepo playerRepo;

    @Autowired
    CardsRepo cardsRepo;

    @Autowired
    DeckRepo deckRepo;

    @Autowired
    AvailableCardsRepo avcRepo;

    @GetMapping("/see/{player_name}")
    public ResponseEntity seeDeck(@PathVariable String player_name) {
        PlayerDB pdb = playerRepo.findByPseudo(player_name);
        if (pdb == null) {
            return ResponseEntity.status(404).body("Ce joueur n'existe pas");
        }
        Long deck_id = pdb.getId_deck().get(0).getId();
        if (deck_id == null) {
            return ResponseEntity.status(404).body("Le joueur n'a pas de deck");
        }
        List<CardsDB> cdbO = cardsRepo.findByDeckId(deck_id);
        List<String> finalRes = new ArrayList<>();
        for (CardsDB cardsDB : cdbO) {
            Optional<AvailableCardsDB> avcDB = avcRepo.findById(cardsDB.getAvc().getId());
            finalRes.add(avcDB.get().toString().replaceAll("\\\\t", "\t").replaceAll("\\\\n", "\n"));
        }
        return ResponseEntity.status(200).body(finalRes);
    }
}
