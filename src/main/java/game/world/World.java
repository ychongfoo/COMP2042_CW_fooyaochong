package game.world;


import game.gameplay.Actor;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.List;


/**
 * {@code World} is the base abstract class that holds all branch nodes in the {@link Scene} of the game.
 * A World object only adds children nodes of {@link Actor} to the Scene.
 */
public abstract class World extends Pane {
    /**
     * Adds a timer to be used.
     */
    private AnimationTimer timer;

    /**
     * Instantiates a World object that listens to the changes in the {@link Node#sceneProperty()}.
     */
    public World() {

        sceneProperty().addListener((observable, oldValue, newValue) -> {
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

        });
    }

    /**
     * Instantiates an {@link AnimationTimer} to store in the private {@code timer} field.
     * The AnimationTimer acts as the timer for all children nodes of the instance and calls {@code act(long)}
     * and {@link Actor#act(long)} in every frame.
     */
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


    /**
     * Calls {@code createTimer()} method and {@link AnimationTimer#start()} and starts the Animations.
     */
    public void start() {
        createTimer();
        timer.start();
    }

    /**
     * Stops all Animations by using {@link AnimationTimer#stop()}.
     */
    public void stop() {
        timer.stop();
    }

    /**
     * Adds an Actor instance as a child node to the Scene.
     *
     * @see Actor
     * @param actor An Actor instance such as {@code Log, Car, Truck, Turtle, etc.} to be displayed.
     */
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    /**
     * Removes an Actor instance from the Scene.
     *
     * @see Actor
     * @param actor An Actor instance such as {@code Log, Car, Truck, Turtle, etc.} to be displayed.
     */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    /**
     * Gets the list of all child nodes attached to the root node filtered by class.
     *
     * @param cls Class used to filter the list of all child nodes.
     * @param <A> A class that must be the subclass of {@code Actor}.
     * @return An ArrayList of all child nodes that are attached to the root node.
     */
    @SuppressWarnings("unchecked")
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<>();
        for (Node n : getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A) n);
            }
        }
        return someArray;
    }
    /**
     * Abstract method to be implemented by subclasses. Called every frame in {@link AnimationTimer#handle(long)}
     * by the timer instance stored in this instance of World.
     * @param now Time in nanoseconds. Passed as argument from AnimationTimer.handle().
     */
    public abstract void act(long now);
}
