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
        System.out.println("-> ProtectionCode.revealAgent()");
        System.out.println("! Elkeszult egy védo agens\n");
        return new ProtectionAgent(30);
    }

    /**
     * Begyűjteti magát a virológus PropertyHandlerével.
     *
     * @param propertyHandler amihez hozzá kell adni a felvett ProtecionCode-t
     */
    @Override
    public void beCollected(PropertyHandler propertyHandler) {
        propertyHandler.add(this);
        System.out.println("beCollected(PropertyHandler propertyHandler)\n! Begyujteti magat a virologus PropertyHandlerével.\n\n");
    }

    /**
     * Eltávolíttatja magát a virológus PropertyHandleréből.
     *
     * @param propertyHandler amiből ki kell törölni a törlendő ProtecionCode-t
     */
    @Override
    public void beRemoved(PropertyHandler propertyHandler) {
        propertyHandler.deleteGenCode(this);
        System.out.println("beRemoved(PropertyHandler propertyHandler)\n! Eltavolittatja magat a virologus PropertyHandlerébol.\n\n");
    }
}
