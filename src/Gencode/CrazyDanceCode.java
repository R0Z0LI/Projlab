package Gencode;

import Field.Laboratory;
import PropertyHandler.PropertyHandler;
import Agent.Agent;
import Agent.CrazyDanceAgent;

/**
 * Vitustáncot okozó ágens létrehozásához szükséges genetikai kódot reprezentáló osztály.
 */
public class CrazyDanceCode extends GenCode{
    private static int id = 0;

    /**
     * CrazyDanceCode constructor
     * @param aminoNeeded The needed amoniacid amount.
     * @param nucleoNeeded The needed nucletid amount.
     * @param field The current laboratory the gencode is on.
     */
    public CrazyDanceCode(int aminoNeeded, int nucleoNeeded, Laboratory field) {
        super(aminoNeeded, nucleoNeeded, field);
        this.name = "cdc" + id++;
    }

    /**
     * Empty CrazyDanceCode constructor
     */
    public CrazyDanceCode(){
        super(2,3);
    }

    /**
     * Létrehozza a belőle készíthető CrazyDanceAgent ágenst.
     *
     * @return Agent    a létrehozott CrazyDanceAgent
     */
    @Override
    public Agent revealAgent() {
        System.out.println("-> CrazyDanceCode.revealAgent()");
        System.out.println("! Elkeszult egy vitustánc ágens\n");
        return new CrazyDanceAgent(30);
    }

    /**
     * Begyűjteti magát a virológus PropertyHandlerével.
     *
     * @param propertyHandler   amihez hozzá kell adni a felvett CrazyDanceCode-t
     */
    @Override
    public void beCollected(PropertyHandler propertyHandler) {
        propertyHandler.add(this);
        System.out.println("beCollected(PropertyHandler propertyHandler)\n! Begyujteti magát a virologus PropertyHandlerével.\n\n");
    }

    /**
     * Eltávolíttatja magát a virológus PropertyHandleréből.
     *
     * @param propertyHandler   amiből ki kell törölni a törlendő CrazyDanceCode-t
     */
    @Override
    public void beRemoved(PropertyHandler propertyHandler) {
        propertyHandler.deleteGenCode(this);
        System.out.println("beRemoved(PropertyHandler propertyHandler)\n! Eltávolittatja magát a virologus PropertyHandlerébol.\n\n");
    }
}
