package Collectible;

import PropertyHandler.PropertyHandler;

public interface Collectible {
    public void BeCollected(PropertyHandler propertyHandler);

    public void BeRemoved(PropertyHandler propertyHandler);
}
