package de.mikadobrain.de.mikadobrain.blaster;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

/**
 * Created by mmohr on 28.01.2016.
 */
public class GamePanel extends JPanel {

    List<Drawable> drawables = new ArrayList<>();
    GameRegistry registry;

    public GamePanel(GameRegistry registry){
        this.registry = registry;
        setDoubleBuffered(true);
    }

    public void doUpdate(GameRegistry registry){
        drawables.clear();
        Graphics2D g2d = (Graphics2D)getGraphics();
        for(Drawable drawable : registry.getDrawables()) {
            drawables.add(drawable);
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(getX(), getY(), getWidth(), getHeight());
        for(Drawable drawable : drawables) {
            drawable.draw(g2d);
        }
    }

}
