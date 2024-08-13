package card.cards.action;

import card.Card;
import card.Color;
import card.Type;
import card.action.ReverseDirection;
import game.Game;

public class Reverse extends Card {
    public Reverse(Type type, Color color, Integer points) {
        super(type, color, points);
    }

    @Override
    public void action(Game game) {
        ReverseDirection.reverse(game);
    }
}
