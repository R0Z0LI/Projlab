package Materials;

import Collectible.Collectible;
import PropertyHandler.PropertyHandler;

/**
 * A nukleotid-ot reprezentáló osztály
 */
public class Nucleotid implements Collectible{
    /**
     * Összegyűjteti magát a paraméterként megadott propertyHandler-rel
     * @param propertyHandler           Ehhez adja hozzá magát
     */
    public void BeCollected(PropertyHandler propertyHandler){

    }

    /**
     * Kitörölteti magát a paraméterként megadott propertyHandler-ből
     * @param propertyHandler           Ebből törlődik ki
     */
    public static void BeRemoved(PropertyHandler propertyHandler){

    }
}
