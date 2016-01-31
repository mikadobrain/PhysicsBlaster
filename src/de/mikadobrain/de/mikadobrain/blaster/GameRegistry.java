package de.mikadobrain.de.mikadobrain.blaster;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by mmohr on 28.01.2016.
 */
public class GameRegistry implements Registerable{

    private Collection<GameObject> objects;
    private Queue<GameObject> objectsQueue;

    public GameRegistry() {
        objects = new HashSet<>();
        objectsQueue = new ArrayDeque<>();
    }

    public List<Drawable> getDrawables() {
        List<Drawable> drawables = new ArrayList<Drawable>();
        for (GameComponentInterface object : objects) {
            drawables.addAll(object.getDrawables());
        }
        return drawables;
    }

    public void update() {
        while(objectsQueue.peek() != null) {
            objects.add(objectsQueue.poll());
        }
        Iterator<GameObject> itr = objects.iterator();
        while (itr.hasNext()) {
            GameObject object = itr.next();
            if (object.isDestroyed()) {
                itr.remove();
            } else {
                object.update();
            }
        }
    }

    public void addGameObject(GameObject o) {
        objectsQueue.offer(o);
    }


    @Override
    public GameRegistry getRegistry() {
        return this;
    }
}
