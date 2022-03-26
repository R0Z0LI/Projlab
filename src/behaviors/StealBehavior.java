package behaviors;

import PropertyHandler.PropertyHandler;
import virologist.Virologist;

public class StealBehavior {
    private Virologist virologist;

    public StealBehavior(Virologist v){
        virologist=v;
    }

    /**+
     *Végrehajtja egy tárgy ellopását.
     * @param c         ellopandó tárgy
     * @param affected  virológus, akitől lop
     * @param ph        annak virológusnak a tárolója, aki lop
     */
    public void Steal(Collectible c, Virologist affected, PropertyHandler ph){
        PropertyHandler ph2 = affected.GetPropertyHandler();
        if(c.BeCollected(ph))
            c.BeRemoved(ph2);
    }
}
