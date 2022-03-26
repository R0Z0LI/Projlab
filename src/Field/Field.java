package Field;

import virologist.Virologist;

import java.util.ArrayList;
import java.util.List;

/**
 * A játék egy mezőjét reprezentáló osztály
 */
public class Field {
    private List<Virologist> virologists;
    private ArrayList<Field> neighbours;
    public Field(){

    }

    /**
     * virologists getterje
     * @return                  visszaadja a virológusok listáját
     */
    public List<Virologist> GetTouchableVirologists(){

        return virologists;
    }

    /**
     * Kitörli a paraméterként megadott virológust a mezőn lévő virológusok közül
     * @param virologist        Ezt a virológust törli ki
     */
    public void RemoveVirologist(Virologist virologist) {

        virologists.remove(virologist);
    }

    /**
     * Hozzáadja a paraméterként megadott virológust a mezőn lévő virológusokhoz
     * @param virologsit        Ezt adja hozzá
     */
    public void AddVirologist(Virologist virologsit){

        virologists.add(virologsit);
    }

    /**
     * Visszaadja a szomszédos mezőket
     * @return                  A szomszédos mezők listáját adja vissza
     */
    public ArrayList<Field> getNeighbours() {

        return neighbours;
    }
}
