package de.mikadobrain.de.mikadobrain.blaster;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

/**
 * Created by mmohr on 28.01.2016.
 */
public class Controller extends GameComponent implements MouseListener {

    private GamePanel panel;
    private Queue<Point> lastClickedPoints;

    public Controller(GameObject parent, GamePanel panel) {
        super(parent);
        this.panel = panel;
        lastClickedPoints = new ArrayDeque<>();
    }

    public void update() {
        GameRegistry reg = getParent().getRegistry();
        Vector location = getParent().getComponent(Body.class).getLocation();

        while(lastClickedPoints.peek() != null) {

            Vector shootingDirection = new Vector(lastClickedPoints.poll()).normalize();
            GameObject o = new Shot(getParent(), location, shootingDirection);
            reg.addGameObject(o);
            getParent().addComponent(o);
        }
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        if (panel.contains(p)) {
            lastClickedPoints.add(p);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
