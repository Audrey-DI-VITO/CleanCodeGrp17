package grp17.out.web;

import grp17.Cards;
import grp17.Deck;
import grp17.Hero;
import grp17.Player;
import grp17.in.persistance.PlayerDB;
import grp17.port.in.PlayerService;
import grp17.repositories.UserRepo;
import grp17.service.PlayerServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

// @RequestBody -> body
// @PathVariable -> /{id}
// @RequestParam("suite") -> ?suite=something

@RestController
@RequestMapping("/user")
public class User {
    PlayerService playerService = new PlayerServiceImpl();
    @Autowired
    UserRepo userRepository;

    @PostMapping("/register")
    public void register(@RequestBody Player p) {
        playerService.registerPlayer(p);
        userRepository.save(new PlayerDB(p.getPseudo()));
    }

    @PostMapping(value="/login", consumes = "application/json", produces = "application/json")
    public ModelAndView login(@RequestBody Player p, HttpServletRequest request) {
        playerService.loginPlayer(p);
        // affiche 0:0:0:0:0:0:0:1 si requete en locale
        // sinon affiche l'ip
        System.out.println(request.getRemoteAddr());
        request.setAttribute(
                View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        return new ModelAndView("redirect:register");
    }

    // addCardToDeck
    @PostMapping(value="/add_card/{id_player}", consumes = "application/json", produces = "application/json")
    public Deck add_card(@RequestBody Cards card, @PathVariable int id_player) {
        Deck deck = new Deck();
        deck.insertCard(card);
        Hero hero = new Hero("name", "TANK");
        return deck;
    }

    // showDeck
    @PostMapping(value="/show_my_deck", consumes = "application/json", produces = "application/json")
    public ModelAndView show_deck(@RequestBody Player p, HttpServletRequest request) {
        playerService.loginPlayer(p);
        // affiche 0:0:0:0:0:0:0:1 si requete en locale
        // sinon affiche l'ip
        System.out.println(request.getRemoteAddr());
        request.setAttribute(
                View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
        return new ModelAndView("redirect:add_card");
    }

    // openPack
    @PostMapping(value="/open_pack", consumes = "application/json", produces = "application/json")
    public ModelAndView open_pack(@RequestBody Player p, HttpServletRequest request) {
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
