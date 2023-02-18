package grp17.in.persistance;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "cards")
public class Cards {
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

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Cards.class)
    @JoinColumn(name = "id_deck")
    private List<Integer> id_deck;

}
