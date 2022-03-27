package Behaviors;

import Collectible.Collectible;
import PropertyHandler.PropertyHandler;
import Virologist.Virologist;

public class StunnedCollectBehavior extends CollectBehavior{
    public StunnedCollectBehavior(Virologist v){
        super(v);
    }

    public StunnedCollectBehavior() {
        super();
    }

    /**+
     * Lebénulva a begyűjtés nem sikerül.
     * @param c         a begyűjtendő tárgy
     * @param handler   egy virológus tárolója, amelybe bele kell tenni a tárgyat
     */
    @Override
    public void collect(Collectible c, PropertyHandler handler) {
        System.out.println("-> StunnedCollectBehavior.collect((Collectible c, PropertyHandler handler)");
        System.out.println("! Lebénulva nem sikerül a begyűjtés.");
        return;
    }
}
