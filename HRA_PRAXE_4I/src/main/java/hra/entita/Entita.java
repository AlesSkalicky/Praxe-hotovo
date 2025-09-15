package hra.entita;

import java.awt.*;

public class Entita {
    private double x;
    private double y;
    private int width;
    private int height;
    private Image image;

    public Entita(int x, int y, int width, int height, Image image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public void draw(Graphics g){
        g.drawImage(image, getX(), getY(), width, height, null);
    }

    public void drawObject(Graphics g, int frameIndex, int spriteWidth, int spriteHeight, int drawWidth, int drawHeight) {

    }

    public int getDistance(Entita entita) {
        double dx = getCenterX() - entita.getCenterX();
        double dy = getCenterY() - entita.getCenterY();
        return (int) Math.round(Math.hypot(dx, dy));
    }

    public double getCenterX() {
        return x + width / 2.0;
    }

    public double getCenterY() {
        return y + height / 2.0;
    }

    public Image getImage() {
        return image;
    }


    public double getX_d() {
        return x;
    }

    public void setX_d(double x_d) {
        this.x = x_d;
    }

    public double getY_d() {
        return y;
    }

    public void setY_d(double y_d) {
        this.y = y_d;
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }


    public void setImage(Image image) {
        this.image = image;
    }
}
