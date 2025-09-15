package hra.mapa.decor;

import hra.mapa.AbstractSpriteHandler;

public class DecorGenerator extends AbstractSpriteHandler {

    @Override
    protected String getSpritesheetPath() {
        return "/Tile/spritesheet.png";
    }

    @Override
    protected String getMapFilePath() {
        return "/decor.txt";
    }
}
