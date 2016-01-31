package de.mikadobrain.de.mikadobrain.blaster;

import java.awt.geom.Ellipse2D;

/**
 * Created by michael on 31.01.2016.
 */
public class EllipticBody extends Body<Ellipse2D> {

    public EllipticBody(GameObject parent, Vector location, Vector impulse, Ellipse2D shape) {
        super(parent, location, impulse, shape);
    }

    @Override
    public void update() {
        location = location.add(impulse);
        shape.setFrame(shape.getX()+impulse.x, shape.getY()+impulse.y, shape.getWidth(), shape.getHeight());
    }
}
