package card.action;

import game.Game;

public class ReverseDirection {
    public static void reverse(Game game){
        game.setDirection(game.getDirection() * -1);
    }
}
