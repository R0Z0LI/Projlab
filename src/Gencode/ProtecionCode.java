package Gencode;

import Field.Field;
import PropertyHandler.PropertyHandler;
import Agent.Agent;
import Agent.ProtectionAgent;

public class ProtecionCode extends GenCode {
    private static int id = 0;


    private String name;

    public ProtecionCode(int aminoNeeded, int nucleoNeeded, Field field) {
        super(aminoNeeded, nucleoNeeded, field);
        this.name = "prc" + id++;
    }

    public ProtecionCode() {
        super(1, 3);
    }

    public String getName() {
        return name;
    }
    /**
     * +
     * Létrehozza a belőle készíthető ProtectionAgent ágenst.
     *
     * @return Agent    a létrehozott ProtectionAgent
     */
    @Override
    public Agent revealAgent() {
        System.out.println("-> ProtectionCode.revealAgent()");
        System.out.println("! Elkeszult egy védo agens\n");
        ProtectionAgent pa = new ProtectionAgent(30);
        return pa;
    }

    /**
     * +
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
     * +
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
