package grp17;

import grp17.enums.e_Specialities;
import grp17.specialities.Mage;
import grp17.specialities.Slayer;
import grp17.specialities.Tank;

import java.util.Objects;

public class Hero extends Cards {
    private String name;
    private int pv;
    private int xp = 0;
    private int power;
    private int armor;
    private Specialities speciality;
    private int level = 1;

    public Hero(){}
    public Hero(String name, String speciality) {
        this.name = name;
        this.initSpeciality(speciality);
    }

    public void increaseStats() {
        this.pv = (int) (speciality.pv * 1.1);
        this.power = (int) (speciality.power * 1.1);
        this.armor = (int) (speciality.armor * 1.1);
    }

    public void initSpeciality(String speciality) {
        if(Objects.equals(speciality.toUpperCase(), e_Specialities.TANK.toString())) {
            this.speciality = new Tank();
        } else if(Objects.equals(speciality.toUpperCase(), e_Specialities.MAGE.toString())) {
            this.speciality = new Mage();
        } else if(Objects.equals(speciality.toUpperCase(), e_Specialities.SLAYER.toString())) {
            this.speciality = new Slayer();
        }
        this.initStat();
    }

    public void initStat() {
        this.pv = this.speciality.pv;
        this.power = this.speciality.power;
        this.armor = this.speciality.armor;
    }

    // Getters et Setters
    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public void setXP(int xp) {
        this.xp = xp;
    }

    public int getXP() {
        return this.xp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
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
                "name='" + name + '\'' +
                ", pv=" + pv +
                ", xp=" + xp +
                ", power=" + power +
                ", armor=" + armor +
                ", speciality=" + speciality +
                ", level=" + level +
                '}';
    }
}
