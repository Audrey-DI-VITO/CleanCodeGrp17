package grp17;

import grp17.enums.e_Pack;
import grp17.enums.e_Rarity;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Cards {
    private Hero hero;
    private e_Rarity rarity;

    public Cards(){}
    public Cards(Hero hero, e_Rarity rarity) {
        this.hero = hero;
        this.rarity = rarity;
    }

    public List<Cards> opening(e_Pack type) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        SecureRandom sRand = new SecureRandom();
        List<Cards> cardsForPlayer = new ArrayList<>();

        File directory = new File(System.getProperty("user.dir")+"/domain/src/main/java/grp17/specialities");
        File[] files = directory.listFiles();

        switch(type) {
            case SILVER: {
                for(int i = 1; i <= 3; i++) {
                    Cards card = new Cards();
                    int rand = sRand.nextInt(100) + 1;
                    if(rand >= 1 && rand <= 5) {
                        card.rarity = e_Rarity.LEGENDARY;
                    } else if(rand >= 6 && rand <= 25) {
                        card.rarity = e_Rarity.RARE;
                    } else {
                        card.rarity = e_Rarity.COMMON;
                    }
                    Hero hero = new Hero();

                    List<String> fileNames = new ArrayList<String>();
                    for (File file : files) {
                        if (file.isFile()) {
                            fileNames.add(file.getName().split(".java")[0]);
                        }
                    }
                    int index = sRand.nextInt(fileNames.size());
                    Class<?> aClass = Class.forName("grp17.specialities."+fileNames.get(index).substring(0, 1).toUpperCase() + fileNames.get(index).substring(1));

                    hero.setSpeciality((Specialities) aClass.getDeclaredConstructor().newInstance());
                    hero.setLevel(1);
                    card.setHero(hero);
                    cardsForPlayer.add(card);
                }
                break;
            }

            case DIAMOND: {
                for(int i = 1; i <= 5; i++) {
                    Cards card = new Cards();
                    int rand = sRand.nextInt(100) + 1;
                    if(rand >= 1 && rand <= 15) {
                        card.rarity = e_Rarity.LEGENDARY;
                    } else if(rand >= 16 && rand <= 36) {
                        card.rarity = e_Rarity.RARE;
                    } else {
                        card.rarity = e_Rarity.COMMON;
                    }
                    Hero hero = new Hero();

                    List<String> fileNames = new ArrayList<String>();
                    for (File file : files) {
                        if (file.isFile()) {
                            fileNames.add(file.getName().split(".java")[0]);
                        }
                    }
                    int index = sRand.nextInt(fileNames.size());
                    Class<?> aClass = Class.forName("grp17.specialities."+fileNames.get(index).substring(0, 1).toUpperCase() + fileNames.get(index).substring(1));

                    hero.setSpeciality((Specialities) aClass.getDeclaredConstructor().newInstance());
                    hero.setLevel(1);
                    card.setHero(hero);
                    cardsForPlayer.add(card);
                }
                break;
            }

            default: {
                System.out.println("Le type de pack que vous avez choisi n'existe pas");
                break;
            }
        }
        return cardsForPlayer;
    }


    // Getters et Setters
    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public e_Rarity getRarity() {
        return rarity;
    }

    public void setRarity(e_Rarity rarity) {
        this.rarity = rarity;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "hero=" + hero +
                ", rarity=" + rarity +
                '}';
    }
}
