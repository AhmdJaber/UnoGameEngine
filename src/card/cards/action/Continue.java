package card.cards.action;

import card.ActionCard;
import card.enums.Color;
import card.enums.Type;
import game.Game;

public class Continue extends ActionCard {
    public Continue(Type type, Color color, Integer points) {
        super(type, color, points);
    }

    @Override
    public void action(Game game) {
        // implement the action
    }
}
