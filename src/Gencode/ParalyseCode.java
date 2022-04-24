package Gencode;

import Field.Laboratory;
import Agent.Agent;
import Agent.ParalyseAgent;

/**
 * Bénuló ágens kódját reprezentáló osztály.
 */
public class ParalyseCode extends GenCode {

    /**
     * ParalyseCode constructor
     * @param aminoNeeded The needed amoniacid amount.
     * @param nucleoNeeded The needed nucletid amount.
     * @param field The current laboratory the gencode is on.
     */
    public ParalyseCode(int aminoNeeded, int nucleoNeeded, Laboratory field) {
        super(aminoNeeded, nucleoNeeded, field);
        this.name = "pac" + id++;
        Uid=2;
    }

    /**
     * Empty ParalyseCode constructor
     */
    public ParalyseCode() {
        super(4, 0);
    }

    public ParalyseCode(int aminoNeeded, int nucleoNeeded) {
        super(aminoNeeded, nucleoNeeded);
        this.name = "pac" + id++;
    }

    /**
     * Létrehozza a belőle készíthető ParalyseAgent ágenst.
     *
     * @return Agent    a létrehozott ParalyseAgent
     */
    @Override
    public Agent revealAgent() {
        return new ParalyseAgent();
    }
}
