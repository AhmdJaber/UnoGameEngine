package game;

import player.Observer;

public interface Notifier {
    public void register(Observer observer);
    public void unregister(Observer observer);
    public void notifyObservers();
}
