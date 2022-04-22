package Gencode;

import Field.Laboratory;
import PropertyHandler.PropertyHandler;
import Agent.Agent;
import Agent.ProtectionAgent;

/**
 * Védő ágens kódját reprezentáló osztály.
 */
public class ProtecionCode extends GenCode {
    private static int id = 0;
    public int getUid(){return id;}
    /**
     * ProtecionCode constructor
     * @param aminoNeeded The needed amoniacid amount.
     * @param nucleoNeeded The needed nucletid amount.
     * @param field The current laboratory the gencode is on.
     */
    public ProtecionCode(int aminoNeeded, int nucleoNeeded, Laboratory field) {
        super(aminoNeeded, nucleoNeeded, field);
        this.name = "prc" + id++;
    }

    public ProtecionCode(int aminoNeeded, int nucleoNeeded){
        super(aminoNeeded, nucleoNeeded);
        this.name = "prc" + id++;
    }
    /**
     * Empty ProtecionCode constructor
     */
    public ProtecionCode() {
        super(1, 3);
    }

    /**
     * Létrehozza a belőle készíthető ProtectionAgent ágenst.
     *
     * @return Agent    a létrehozott ProtectionAgent
     */
    @Override
    public Agent revealAgent() {
        return new ProtectionAgent(30);
    }
}
