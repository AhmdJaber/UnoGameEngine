package utility.action;

import card.enums.Color;
import game.Game;
import utility.ColorUtil;

public class ChangeColor {
    public static Color change(Game game) {
        if (game == null){
            throw new IllegalArgumentException("Game is null");
        }
        ColorUtil.printColors(game.getColors());
        return ColorUtil.pickColor();
    }
}
