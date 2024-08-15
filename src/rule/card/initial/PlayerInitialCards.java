package rule.card.initial;

public class PlayerInitialCards {
    private final int numOfInitCards;

    public PlayerInitialCards(int numOfInitCards) {
        this.numOfInitCards = numOfInitCards;
    }

    public Integer initialize(){
        return numOfInitCards;
    }
}