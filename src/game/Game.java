package game;

import card.ActionCard;
import card.Card;
import card.action.DrawCards;
import card.enums.Color;
import card.enums.Type;
import player.Observer;
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

public abstract class Game implements Notifier{
    private List<Player> players;
    private Integer dealer;
    private Integer currentPlayer;
    private Player winner;
    private List<Card> cards;
    private List<Color> colors;
    private Color currentColor;
    private List<Card> pile;
    private List<Card> discard;
    private Integer direction;
    private Integer numOfInitPlayerCards;
    private Match match;
    private Win win;
    private InitializeShuffle initializeShuffle;
    private CardCreation cardCreation;
    private ColorInitialization colorInitialization;
    private PlayerCreation playerCreation;
    private PickDealer pickDealer;
    private PlayerInitialCards playerInitialCards;
    private InitialDirection initialDirection;
    private CalculatePoints calculatePoints;
    private CardDistribution cardDistribution;
    private List<Observer> observers;

    public final void start(){
        while (winner == null) {
            prepareGame();
            players = playerCreation.create();
            dealer = pickDealer.pick();
            currentPlayer = dealer;
            colors = colorInitialization.initialize();
            cards = cardCreation.create(colors);
            initializeShuffle.shuffle(cards);
            numOfInitPlayerCards = playerInitialCards.initialize();
            cardDistribution.distribute(cards, players, numOfInitPlayerCards);
            direction = initialDirection.initialize();
            setRemainingCards(cards);
            setObservers();
            gamePlay();
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

    private void gamePlay(){
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
                List<Card> playersCards = new ArrayList<>();
                for(Player currentPlayer: players){
                    playersCards.addAll(currentPlayer.getCards());
                }
                notifyObserver(player, playersCards);
                notifyObserver(player.getCards());

                if (getWin().win(player)){
                    winner = player;
                }
                break;
            }
            currentPlayer += direction;
        }

        System.out.println("The player: " + winner + " Wins the Game!");
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

    public final boolean checkCardsMatch(Player player, Card card){
        for (Card currentCard: player.getCards()){
            if (match.match(currentCard, card) || currentCard.getType() == Type.WILD || currentCard.getType() == Type.WILD_DRAW_FOUR){
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
    public void notifyObserver(List<Card> cards){
        for (Observer observer: observers){
            observer.update(this, cards);
        }
    }

    @Override
    public void notifyObserver(Observer observer, List<Card> cards){
        observer.update(this, cards);
    }

    // abstract
    public abstract void initPlayers();

    public abstract void initDealer();

    public abstract void initColors();

    public abstract void initCardCreation();

    public abstract void initShuffle();

    public abstract void initNumOfInItPlayerCards();

    public abstract void initMatch();

    public abstract void initCalculatePoints();

    public abstract void initWin();

    public abstract void initInitDirection();

    public abstract void initCardDistribution();

    // getters / setters
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Integer getDealer() {
        return dealer;
    }

    public void setDealer(Integer dealer) {
        this.dealer = dealer;
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

    public void setWinner(Player winner) {
        this.winner = winner;
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

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public List<Card> getPile() {
        return pile;
    }

    public void setPile(List<Card> pile) {
        this.pile = pile;
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

    public Integer getNumOfInitPlayerCards() {
        return numOfInitPlayerCards;
    }

    public void setNumOfInitPlayerCards(Integer numOfInitPlayerCards) {
        this.numOfInitPlayerCards = numOfInitPlayerCards;
    }

    public Match getMatch() {
        return match;
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

    public InitializeShuffle getInitializeShuffle() {
        return initializeShuffle;
    }

    public void setInitializeShuffle(InitializeShuffle initializeShuffle) {
        this.initializeShuffle = initializeShuffle;
    }

    public CardCreation getCardCreation() {
        return cardCreation;
    }

    public void setCardCreation(CardCreation cardCreation) {
        this.cardCreation = cardCreation;
    }

    public ColorInitialization getColorInitialization() {
        return colorInitialization;
    }

    public void setColorInitialization(ColorInitialization colorInitialization) {
        this.colorInitialization = colorInitialization;
    }

    public PlayerCreation getPlayerCreation() {
        return playerCreation;
    }

    public void setPlayerCreation(PlayerCreation playerCreation) {
        this.playerCreation = playerCreation;
    }

    public PickDealer getPickDealer() {
        return pickDealer;
    }

    public void setPickDealer(PickDealer pickDealer) {
        this.pickDealer = pickDealer;
    }

    public PlayerInitialCards getPlayerInitialCards() {
        return playerInitialCards;
    }

    public void setPlayerInitialCards(PlayerInitialCards playerInitialCards) {
        this.playerInitialCards = playerInitialCards;
    }

    public InitialDirection getInitialDirection() {
        return initialDirection;
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

    public CardDistribution getCardDistribution() {
        return cardDistribution;
    }

    public void setCardDistribution(CardDistribution cardDistribution) {
        this.cardDistribution = cardDistribution;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers() {
        this.observers = new ArrayList<>();
        observers.addAll(players);
    }
}
