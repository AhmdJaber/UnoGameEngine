package card.actions;

import game.Game;

public class ReverseAction {
    public static void reverse(Game game){
        game.setDirection(game.getDirection() * -1);
    }
}
