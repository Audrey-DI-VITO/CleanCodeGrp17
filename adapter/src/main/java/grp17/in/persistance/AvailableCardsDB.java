package grp17.in.persistance;

import grp17.Cards;
import grp17.Specialities;
import grp17.enums.e_Rarity;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "available_cards")
public class AvailableCardsDB extends Cards {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator = "native")
    private Long id;

    @Column(name = "name_hero")
    private String name_hero;

    @Column(name = "rarity_hero")
    @Enumerated(EnumType.STRING)
    private e_Rarity rarity;

    @Embedded
    private Specialities specialities;

    public String getName_hero() {
        return name_hero;
    }

    public void setName_hero(String name_hero) {
        this.name_hero = name_hero;
    }

    public Specialities getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Specialities specialities) {
        this.specialities = specialities;
    }

    public e_Rarity getRarity() {
        return rarity;
    }

    public void setRarity(e_Rarity rarity_hero) {
        this.rarity = rarity_hero;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Nom du héro : " + name_hero +
                ", Rareté : " + rarity +
                ", Spécialité : " + specialities.toString();
    }
}
