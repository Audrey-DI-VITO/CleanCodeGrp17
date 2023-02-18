package grp17.out.web;

import grp17.port.in.PlayerService;
import grp17.service.PlayerServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

// @RequestBody -> body
// @PathVariable -> /{id}
// @RequestParam("suite") -> ?suite=something

@RestController
@RequestMapping("/user")
public class User {
    PlayerService playerService = new PlayerServiceImpl();

    @PostMapping("/register")
    public void register(@RequestBody String request) {
        System.out.println("test");
    }

    /*@PostMapping(value="/login", consumes = "application/json", produces = "application/json")
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
    }*/

    // whatYouWantToDo
}
