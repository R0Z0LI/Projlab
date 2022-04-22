package Gencode;

import Field.Laboratory;
import PropertyHandler.PropertyHandler;
import Agent.Agent;
import Agent.ParalyseAgent;

/**
 * Bénuló ágens kódját reprezentáló osztály.
 */
public class ParalyseCode extends GenCode {
    private static int id = 0;

    /**
     * ParalyseCode constructor
     * @param aminoNeeded The needed amoniacid amount.
     * @param nucleoNeeded The needed nucletid amount.
     * @param field The current laboratory the gencode is on.
     */
    public ParalyseCode(int aminoNeeded, int nucleoNeeded, Laboratory field) {
        super(aminoNeeded, nucleoNeeded, field);
        this.name = "pac" + id++;
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
        System.out.println("-> ParalyseCode.revealAgent()");
        System.out.println("! Elkeszult egy benito agens\n");
        return new ParalyseAgent();
    }

    /**
     * Begyűjteti magát a virológus PropertyHandlerével.
     *
     * @param propertyHandler amihez hozzá kell adni a felvett ParalyseCode-t
     */
    @Override
    public void beCollected(PropertyHandler propertyHandler) {
        propertyHandler.add(this);
        System.out.println("beCollected(PropertyHandler propertyHandler)\n! Begyujteti magat a virologus PropertyHandlerevel.\n\n");
    }

    /**
     * Eltávolíttatja magát a virológus PropertyHandleréből.
     *
     * @param propertyHandler amiből ki kell törölni a törlendő ParalyseCode-t
     */
    @Override
    public void beRemoved(PropertyHandler propertyHandler) {
        propertyHandler.deleteGenCode(this);
        System.out.println("beRemoved(PropertyHandler propertyHandler)\n! Eltavolittatja magat a virologus PropertyHandlerébol.\n\n");
    }
}
