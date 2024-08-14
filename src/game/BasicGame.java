package game;

import rule.card.creation.NormalCardCreation;
import rule.card.distribute.NormalDistribution;
import rule.card.initial.SevenInitialCards;
import rule.color.NormalColorsInitialization;
import rule.dealer.FirstPlayerDealer;
import rule.direction.LeftInitialDirection;
import rule.match.MatchTypeOrColor;
import rule.player.NormalPlayerCreation;
import rule.points.PositiveCalculation;
import rule.shuffle.RandomShuffle;
import rule.win.PositiveWin;

public class BasicGame extends Game {
    @Override
    public void initPlayers() {
        this.setPlayerCreation(new NormalPlayerCreation());
    }

    @Override
    public void initDealer() {
        this.setPickDealer(new FirstPlayerDealer());
    }

    @Override
    public void initColors() {
        this.setColorInitialization(new NormalColorsInitialization());
    }

    @Override
    public void initCardCreation() {
        this.setCardCreation(new NormalCardCreation());
    }

    @Override
    public void initShuffle() {
        this.setInitializeShuffle(new RandomShuffle());
    }

    @Override
    public void initNumOfInItPlayerCards() {
        this.setPlayerInitialCards(new SevenInitialCards());
    }

    @Override
    public void initMatch(){
        this.setMatch(new MatchTypeOrColor());
    }

    @Override
    public void initCalculatePoints() {
        this.setCalculatePoints(new PositiveCalculation());
    }

    @Override
    public void initWin() {
        this.setWin(new PositiveWin());
    }

    @Override
    public void initInitDirection() {
        this.setInitialDirection(new LeftInitialDirection());
    }

    @Override
    public void initCardDistribution() {
        this.setCardDistribution(new NormalDistribution());
    }
}