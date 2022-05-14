package Gencode;

import Collectible.Collectible;
import Field.Laboratory;
import Agent.Agent;
import PropertyHandler.PropertyHandler;

/**
 * Gentikai kódot reprezentáló osztály.
 */
public abstract class GenCode implements Collectible {
    protected Laboratory currentPosition;

    public int getUid(){return -1;}

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

    /* Szerintem ilyen ne legyen, mert a genetikai kódnak úgy kellene működnie, hogy laborról soha nem távolítódik el.
       Mindig a laboron marad, és így mindenki által ugyanaz az objktum lesz felvéve/megtanulva.
       A labor nélküli létrehozás sérteni ezt.*/
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
    public String getName() {
        return name;
    }

    /**
     * Begyűjteti magát a virológus PropertyHandlerével.
     *
     * @param propertyHandler amihez hozzá kell adni a felvett GenCode-ot
     */
    @Override
    public void beCollected(PropertyHandler propertyHandler) {
        propertyHandler.add(this);
    }

    /* TODO Ez kell? Mármint csak felejtésnél törlünk, de akkor mindent. */
    /**
     * Eltávolíttatja magát a virológus PropertyHandleréből.
     *
     * @param propertyHandler amiből ki kell törölni a törlendő GenCode-ot
     */
    @Override
    public void beRemoved(PropertyHandler propertyHandler) {
        propertyHandler.deleteGenCode(this);
    }

    /**
     * Gets the needed amount of amino acid.
     * @return needed amount of amino acid
     */
    public int getAminoNeeded() {
        return aminoNeeded;
    }

    /**
     * Gets the needed amount of nucleotid.
     * @return needed amount of nucleotid
     */
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
