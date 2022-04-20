package Gencode;

import Field.Laboratory;
import PropertyHandler.PropertyHandler;
import Agent.Agent;
import Agent.AmnesiaAgent;

/**
 * Felejtő ágens kódját reprezentáló osztály.
 */
public class AmnesiaCode extends GenCode {
    private static int id = 0;

    /**
     * AmnesiaCode constructor
     * @param aminoNeeded The needed amoniacid amount.
     * @param nucleoNeeded The needed nucletid amount.
     * @param field The current laboratory the gencode is on.
     */
    public AmnesiaCode(int aminoNeeded, int nucleoNeeded, Laboratory field) {
        super(aminoNeeded, nucleoNeeded, field);
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
        System.out.println("-> AmnesiaCode.revealAgent()");
        System.out.println("! Elkeszult egy felejto agens\n");
        return new AmnesiaAgent(30);
    }

    /**
     * Begyűjteti magát a virológus PropertyHandlerével.
     *
     * @param propertyHandler amihez hozzá kell adni a felvett AmnesiaCode-t
     */
    @Override
    public void beCollected(PropertyHandler propertyHandler) {
        System.out.println("beCollected(PropertyHandler propertyHandler)\n! Begyujteti magat a virologus PropertyHandlerevel.\n\n");
        propertyHandler.add(this);
    }

    /**
     * Eltávolíttatja magát a virológus PropertyHandleréből.
     *
     * @param propertyHandler amiből ki kell törölni a törlendő AmnesiaCode-t
     */
    @Override
    public void beRemoved(PropertyHandler propertyHandler) {
        propertyHandler.deleteGenCode(this);
        System.out.println("beRemoved(PropertyHandler propertyHandler)\n! Eltavolittatja magat a virologus PropertyHandlerebol.\n\n");
    }
}
