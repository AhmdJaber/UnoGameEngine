package card.cards.number;

import card.Card;
import card.Color;
import card.Type;
import game.Game;

public class Two extends Card {
    public Two(Type type, Color color, Integer points) {
        super(type, color, points);
    }

    @Override
    public void action(Game game) {
        // No actions for this card
    }
}