package grp17;

import grp17.enums.e_Specialities;
import grp17.specialities.Mage;
import grp17.specialities.Assassin;
import grp17.specialities.Tank;

import java.util.Objects;

public class Hero extends Cards {
    private String name_hero;
    private int pv_hero;
    private int xp_hero = 0;
    private int power_hero;
    private int armor_hero;
    private Specialities speciality;
    private int level_hero = 1;

    public Hero(){}
    public Hero(String name_hero, String speciality) {
        this.name_hero = name_hero;
        this.initSpeciality(speciality);
    }

    public void increaseStats() {
        this.pv_hero = (int) (speciality.pv_spe * 1.1);
        this.power_hero = (int) (speciality.power_spe * 1.1);
        this.armor_hero = (int) (speciality.armor_spe * 1.1);
    }

    public void initSpeciality(String speciality) {
        if(Objects.equals(speciality.toUpperCase(), e_Specialities.TANK.toString())) {
            this.setSpeciality(new Tank());
        } else if(Objects.equals(speciality.toUpperCase(), e_Specialities.MAGE.toString())) {
            this.setSpeciality(new Mage());
        } else if(Objects.equals(speciality.toUpperCase(), e_Specialities.ASSASSIN.toString())) {
            this.setSpeciality(new Assassin());
        }
        this.initStat();
    }

    public void initStat() {
        this.pv_hero = this.getSpeciality().getPv_spe();
        this.power_hero = this.getSpeciality().getPower_spe();
        this.armor_hero = this.getSpeciality().getArmor_spe();
    }

    // Getters et Setters
    public void setLevel_hero(int level_hero) {
        this.level_hero = level_hero;
    }

    public int getLevel_hero() {
        return this.level_hero;
    }

    public void setXP(int xp) {
        this.xp_hero = xp;
    }

    public int getXP() {
        return this.xp_hero;
    }

    public String getName_hero() {
        return name_hero;
    }

    public void setName_hero(String name_hero) {
        this.name_hero = name_hero;
    }

    public int getPv_hero() {
        return pv_hero;
    }

    public void setPv_hero(int pv_hero) {
        this.pv_hero = pv_hero;
    }

    public int getPower_hero() {
        return power_hero;
    }

    public void setPower_hero(int power_hero) {
        this.power_hero = power_hero;
    }

    public int getArmor_hero() {
        return armor_hero;
    }

    public void setArmor_hero(int armor_hero) {
        this.armor_hero = armor_hero;
    }

    public Specialities getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Specialities speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name_hero + '\'' +
                ", pv=" + pv_hero +
                ", xp=" + xp_hero +
                ", power=" + power_hero +
                ", armor=" + armor_hero +
                ", speciality=" + speciality +
                ", level=" + level_hero +
                '}';
    }

    public void levelUp() {
        if(this.xp_hero >= 5) {
            this.xp_hero = 0;
            this.level_hero += 1;
            this.pv_hero *= 1.1;
            this.speciality.armor_spe *= 1.1;
            this.speciality.power_spe *= 1.1;
        }
    }
}
