package game;

import rule.card.creation.StandardCardCreation;
import rule.card.distribute.StandardDistribution;
import rule.card.initial.PlayerInitialCards;
import rule.color.RGBColorInitialization;
import rule.dealer.PickDealer;
import rule.direction.RightDirection;
import rule.match.MatchTypeOrColor;
import rule.player.StandardPlayerCreation;
import rule.points.PositiveCalculation;
import rule.shuffle.RandomShuffle;
import rule.win.PositiveWin;

public class AttackGame extends Game{
    @Override
    public void initPlayers() {
        this.setPlayerCreation(new StandardPlayerCreation(2));
    }

    @Override
    public void initDealer() {
        this.setPickDealer(new PickDealer(0));
    }

    @Override
    public void initColors() {
        this.setColorInitialization(RGBColorInitialization.getInstance());
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
        this.setPlayerInitialCards(new PlayerInitialCards(5));
    }

    @Override
    public void initMatch() {
        this.setMatch(MatchTypeOrColor.getInstance());
    }

    @Override
    public void initCalculatePoints() {
        this.setCalculatePoints(PositiveCalculation.getInstance());
    }

    @Override
    public void initWin() {
        this.setWin(new PositiveWin(200));
    }

    @Override
    public void initInitDirection() {
        this.setInitialDirection(new RightDirection());
    }

    @Override
    public void initCardDistribution() {
        this.setCardDistribution(StandardDistribution.getInstance());
    }
}
