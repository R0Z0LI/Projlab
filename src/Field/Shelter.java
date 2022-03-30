package Field;

import Equipments.Equipment;

import java.util.ArrayList;
import java.util.List;

/**
 * A menedéket reprezentáló osztály
 */
public class Shelter extends Field{
    private List<Equipment> equipments = new ArrayList<>();

    /**
     * Hozzáadja a currEquipment-hez a paraméterként kapott felszerelést
     * @param equipment         Ezt adja hozzá
     */
    public void add(Equipment equipment){
        System.out.println("-> AddEquipment(Equipment equipment)\n! Hozzáadja a currEquipment-hez a paraméterként kapott felszerelést\n\n");
        equipments.add(equipment);
    }

    /**
     * Eltávolítja a currEquipment-bőé a paraméterként kapott felszerelést
     * @param equipment         Ezt veszi el
     */
    public void remove(Equipment equipment){
        System.out.println("-> RemoveEquipment(Equipment equipment)\n! Eltávolítja a currEquipment-bőé a paraméterként kapott felszerelést\n\n");
    }

    /**
     * A currEquipment getterje
     * @return                  Visszaadja currEquipment-et
     */
    public List<Equipment> getEquipments(){
        System.out.println("-> getCurrEquipment()\n! A currEquipment getterje\n <- currEquipment\n\n");
        return equipments;
    }
}
