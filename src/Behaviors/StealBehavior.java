package Behaviors;

import Collectible.Collectible;
import PropertyHandler.PropertyHandler;
import Virologist.Virologist;

public class StealBehavior {
    private Virologist virologist;

    public StealBehavior(Virologist v) {
        virologist = v;
    }

    public StealBehavior() {
    }

    public void setVirologist(Virologist v) {
        virologist = v;
    }

    public Virologist getVirologist() {
        return virologist;
    }

    /**
     * +
     * Végrehajtja egy tárgy ellopását.
     *
     * @param collectible        ellopandó tárgy
     * @param affected virológus, akitől lop
     * @param propertyHandler       annak virológusnak a tárolója, aki lop
     */
    public void steal(Collectible collectible, Virologist affected, PropertyHandler propertyHandler) {
        System.out.println("-> StealBehavior.steal(Collectible collectible, Virologist affected, PropertyHandler propertyHandler)");
        PropertyHandler ph2 = affected.getPropertyHandler();
        if (ph2.getEquipments().contains(collectible) || ph2.getAminoAcids().contains(collectible) || ph2.getNucleotids().contains(collectible)) {
            collectible.beCollected(propertyHandler);
            collectible.beRemoved(ph2);
        }
    }
}
