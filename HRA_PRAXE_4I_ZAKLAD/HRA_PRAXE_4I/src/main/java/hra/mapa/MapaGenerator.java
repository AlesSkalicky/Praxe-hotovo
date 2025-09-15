package hra.mapa;

import hra.mapa.decor.DecorGenerator;
import hra.mapa.tile.TileGenerator;

import java.awt.*;

public class MapaGenerator {
    private TileGenerator tileGenerator;
    private DecorGenerator decorGenerator;

    public MapaGenerator() {
        this.tileGenerator = new TileGenerator();
        this.decorGenerator = new DecorGenerator();
    }

    public void draw(Graphics g){
        tileGenerator.draw(g);
        decorGenerator.draw(g);
    }
}
