package card.cards.action;

import card.ActionCard;
import card.action.ChangeColor;
import card.enums.Color;
import card.enums.Type;
import game.Game;

public class Wild extends ActionCard {
    public Wild(Type type, Color color, Integer points) {
        super(type, color, points);
    }

    @Override
    public void action(Game game) {
        setColor(ChangeColor.change(game));
    }
}