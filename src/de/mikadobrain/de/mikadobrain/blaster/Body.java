package de.mikadobrain.de.mikadobrain.blaster;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.javafx.geom.Vec2d;

import java.awt.*;

/**
 * Created by mmohr on 28.01.2016.
 */
public abstract class Body<T extends Shape> extends GameComponent implements Drawable {

    protected Vector impulse;
    protected Vector location;
    protected T shape;
    protected Color color = Color.RED;

    public Body(GameObject parent, Vector location, Vector impulse, T shape) {
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
        return new Vector(location);
    }

    @Override
    public abstract void update();

    T getShape() {
        return shape;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fill(this.getShape());
    }
}
