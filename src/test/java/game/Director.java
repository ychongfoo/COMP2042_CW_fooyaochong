package game;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class Director {
    private HashMap<String, Pane> sceneController = new HashMap<>();
    private Scene scene;

    public Director(Scene scene){
        this.scene = scene;
    }

    protected void nextScene(String name, Pane pane){
        sceneController.put(name,pane);
    }

    protected void cutPreviousScene(String name){
        sceneController.remove(name);
    }

    protected void activeScene(String name){
        scene.setRoot(sceneController.get(name));
    }
}
