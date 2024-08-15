package game;

import rule.card.creation.NormalCardCreation;
import rule.card.distribute.NormalDistribution;
import rule.card.initial.PlayerInitialCards;
import rule.color.NormalColorsInitialization;
import rule.dealer.PickDealer;
import rule.direction.LeftInitialDirection;
import rule.match.MatchTypeOrColor;
import rule.player.NormalPlayerCreation;
import rule.points.PositiveCalculation;
import rule.shuffle.RandomShuffle;
import rule.win.PositiveWin;

public class BasicGame extends Game {
    @Override
    public void initPlayers() {
        this.setPlayerCreation(new NormalPlayerCreation(4));
    }

    @Override
    public void initDealer() {
        this.setPickDealer(new PickDealer(0));
    }

    @Override
    public void initColors() {
        this.setColorInitialization(NormalColorsInitialization.getInstance());
    }

    @Override
    public void initCardCreation() {
        this.setCardCreation(NormalCardCreation.getInstance());
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
    public void initMatch(){
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
        this.setInitialDirection(new LeftInitialDirection());
    }

    @Override
    public void initCardDistribution() {
        this.setCardDistribution(NormalDistribution.getInstance());
    }
}