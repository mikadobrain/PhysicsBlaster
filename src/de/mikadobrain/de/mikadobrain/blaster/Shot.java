package de.mikadobrain.de.mikadobrain.blaster;

import java.awt.geom.Ellipse2D;

/**
 * Created by mmohr on 28.01.2016.
 */
public class Shot extends GameObject {

    private double speed = 10;
    private Ellipse2D shape;

    public Shot(GameObject parent, Vector location, Vector direction) {
        super(parent);
        shape = new Ellipse2D.Double(location.x,location.y,10,10);
        addComponent(new EllipticBody(this, new Vector(location), direction.scale(speed), shape));
        addComponent(new Collider(this,1));
    }

    @Override
    public void update() {
        super.update();
    }


}
