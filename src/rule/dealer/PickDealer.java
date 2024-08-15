package rule.dealer;

public class PickDealer {
    private final int dealer;

    public PickDealer(int dealer) {
        this.dealer = dealer;
    }

    public Integer pick(){
        return dealer;
    }
}
