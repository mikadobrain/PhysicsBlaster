package de.mikadobrain.de.mikadobrain.blaster;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by michael on 31.01.2016.
 */
public class RectangularBody extends Body<Rectangle2D> {

    public RectangularBody(GameObject parent, Vector location, Vector impulse, Rectangle2D shape) {
        super(parent, location, impulse, shape);
    }

    @Override
    public void update() {
        location = location.add(impulse);
        shape.setFrame(shape.getX()+impulse.x, shape.getY()+impulse.y, shape.getWidth(), shape.getHeight());
    }
}
