package card.cards.number;

import card.Card;
import card.Color;
import card.Type;
import game.Game;

public class Four extends Card {
    public Four(Type type, Color color, Integer points) {
        super(type, color, points);
    }

    @Override
    public void action(Game game) {
        // No actions for this card
    }
}
