package game;

import card.Card;
import card.Color;
import card.Type;
import card.cards.action.WildDrawFour;
import player.Player;
import rule.card.creation.CardCreation;
import rule.card.distribute.CardDistribution;
import rule.card.initial.PlayerInitialCards;
import rule.color.ColorInitialization;
import rule.dealer.PickDealer;
import rule.direction.InitialDirection;
import rule.match.Match;
import rule.player.PlayerCreation;
import rule.points.CalculatePoints;
import rule.shuffle.InitializeShuffle;
import rule.win.Win;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Game {
    protected List<Player> players;
    protected Integer dealer;
    protected Integer currentPlayer;
    protected Player winner;
    protected List<Card> cards;
    protected List<Color> colors;
    protected Color currentColor;
    protected List<Card> pile;
    protected List<Card> discard;
    protected Integer direction;
    protected Integer numOfInitPlayerCard;
    protected Match match;
    protected Win win;
    protected InitializeShuffle initializeShuffle;
    protected CardCreation cardCreation;
    protected ColorInitialization colorInitialization;
    protected PlayerCreation playerCreation;
    protected PickDealer pickDealer;
    protected PlayerInitialCards playerInitialCards;
    protected InitialDirection initialDirection;
    protected CalculatePoints calculatePoints;
    protected CardDistribution cardDistribution;

    public final void prepareGame(){
        setPlayers();
        setDealer();
        setColors();
        setCardCreation();
        setShuffle();
        setNumOfInItPlayerCard();
        setInitDirection();
        setCalculatePoints();
        setWin();
        setMatch();
        setCardDistribution();
        // reorder them
    }

    public final void start(){
        prepareGame();
        players = playerCreation.create();
        dealer = pickDealer.pick();
        colors = colorInitialization.initialize();
        cards = cardCreation.create(colors);
        initializeShuffle.shuffle(cards);
        numOfInitPlayerCard = playerInitialCards.initialize();
        cardDistribution.distribute(cards, players, numOfInitPlayerCard);
        direction = initialDirection.initialize();
        setRemainingCards(cards);
        gamePlay();
    }

    public final void gamePlay(){
        Scanner sc = new Scanner(System.in);
        currentPlayer = dealer + direction;
        while (true){
            currentPlayer = (currentPlayer + players.size()) % players.size();
            Player player = players.get(currentPlayer);
            player.getCards().add(new WildDrawFour(Type.WILD_DRAW_FOUR, Color.NONE, 50)); // remove it
            System.out.println("Discard: " + discard.get(discard.size() - 1));
            System.out.println("{ " + player.getName() + " }");
            while (!checkCardsMatch(player, discard.get(discard.size() - 1))){
                System.out.println("You have no card that matches with the current Discard card!");
                System.out.println("Drawing a card from the Pile...");
                player.getCards().add(pile.remove(pile.size() - 1));
            }
            System.out.println("Pick one of the following cards: (Enter the index of it)");
            System.out.println(player.getCards());
            int cardIdx = sc.nextInt();
            while (true){
                while(cardIdx >= player.getCards().size()){
                    System.out.println("Enter a number from " + 0 + " to " + (player.getCards().size() - 1));
                    cardIdx = sc.nextInt();
                }
                Card card = player.getCards().get(cardIdx);
                if (match.match(card, discard.get(discard.size() - 1)) || card.getType() == Type.WILD || card.getType() == Type.WILD_DRAW_FOUR){
                    break;
                }
                System.out.println("The card " + card + " doesn't matches with the Discard card!");
                System.out.println("Enter a card that matches with: " + discard.get(discard.size() - 1));
                cardIdx = sc.nextInt();
            }


            Card card = player.getCards().remove(cardIdx);
            getDiscard().add(card);
            card.use(this);
            if (player.getCards().size() == 1){
                System.out.println(player.getName() + ": UNO!");
            }

            if (player.getCards().isEmpty()){
                winner = player;
                break;
            }
            currentPlayer += direction;
        }

        System.out.println("The player: " + winner + " Wins the Game!");
    }

    public final void setRemainingCards(List<Card> cards){
        setPile(cards);
        setDiscard(new ArrayList<>());
        Card card = pile.remove(pile.size() - 1);
        discard.add(card);
        while(card.getType() == Type.WILD || card.getType() == Type.WILD_DRAW_FOUR){
            card = pile.remove(pile.size() - 1);
            discard.add(card);
        }
        this.getCards().clear();
    }

    public final boolean checkCardsMatch(Player player, Card card){
        for (Card currentCard: player.getCards()){
            if (match.match(currentCard, card) || card.getType() == Type.WILD || card.getType() == Type.WILD_DRAW_FOUR){
                return true;
            }
        }

        return false;
    }

    public abstract void setPlayers();

    public abstract void setDealer();

    public abstract void setColors();

    public abstract void setCardCreation();

    public abstract void setShuffle();

    public abstract void setNumOfInItPlayerCard();

    public abstract void setMatch();

    public abstract void setCalculatePoints();

    public abstract void setWin();

    public abstract void setInitDirection();

    public abstract void setCardDistribution();



    // trash?
    public void setCurrentPlayer(Integer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public void setPile(List<Card> pile) {
        this.pile = pile;
    }

    public void setDiscard(List<Card> discard) {
        this.discard = discard;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public InitializeShuffle getInitializeShuffle() {
        return initializeShuffle;
    }

    public List<Player> getPlayers(){
        return players;
    }

    public Integer getCurrentPlayer() {
        return currentPlayer;
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Color> getColors() {
        return colors;
    }

    public List<Card> getPile() {
        return pile;
    }

    public List<Card> getDiscard() {
        return discard;
    }

    public Integer getDirection() {
        return direction;
    }

    public Integer getNumOfInItPlayerCard() {
        return numOfInitPlayerCard;
    }

    public Match getMatch() {
        return match;
    }

    public CalculatePoints getCalculatePoints() {
        return calculatePoints;
    }

    public Win getWin() {
        return win;
    }
}
