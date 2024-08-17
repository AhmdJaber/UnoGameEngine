package utility.action;

import game.Game;

public class ReverseDirection {
    private ReverseDirection(){
        throw new AssertionError("Utility class should not be instantiated");
    }

    public static void reverse(Game game){
        if (game == null){
            throw new IllegalArgumentException("Game is null");
        }
        game.setDirection(game.getDirection() * -1);
    }
}
