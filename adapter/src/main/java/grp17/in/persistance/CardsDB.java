package grp17.in.persistance;

import grp17.Cards;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "cards")
public class CardsDB extends Cards {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator = "native")
    private Long id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "pv")
    private int pv;

    @Column(name = "xp")
    private int xp;

    @Column(name = "power")
    private int power;

    @Column(name = "armor")
    private int armor;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "rarity")
    private String rarity;

    @Column(name = "level")
    private int level;

}
