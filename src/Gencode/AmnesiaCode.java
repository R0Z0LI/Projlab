package Gencode;

import Field.Field;
import PropertyHandler.PropertyHandler;
import Agent.Agent;
import Agent.AmnesiaAgent;

public class AmnesiaCode extends GenCode{
    public AmnesiaCode(int aminoneeded, int nucleoneeded, Field field) {
        super(aminoneeded, nucleoneeded, field);
    }
    public AmnesiaCode(){
        super(2,2);
    }

    /**+
     * Létrehozza a belőle készíthető AmnesiaAgent ágenst.
     *
     * @return Agent    a létrehozott AmnesiaAgent
     */
    @Override
    public Agent revealAgent() {
        System.out.println("-> AmnesiaCode.revealAgent()");
        System.out.println("! Elkészült egy felejtő ágens\n");
        AmnesiaAgent ae=new AmnesiaAgent(30);
        return ae;
    }

    /**+
     * Begyűjteti magát a virológus PropertyHandlerével.
     *
     * @param propertyHandler   amihez hozzá kell adni a felvett AmnesiaCode-t
     */
    @Override
    public void beCollected(PropertyHandler propertyHandler) {
        System.out.println("beCollected(PropertyHandler propertyHandler)\n! Begyűjteti magát a virológus PropertyHandlerével.\n\n");
        propertyHandler.addGenCode(this);
    }

    /**+
     * Eltávolíttatja magát a virológus PropertyHandleréből.
     *
     * @param propertyHandler   amiből ki kell törölni a törlendő AmnesiaCode-t
     */
    @Override
    public void beRemoved(PropertyHandler propertyHandler) {
        propertyHandler.deleteGenCode(this);
        System.out.println("beRemoved(PropertyHandler propertyHandler)\n! Eltávolíttatja magát a virológus PropertyHandleréből.\n\n");
    }
}
