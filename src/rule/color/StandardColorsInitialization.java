package rule.color;

import card.enums.Color;

import java.util.ArrayList;
import java.util.List;

public class StandardColorsInitialization implements ColorInitialization{
    private StandardColorsInitialization(){
    }

    private static class SingletonHolder{
        private static final StandardColorsInitialization standardColorsInitialization = new StandardColorsInitialization();
    }

    public static StandardColorsInitialization getInstance(){
        return SingletonHolder.standardColorsInitialization;
    }

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
