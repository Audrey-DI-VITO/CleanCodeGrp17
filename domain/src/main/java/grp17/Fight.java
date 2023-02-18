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
        this.opponent=this.selectOpponent();
        this.opponentCard=this.selectOpponentCard(this.playerCard.getHero().getLevel());
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



    public Player selectOpponent() {
        System.out.println("Select a opponent :");
        int numberChosen=0;
        tmp temp=new tmp();
        this.displayAllPlayer();
        System.out.println("Type your opponent's number :");
        return temp.getPeople().get(numberChosen);
    }
    public Cards selectOpponentCard(int levelPlayerCard) {
        System.out.println("Select a opponent card:");
        int numberChosen=1;
        tmp temp=new tmp();
        this.opponent.getDeck().displayAuthorizedCards(levelPlayerCard);
        System.out.println("Type your opponent's number :");
        return this.opponent.getDeck().getAllCards().get(numberChosen);
    }


    public void displayAllPlayer(){
        tmp temp=new tmp();
        for(int i=0;i<temp.getPeople().size();i++){
            System.out.println(i+" :"+temp.getPeople().get(i).getPseudo());
        }
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
