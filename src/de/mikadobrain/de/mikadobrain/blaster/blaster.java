package de.mikadobrain.de.mikadobrain.blaster;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mmohr on 28.01.2016.
 */
public class Blaster extends JFrame{

    JPanel panel;
    GamePanel canvas;
    Dimension size = new Dimension(640,480);

    public static void main(String[] args)  {
        Blaster blaster = new Blaster();
        blaster.play();
    }

    public Blaster() {
        setSize(size);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void play() {
        GameRegistry registry = new GameRegistry();
        canvas = new GamePanel(registry);
        canvas.setSize(size);
        add(canvas);
        GameLoop loop = new GameLoop(registry, canvas);
        loop.run();
    }
}
