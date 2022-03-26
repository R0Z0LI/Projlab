package Field;

import Collectible.Equipment;

import java.util.List;

/**
 * A menedéket reprezentáló osztály
 */
public class Shelter extends Field{
    private List<Equipment> currEquipment;

    /**
     * Hozzáadja a currEquipment-hez a paraméterként kapott felszerelést
     * @param equipment         Ezt adja hozzá
     */
    public void AddEquipment(Equipment equipment){

    }

    /**
     * Eltávolítja a currEquipment-bőé a paraméterként kapott felszerelést
     * @param equipment         Ezt veszi el
     */
    public void RemoveEquipment(Equipment equipment){

    }

    /**
     * A currEquipment getterje
     * @return                  Visszaadja currEquipment-et
     */
    public List<Equipment> getCurrEquipment(){
        return currEquipment;
    }
}
