package Field;

import Virologist.Virologist;

import java.util.ArrayList;
import java.util.List;

/**
 * A játék egy mezőjét reprezentáló osztály
 */
public class Field {
    private static int id = 0;
    protected static List<Field> fields = new ArrayList<>();
    protected ArrayList<Virologist> virologists = new ArrayList<>();
    private ArrayList<Field> neighbours = new ArrayList<>();
    private String name;

    public Field() {
        name = "fid" + id++;
        fields.add(this);
    }

    public String getName() {
        return name;
    }

    public static List<Field> getFields() {
        return fields;
    }

    // TODO more complex constructor? (maybe)

    /**
     * virologists getterje
     *
     * @return visszaadja a mezőről elérhető virológusok listáját
     */
    public ArrayList<Virologist> GetTouchableVirologists() {
        //System.out.println("-> GetTouchableVirologists()\n! virologists getterje\n <- return virologists\n\n");
        return virologists;
    }

    /**
     * Hozzáadja a paraméterként megadott virológust a mezőn lévő virológusokhoz
     *
     * @param virologist Ezt adja hozzá
     */
    public void addVirologist(Virologist virologist) {
        //System.out.println("-> AddVirologist(Virologist virologsit)\n! Hozzaadja a parameterkent megadott virologust a mezon levo virologusokhoz\n\n");
        virologists.add(virologist);
    }

    /**
     * Kitörli a paraméterként megadott virológust a mezőn lévő virológusok közül
     *
     * @param virologist Ezt a virológust törli ki
     */
    public void removeVirologist(Virologist virologist) {
        //System.out.println("-> RemoveVirologist(Virologist Virologist)\n! Kitorli a parameterkent megadott virologust a mezon levo virologusok kozul\n\n");
        virologists.remove(virologist);
    }

    /**
     * Hozzáad egy szomszédos mezőt
     *
     * @param field Ezt a mezőt adja hozzá szomszédként
     */
    public void addNeighbour(Field field) {
        neighbours.add(field);
    }

    /**
     * Anyagot pusztít a mezőn, mivel ez egy sima mező, ezért itt nem történik semmi
     */
    public void rampage() {
        //
        System.out.println("\tA virologist tried to rampage on a non-warehouse. Nothing happened.");
    }

    /**
     * Visszaadja a szomszédos mezőket
     *
     * @return A szomszédos mezők listáját adja vissza
     */
    public ArrayList<Field> getNeighbours() {
        //System.out.println("-> getNeighbours()\n! Visszaadja a szomszedos mezoket\n <- neighbours\n\n");
        return neighbours;
    }

    @Override
    public String toString() {
        String name = this.name;
        String neighbours = " ";
        for (Field neighbour : this.neighbours) {
            neighbours += neighbour.name + " ";
        }
        return name + ", [" + neighbours + "]";
    }

}
