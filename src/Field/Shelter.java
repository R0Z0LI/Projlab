package Field;

import Collectible.Collectible;
import Equipments.Equipment;
import Gencode.GenCode;
import Graphics.FieldView;
import Materials.AminoAcid;
import Materials.Nucleotid;
import Virologist.Virologist;

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
    public String toString() {
            String name = this.name;
            String neighbours = "";
            for (Field neighbour : this.neighbours) {
                neighbours += neighbour.name + " ";
            }
            if(neighbours.equals(""))
                neighbours="0";
            String viros= "";
            for(Virologist v : virologists)
                viros+=v.toString()+" ";
            if(viros.equals(""))
                viros="0";
            String things ="";
            for(Equipment e: equipments)
                things+=e.getName()+" ";
            if(things.equals(""))
                things="0";
            return name + "\n" + neighbours+"\n"+things + "\n"+ viros+"\n"+name+"\n";
    }

}
