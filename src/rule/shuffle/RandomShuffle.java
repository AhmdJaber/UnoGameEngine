package rule.shuffle;

import card.Card;

import java.util.Collections;
import java.util.List;

public class RandomShuffle implements InitializeShuffle {
    private RandomShuffle(){

    }

    private static class SingletonHolder{
        private static final RandomShuffle randomShuffle = new RandomShuffle();
    }

    public static RandomShuffle getInstance(){
        return SingletonHolder.randomShuffle;
    }

    @Override
    public void shuffle(List<Card> cards) {
        if (cards == null){
            throw new IllegalArgumentException("cards is null");
        }
        int n = cards.size();
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * (n));
            int b = (int) (Math.random() * (n));

            Collections.swap(cards, a, b);
        }
    }
}
