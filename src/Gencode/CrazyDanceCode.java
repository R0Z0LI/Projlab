package Gencode;

import Field.Laboratory;
import Agent.Agent;
import Agent.CrazyDanceAgent;

/**
 * Vitustáncot okozó ágens létrehozásához szükséges genetikai kódot reprezentáló osztály.
 */
public class CrazyDanceCode extends GenCode{
    private static int id = 0;

    /**
     * CrazyDanceCode constructor
     * @param aminoNeeded The needed amoniacid amount.
     * @param nucleoNeeded The needed nucletid amount.
     * @param field The current laboratory the gencode is on.
     */
    public CrazyDanceCode(int aminoNeeded, int nucleoNeeded, Laboratory field) {
        super(aminoNeeded, nucleoNeeded, field);
        this.name = "cdc" + id++;
    }

    /**
     * Empty CrazyDanceCode constructor
     */
    public CrazyDanceCode(){
        super(2,3);
    }

    public CrazyDanceCode(int aminoNeeded, int nucleoNeeded) {
        super(aminoNeeded, nucleoNeeded);
        this.name = "cdc" + id++;
    }

    /**
     * Létrehozza a belőle készíthető CrazyDanceAgent ágenst.
     *
     * @return Agent    a létrehozott CrazyDanceAgent
     */
    @Override
    public Agent revealAgent() {
        return new CrazyDanceAgent(30);
    }
}
