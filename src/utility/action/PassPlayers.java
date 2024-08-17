package utility.action;

import game.Game;

public class PassPlayers {
    private PassPlayers(){
        throw new AssertionError("Utility class should not be instantiated");
    }

    public static void pass(Game game){
        if (game == null){
            throw new IllegalArgumentException("Game is null");
        }
        int numOfPlayers = game.getPlayers().size();
        game.setCurrentPlayer((game.getCurrentPlayer() + game.getDirection() + numOfPlayers) % numOfPlayers); // duplicate code in draw!
    }
}
