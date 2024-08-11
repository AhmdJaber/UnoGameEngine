package card.cards.action;

import card.Card;
import card.Color;
import card.Type;
import card.actions.ReverseAction;
import game.Game;

public class Reverse extends Card {
    public Reverse(Type type, Color color, Integer points) {
        super(type, color, points);
    }

    @Override
    public void action(Game game) {
        ReverseAction.reverse(game);
    }
}
