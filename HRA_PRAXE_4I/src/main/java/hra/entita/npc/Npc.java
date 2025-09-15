package hra.entita.npc;

import hra.entita.Entita;

import java.awt.*;

public class Npc extends Entita {

    private NpcState currentState;
    private int frameIndex, frameCounter, totalFrames;
    private boolean facingLeft;
    private boolean hurt;

    private int animationSpeed = 10;
    private int tick;

    public Npc(int x, int y, int width, int height, Image image, int frameIndex, int frameCounter) {
        super(x, y, width, height, image);
        this.frameIndex = frameIndex;
        this.frameCounter = frameCounter;
        this.facingLeft = true;
        this.hurt = false;
    }

    public void idle(Image image, int frames) {
        changeState(NpcState.IDLE, image, frames);
    }

    public void walk(Image image, int frames) {
        changeState(NpcState.WALKING, image, frames);
    }

    public void attack(Image image, int frames) {
        changeState(NpcState.ATTACKING, image, frames);
    }

    public void die(Image image, int frames) {
    }

    public void hurt(Image image, int frames) {
    }

    private void changeState(NpcState state, Image image, int frames) {
        if (!(this.currentState == state)) {
            setImage(image);
            totalFrames = frames;
            frameIndex = frameCounter = 0;
            currentState = state;
        }
        updateAnimation();
    }

    public void updateAnimation() {
        tick++;
        if (tick >= animationSpeed) {
            tick = 0;
            frameIndex++;

            if (frameIndex >= totalFrames) {
                frameIndex = 0;
                onAnimationEnd();
            }
        }
    }

    public void onAnimationEnd() {

    }

    @Override
    public void drawObject(Graphics g, int frameIndex, int sw, int sh, int dw, int dh) {
        int cols = getImage().getWidth(null) / sw;
        int sx = (frameIndex % cols) * sw, sy = (frameIndex / cols) * sh;
        int dx = getX(), dy = getY();
        Graphics2D g2 = (Graphics2D) g.create();
        if (isFacingLeft())
            g2.drawImage(getImage(), dx + dw, dy, dx, dy + dh, sx, sy, sx + sw, sy + sh, null);
        else
            g2.drawImage(getImage(), dx, dy, dx + dw, dy + dh, sx, sy, sx + sw, sy + sh, null);
        g2.dispose();
    }

    public boolean isFacingLeft() {
        return facingLeft;
    }

    public NpcState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(NpcState currentState) {
        this.currentState = currentState;
    }

    public int getFrameIndex() {
        return frameIndex;
    }

    public void setFrameIndex(int frameIndex) {
        this.frameIndex = frameIndex;
    }

    public int getFrameCounter() {
        return frameCounter;
    }

    public void setFrameCounter(int frameCounter) {
        this.frameCounter = frameCounter;
    }

    public int getTotalFrames() {
        return totalFrames;
    }

    public void setTotalFrames(int totalFrames) {
        this.totalFrames = totalFrames;
    }

    public void setFacingLeft(boolean facingLeft) {
        this.facingLeft = facingLeft;
    }

    public boolean isHurt() {
        return hurt;
    }

    public void setHurt(boolean hurt) {
        this.hurt = hurt;
    }

    public int getAnimationSpeed() {
        return animationSpeed;
    }

    public void setAnimationSpeed(int animationSpeed) {
        this.animationSpeed = animationSpeed;
    }

    public int getTick() {
        return tick;
    }

    public void setTick(int tick) {
        this.tick = tick;
    }
}
