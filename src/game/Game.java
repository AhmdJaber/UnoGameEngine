package game;

import card.ActionCard;
import card.Card;
import card.cards.action.Continue;
import card.enums.Color;
import card.enums.Type;
import player.Observer;
import player.Player;
import rule.card.creation.CardCreation;
import rule.card.distribute.CardDistribution;
import rule.card.initial.PlayerInitialCards;
import rule.color.ColorInitialization;
import rule.dealer.GameDealer;
import rule.direction.InitialDirection;
import rule.match.Match;
import rule.player.PlayerCreation;
import rule.points.CalculatePoints;
import rule.shuffle.InitializeShuffle;
import rule.win.Win;
import utility.action.DrawCards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Game implements Notifier{
    private List<Player> players;
    private Integer dealer;
    private Integer currentPlayer;
    private Player winner;
    private List<Card> cards;
    private List<Color> colors;
    private List<Card> pile;
    private List<Card> discard;
    private Integer direction;
    private Match match;
    private Win win;
    private InitializeShuffle initializeShuffle;
    private CardCreation cardCreation;
    private ColorInitialization colorInitialization;
    private PlayerCreation playerCreation;
    private GameDealer gameDealer;
    private PlayerInitialCards playerInitialCards;
    private InitialDirection initialDirection;
    private CalculatePoints calculatePoints;
    private CardDistribution cardDistribution;
    private List<Observer> observers;

    public final void play(){
        prepareGame();
        players = playerCreation.create();
        colors = colorInitialization.initialize();
        while (winner == null) {
            dealer = gameDealer.pick();
            currentPlayer = dealer;
            cards = cardCreation.create(colors);
            initializeShuffle.shuffle(cards);
            Integer numOfInitPlayerCards = playerInitialCards.initialize();
            cardDistribution.distribute(cards, players, numOfInitPlayerCards);
            direction = initialDirection.initialize();
            setRemainingCards(cards);
            setObservers(players);
            start();
            System.out.println("Round ends.");
            System.out.println("===========================================================");
        }
    }

    private void prepareGame(){
        initPlayers();
        initDealer();
        initColors();
        initCardCreation();
        initShuffle();
        initNumOfInItPlayerCards();
        initInitDirection();
        initCalculatePoints();
        initWin();
        initMatch();
        initCardDistribution();
    }

    private void start(){
        Scanner sc = new Scanner(System.in);

        currentPlayer = dealer + direction;
        while (true){
            currentPlayer = (currentPlayer + players.size()) % players.size();
            Player player = players.get(currentPlayer);
            System.out.println("Discard: " + discard.get(discard.size() - 1));
            System.out.println("{ " + player.getName() + " }");

            int cardIdx;
            boolean useCard = true;
            boolean canDraw = true;
            while (true){
                System.out.println("-----------------------------------------------------");
                System.out.println("Pick one card using it's index: ");
                System.out.println(player.getCards());
                boolean isMatch = checkCardsMatch(player, discard.get(discard.size() - 1));
                if (!isMatch && canDraw){
                    System.out.println("Draw a card from the Pile [Enter -1]");
                }

                cardIdx = sc.nextInt();
                if (cardIdx == -1 && canDraw && !isMatch){
                    DrawCards.draw(this, player, 1);
                    canDraw = false;
                    if (checkCardsMatch(player, discard.get(discard.size() - 1))){
                        useCard = checkUseCard();
                    }
                    else {
                        useCard = false;
                        break;
                    }
                    if (useCard) {
                        continue;
                    }
                    break;
                }
                if (cardIdx >= player.getCards().size() || cardIdx < 0){
                    System.out.println("Enter an index from " + 0 + " to " + (player.getCards().size() - 1));
                    continue;
                }
                Card card = player.getCards().get(cardIdx);
                if (match.match(card, discard.get(discard.size() - 1)) || card.getType() == Type.WILD || card.getType() == Type.WILD_DRAW_FOUR){
                    break;
                }
                System.out.println("The card " + card + " doesn't matches with the Discard card!");
                System.out.println("Enter a card that matches with: " + discard.get(discard.size() - 1));
            }

            if (useCard){
                Card card = player.getCards().remove(cardIdx);
                discard.add(card);
                if (card instanceof ActionCard){
                    ((ActionCard) card).use(this);
                }
            }

            if (player.getCards().size() == 1){
                System.out.println(player.getName() + ": UNO!");
            }

            if (player.getCards().isEmpty()){
                notifyObservers();

                if (getWin().win(player)){
                    winner = player;
                }
                break;
            }
            currentPlayer += direction;
        }

        System.out.println("The player: " + this.getPlayers().get(this.getCurrentPlayer()) + " Wins the Round!");
        Player.printScores(this);
        sc.close();
    }

    public final void setRemainingCards(List<Card> cards){
        pile = new ArrayList<>();
        pile.addAll(cards);
        setDiscard(new ArrayList<>());
        Card card = pile.remove(pile.size() - 1);
        discard.add(card);
        while(card.getType() == Type.WILD || card.getType() == Type.WILD_DRAW_FOUR){
            card = pile.remove(pile.size() - 1);
            discard.add(card);
        }
        if (card instanceof ActionCard){
            ((ActionCard) card).use(this);
        }
        cards.clear();
    }

    private boolean checkCardsMatch(Player player, Card card){
        for (Card currentCard: player.getCards()){
            if (match.match(currentCard, card)){
                return true;
            }
        }
        return false;
    }

    public final boolean checkUseCard(){
        System.out.println("Do you want to use the drawn card? [Y/N]");
        Scanner sc = new Scanner(System.in);
        while (true){
            String input = sc.next();
            if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")){
                return true;
            }
            else if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")){
                return false;
            }
            else {
                System.out.println("Enter Y/Yes or N/NO");
            }
        }
    }

    @Override
    public void register(Observer observer){
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer){
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(){
        for (Observer observer: getObservers()){
            observer.update(this);
        }
    }

    public abstract void initPlayers();

    public abstract void initColors();

    public abstract void initCardCreation();

    public abstract void initShuffle();

    public abstract void initNumOfInItPlayerCards();

    public abstract void initMatch();

    public abstract void initCalculatePoints();

    public abstract void initWin();

    public abstract void initInitDirection();

    public abstract void initCardDistribution();

    public abstract void initDealer();

    public List<Player> getPlayers() {
        return players;
    }

    public Integer getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Integer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
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

    public void setDiscard(List<Card> discard) {
        this.discard = discard;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Win getWin() {
        return win;
    }

    public void setWin(Win win) {
        this.win = win;
    }

    public void setInitializeShuffle(InitializeShuffle initializeShuffle) {
        this.initializeShuffle = initializeShuffle;
    }

    public void setCardCreation(CardCreation cardCreation) {
        this.cardCreation = cardCreation;
    }

    public void setColorInitialization(ColorInitialization colorInitialization) {
        this.colorInitialization = colorInitialization;
    }

    public void setPlayerCreation(PlayerCreation playerCreation) {
        this.playerCreation = playerCreation;
    }

    public void setGameDealer(GameDealer gameDealer) {
        this.gameDealer = gameDealer;
    }

    public void setPlayerInitialCards(PlayerInitialCards playerInitialCards) {
        this.playerInitialCards = playerInitialCards;
    }

    public void setInitialDirection(InitialDirection initialDirection) {
        this.initialDirection = initialDirection;
    }

    public CalculatePoints getCalculatePoints() {
        return calculatePoints;
    }

    public void setCalculatePoints(CalculatePoints calculatePoints) {
        this.calculatePoints = calculatePoints;
    }

    public void setCardDistribution(CardDistribution cardDistribution) {
        this.cardDistribution = cardDistribution;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Player> players) {
        this.observers = new ArrayList<>();
        for (Player player: players){
            register(player);
        }
    }
}
