package grp17.in.persistance;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "cards")
public class CardsDB {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
