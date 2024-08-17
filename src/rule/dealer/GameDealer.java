package rule.dealer;

public class GameDealer {
    private final int dealer;

    public GameDealer(int dealer) {
        this.dealer = dealer;
    }

    public Integer pick(){
        return dealer;
    }
}
