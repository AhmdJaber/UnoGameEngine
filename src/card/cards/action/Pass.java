package card.cards.action;

import card.Card;
import card.Color;
import card.Type;
import card.action.PassPlayers;
import game.Game;

public class Pass extends Card {
    public Pass(Type type, Color color, Integer points) {
        super(type, color, points);
    }

    @Override
    public void action(Game game) {
        PassPlayers.pass(game);
    }
}
