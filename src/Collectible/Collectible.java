package Collectible;

import PropertyHandler.PropertyHandler;

public interface Collectible {
    void BeCollected(PropertyHandler propertyHandler);

    void BeRemoved(PropertyHandler propertyHandler);
}
