package card.cards.action;

import card.ActionCard;
import card.action.PassPlayers;
import card.enums.Color;
import card.enums.Type;
import game.Game;

public class Pass extends ActionCard {
    public Pass(Type type, Color color, Integer points) {
        super(type, color, points);
    }

    @Override
    public void action(Game game) {
        PassPlayers.pass(game);
    }
}
