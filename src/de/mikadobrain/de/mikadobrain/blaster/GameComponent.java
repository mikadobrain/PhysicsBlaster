package de.mikadobrain.de.mikadobrain.blaster;

import java.awt.*;

/**
 * Created by mmohr on 28.01.2016.
 */
public abstract class GameComponent implements Parentable{

    private GameObject parent;

    public GameComponent(GameObject parent) {
        this.parent = parent;
    }

    public GameObject getParent() {
        return parent;
    }

    void update() {

    }

}
