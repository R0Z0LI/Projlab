package Behaviors;

import Gencode.GenCode;
import Virologist.Virologist;

public class StunnedCreateBehavior extends CreateBehavior{
    public StunnedCreateBehavior(Virologist v){
        super(v);
    }

    public StunnedCreateBehavior() {
        super();
    }
    /**+
     * Lebénulva az ágens előállítása nem sikerül.
     * @param code  genetikai kód, amelyből az ágenst elő kell állítani.
     */
    @Override
    public void create(GenCode code) {
        System.out.println("-> StunnedCreateBehavior.create(GenCode code)");
        System.out.println("! Lebénulva az ágens előállítása nem sikerül.");
        return;
    }
}
