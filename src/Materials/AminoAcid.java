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
    public void beCollected(PropertyHandler propertyHandler){
        System.out.println("-> BeCollected(PropertyHandler propertyHandler)\n! Összegyűjteti magát a paraméterként megadott propertyHandler-rel\n\n");
        propertyHandler.addAmino(this);
    }

    /**
     * Kitörölteti magát a paraméterként megadott propertyHandler-ből
     * @param propertyHandler           Ebből törlődik ki
     */
    @Override
    public void beRemoved(PropertyHandler propertyHandler){
        System.out.println("-> BeRemoved(PropertyHandler propertyHandler)\n! Kitörölteti magát a paraméterként megadott propertyHandler-ből\n\n");
        propertyHandler.removeAmino(this);
    }
}
