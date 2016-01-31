package de.mikadobrain.de.mikadobrain.blaster;

import java.util.List;

/**
 * Created by michael on 29.01.2016.
 */
public interface GameComponentInterface {
    GameObject getParent();
    List<Drawable> getDrawables();

    void update();
}
