package card.cards.action;

import card.Card;
import card.Color;
import card.Type;
import card.action.DrawCards;
import game.Game;
import player.Player;

public class DrawTwo extends Card {
    public DrawTwo(Type type, Color color, Integer points) {
        super(type, color, points);
    }

    @Override
    public void action(Game game) {
        Player player = game.getPlayers().get((game.getCurrentPlayer() + game.getDirection() + game.getPlayers().size()) % game.getPlayers().size());
        DrawCards.draw(game, player, 2);
    }
}
