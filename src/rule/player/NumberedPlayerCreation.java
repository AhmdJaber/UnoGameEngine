package rule.player;

public abstract class NumberedPlayerCreation implements PlayerCreation {
    private final int numOfPlayers;

    public NumberedPlayerCreation(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }
}
