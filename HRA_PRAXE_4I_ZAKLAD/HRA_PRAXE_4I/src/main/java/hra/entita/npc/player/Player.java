package hra.entita.npc.player;

import hra.GameFrame;
import hra.entita.npc.Npc;
import hra.entita.npc.NpcState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Objects;
import java.util.Set;

public class Player extends Npc {
    private GameFrame gameFrame;
    private int speed = 3;
    private static final Image idleImage = new ImageIcon(Objects.requireNonNull(Player.class.getResource("/Player/crow_idle.png"))).getImage();
    private static final Image walkImage = new ImageIcon(Objects.requireNonNull(Player.class.getResource("/Player/crow_walk.png"))).getImage();
    private static final Image attackImage = new ImageIcon(Objects.requireNonNull(Player.class.getResource("/Player/crow_attack.png"))).getImage();
    private static final Image dieImage = new ImageIcon(Objects.requireNonNull(Player.class.getResource("/Player/crow_death1.png"))).getImage();
    private static final Image hurtImage = new ImageIcon(Objects.requireNonNull(Player.class.getResource("/Player/crow_damage.png"))).getImage();


    public Player(int x, int y, int width, int height, Image image, int frameIndex, int frameCounter, GameFrame gameFrame) {
        super(x, y, width, height, image, frameIndex, frameCounter);
        this.gameFrame = gameFrame;
        idle(idleImage, 4);
    }

    public void keyInput() {
        if (getCurrentState() == NpcState.ATTACKING || getCurrentState() == NpcState.DIE || getCurrentState() == NpcState.HURT) {
            updateAnimation(); return;
        }
        Set<Integer> keys = gameFrame.getPressedKeyInput().getPressedKeys();
        int dx = (keys.contains(KeyEvent.VK_D) ? 1 : 0) - (keys.contains(KeyEvent.VK_A) ? 1 : 0);
        int dy = (keys.contains(KeyEvent.VK_S) ? 1 : 0) - (keys.contains(KeyEvent.VK_W) ? 1 : 0);
        if (dx < 0) setFacingLeft(true);
        else if (dx > 0) setFacingLeft(false);

        if (keys.contains(KeyEvent.VK_SPACE)) {
            attack(attackImage, 5); return;
        }

        if (dx != 0 || dy != 0) {
            double length = Math.hypot(dx, dy);
            double speed = 3.5;
            setX_d(getX_d() + (dx / length) * speed);
            setY_d(getY_d() + (dy / length) * speed);
            walk(walkImage, 4);
        } else idle(idleImage, 4);
    }

    @Override
    public void onAnimationEnd() {
        if (getCurrentState() == NpcState.ATTACKING) {
            idle(idleImage, 4);
        }
    }
}
