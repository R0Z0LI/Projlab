package PropertyHandler;

import Collectible.Equipment;
import Collectible.GenCode;
import Materials.AminoAcid;
import Materials.Nucleotid;
import Steppable.Agent;
import virologist.Virologist;

import java.util.List;

/**
 * A virológus felszerelését, nyersanyagait, genetikai kódjait, és ágenseit tároló osztály
 */
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

    /**
     * Hozzáadja a paraméterként kapott genetikai kódot a saját genetikai kódjaihoz
     * @param genCode               Ezt adja hozzá
     */
    public void AddGenCode(GenCode genCode){

    }

    /**
     * Hozzáadja a paraméterként kapott aminósavat a saját aminósavjaihoz
     * @param aminoAcid             Ezt az aminósavat adja hozzá
     */
    public void AddAmino(AminoAcid aminoAcid){

    }

    /**
     * Hozzáadja a paraméterként kapott nukleotidot a saját nukleotidjaihoz
     * @param nucleotid             Ezt a nukleotidot adja hozzá
     */
    public void AddNucleo(Nucleotid nucleotid){

    }

    /**
     * Hozzáadja a paraméterként kapott felszerelést a saját felszerelést
     * @param equipment             Ezt a felszerelést adja hozzá
     */
    public void AddEquipment(Equipment equipment){

    }

    /**
     * Elkészít egy ágenst
     * @param genCode
     */
    public void MakeAgent(GenCode genCode){

    }

    /**
     * Eltávolítja a paraméterként kapott genetikai kódot a saját genetikai kódjaiból
     * @param genCode               Ezt az genetikai kódot tővolítja el
     */
    public void DeleteGenCodes(GenCode genCode){

    }

    /**
     * Eltávolítja a paraméterként kapott aminósavat a saját aminósavjaiból
     * @param aminoAcid             Ezt az aminósavat tővolítja el
     */
    public void RemoveAmino(AminoAcid aminoAcid){

    }

    /**
     * Eltávolítja a paraméterként kapott nukleotidot a saját nukleotidjaiból
     * @param nucleotid             Ezt a nukleotidot tővolítja el
     */
    public void RemoveNucleo(Nucleotid nucleotid){

    }

    /**
     * Eltávolítja a paraméterként kapott felszerelést a saját felszerelést
     * @param equipment             Ezt a felszerelést tővolítja el
     */
    public void RemoveEqupment(Equipment equipment){

    }

    /**
     * Eltávolítja a paraméterként kapott ágenst a saját ágenseiből
     * @param agent                 Ezt az ágenst tővolítja el
     */
    public void RemoveAgent(Agent agent){

    }

    /**
     * equipments setterje
     * @param equipments            Erre állítja be a felszerelést
     */
    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }
}
