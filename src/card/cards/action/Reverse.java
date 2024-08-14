package card.cards.action;

import card.ActionCard;
import card.action.ReverseDirection;
import card.enums.Color;
import card.enums.Type;
import game.Game;

public class Reverse extends ActionCard {
    public Reverse(Type type, Color color, Integer points) {
        super(type, color, points);
    }

    @Override
    public void action(Game game) {
        ReverseDirection.reverse(game);
    }
}
