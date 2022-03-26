package Field;

import Collectible.GenCode;

import java.util.List;

/**
 * A laboratóriumot reprezentáló osztály
 */
public class Laboratory extends Field{
    private List<GenCode> currGenCode;

    /**
     * Hozzáadja a currGenCode-hoz a paraméterként kapott genetikai kódot
     * @param genCode           Ezt adja hozzá
     */
    public void AddGenCode(GenCode genCode){

    }

    /**
     * Elveszi a currGenCode-ból a paraméterként kapott genetikai kódot
     * @param genCode           Ezt törli ki
     */
    public void RemoveGenCode(GenCode genCode){

    }

    /**
     * currGenCode getterje
     * @return                  Visszaadja a currGenCode-ot
     */
    public List<GenCode> getGenCode(){
        return currGenCode;
    }
}
