package card.action;

import game.Game;

public class PassPlayers {
    public static void pass(Game game){
        game.setCurrentPlayer(game.getCurrentPlayer() + game.getDirection()); // duplicate code in draw!
    }
}
