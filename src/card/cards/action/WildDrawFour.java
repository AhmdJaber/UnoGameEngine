package card.cards.action;

import card.ActionCard;
import card.action.ChangeColor;
import card.action.DrawCards;
import card.enums.Color;
import card.enums.Type;
import game.Game;
import player.Player;

public class WildDrawFour extends ActionCard {
    public WildDrawFour(Type type, Color color, Integer points) {
        super(type, color, points);
    }

    @Override
    public void action(Game game) {
        setColor(ChangeColor.change(game));
        Player player = game.getPlayers().get((game.getCurrentPlayer() + game.getDirection() + game.getPlayers().size()) % game.getPlayers().size());
        DrawCards.draw(game, player, 4);
    }
}