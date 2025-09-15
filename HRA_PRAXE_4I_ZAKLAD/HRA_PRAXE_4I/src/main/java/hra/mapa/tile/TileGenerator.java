package hra.mapa.tile;

import hra.mapa.AbstractSpriteHandler;

public class TileGenerator extends AbstractSpriteHandler {

    @Override
    protected String getSpritesheetPath() {
        return "/Tile/spritesheet.png";
    }

    @Override
    protected String getMapFilePath() {
        return "/tile.txt";
    }
}