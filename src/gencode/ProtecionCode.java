package gencode;

import Field.Field;
import Materials.AminoAcid;
import Materials.Nucleotid;
import PropertyHandler.PropertyHandler;
import agent.Agent;
import agent.ParalyseAgent;
import agent.ProtectionAgent;

import java.util.List;

public class ProtecionCode extends GenCode{
    public ProtecionCode(int aminoneeded, int nucleoneeded, Field field) {
        super(aminoneeded, nucleoneeded, field);
    }

    public ProtecionCode() {
        super(1,3);
    }

    /**+
     * Létrehozza a belőle készíthető ProtectionAgent ágenst.
     *
     * @return Agent    a létrehozott ProtectionAgent
     */
    @Override
    public Agent revealAgent() {
        System.out.println("-> ProtectionCode.revealAgent()");
        System.out.println("! Elkészült egy védő ágens\n");
        ProtectionAgent pa=new ProtectionAgent(30);
        return pa;
    }

    /**+
     * Begyűjteti magát a virológus PropertyHandlerével.
     *
     * @param propertyHandler   amihez hozzá kell adni a felvett ProtecionCode-t
     */
    @Override
    public void beCollected(PropertyHandler propertyHandler) {
        propertyHandler.AddGenCode(this);
        System.out.println("beCollected(PropertyHandler propertyHandler)\n! Begyűjteti magát a virológus PropertyHandlerével.\n\n");
    }

    /**+
     * Eltávolíttatja magát a virológus PropertyHandleréből.
     *
     * @param propertyHandler   amiből ki kell törölni a törlendő ProtecionCode-t
     */
    @Override
    public void beRemoved(PropertyHandler propertyHandler) {
        propertyHandler.DeleteGenCode(this);
        System.out.println("beRemoved(PropertyHandler propertyHandler)\n! Eltávolíttatja magát a virológus PropertyHandleréből.\n\n");
    }
}
