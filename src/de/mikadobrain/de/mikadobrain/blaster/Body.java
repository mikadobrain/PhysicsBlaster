package de.mikadobrain.de.mikadobrain.blaster;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.javafx.geom.Vec2d;

import java.awt.*;

/**
 * Created by mmohr on 28.01.2016.
 */
public class Body extends GameComponent implements Drawable{

    private Vector impulse;
    private Vector location;
    private Shape shape;
    private Color color = Color.RED;

    public Body(GameObject parent, Vector location, Vector impulse, Shape shape) {
        super(parent);
        this.location = location;
        this.impulse = impulse;
        this.shape = shape;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void addImpulse(Vector i) {
        impulse.add(i);
    }

    public Vector getImpulse() {
        return impulse;
    }

    public Vector getLocation() {
        return location;
    }

    @Override
    public void update() {
        location.add(impulse);
    }

    Shape getShape() {
        return shape;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fill(this.getShape());
    }
}
