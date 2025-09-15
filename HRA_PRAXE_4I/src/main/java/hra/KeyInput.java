package hra;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class KeyInput implements KeyListener {
    private final Set<Integer> pressedKeys = new HashSet<>();

    @Override public void keyPressed(KeyEvent e) {
        pressedKeys.add(e.getKeyCode());}

    @Override public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());}

    @Override public void keyTyped(KeyEvent e) {

    }
    public Set<Integer> getPressedKeys() {
        return pressedKeys;
    }
}
