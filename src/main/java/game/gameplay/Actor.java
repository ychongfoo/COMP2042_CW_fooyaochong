package game.gameplay;

import game.world.World;
import javafx.scene.image.ImageView;

import java.util.ArrayList;


/**
 * The parent node for all child nodes to be displayed in the {@code Scene} graph of the game.
 */
public abstract class Actor extends ImageView {

    /**
     * Moves any child node that calls this method graphically by the specified amount.
     *
     * @param dx the difference in change for the x-position measured in pixels.
     * @param dy the difference in change for the y-position measured in pixels.
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * Gets the parent node of this instance.
     *
     * @return the World object that is the parent of this instance in the scene graph.
     */
    public World getWorld() {
        return (World) getParent();
    }

    /**
     * Gets the width of the ImageView.
     *
     * @return the width of any child node calling this method.
     */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    /**
     * Gets the height of the ImageView.
     *
     * @return the height of any child node calling this method.
     */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /**
     * Gets a {@code List} of all nodes of {@code ImageView} bounds that intersect with the bounds of this instance.
     *
     * @param cls the classes used to filter the {@code List} of all intersecting nodes.
     * @param <A> The class that extends {@code Actor}.
     * @return A {@code List} of all {@code Actor} instances that intersect this instance.
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<>();
        for (A actor : getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }

    /**
     * @param now Time measured in nanosecond.
     */
    public abstract void act(long now);
}
