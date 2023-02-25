package grp17;

public class Specialities {
    int pv_spe;
    int power_spe;
    int armor_spe;
    int supPower_spe;
    String againstWhoSpe;
    String name_spe;

    public Specialities() {}
    public Specialities(String name, int pv_spe, int power_spe, int armor_spe, int supPower_spe, String againstWhoSpe) {
        this.name_spe =name;
        this.pv_spe = pv_spe;
        this.power_spe = power_spe;
        this.armor_spe = armor_spe;
        this.supPower_spe = supPower_spe;
        this.againstWhoSpe = againstWhoSpe;
    }

    // Getters and Setters
    public int getPv_spe() {
        return pv_spe;
    }

    public void setPv_spe(int pv) {
        this.pv_spe = pv;
    }

    public int getPower_spe() {
        return power_spe;
    }

    public void setPower_spe(int power) {
        this.power_spe = power;
    }

    public int getArmor_spe() {
        return armor_spe;
    }

    public void setArmor_spe(int armor) {
        this.armor_spe = armor;
    }

    public int getSupPower_spe() {
        return supPower_spe;
    }

    public void setSupPower_spe(int supPower) {
        this.supPower_spe = supPower;
    }

    public String getAgainstWhoSpe() {
        return againstWhoSpe;
    }

    public void setAgainstWhoSpe(String againstWho) {
        this.againstWhoSpe = againstWho;
    }

    public String getName_spe() {
        return name_spe;
    }

    public void setName_spe(String name_speciality) {
        this.name_spe = name_speciality;
    }

    @Override
    public String toString() {
        return "pv : " + pv_spe +
                ", power=" + power_spe +
                ", armor=" + armor_spe +
                ", supPower=" + supPower_spe +
                ", againstWho='" + againstWhoSpe +
                ", name_speciality=" + name_spe;
    }
}
