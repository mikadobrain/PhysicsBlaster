package de.mikadobrain.de.mikadobrain.blaster;

/**
 * Created by michael on 29.01.2016.
 */
public class GameLoop implements Runnable{

    GameRegistry registry;
    GameCanvas panel;

    public GameLoop(GameRegistry registry, GameCanvas panel) {
        this.registry = registry;
        this.panel = panel;
    }

    public void run() {
        Player player = new Player(registry, panel);
        registry.addGameObject(player);
        while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            registry.update();
            panel.doUpdate(registry);
        }
    }
}
