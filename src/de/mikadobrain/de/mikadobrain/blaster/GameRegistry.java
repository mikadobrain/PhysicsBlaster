package de.mikadobrain.de.mikadobrain.blaster;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by mmohr on 28.01.2016.
 */
public class GameRegistry implements Registerable{

    private Collection<GameObject> objects;

    public GameRegistry() {
        objects = new HashSet<GameObject>();
    }

    public List<Shape> getShapes() {
        List<Shape> shapes = new ArrayList<Shape>();
        for (GameObject object : objects) {
            shapes.add(object.getComponent(Body.class).getShape());
        }
        return shapes;
    }

    public void update() {
        for(GameObject object : objects) {

        }
    }

    public void addGameObject(GameObject o) {
        objects.add(o);
    }


    @Override
    public GameRegistry getRegistry() {
        return this;
    }
}
