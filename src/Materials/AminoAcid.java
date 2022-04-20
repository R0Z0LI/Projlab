package Materials;

import Collectible.Collectible;
import Field.Field;
import PropertyHandler.PropertyHandler;

/**
 * Az aminósavat reprezentáló osztály
 */
public class AminoAcid implements Collectible {
    private String name;
    private static int id = 0;
    private Field field;

    public AminoAcid(Field field){
        this.name = "aac" + id++;
        this.field = field;
    }
    /**
     * Összegyűjteti magát a paraméterként megadott propertyHandler-rel
     *
     * @param propertyHandler Ehhez adja hozzá magát
     */
    @Override
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
    @Override
    public void beRemoved(PropertyHandler propertyHandler) {
        System.out.println("-> BeRemoved(PropertyHandler propertyHandler)\n! Kitorolteti magat a paraméterként megadott propertyHandler-bol\n\n");
        propertyHandler.remove(this);
    }

    public String getName() {
        return this.name;
    }
}
