package hra;

import javax.swing.*;

public class Game implements Runnable {
    private GameFrame frame;
    private boolean running = true;

    public Game(GameFrame frame) {
        this.frame = frame;
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double nsPerFrame = 1_000_000_000.0 / 60.0;
        double delta = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerFrame;
            lastTime = now;

            while (delta >= 1) {
                frame.repaint();
                frame.keyUpdate();
                delta--;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        JFrame window = new JFrame("HRA");
        window.add(frame);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(true);

        new Thread(new Game(frame)).start();
    }
}