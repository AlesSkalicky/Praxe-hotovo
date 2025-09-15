package hra;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

    private boolean isPressed = false;
    private int pressedButton = -1;
    private int mouseX = 0;
    private int mouseY = 0;



    @Override
    public void mousePressed(MouseEvent e) {
        isPressed = true;
        pressedButton = e.getButton();
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isPressed = false;
        pressedButton = -1;
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }


    public boolean isPressed() {
        return isPressed;
    }

    public int getPressedButton() {
        return pressedButton;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }


}

