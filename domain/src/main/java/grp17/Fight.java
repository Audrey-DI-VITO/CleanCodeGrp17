package grp17;

public class Fight {
    private Player player;
    private Cards playerCard;
    private Player opponent;
    private Cards opponentCard;

    public Fight(){}
    public Fight(Player player) {
        this.player=player;
        this.setup();
        this.startBattle();
    }
    public void setup(){
        this.playerCard=this.selectCardToFight();
        this.startBattle();

    }
    public String startBattle(){

                return "";
    }
    public Cards selectCardToFight(){
        boolean valid=false;
        int numberChosen=0;
        System.out.println("Select your card to fight :");
        this.player.getDeck().displayAllCard();
        System.out.println("Type your card's number :");
        return this.player.getDeck().getAllCards().get(numberChosen);
    }


    //getter & setter
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public Cards getPlayerCard() {
        return playerCard;
    }

    public Cards getOpponentCard() {
        return opponentCard;
    }
}
