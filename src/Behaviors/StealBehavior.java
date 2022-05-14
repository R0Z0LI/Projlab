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
     * Végrehajtja egy tárgy ellopását.
     *
     * @param collectible        ellopandó tárgy
     * @param affected virológus, akitől lop
     * @param propertyHandler       annak virológusnak a tárolója, aki lop
     */
    public void steal(Collectible collectible, Virologist affected, PropertyHandler propertyHandler) {
        PropertyHandler ph2 = affected.getPropertyHandler();
        collectible.beCollected(propertyHandler);
        //ha sikeresen begyűjtötte, akkor el kell venni a másiktól
        if(propertyHandler.getEquipments().contains(collectible) || propertyHandler.getAminoAcids().contains(collectible) || propertyHandler.getNucleotids().contains(collectible)){
            collectible.beRemoved(ph2);
            System.out.println("Successful steal, stolen item: "+collectible.getName());
        }
    }
}
