package card.action;

import game.Game;

public class ReverseDirection {
    public static void reverse(Game game){
        if (game == null){
            throw new IllegalArgumentException("Game is null");
        }
        game.setDirection(game.getDirection() * -1);
    }
}
