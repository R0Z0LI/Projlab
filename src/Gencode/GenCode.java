package Gencode;

import Collectible.Collectible;
import Field.Laboratory;
import Agent.Agent;

import java.util.UUID;

/**
 * Gentikai kódot reprezentáló osztály.
 */
public abstract class GenCode implements Collectible {
    protected Laboratory currentPosition = null;

    public String getName() {
        return name;
    }
    public abstract int getUid();
    protected String name;

    // needed materials for the agent creation
    private int aminoNeeded;
    private int nucleoNeeded;

    /**
     * GenCode constructor
     * @param aminoNeeded The needed amoniacid amount.
     * @param nucleoNeeded The needed nucletid amount.
     * @param field The current laboratory the gencode is on.
     */
    public GenCode(int aminoNeeded, int nucleoNeeded, Laboratory field) {
        this.aminoNeeded = aminoNeeded;
        this.nucleoNeeded = nucleoNeeded;
        currentPosition = field;
    }

    /**
     * GenCode constructor without any parameters.
     * Should be used when adding to the inventory directly.
     * @param aminoNeeded The needed amoniacid amount.
     * @param nucleoNeeded The needed nucletid amount.
     */
    public GenCode(int aminoNeeded, int nucleoNeeded) {
        this.aminoNeeded = aminoNeeded;
        this.nucleoNeeded = nucleoNeeded;
        currentPosition = null;
    }

    // gets name/id of this object
    @Override
    public String toString() {
        return name;
    }

    public void setField(Laboratory lab) {
        currentPosition = lab;
    }

    public int getAminoNeeded() {
        return aminoNeeded;
    }

    public int getNucleoNeeded() {
        return nucleoNeeded;
    }

    public Laboratory getCurrentPosition() {
        return currentPosition;
    }


    /**
     * Létrehozza a belőle készíthető ágenst.
     *
     * @return Agent    a létrehozott ágens
     */
    public abstract Agent revealAgent();
}
