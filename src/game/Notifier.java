package game;

import card.Card;
import player.Observer;

import java.util.List;

public interface Notifier {
    public void register(Observer observer);
    public void unregister(Observer observer);
    public void notifyObserver(List<Card> cards);
}
