package grp17.out.web;

import grp17.*;
import grp17.in.persistance.CardsDB;
import grp17.in.persistance.DeckDB;
import grp17.in.persistance.PlayerDB;
import grp17.port.in.PlayerService;
import grp17.repositories.CardsRepo;
import grp17.repositories.DeckRepo;
import grp17.repositories.PlayerRepo;
import grp17.service.PlayerServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.lang.reflect.InvocationTargetException;
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

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody grp17.Player p) {
        if(p.getPseudo() != null) {
            if(playerRepo.findByPseudo(p.getPseudo()).size() == 0) {
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

    @PostMapping("/add_card/{pseudo_player}")
    public ResponseEntity<String> add_card(@PathVariable String pseudo_player, @RequestBody Hero hero) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<PlayerDB> player = playerRepo.findByPseudo(pseudo_player);

        if (player.size() == 0) {
            return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND);
        }

        Optional<DeckDB> optionalDeck = player.get(0).getId_deck().stream().findFirst();

        if (!optionalDeck.isPresent()) {
            return new ResponseEntity<>("Player's deck not found", HttpStatus.NOT_FOUND);
        }

        DeckDB deck = optionalDeck.get();

        CardsDB cardsDB = new CardsDB();
        cardsDB.setName_card(hero.getName());
        cardsDB.setXp(0);
        cardsDB.setRarity(hero.getRarity());
        cardsDB.setLevel(1);
        cardsDB.setDeck(deck);
        Class<?> aClass = Class.forName("grp17.specialities."+hero.getSpeciality().getName_speciality().substring(0, 1).toUpperCase() + hero.getSpeciality().getName_speciality().substring(1));
        cardsDB.setSpeciality((Specialities) aClass.getDeclaredConstructor().newInstance());

        cardsRepo.save(cardsDB);

        deck.getAllCards().add(cardsDB);
        deckRepo.save(deck);

        return new ResponseEntity<>("Carte ajoutée au deck avec succès", HttpStatus.OK);
    }

    // showDeck
    @PostMapping(value="/show_my_deck", consumes = "application/json", produces = "application/json")
    public ModelAndView show_deck(@RequestBody grp17.Player p, HttpServletRequest request) {
        playerService.loginPlayer(p);
        // affiche 0:0:0:0:0:0:0:1 si requete en locale
        // sinon affiche l'ip
        System.out.println(request.getRemoteAddr());
        request.setAttribute(
                View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        return new ModelAndView("redirect:add_card");
    }

    // whatYouWantToDo
}
