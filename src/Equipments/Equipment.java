package Equipments;

import Collectible.Collectible;
import Field.Shelter;
import PropertyHandler.PropertyHandler;
import Virologist.Virologist;

/**+
 * Felszerelést reprezentáló osztály.
 */
//TODO érdemes-e egy közös inteface-be kiszervezni az addBehavior()
public abstract class Equipment implements Collectible {
    private Shelter currPosition;

    public Equipment(){}

    public void setCurrPosition(Shelter currPosition) {
        this.currPosition = currPosition;
    }

    /**+
     * Hozzáadja a megadott virológus verméhez az adott Equipmentből adódó viselkedést.
     *
     * @param v   virológus, akinek a vermébe bele fog kerülni az adott Equipmentből adódó viselkedés
     */
    public abstract void addBehaviour(Virologist v);

    /**+
     * Törli a megadott virológus verméből az adott Equipmentből adódó viselkedést.
     *
     * @param v   virológus, akinek a verméből törlődni fog az adott Equipmentből adódó viselkedés
     */
    public abstract void removeBehavior(Virologist v);

    /**+
     * Begyűjteti magát a virológus PropertyHandlerével.
     *
     * @param ph   amihez hozzá kell adni a felvett Equipmentet
     */
    public abstract void beCollected(PropertyHandler ph);

    /**+
     * Törli magát a virológus PropertyHandleréből.
     *
     * @param ph   amiből törölni kell a törlendő Equipmentet
     */
    public abstract void beRemoved(PropertyHandler ph);
}
