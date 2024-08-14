package card;

import card.enums.Color;
import card.enums.Type;

public abstract class Card {
    private final Type type;
    private Color color; // How to make it final?
    private final Integer points;

    public Card(Type type, Color color, Integer points) {
        this.type = type;
        this.color = color;
        this.points = points;
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
