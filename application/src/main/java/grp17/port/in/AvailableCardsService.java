package grp17.port.in;

import grp17.Cards;
import grp17.Hero;
import grp17.Specialities;

import java.lang.reflect.InvocationTargetException;

public interface AvailableCardsService {
    Hero addCard(Hero hero);

    Specialities setSpeByRarity(Hero hero) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
