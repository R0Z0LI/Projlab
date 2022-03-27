package behaviors;

import Collectible.Collectible;
import PropertyHandler.PropertyHandler;
import virologist.Virologist;

public class CollectBehavior {
    private Virologist virologist;

    public CollectBehavior(Virologist v){
        virologist=v;
    }
    public CollectBehavior(){

    }
    public void setVirologist(Virologist v){
        virologist=v;
    }

    /**+
     * Kezdeményezi egy tárgy begyűjtését.
     * @param c         a begyűjtendő tárgy
     * @param handler   egy virológus tárolója, amelybe bele kell tenni a tárgyat
     */
    public void collect(Collectible c, PropertyHandler handler){
        System.out.println("-> CollectBehavior.collect(Collectible c, PropertyHandler handler)");
        c.beCollected(handler);
    }
}
