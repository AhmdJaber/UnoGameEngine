package card.action;

import game.Game;

public class PassPlayers {
    public static void pass(Game game){
        int numOfPlayers = game.getPlayers().size();
        game.setCurrentPlayer((game.getCurrentPlayer() + game.getDirection() + numOfPlayers) % numOfPlayers); // duplicate code in draw!
    }
}
