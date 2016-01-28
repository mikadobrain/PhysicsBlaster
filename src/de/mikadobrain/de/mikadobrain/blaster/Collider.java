package de.mikadobrain.de.mikadobrain.blaster;

import javafx.scene.shape.Circle;

import java.awt.*;
import java.util.Collection;

/**
 * Created by mmohr on 28.01.2016.
 */
public class Collider extends GameComponent {

    private Circle shape;

    public Collider (GameObject parent, int r) {
        super(parent);
        this.shape = new Circle(r);
    }

    public void collideWith(Collider c) {
        GameObject other = c.getParent();
        Body otherBody = other.getComponent(Body.class);

        Body thisBody = getParent().getComponent(Body.class);

        otherBody.addImpulse(thisBody.getImpulse());
    }

}
