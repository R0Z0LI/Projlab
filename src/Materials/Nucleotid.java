package Materials;

import PropertyHandler.PropertyHandler;

/**
 * A nukleotid-ot reprezentáló osztály
 */
public class Nucleotid {
    /**
     * Összegyűjteti magát a paraméterként megadott propertyHandler-rel
     * @param propertyHandler           Ehhez adja hozzá magát
     */
    public void BeCollected(PropertyHandler propertyHandler){
        System.out.println("-> BeCollected(PropertyHandler propertyHandler)\n! Összegyűjteti magát a paraméterként megadott propertyHandler-rel\n\n");
    }

    /**
     * Kitörölteti magát a paraméterként megadott propertyHandler-ből
     * @param propertyHandler           Ebből törlődik ki
     */
    public static void BeRemoved(PropertyHandler propertyHandler){
        System.out.println("-> BeRemoved(PropertyHandler propertyHandler)\n! Kitörölteti magát a paraméterként megadott propertyHandler-ből\n\n");
    }
}
