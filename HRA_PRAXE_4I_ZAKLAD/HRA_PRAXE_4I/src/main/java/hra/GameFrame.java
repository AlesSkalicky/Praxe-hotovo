package hra;

import hra.entita.npc.enemy.Enemy;
import hra.entita.npc.player.Player;
import hra.mapa.MapaGenerator;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GameFrame extends JPanel {


    private KeyInput pressedKeyInput;
    private MouseInput mouseInput;
    private int frameWidth = 1280;
    private int frameHeight = 960;
    private int cameraX = 0;
    private int cameraY = 0;


    private MapaGenerator mapaGenerator;
    private Player player;
    private Enemy enemy;


    public GameFrame() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(frameWidth, frameHeight));


        pressedKeyInput = new KeyInput();
        mouseInput = new MouseInput();

        addKeyListener(pressedKeyInput);
        addMouseListener(mouseInput);

        setFocusable(true);
        requestFocusInWindow();


        mapaGenerator = new MapaGenerator();
        player = new Player(100,100,32,32,null,0,0,this);
        enemy = new Enemy(100,100,32,32,null,0,0,this);
    }


    public void keyUpdate(){
        player.keyInput();
        enemy.enemyAI();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int screenWidth = getWidth();
        int screenHeight = getHeight();

        cameraX = (int) ((player.getX() - screenWidth / 2.0) + 128);
        cameraY = (int) ((player.getY() - screenHeight / 2.0) + 128);

        g2d.translate(-cameraX, -cameraY);

        mapaGenerator.draw(g2d);
        player.drawObject(g2d, player.getFrameIndex(), 64, 64, 256, 256);
        enemy.drawObject(g2d, enemy.getFrameIndex(), 64, 64, 256, 256);
        g2d.dispose();
    }


    public KeyInput getPressedKeyInput() {
        return pressedKeyInput;
    }
}
