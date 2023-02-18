package grp17.specialities;

import grp17.Specialities;

public class Slayer extends Specialities {
    public Slayer() {
        super("Assassin",800, 200, 5, 30, "Tank");
    }

    public void test() {
        System.out.println(super.getPv());
    }
}
