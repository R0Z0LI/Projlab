package Collectible;

import PropertyHandler.PropertyHandler;

/**
 * Összegyűjthető dolgokat reprezentáló osztály.
 */
public interface Collectible {
    /**
     * Begyűjteti az adott objektumot a megadott propertyHandler-vel
     * @param propertyHandler A begyüjtő PropertyHandler.
     */
    void beCollected(PropertyHandler propertyHandler);

    /**
     * Eltávolítatja az adott objektumot a megadott propertyHandler-vel
     * @param propertyHandler Az eltávolító PropertyHandler.
     */
    void beRemoved(PropertyHandler propertyHandler);
    String getName();
}
