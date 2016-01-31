package de.mikadobrain.de.mikadobrain.blaster;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by mmohr on 28.01.2016.
 */
public abstract class GameComponent implements Parentable, GameComponentInterface{

    private GameObject parent;

    public GameComponent(GameObject parent) {
        this.parent = parent;
    }

    public GameObject getParent() {
        return parent;
    }

    public void update() {
    }

    @Override
    public List<Drawable> getDrawables() {
        List<Drawable> drawables = new ArrayList<>();
        if (this instanceof Drawable){
            drawables.add((Drawable)this);
        }
        return drawables;
    }
}
