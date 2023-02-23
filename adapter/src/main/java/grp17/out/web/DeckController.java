package grp17.out.web;

import grp17.repositories.DeckRepo;
import grp17.repositories.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deck")
public class DeckController {
    @Autowired
    PlayerRepo playerRepo;

    @Autowired
    DeckRepo deckRepo;


}
