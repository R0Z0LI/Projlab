package Materials;

import Collectible.Collectible;
import Field.Warehouse;
import PropertyHandler.PropertyHandler;
import TestSets.TestInOutHandler;

/**
 * A nukleotid-ot reprezentáló osztály
 */
public class Nucleotid implements Collectible {
    private static int id = 0;
    private String name;
    private Warehouse currPosition;

    /**
     * Nucleotid constructor
     * @param field This the field (warehouse), that the nucleotid is on.
     */
    public Nucleotid(Warehouse field) {
        this.name = "ncd" + id++;
        this.currPosition = field;
    }
    /**
     * Nucleotid constructor without any parameters.
     * Should be used when adding to the inventory directly.
     */
    public Nucleotid() {
        this.name = "ncd" + id++;
        this.currPosition = null;
    }

    // gets name/id of this object
    public String getName() {
        return name;
    }
    /**
     * Összegyűjteti magát a paraméterként megadott propertyHandler-rel
     *
     * @param propertyHandler Ehhez adja hozzá magát
     */
    @Override
    public void beCollected(PropertyHandler propertyHandler) {
        // only collect, if there is enough space in inventory
        if (propertyHandler.getAminoAcids().size() + propertyHandler.getNucleotids().size() < propertyHandler.getMaxMaterial()) {
            // adding this to Virologist
            propertyHandler.add(this);
            System.out.println("Successful collect: "+ this.getName()+" collected by "+this.getName()+".");
            TestInOutHandler.appendToTestOutput("Successful collect: "+ this.getName()+" collected by "+this.getName()+".\n");

            // removing it from the warehouse
            currPosition.remove(this);
        } else {
            System.out.println("There is not enough space in your inventory for "+this.getName());
            TestInOutHandler.appendToTestOutput("There is not enough space in your inventory for " + this.name);
        }
    }

    /**
     * Kitörölteti magát a paraméterként megadott propertyHandler-ből
     *
     * @param propertyHandler Ebből törlődik ki
     */
    @Override
    public void beRemoved(PropertyHandler propertyHandler) {
        propertyHandler.remove(this);
    }
}
