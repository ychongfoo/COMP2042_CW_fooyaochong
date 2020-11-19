package game;


import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;


public abstract class World extends Pane {
    private AnimationTimer timer;

    public World() {

        sceneProperty().addListener(new ChangeListener<Scene>() {
            @Override
            public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
                if (newValue != null) {
                    newValue.setOnKeyReleased(e -> {
                        if (getOnKeyReleased() != null)
                            getOnKeyReleased().handle(e);
                        List<Actor> myActors = getObjects(Actor.class);
                        for (Actor anActor : myActors) {
                            if (anActor.getOnKeyReleased() != null) {
                                anActor.getOnKeyReleased().handle(e);
                            }
                        }
                    });

                    newValue.setOnKeyPressed(e -> {
                        if (getOnKeyPressed() != null)
                            getOnKeyPressed().handle(e);
                        List<Actor> myActors = getObjects(Actor.class);
                        for (Actor anActor : myActors) {
                            if (anActor.getOnKeyPressed() != null) {
                                anActor.getOnKeyPressed().handle(e);
                            }
                        }
                    });
                }

            }

        });
    }

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);

                for (Actor anActor : actors) {
                    anActor.act(now);
                }

            }
        };
    }

    public void start() {
        createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void add(Actor actor) {
        getChildren().add(actor);
    }

    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n : getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A) n);
            }
        }
        return someArray;
    }

    public abstract void act(long now);
}
