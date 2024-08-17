package rule.shuffle;

import card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomSplitShuffle implements InitializeShuffle{
    private RandomSplitShuffle(){

    }

    private static class SingletonHolder{
        private static final RandomSplitShuffle randomSplitShuffle = new RandomSplitShuffle();
    }

    public static RandomSplitShuffle getInstance(){
        return RandomSplitShuffle.SingletonHolder.randomSplitShuffle;
    }

    @Override
    public void shuffle(List<Card> cards) {
        if (cards == null){
            throw new IllegalArgumentException("cards is null");
        }

        int n = cards.size();
        List<Card> first = new ArrayList<>();
        List<Card> second = new ArrayList<>();
        int random = (int) (Math.random() * n);
        for(int i = 0; i < n; i++){
            if (i < random){
                second.add(cards.get(i));
            }
            else {
                first.add(cards.get(i));
            }
        }

        first.addAll(second);
        cards.clear();
        cards.addAll(first);
    }
}
