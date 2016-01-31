package de.mikadobrain.de.mikadobrain.blaster;

import java.awt.*;

/**
 * Created by mmohr on 28.01.2016.
 */
public class Vector {
    double x;
    double y;

    public Vector(double x, double y) {
        this.x=x;
        this.y=y;
    }

    public Vector(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public Vector(Vector v) {
        this.x = v.x;
        this.y = v.y;
    }

    Vector add(Vector v) {
        return new Vector(x+v.x, y+v.y);
    }

    double scalarProduct() {
        return (x*x + y*y);
    }

    double getLength() {
        return Math.abs(Math.sqrt(scalarProduct()));
    }

    Vector normalize() {
        double length = getLength();
        return new Vector(x / length, y / length);
    }

    Vector scale(double s) {
        return new Vector(x*s, y*s);
    }


}
