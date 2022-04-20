package Field;

import Gencode.GenCode;
import Agent.BearAgent;
import Virologist.Virologist;

import java.util.ArrayList;

/**
 * A laboratóriumot reprezentáló osztály
 */
public class Laboratory extends Field {
    private static int id = 0;
    private ArrayList<GenCode> genCodes = new ArrayList<>();
    private BearAgent bearAgent = null;
    private String name;

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
        System.out.println("\tA virologist has stepped on the laboratory.");

        // infecting with bear agent
        if (bearAgent != null) {
            virologist.beInfected(bearAgent, virologist);
            System.out.println("\t\t...the virologist has been infected with a bear agent.");
        }
    }

    /**
     * Hozzáadja a currGenCode-hoz a paraméterként kapott genetikai kódot
     *
     * @param genCode Ezt adja hozzá
     */
    public void add(GenCode genCode) {
        //System.out.println("-> AddGenCode(GenCode genCode)\n! Hozzaadja a currGenCode-hoz a parameterkent kapott genetikai kodot\n\n");
        genCodes.add(genCode);
        System.out.println("\tAdded new gencode to lab.");
    }

    // TODO this should still work as intended, but will leave this here just in case
    // the gencode will never be removed from the laboratory, as there is no need for it
    // the gencode object, that is learned by the virologist is just there to create them agents
    // it is not going to be changed
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
     * @return Visszaadja a currGenCode-ot
     */
    public ArrayList<GenCode> getGenCode() {
        //System.out.println("-> getGenCode\n! currGenCode getterje\n<- currGenCode");
        return genCodes;
    }

    /**
     * Beállítja a laboron lévő medvevírust.
     * @param bearAgent A megadott medvevírus.
     */
    public void setBearAgent(BearAgent bearAgent) {
        this.bearAgent = bearAgent;
    }
}
