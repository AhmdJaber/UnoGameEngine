package card;

import card.action.Action;
import game.Game;

public abstract class Card implements Action {
    private final Type type;
    private Color color; // How to make it final?
    private final Integer points;

    public Card(Type type, Color color, Integer points) {
        this.type = type;
        this.color = color;
        this.points = points;
    }

    @Override
    public abstract void action(Game game);

    public void use(Game game){
        this.action(game);
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "[" + type + " " + color + "]";
    }
}
