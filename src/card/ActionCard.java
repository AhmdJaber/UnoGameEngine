package card;

import card.cards.action.Action;
import card.enums.Color;
import card.enums.Type;
import game.Game;

public abstract class ActionCard extends Card implements Action {
    public ActionCard(Type type, Color color, Integer points) {
        super(type, color, points);
    }

    @Override
    public abstract void action(Game game);

    public void use(Game game){
        this.action(game);
    }
}
