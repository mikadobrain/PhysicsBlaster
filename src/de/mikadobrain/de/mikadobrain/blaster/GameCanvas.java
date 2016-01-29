package de.mikadobrain.de.mikadobrain.blaster;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by mmohr on 28.01.2016.
 */
public class GameCanvas extends JPanel {

    Set<Drawable> drawables = new HashSet<>();
    GameRegistry registry;

    public GameCanvas(GameRegistry registry){
        this.registry = registry;
    }

    public void doUpdate(GameRegistry registry){
        for(Drawable drawable : registry.getDrawables()) {
            drawables.add(drawable);
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        for(Drawable drawable : drawables) {
            drawable.draw(g2d);
        }
    }

}
