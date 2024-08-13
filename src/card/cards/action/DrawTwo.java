package card.cards.action;

import card.Card;
import card.Color;
import card.Type;
import card.action.DrawCards;
import game.Game;

public class DrawTwo extends Card {
    public DrawTwo(Type type, Color color, Integer points) {
        super(type, color, points);
    }

    @Override
    public void action(Game game) {
        DrawCards.draw(game, 2);
    }
}
