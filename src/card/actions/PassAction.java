package card.actions;

import game.Game;

public class PassAction {
    public static void pass(Game game){
        game.setCurrentPlayer(game.getCurrentPlayer() + game.getDirection()); // duplicate code in draw!
    }
}
