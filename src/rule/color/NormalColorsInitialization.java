package rule.color;

import card.enums.Color;

import java.util.ArrayList;
import java.util.List;

public class NormalColorsInitialization implements ColorInitialization{
    @Override
    public List<Color> initialize() {
        List<Color> colors = new ArrayList<>();
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.RED);
        colors.add(Color.YELLOW);
        colors.add(Color.NONE);
        return colors;
    }
}
