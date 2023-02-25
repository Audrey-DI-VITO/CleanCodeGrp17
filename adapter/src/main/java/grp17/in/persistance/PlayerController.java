package grp17.in.persistance;

import grp17.Player;
import grp17.out.web.AvailableCardsDB;
import grp17.out.web.CardsDB;
import grp17.out.web.DeckDB;
import grp17.out.web.PlayerDB;
import grp17.port.in.PlayerService;
import grp17.repositories.AvailableCardsRepo;
import grp17.repositories.CardsRepo;
import grp17.repositories.DeckRepo;
import grp17.repositories.PlayerRepo;
import grp17.service.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// @RequestBody -> body
// @PathVariable -> /{id}
// @RequestParam("suite") -> ?suite=something

@RestController
@RequestMapping("/player")
public class PlayerController {
    PlayerService playerService = new PlayerServiceImpl();

    @Autowired
    PlayerRepo playerRepo;

    @Autowired
    DeckRepo deckRepo;

    @Autowired
    CardsRepo cardsRepo;

    @Autowired
    AvailableCardsRepo avcRepo;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Player p) {
        if(p.getPseudo() != null) {
            if(playerRepo.findByPseudo(p.getPseudo()) == null) {
                PlayerDB playerDB = new PlayerDB(p.getPseudo());
                PlayerDB player = playerRepo.save(playerDB);
                DeckDB deckDB = new DeckDB();
                deckDB.setPlayer(player);
                deckRepo.save(deckDB);
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Il existe déjà un joueur avec ce pseudo");
            }
        } else {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Vous devez obligatoirement renseigner le champs pseudo pour vous inscrire");
        }
        return ResponseEntity.ok("Votre compte "+p.getPseudo()+" a bien été créé");
    }


    // showDeck
    @GetMapping(value="/show_deck/{p}")
    public ResponseEntity show_deck(@PathVariable Player p) {
        PlayerDB pdb = playerRepo.findByPseudo(p.getPseudo());
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
            Optional<AvailableCardsDB> avcDB = avcRepo.findById(cardsDB.getAvailable_card_id().getId());
            finalRes.add(avcDB.get().toString().replaceAll("\\\\t", "\t").replaceAll("\\\\n", "\n"));
        }
        return ResponseEntity.status(200).body(finalRes);
    }

    // see opponents
    @GetMapping(value="/see_opponents")
    public void see_opponents() {

    }
}
