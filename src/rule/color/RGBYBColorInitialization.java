package rule.color;

import card.enums.Color;

import java.util.ArrayList;
import java.util.List;

public class RGBYBColorInitialization implements ColorInitialization{
    private RGBYBColorInitialization(){

    }

    private static class SingletonHolder{
        private static final RGBYBColorInitialization rgbybColorInitialization = new RGBYBColorInitialization();
    }

    public static RGBYBColorInitialization getInstance(){
        return SingletonHolder.rgbybColorInitialization;
    }

    @Override
    public List<Color> initialize() {
        List<Color> colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);
        colors.add(Color.BLACK);
        colors.add(Color.NONE);
        return colors;
    }
}
