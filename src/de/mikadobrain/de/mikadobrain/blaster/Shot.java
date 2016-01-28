package de.mikadobrain.de.mikadobrain.blaster;

import java.awt.geom.Ellipse2D;

/**
 * Created by mmohr on 28.01.2016.
 */
public class Shot extends GameObject {

    private double speed = 10;
    private Ellipse2D shape = new Ellipse2D.Double(0,0,1,1);

    public Shot(GameObject parent, Vector location, Vector direction) {

        this.parent = parent;
        addComponent(new Body(this, location, direction.scale(speed), shape));
        addComponent(new Collider(this,1));
    }
}
