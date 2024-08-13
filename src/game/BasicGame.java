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
    public void setPlayers() {
        this.playerCreation = new NormalPlayerCreation();
    }

    @Override
    public void setDealer() {
        this.pickDealer = new FirstPlayerDealer();
    }

    @Override
    public void setColors() {
        this.colorInitialization = new NormalColorsInitialization();
    }

    @Override
    public void setCardCreation() {
        this.cardCreation = new NormalCardCreation();
    }

    @Override
    public void setShuffle() {
        this.initializeShuffle = new RandomShuffle();
    }

    @Override
    public void setNumOfInItPlayerCard() {
        this.playerInitialCards = new SevenInitialCards();
    }

    @Override
    public void setMatch(){
        this.match = new MatchTypeOrColor();
    }

    @Override
    public void setCalculatePoints() {
        this.calculatePoints = new PositiveCalculation();
    }

    @Override
    public void setWin() {
        this.win = new PositiveWin();
    }

    @Override
    public void setInitDirection() {
        this.initialDirection = new LeftInitialDirection();
    }

    @Override
    public void setCardDistribution() {
        this.cardDistribution = new NormalDistribution();
    }
}