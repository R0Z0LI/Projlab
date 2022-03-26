package Field;

import virologist.Virologist;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private List<Virologist> virologists;
    private ArrayList<Field> neighbours;
    public Field(){

    }

    public List<Virologist> GetTouchableVirologists(){
        return virologists;
    }

    public void RemoveVirologist(Virologist virologist) {
        virologists.remove(virologist);
    }

    public void AddVirologist(Virologist virologsit){
        virologists.add(virologsit);
    }

    public ArrayList<Field> getNeighbours() {
        return neighbours;
    }
}
