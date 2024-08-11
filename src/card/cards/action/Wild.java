package card.cards.action;

import card.Card;
import card.Color;
import card.Type;
import card.actions.ColorAction;
import game.Game;

public class Wild extends Card {
    public Wild(Type type, Color color, Integer points) {
        super(type, color, points);
    }

    @Override
    public void action(Game game) {
        setColor(ColorAction.change(game));
    }
}