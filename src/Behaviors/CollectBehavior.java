package Behaviors;

import Collectible.Collectible;
import PropertyHandler.PropertyHandler;
import Virologist.Virologist;

public class CollectBehavior {
    private Virologist virologist;

    public CollectBehavior(Virologist v) {
        virologist = v;
    }

    public CollectBehavior() {
    }

    public void setVirologist(Virologist v) {
        virologist = v;
    }

    public Virologist getVirologist() {
        return virologist;
    }

    /**
     * +
     * Kezdeményezi egy tárgy begyűjtését.
     *
     * @param collectible a begyűjtendő tárgy
     * @param handler     egy virológus tárolója, amelybe bele kell tenni a tárgyat
     */
    public void collect(Collectible collectible, PropertyHandler handler) {
        collectible.beCollected(handler);
    }
}
