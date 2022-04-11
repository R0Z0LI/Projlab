package Field;

import Gencode.GenCode;

import java.util.ArrayList;
import java.util.List;

/**
 * A laboratóriumot reprezentáló osztály
 */
public class Laboratory extends Field {
    private List<GenCode> genCodes = new ArrayList<>();

    public Laboratory() {

    }

    /**
     * Hozzáadja a currGenCode-hoz a paraméterként kapott genetikai kódot
     *
     * @param genCode Ezt adja hozzá
     */
    public void add(GenCode genCode) {
        System.out.println("-> AddGenCode(GenCode genCode)\n! Hozzaadja a currGenCode-hoz a parameterkent kapott genetikai kodot\n\n");
        genCodes.add(genCode);
    }

    /**
     * Elveszi a currGenCode-ból a paraméterként kapott genetikai kódot
     *
     * @param genCode Ezt törli ki
     */
    public void remove(GenCode genCode) {
        System.out.println("-> RemoveGenCode(GenCode genCode)\n! Elveszi a currGenCode-bol a parameterkent kapott genetikai kodot\n\n");
    }

    /**
     * currGenCode getterje
     *
     * @return Visszaadja a currGenCode-ot
     */
    public List<GenCode> getGenCode() {
        System.out.println("-> getGenCode\n! currGenCode getterje\n<- currGenCode");
        return genCodes;
    }
}
