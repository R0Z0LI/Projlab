package Field;

import Collectible.Collectible;
import Equipments.Equipment;

import java.util.ArrayList;

/**
 * A menedéket reprezentáló osztály
 */
public class Shelter extends Field{
    private static int id = 0;
    private ArrayList<Equipment> equipments = new ArrayList<>();

    /**
     * Shelter constructor
     */
    public Shelter(){
        super(0);
        this.name = "shl" + id++;
        fields.add(this);
    }

    /**
     * Hozzáadja a currEquipment-hez a paraméterként kapott felszerelést
     * @param equipment         Ezt adja hozzá
     */
    public void add(Equipment equipment){
        equipments.add(equipment);
    }

    /**
     * Eltávolítja a currEquipment-ből a paraméterként kapott felszerelést
     * @param equipment         Ezt veszi el
     */
    public void remove(Equipment equipment){
        equipments.remove(equipment);
    }

    /**
     * Get the collectibles from this field
     * @return
     */
    public Collectible getCollectible() {
        if (!equipments.isEmpty())
            return equipments.get(0);
        return null;
    }

    /**
     * A currEquipment getterje
     * @return                  Visszaadja equipments-et
     */
    public ArrayList<Equipment> getEquipments(){
        return equipments;
    }
}
