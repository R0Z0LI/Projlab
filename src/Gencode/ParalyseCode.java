package Gencode;

import Field.Field;
import PropertyHandler.PropertyHandler;
import Agent.Agent;
import Agent.ParalyseAgent;

public class ParalyseCode extends GenCode {
    private static int id = 0;


    private String name;

    public ParalyseCode(int aminoneeded, int nucleoneeded, Field field) {
        super(aminoneeded, nucleoneeded, field);
        this.name = "pac" + id++;
    }

    public String getName() {
        return name;
    }
    public ParalyseCode() {
        super(4, 0);
    }

    /**
     * +
     * Létrehozza a belőle készíthető ParalyseAgent ágenst.
     *
     * @return Agent    a létrehozott ParalyseAgent
     */
    @Override
    public Agent revealAgent() {
        System.out.println("-> ParalyseCode.revealAgent()");
        System.out.println("! Elkeszult egy benito agens\n");
        ParalyseAgent pa = new ParalyseAgent(30);
        return pa;
    }

    /**
     * +
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
     * +
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
