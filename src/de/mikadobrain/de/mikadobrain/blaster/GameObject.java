package de.mikadobrain.de.mikadobrain.blaster;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mmohr on 28.01.2016.
 */
public class GameObject implements Registerable, Parentable, GameComponentInterface{

    Set<GameComponentInterface> components;
    Registerable parent;

    public GameObject(Registerable parent) {

        this.parent = parent;
        components = new HashSet<GameComponentInterface>();
    }

    public <T extends GameComponent> T getComponent(Class<T> type) {
        T returnComponent = null;
        for(GameComponentInterface component : components) {
            if (type.isInstance(component)) {
                returnComponent = (T)component;
                break;
            }
        }
        return returnComponent;
    }

    public void addComponent(GameComponentInterface c) {
        components.add(c);
    }

    public void update() {
        for(GameComponentInterface component : components) {
            component.update();
        }
    }

    @Override
    public GameRegistry getRegistry() {
        return parent.getRegistry();
    }

    @Override
    public GameObject getParent() {
        return (parent instanceof GameObject)
                ? (GameObject)parent
                : null;
    }
}
