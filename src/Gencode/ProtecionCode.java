package Gencode;

import Field.Laboratory;
import Agent.Agent;
import Agent.ProtectionAgent;

/**
 * Védő ágens kódját reprezentáló osztály.
 */
public class ProtecionCode extends GenCode {

    /**
     * ProtecionCode constructor
     * @param aminoNeeded The needed amoniacid amount.
     * @param nucleoNeeded The needed nucletid amount.
     * @param field The current laboratory the gencode is on.
     */
    public ProtecionCode(int aminoNeeded, int nucleoNeeded, Laboratory field) {
        super(aminoNeeded, nucleoNeeded, field);
        this.name = "prc" + id++;
        Uid=3;
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
