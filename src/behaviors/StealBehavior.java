package behaviors;

import Collectible.Collectible;
import Field.Field;
import PropertyHandler.PropertyHandler;
import virologist.Virologist;

public class StealBehavior {
    private Virologist virologist;

    public StealBehavior(Virologist v){
        virologist=v;
    }

    public StealBehavior() {

    }

    /**+
     *Végrehajtja egy tárgy ellopását.
     * @param c         ellopandó tárgy
     * @param affected  virológus, akitől lop
     * @param ph        annak virológusnak a tárolója, aki lop
     */
    public void steal(Collectible c, Virologist affected, PropertyHandler ph){
        System.out.println("-> StealBehavior.steal(Collectible c, Virologist affected, PropertyHandler ph)");
        PropertyHandler ph2 = affected.getPropertyHandler();
        if(ph2.getEquipments().contains(c)) {
            c.BeCollected(ph);
            c.BeRemoved(ph2);
        }
    }
}
