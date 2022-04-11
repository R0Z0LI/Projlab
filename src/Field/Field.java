package Field;

import Virologist.Virologist;

import java.util.ArrayList;
import java.util.List;

/**
 * A játék egy mezőjét reprezentáló osztály
 */
public class Field {
    private List<Virologist> virologists = new ArrayList<>();
    private ArrayList<Field> neighbours = new ArrayList<>();

    //TODO kell-e konstruktor szomszédokkal

    public Field() {

    }

    /**
     * virologists getterje
     *
     * @return visszaadja a virológusok listáját
     */
    public List<Virologist> GetTouchableVirologists() {
        System.out.println("-> GetTouchableVirologists()\n! virologists getterje\n <- return virologists\n\n");
        return virologists;
    }

    //TODO remove és addVirologist metódusokat egy metódusba tenni
    /**
     * Kitörli a paraméterként megadott virológust a mezőn lévő virológusok közül
     *
     * @param virologist Ezt a virológust törli ki
     */
    public void removeVirologist(Virologist virologist) {
        System.out.println("-> RemoveVirologist(Virologist Virologist)\n! Kitorli a parameterkent megadott virologust a mezon levo virologusok kozul\n\n");
        virologists.remove(virologist);
    }

    /**
     * Hozzáadja a paraméterként megadott virológust a mezőn lévő virológusokhoz
     *
     * @param virologsit Ezt adja hozzá
     */
    public void addVirologist(Virologist virologsit) {
        System.out.println("-> AddVirologist(Virologist virologsit)\n! Hozzaadja a parameterkent megadott virologust a mezon levo virologusokhoz\n\n");
        virologists.add(virologsit);
    }

    /**
     * Visszaadja a szomszédos mezőket
     *
     * @return A szomszédos mezők listáját adja vissza
     */
    public ArrayList<Field> getNeighbours() {
        System.out.println("-> getNeighbours()\n! Visszaadja a szomszedos mezoket\n <- neighbours\n\n");
        return neighbours;
    }

    public void addNeighbour(Field field) {
        neighbours.add(field);
    }
}
