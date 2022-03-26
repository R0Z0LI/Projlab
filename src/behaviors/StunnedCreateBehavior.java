package behaviors;

import gencode.GenCode;
import virologist.Virologist;

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
        return;
    }
}
