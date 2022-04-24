package Field;

import Agent.BearDanceAgent;
import Collectible.Collectible;
import Gencode.GenCode;
import Virologist.Virologist;

import java.util.ArrayList;

/**
 * A laboratóriumot reprezentáló osztály
 */
public class Laboratory extends Field {
    private static int id = 1;
    private ArrayList<GenCode> genCodes = new ArrayList<>();
    private BearDanceAgent bearAgent = null;

    /**
     * Laboratory constructor
     */
    public Laboratory() {
        this.name = "lab" + id++;
        fields.add(this);
    }

    /**
     * Hozzáadja a paraméterként megadott virológust a mezőn lévő virológusokhoz, és megfertőzi medvevírussal, ha van a laboron.
     * @param virologist Ezt adja hozzá
     */
    @Override
    public void addVirologist(Virologist virologist) {
        // adding virologist
        virologists.add(virologist);

        // infecting with bear agent, if there is any
        if (bearAgent != null) {
            virologist.beInfected(bearAgent, virologist);
        }
    }

    /**
     * Hozzáadja a currGenCode-hoz a paraméterként kapott genetikai kódot
     *
     * @param genCode Ezt adja hozzá
     */
    public void add(GenCode genCode) {
        genCodes.add(genCode);
    }
    public void add(BearDanceAgent agent){
        bearAgent=agent;
    }

    // TODO this should still work as intended, but will leave this here just in case
    // the gencode will never be removed from the laboratory, as there is no need for it
    /*
     * Elveszi a currGenCode-ból a paraméterként kapott genetikai kódot
     *
     * @param genCode Ezt törli ki
     *
    public void remove(GenCode genCode) {
        System.out.println("-> RemoveGenCode(GenCode genCode)\n! Elveszi a currGenCode-bol a parameterkent kapott genetikai kodot\n\n");
        System.out.println("\tRemoved a gencode from lab.");
    }
    */

    /**
     * currGenCode getterje
     *
     * @return Visszaadja a genCodes-ot
     */
    public ArrayList<GenCode> getGenCode() {
        return genCodes;
    }

    /**
     * Beállítja a laboron lévő medvevírust.
     * @param bearAgent A megadott medvevírus.
     */
    public void setBearAgent(BearDanceAgent bearAgent) {
        this.bearAgent = bearAgent;
    }
}
