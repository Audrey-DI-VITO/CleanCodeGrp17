package grp17.service;

import grp17.Hero;
import grp17.Specialities;
import grp17.port.in.AvailableCardsService;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

import static grp17.enums.e_Rarity.*;

@Service
public class AvailableCardsServiceImpl implements AvailableCardsService {

    @Override
    public Hero addCard(Hero hero) {
        Hero hTemp = new Hero(hero.getName_hero(), hero.getSpeciality().getName_spe().substring(0, 1).toUpperCase() + hero.getSpeciality().getName_spe().substring(1));
        hTemp.setRarity(hero.getRarity());
        return hTemp;
    }

    @Override
    public Specialities setSpeByRarity(Hero h) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Specialities spe = (Specialities) Class.forName("grp17.specialities."+h.getSpeciality()
                .getName_spe()).getDeclaredConstructor().newInstance();

        switch (h.getRarity()) {
            case RARE: {
                spe.setPv_spe((int) (spe.getPv_spe() * 1.1));
                spe.setArmor_spe((int) (spe.getArmor_spe() * 1.1));
                spe.setPower_spe((int) (spe.getPower_spe() * 1.1));
                break;
            }

            case LEGENDARY: {
                spe.setPv_spe((int) (spe.getPv_spe() * 1.2));
                spe.setArmor_spe((int) (spe.getArmor_spe() * 1.2));
                spe.setPower_spe((int) (spe.getPower_spe() * 1.2));
                break;
            }
        }

        return spe;
    }
}
