package Materials;

import Collectible.Collectible;
import PropertyHandler.PropertyHandler;

/**
 * Az aminósavat reprezentáló osztály
 */
public class AminoAcid implements Collectible {
    /**
     * Összegyűjteti magát a paraméterként megadott propertyHandler-rel
     * @param propertyHandler           Ehhez adja hozzá magát
     */
    @Override
    public void BeCollected(PropertyHandler propertyHandler){

    }

    /**
     * Kitörölteti magát a paraméterként megadott propertyHandler-ből
     * @param propertyHandler           Ebből törlődik ki
     */
    @Override
    public void BeRemoved(PropertyHandler propertyHandler){

    }
}
