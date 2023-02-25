package grp17.service;

import grp17.Hero;
import grp17.port.in.AvailableCardsService;
import org.springframework.stereotype.Service;

@Service
public class AvailableCardsServiceImpl implements AvailableCardsService {

    @Override
    public Hero addCard(Hero hero) {
        Hero hTemp = new Hero(hero.getName_hero(), hero.getSpeciality().getName_spe().substring(0, 1).toUpperCase() + hero.getSpeciality().getName_spe().substring(1));
        hTemp.setRarity(hero.getRarity());
        return hTemp;
    }
}
