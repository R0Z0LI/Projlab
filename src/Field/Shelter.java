package Field;

import Equipments.Equipment;

import java.util.ArrayList;

/**
 * A menedéket reprezentáló osztály
 */
public class Shelter extends Field{
    private static int id = 0;
    private ArrayList<Equipment> equipments = new ArrayList<>();
    private String name;

    /**
     * Shelter constructor
     */
    public Shelter(){
        this.name = "shl" + id++;
    }

    /**
     * Hozzáadja a currEquipment-hez a paraméterként kapott felszerelést
     * @param equipment         Ezt adja hozzá
     */
    public void add(Equipment equipment){
        //System.out.println("-> AddEquipment(Equipment equipment)\n! Hozzaadja a currEquipment-hez a parameterkent kapott felszerelest\n\n");
        equipments.add(equipment);
        System.out.println("\tAdded new equipment to shelter.");
    }

    /**
     * Eltávolítja a currEquipment-ből a paraméterként kapott felszerelést
     * @param equipment         Ezt veszi el
     */
    public void remove(Equipment equipment){
        //System.out.println("-> RemoveEquipment(Equipment equipment)\n! Eltavolitja a currEquipment-boe a parameterkent kapott felszerelest\n\n");
        equipments.remove(equipment);
        System.out.println("\tRemoved equipment from shelter.");
    }

    /**
     * A currEquipment getterje
     * @return                  Visszaadja currEquipment-et
     */
    public ArrayList<Equipment> getEquipments(){
        //System.out.println("-> getCurrEquipment()\n! A currEquipment getterje\n <- currEquipment\n\n");
        return equipments;
    }
}
