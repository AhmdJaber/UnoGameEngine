package card;

import card.enums.Color;
import card.enums.Type;

import java.util.Objects;

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

    @Override
    public boolean equals(Object object) {
        if (this == object){
            return true;
        }

        if (object == null || this.getClass() != object.getClass()){
            return false;
        }

        Card card = (Card) object;
        return type == card.type && color == card.color && Objects.equals(points, card.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color, points);
    }
}
