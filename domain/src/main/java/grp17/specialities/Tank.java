package grp17.specialities;

import grp17.Specialities;

public class Tank extends Specialities {
    public Tank() {
        super("Tank",1000, 100, 20, 20, "Mage");
    }

    public void test() {
        System.out.println(super.getPv());
    }
}
