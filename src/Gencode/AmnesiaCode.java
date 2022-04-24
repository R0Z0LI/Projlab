package Gencode;

import Field.Laboratory;
import Agent.Agent;
import Agent.AmnesiaAgent;

/**
 * Felejtő ágens kódját reprezentáló osztály.
 */
public class AmnesiaCode extends GenCode {
    private static int id = 0;
    private static int Uid=1;
    public int getUid(){return Uid;}
    /**
     * AmnesiaCode constructor
     * @param aminoNeeded The needed amoniacid amount.
     * @param nucleoNeeded The needed nucletid amount.
     * @param field The current laboratory the gencode is on.
     */
    public AmnesiaCode(int aminoNeeded, int nucleoNeeded, Laboratory field) {
        super(aminoNeeded, nucleoNeeded, field);
        this.name = "amc" + id++;
        Uid=0;
    }

    public AmnesiaCode(int aminoNeeded, int nucleoNeeded){
        super(aminoNeeded, nucleoNeeded);
        this.name = "amc" + id++;
    }

    /**
     * Empty AmnesiaCode constructor
     */
    public AmnesiaCode() {
        super(2, 2);
    }

    /**
     * Létrehozza a belőle készíthető AmnesiaAgent ágenst.
     *
     * @return Agent    a létrehozott AmnesiaAgent
     */
    @Override
    public Agent revealAgent() {
        return new AmnesiaAgent(30);
    }
}
