package rule.shuffle;

import card.Card;

import java.util.Collections;
import java.util.List;

public class RandomShuffle implements InitializeShuffle {
    @Override
    public void shuffle(List<Card> cards) {
        int n = cards.size();
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * (n));
            int b = (int) (Math.random() * (n));

            Collections.swap(cards, a, b);
        }
    }
}
