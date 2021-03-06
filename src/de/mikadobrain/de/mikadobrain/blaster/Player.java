package de.mikadobrain.de.mikadobrain.blaster;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by michael on 29.01.2016.
 */
public class Player extends GameObject{

    public Player(Registerable parent, GamePanel panel) {
        super(parent);
        Body body = new RectangularBody(this, new Vector(0f,0f), new Vector(0f, 0f), new Rectangle2D.Double(0,0,30,30));
        body.setColor(Color.BLUE);
        addComponent(body);
        Controller controller = new Controller(this, panel);
        addComponent(controller);

        panel.addMouseListener(controller);
    }


}
