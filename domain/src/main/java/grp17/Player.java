package grp17;

import grp17.enums.e_Rarity;

public class Player {
    private String pseudo;
    private Deck deck;
    private int token;
    private int nbrVictory;

    public Player() {}

    public Player(String pseudo) {
        this.pseudo = pseudo;
        this.token = 4;
        this.deck = new Deck();
    }

    // Getters et Setters
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public int getNbrVictory() {
        return nbrVictory;
    }

    public void setNbrVictory(int nbrVictory) {
        this.nbrVictory = nbrVictory;
    }
}
