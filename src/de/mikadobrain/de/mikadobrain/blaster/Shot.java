package de.mikadobrain.de.mikadobrain.blaster;

import java.awt.geom.Ellipse2D;

/**
 * Created by mmohr on 28.01.2016.
 */
public class Shot extends GameObject {

    private double speed = 1;
    private Ellipse2D shape;

    public Shot(GameObject parent, Vector location, Vector direction) {
        super(parent);
        shape = new Ellipse2D.Double(location.x+200,location.y+200,10,10);
        addComponent(new Body(this, location, direction.scale(speed), shape));
        addComponent(new Collider(this,1));
    }

    @Override
    public void update() {
        super.update();
    }


}
