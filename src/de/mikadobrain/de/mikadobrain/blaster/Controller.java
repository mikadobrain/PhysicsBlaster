package de.mikadobrain.de.mikadobrain.blaster;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mmohr on 28.01.2016.
 */
public class Controller extends GameComponent implements MouseListener {

    private GameCanvas panel;
    private List<Point> lastClickedPoints;

    public Controller(GameObject parent, GameCanvas panel) {
        super(parent);
        this.panel = panel;
        lastClickedPoints = new ArrayList<>();
    }

    public void update() {
        GameRegistry reg = getParent().getRegistry();

        Vector location = getParent().getComponent(Body.class).getLocation();

        for(Point p : lastClickedPoints) {

            Vector shootingDirection = new Vector(p).normalize();
            GameObject o = new Shot(getParent(), location, shootingDirection);
            reg.addGameObject(o);
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
