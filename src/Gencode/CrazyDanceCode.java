package Gencode;

import Field.Field;
import PropertyHandler.PropertyHandler;
import Agent.Agent;
import Agent.CrazyDanceAgent;

/**+
 * Vitustáncot okozó ágens létrehozásához szükséges genetikai kódot reprezentáló osztály.
 */
public class CrazyDanceCode extends GenCode{
    public CrazyDanceCode(int aminoneeded, int nucleoneeded, Field field) {
        super(aminoneeded, nucleoneeded, field);
    }

    /**+
     * Létrehozza a belőle készíthető CrazyDanceAgent ágenst.
     *
     * @return Agent    a létrehozott CrazyDanceAgent
     */
    @Override
    public Agent revealAgent() {
        CrazyDanceAgent cda=new CrazyDanceAgent(30);
        return cda;
    }

    /**+
     * Begyűjteti magát a virológus PropertyHandlerével.
     *
     * @param propertyHandler   amihez hozzá kell adni a felvett CrazyDanceCode-t
     */
    @Override
    public void beCollected(PropertyHandler propertyHandler) {
        propertyHandler.addGenCode(this);
        System.out.println("beCollected(PropertyHandler propertyHandler)\n! Begyűjteti magát a virológus PropertyHandlerével.\n\n");
    }

    /**+
     * Eltávolíttatja magát a virológus PropertyHandleréből.
     *
     * @param propertyHandler   amiből ki kell törölni a törlendő CrazyDanceCode-t
     */
    @Override
    public void beRemoved(PropertyHandler propertyHandler) {
        propertyHandler.deleteGenCode(this);
        System.out.println("beRemoved(PropertyHandler propertyHandler)\n! Eltávolíttatja magát a virológus PropertyHandleréből.\n\n");
    }
}
