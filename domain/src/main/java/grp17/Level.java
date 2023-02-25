package grp17;

public class Level extends Hero {
    public Level(String name, String speciality) {
        super(name, speciality);
    }

    public void increaseXP() {
        super.setXP(super.getXP() + 1);

        if(super.getXP() == 5) {
            this.resetXP();
            this.increaseLevel();
        }
    }

    public void resetXP() {
        super.setXP(0);
    }

    public void increaseLevel() {
        if(super.getLevel_hero() >= 100) {
            System.out.println("Vous avez atteint le niveau maximum du jeu !");
            return;
        }
        super.increaseStats();
        super.setLevel_hero(super.getLevel_hero() + 1);
    }
}
