package Collectible;

import PropertyHandler.PropertyHandler;

public interface Collectible {
    void beCollected(PropertyHandler propertyHandler);

    void beRemoved(PropertyHandler propertyHandler);
}
