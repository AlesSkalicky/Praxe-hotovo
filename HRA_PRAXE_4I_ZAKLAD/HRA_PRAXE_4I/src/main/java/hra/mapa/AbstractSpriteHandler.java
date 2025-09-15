package hra.mapa;

import hra.entita.Entita;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class AbstractSpriteHandler {

    protected BufferedImage[] spriteImg;
    protected Entita[][] imgMap;
    protected final int tileSize = 16, renderSize = 64;

    public AbstractSpriteHandler() {
        loadResources();
        generate();
    }

    protected void loadResources() {
        try {
            BufferedImage tileset = ImageIO.read(getClass().getResource(getSpritesheetPath()));
            int tilesAcross = tileset.getWidth() / tileSize, tilesDown = tileset.getHeight() / tileSize;
            spriteImg = new BufferedImage[tilesAcross * tilesDown];
            for (int i = 0, y = 0; y < tilesDown; y++)
                for (int x = 0; x < tilesAcross; x++, i++)
                    spriteImg[i] = tileset.getSubimage(x * tileSize, y * tileSize, tileSize, tileSize);
        } catch (IOException e) { e.printStackTrace(); }
    }

    protected void generate() {
        try {
            InputStream is = getClass().getResourceAsStream(getMapFilePath());
            if (is == null) { System.err.println("Soubor nebyl nalezen: " + getMapFilePath()); return; }
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line; int rows = 0, cols = -1;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.trim().split("\\s+");
                if (cols == -1) cols = tokens.length; rows++;
            }
            imgMap = new Entita[rows][cols];
            reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(getMapFilePath())));
            for (int y = 0; (line = reader.readLine()) != null; y++) {
                String[] tokens = line.trim().split("\\s+");
                for (int x = 0; x < tokens.length; x++) {
                    int id = Integer.parseInt(tokens[x]);
                    imgMap[y][x] = (id >= 0 && id < spriteImg.length)
                            ? new Entita(x * tileSize, y * tileSize, tileSize, tileSize, spriteImg[id]) : null;
                }
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void draw(Graphics g) {
        if (imgMap == null) return;
        for (int y = 0; y < imgMap.length; y++)
            for (int x = 0; x < imgMap[0].length; x++) {
                Entita tile = imgMap[y][x];
                if (tile != null && tile.getImage() != null)
                    g.drawImage(tile.getImage(), x * renderSize, y * renderSize, renderSize, renderSize, null);
            }
    }

    protected abstract String getSpritesheetPath();
    protected abstract String getMapFilePath();
}
