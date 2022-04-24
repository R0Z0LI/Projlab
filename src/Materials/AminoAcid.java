package Materials;

import Collectible.Collectible;
import Field.Warehouse;
import PropertyHandler.PropertyHandler;
import TestSets.TestInOutHandler;

/**
 * Az aminósavat reprezentáló osztály
 */
public class AminoAcid implements Collectible {
    private String name;
    private static int id = 0;
    private Warehouse currPosition;

    /**
     * Aminoacid constructor
     * @param field This the field (warehouse), that the Aminoacid is on.
     */
    public AminoAcid(Warehouse field){
        this.name = "aac" + id++;
        this.currPosition = field;
    }

    /**
     * Aminoacid constructor without any parameters.
     * Should be used when adding to the inventory directly.
     */
    public AminoAcid(){
        this.name = "aac" + id++;
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
        // adding this to Virologist
        propertyHandler.add(this);
        // only collect, if there is enough space in inventory
        if (propertyHandler.getAminoAcids().size() + propertyHandler.getNucleotids().size() < propertyHandler.getMaxMaterial()) {
            // removing it from the warehouse
            currPosition.remove(this);
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
