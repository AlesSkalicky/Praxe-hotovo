package hra.entita.npc.enemy;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import hra.GameFrame;
import hra.entita.npc.Npc;
import hra.entita.npc.NpcState;

public class Enemy extends Npc {
    private GameFrame gameFrame;
    private static final Image idleImage = new ImageIcon(Objects.requireNonNull(Enemy.class.getResource("/Enemy/enemy_idle.png"))).getImage();
    private static final Image walkImage = new ImageIcon(Objects.requireNonNull(Enemy.class.getResource("/Enemy/enemy_walk.png"))).getImage();
    private static final Image attackImage = new ImageIcon(Objects.requireNonNull(Enemy.class.getResource("/Enemy/enemy_attack.png"))).getImage();
    private static final Image dieImage = new ImageIcon(Objects.requireNonNull(Enemy.class.getResource("/Enemy/enemy_die.png"))).getImage();

    public Enemy(int x, int y, int width, int height, Image image, int frameIndex, int frameCounter, GameFrame gameFrame) {
        super(x, y, width, height, image, frameIndex, frameCounter);
        this.gameFrame = gameFrame;
        idle(idleImage, 4);
    }

    public void enemyAI(){
        if (getCurrentState() == NpcState.ATTACKING ) {
            updateAnimation();
            return;
        }

        idle(idleImage, 6);
    }

    @Override
    public void onAnimationEnd() {
        if (getCurrentState() == NpcState.ATTACKING) {
            idle(idleImage, 4);
        }
    }
}
