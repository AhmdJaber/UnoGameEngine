package utility.action;

import card.enums.Color;
import game.Game;
import utility.Colors;

public class ChangeColor {
    public static Color change(Game game) {
        if (game == null){
            throw new IllegalArgumentException("Game is null");
        }
        Colors.printColors(game.getColors());
        return Colors.pickColor();
    }
}
