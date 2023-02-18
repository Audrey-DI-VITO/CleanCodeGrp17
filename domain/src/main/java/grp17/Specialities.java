package grp17;

public class Specialities {
    int pv;
    int power;
    int armor;
    int supPower;
    String againstWho;
    String name;

    public Specialities() {}
    public Specialities(String name,int pv, int power, int armor, int supPower, String againstWho) {
        this.name=name;
        this.pv = pv;
        this.power = power;
        this.armor = armor;
        this.supPower = supPower;
        this.againstWho = againstWho;
    }

    // Getters and Setters
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

    public int getSupPower() {
        return supPower;
    }

    public void setSupPower(int supPower) {
        this.supPower = supPower;
    }

    public String getAgainstWho() {
        return againstWho;
    }

    public void setAgainstWho(String againstWho) {
        this.againstWho = againstWho;
    }

    public String getName() {
        return name;
    }

}
