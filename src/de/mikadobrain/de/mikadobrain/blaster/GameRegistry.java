package de.mikadobrain.de.mikadobrain.blaster;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by mmohr on 28.01.2016.
 */
public class GameRegistry implements Registerable{

    private volatile Collection<GameObject> objects;
    private Queue<GameObject> objectsQueue;

    public GameRegistry() {
        objects = new HashSet<>();
        objectsQueue = new ArrayDeque<>();
    }

    public List<Drawable> getDrawables() {
        List<Drawable> drawables = new ArrayList<Drawable>();
        for (GameObject object : objects) {
            Drawable drawable = object.getComponent(Body.class);
            if (drawable != null) {
                drawables.add(drawable);
            }
        }
        return drawables;
    }

    public void update() {

        for(GameObject object : objects) {
            object.update();
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
