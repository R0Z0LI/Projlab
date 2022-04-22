package Field;

import Virologist.Virologist;

import java.util.ArrayList;
import java.util.List;

/**
 * A játék egy mezőjét reprezentáló osztály
 */
public class Field {
    protected String name;
    private static int id = 0;
    protected static ArrayList<Field> fields = new ArrayList<>(); // the map's fields
    protected ArrayList<Virologist> virologists = new ArrayList<>(); // the virologists on this field
    private ArrayList<Field> neighbours = new ArrayList<>();

    /**
     * Field constructor
     */
    public Field() {
        name = "fid" + id++;
        fields.add(this);
    }

    // gets name/id of this object
    public String getName() {
        return name;
    }

    // gets all the fields on the map
    public static List<Field> getFields() {
        return fields;
    }

    /**
     * virologists getterje
     *
     * @return visszaadja a mezőről elérhető virológusok listáját
     */
    public ArrayList<Virologist> GetTouchableVirologists() {
        return virologists;
    }

    /**
     * Hozzáadja a paraméterként megadott virológust a mezőn lévő virológusokhoz
     *
     * @param virologist Ezt adja hozzá
     */
    public void addVirologist(Virologist virologist) {
        virologists.add(virologist);
    }

    /**
     * Kitörli a paraméterként megadott virológust a mezőn lévő virológusok közül
     *
     * @param virologist Ezt a virológust törli ki
     */
    public void removeVirologist(Virologist virologist) {
        virologists.remove(virologist);
    }

    /**
     * Hozzáad egy szomszédos mezőt
     *
     * @param field Ezt a mezőt adja hozzá szomszédként
     */
    public void addNeighbour(Field field) {
        neighbours.add(field);
        field.getNeighbours().add(this);
    }

    /**
     * Anyagot pusztít a mezőn, mivel ez egy sima mező, ezért itt nem történik semmi
     */
    public void rampage() {
        //
    }

    /**
     * Visszaadja a szomszédos mezőket
     *
     * @return A szomszédos mezők listáját adja vissza
     */
    public ArrayList<Field> getNeighbours() {
        return neighbours;
    }

    /*
    @Override
    public String toString() {
        String name = this.name;
        String neighbours = " ";
        for (Field neighbour : this.neighbours) {
            neighbours += neighbour.name + " ";
        }
        return name + ", [" + neighbours + "]";
    }
    */
}
