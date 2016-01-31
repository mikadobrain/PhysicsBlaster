package de.mikadobrain.de.mikadobrain.blaster;

import java.util.*;

/**
 * Created by mmohr on 28.01.2016.
 */
public class GameObject implements Registerable, Parentable, GameComponentInterface{

    Set<GameComponentInterface> components;
    Queue<GameComponentInterface> componentsQueue;
    Registerable parent;
    boolean destroyed = false;

    public GameObject(Registerable parent) {

        this.parent = parent;
        components = new HashSet<>();
        componentsQueue = new ArrayDeque<>();
    }

    public List<Drawable> getDrawables() {
        List<Drawable> drawables = new ArrayList<>();
        for (GameComponentInterface component : components) {
            if(component instanceof Drawable) {
                drawables.add((Drawable)component);
            }else{
                drawables.addAll(component.getDrawables());
            }
        }
        return drawables;
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

    public void destroy() {
        destroyed = true;
    }

    public boolean isDestroyed(){
        return destroyed;
    }

    public void addComponent(GameComponentInterface c) {
        componentsQueue.offer(c);
    }

    public void update() {
        while (componentsQueue.peek() != null) {
            components.add(componentsQueue.poll());
        }
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
