package rule.color;

import card.enums.Color;

import java.util.ArrayList;
import java.util.List;

public class RGBColorInitialization implements ColorInitialization {
    private RGBColorInitialization(){

    }

    private static class SingletonHolder{
        private static final RGBColorInitialization rgbColorInitialization = new RGBColorInitialization();
    }

    public static RGBColorInitialization getInstance(){
        return SingletonHolder.rgbColorInitialization;
    }

    @Override
    public List<Color> initialize() {
        List<Color> colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);
        return colors;
    }
}
