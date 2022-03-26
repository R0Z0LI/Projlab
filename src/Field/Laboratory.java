package Field;

import gencode.GenCode;

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
        System.out.println("-> AddGenCode(GenCode genCode)\n! Hozzáadja a currGenCode-hoz a paraméterként kapott genetikai kódot\n\n");
    }

    /**
     * Elveszi a currGenCode-ból a paraméterként kapott genetikai kódot
     * @param genCode           Ezt törli ki
     */
    public void RemoveGenCode(GenCode genCode){
        System.out.println("-> RemoveGenCode(GenCode genCode)\n! Elveszi a currGenCode-ból a paraméterként kapott genetikai kódot\n\n");
    }

    /**
     * currGenCode getterje
     * @return                  Visszaadja a currGenCode-ot
     */
    public List<GenCode> getGenCode(){
        System.out.println("-> getGenCode\n! currGenCode getterje\n<- currGenCode");
        return currGenCode;
    }
}
