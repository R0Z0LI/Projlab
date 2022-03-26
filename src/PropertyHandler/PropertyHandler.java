package PropertyHandler;

import Collectible.Equipment;
import Collectible.GenCode;
import Materials.AminoAcid;
import Materials.Nucleotid;
import Steppable.Agent;
import virologist.Virologist;

import java.util.List;

public class PropertyHandler {
    private int max_material;
    private int max_equipment;
    private int max_gencode;
    private Virologist viro;
    private List<GenCode> gencodes;
    private List<AminoAcid> aminos;
    private List<Nucleotid> nucleos;
    private List<Agent> agents;
    private List<Equipment> equipments;

    public PropertyHandler(int max_equipment, int max_gencode, int max_material, Virologist viro, List<GenCode> gencodes, List<AminoAcid> aminos,
                           List<Nucleotid> nucleos, List<Agent> agents, List<Equipment> equipments){
        this.max_equipment = max_equipment;
        this.max_gencode = max_gencode;
        this.max_material = max_material;
        this.viro = viro;
        this.gencodes = gencodes;
        this.aminos = aminos;
        this.nucleos = nucleos;
        this.agents = agents;
        this.equipments = equipments;
    }

    public void AddGenCode(GenCode genCode){

    }

    public void AddAmino(AminoAcid aminoAcid){

    }

    public void AddNucleo(Nucleotid nucleotid){

    }

    public void AddEquipment(Equipment equipment){

    }

    public void MakeAgent(GenCode genCode){

    }

    public void DeleteGenCodes(){

    }

    public void RemoveAmino(){

    }

    public void RemoveNucleo(){

    }

    public void RemoveEqupment(Equipment equipment){

    }

    public void RemoveAgent(Agent agent){

    }
}
