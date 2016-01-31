package de.mikadobrain.de.mikadobrain.blaster;

/**
 * Created by michael on 29.01.2016.
 */
public class GameLoop implements Runnable{

    GameRegistry registry;
    GamePanel panel;

    public GameLoop(GameRegistry registry, GamePanel panel) {
        this.registry = registry;
        this.panel = panel;
    }

    public void run() {
        Player player = new Player(registry, panel);
        registry.addGameObject(player);
        while(true) {

            registry.update();
            panel.doUpdate(registry);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
