package gencode;

import Field.Field;
import Materials.AminoAcid;
import Materials.Nucleotid;
import PropertyHandler.PropertyHandler;
import agent.Agent;
import agent.ParalyseAgent;

import java.util.List;

public class ParalyseCode extends GenCode{
    public ParalyseCode(int aminoneeded, int nucleoneeded, Field field) {
        super(aminoneeded, nucleoneeded, field);
    }
    public ParalyseCode(){
        super(4,0);
    }

    /**+
     * Létrehozza a belőle készíthető ParalyseAgent ágenst.
     *
     * @return Agent    a létrehozott ParalyseAgent
     */
    @Override
    public Agent revealAgent() {
        System.out.println("-> ParalyseCode.revealAgent()");
        System.out.println("! Elkészült egy bénító ágens\n");
        ParalyseAgent pa=new ParalyseAgent(30);
        return pa;
    }

    /**+
     * Begyűjteti magát a virológus PropertyHandlerével.
     *
     * @param propertyHandler   amihez hozzá kell adni a felvett ParalyseCode-t
     */
    @Override
    public void beCollected(PropertyHandler propertyHandler) {
        propertyHandler.AddGenCode(this);
        System.out.println("beCollected(PropertyHandler propertyHandler)\n! Begyűjteti magát a virológus PropertyHandlerével.\n\n");
    }

    /**+
     * Eltávolíttatja magát a virológus PropertyHandleréből.
     *
     * @param propertyHandler   amiből ki kell törölni a törlendő ParalyseCode-t
     */
    @Override
    public void beRemoved(PropertyHandler propertyHandler) {
        propertyHandler.DeleteGenCode(this);
        System.out.println("beRemoved(PropertyHandler propertyHandler)\n! Eltávolíttatja magát a virológus PropertyHandleréből.\n\n");
    }
}
