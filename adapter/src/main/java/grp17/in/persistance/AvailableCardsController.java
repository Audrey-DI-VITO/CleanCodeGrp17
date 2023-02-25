package grp17.in.persistance;

import grp17.Hero;
import grp17.Specialities;
import grp17.out.web.AvailableCardsDB;
import grp17.repositories.AvailableCardsRepo;
import grp17.service.AvailableCardsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/heros")
public class AvailableCardsController {
    @Autowired
    AvailableCardsRepo cardsAvailableRepo;

    AvailableCardsServiceImpl avcService = new AvailableCardsServiceImpl();

    @PostMapping("/add_card")
    public ResponseEntity<String> add_card(@RequestBody Hero hero) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        AvailableCardsDB avCardsDB = new AvailableCardsDB();

        Hero h2 = avcService.addCard(hero);

        avCardsDB.setSpecialities((Specialities) Class.forName("grp17.specialities."+h2.getSpeciality()
                .getName_spe()).getDeclaredConstructor().newInstance());
        avCardsDB.setRarity(h2.getRarity());
        avCardsDB.setName_hero(hero.getName_hero());
        cardsAvailableRepo.save(avCardsDB);

        return new ResponseEntity<>("Carte ajoutée à la liste des cartes disponibles avec succès", HttpStatus.OK);
    }
}
