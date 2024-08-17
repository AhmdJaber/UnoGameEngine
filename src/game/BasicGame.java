package game;

import rule.card.creation.StandardCardCreation;
import rule.card.distribute.StandardDistribution;
import rule.card.initial.PlayerInitialCards;
import rule.color.StandardColorsInitialization;
import rule.dealer.GameDealer;
import rule.direction.LeftDirection;
import rule.match.MatchTypeOrColor;
import rule.player.StandardPlayerCreation;
import rule.points.PositiveCalculation;
import rule.shuffle.RandomShuffle;
import rule.win.PositiveWin;

public class BasicGame extends Game {
    @Override
    public void initPlayers() {
        this.setPlayerCreation(new StandardPlayerCreation(4));
    }

    @Override
    public void initColors() {
        this.setColorInitialization(StandardColorsInitialization.getInstance());
    }

    @Override
    public void initCardCreation() {
        this.setCardCreation(StandardCardCreation.getInstance());
    }

    @Override
    public void initShuffle() {
        this.setInitializeShuffle(RandomShuffle.getInstance());
    }

    @Override
    public void initNumOfInItPlayerCards() {
        this.setPlayerInitialCards(new PlayerInitialCards(7));
    }

    @Override
    public void initMatching(){
        this.setMatch(MatchTypeOrColor.getInstance());
    }

    @Override
    public void initCalculatePoints() {
        this.setCalculatePoints(PositiveCalculation.getInstance());
    }

    @Override
    public void initWin() {
        this.setWin(new PositiveWin(500));
    }

    @Override
    public void initInitDirection() {
        this.setInitialDirection(new LeftDirection());
    }

    @Override
    public void initDealer() {
        this.setGameDealer(new GameDealer(0));
    }

    @Override
    public void initCardDistribution() {
        this.setCardDistribution(StandardDistribution.getInstance());
    }
}
