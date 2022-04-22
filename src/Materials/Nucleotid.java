package Materials;

import Collectible.Collectible;
import Field.Warehouse;
import PropertyHandler.PropertyHandler;

/**
 * A nukleotid-ot reprezentáló osztály
 */
public class Nucleotid implements Collectible {
    private static int id = 0;
    private String name;
    private Warehouse field;

    /**
     * Nucleotid constructor
     * @param field This the field (warehouse), that the nucleotid is on.
     */
    public Nucleotid(Warehouse field) {
        this.name = "ncd" + id++;
        this.field = field;
    }
    /**
     * Nucleotid constructor without any parameters.
     * Should be used when adding to the inventory directly.
     */
    public Nucleotid() {
        this.name = "ncd" + id++;
        this.field = null;
    }

    // gets name/id of this object
    @Override
    public String toString() {
        return name;
    }
    public String getName(){return name;}
    /**
     * Összegyűjteti magát a paraméterként megadott propertyHandler-rel
     *
     * @param propertyHandler Ehhez adja hozzá magát
     */
    public void beCollected(PropertyHandler propertyHandler) {
        if (propertyHandler.getEquipments().size() < propertyHandler.getMaxMaterial()) {
            System.out.println("-> BeCollected(PropertyHandler propertyHandler)\n! osszegyujteti magat a paraméterként megadott propertyHandler-rel\n\n");
            propertyHandler.add(this);
        }
    }

    /**
     * Kitörölteti magát a paraméterként megadott propertyHandler-ből
     *
     * @param propertyHandler Ebből törlődik ki
     */
    public void beRemoved(PropertyHandler propertyHandler) {
        System.out.println("-> BeRemoved(PropertyHandler propertyHandler)\n! Kitorolteti magat a paraméterként megadott propertyHandler-bol\n\n");
        propertyHandler.remove(this);
    }
}
