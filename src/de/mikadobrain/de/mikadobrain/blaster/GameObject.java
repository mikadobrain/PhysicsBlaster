package de.mikadobrain.de.mikadobrain.blaster;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mmohr on 28.01.2016.
 */
public class GameObject implements Registerable, Parentable{

    Set<GameComponent> components;
    Registerable parent;

    public GameObject() {
        components = new HashSet<GameComponent>();
    }

    public <T extends GameComponent> T getComponent(Class<T> type) {
        T returnComponent = null;
        for(GameComponent component : components) {
            if (type.isInstance(component)) {
                returnComponent = (T)component;
                break;
            }
        }
        return returnComponent;
    }

    public void addComponent(GameComponent c) {
        components.add(c);
    }

    public void onUpdate() {
        for(GameComponent component : components) {
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
