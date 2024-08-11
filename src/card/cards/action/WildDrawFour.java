package card.cards.action;

import card.Card;
import card.Color;
import card.Type;
import card.actions.ColorAction;
import card.actions.DrawAction;
import game.Game;

public class WildDrawFour extends Card {
    public WildDrawFour(Type type, Color color, Integer points) {
        super(type, color, points);
    }

    @Override
    public void action(Game game) {
        setColor(ColorAction.change(game));
        DrawAction.draw(game, 4);
    }
}