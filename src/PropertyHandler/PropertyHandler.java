package PropertyHandler;

import agent.Agent;
import equipments.Equipment;
import gencode.GenCode;
import Materials.AminoAcid;
import Materials.Nucleotid;
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

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

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

    public PropertyHandler() {

    }

    /**
     * Hozzáadja a paraméterként kapott genetikai kódot a saját genetikai kódjaihoz
     * @param genCode               Ezt adja hozzá
     */
    public void AddGenCode(GenCode genCode){
        System.out.println("-> AddGenCode(GenCode genCode) \n! Hozzáadja a paraméterként kapott genetikai kódot a saját genetikai kódjaihoz \n\n");
    }

    /**
     * Hozzáadja a paraméterként kapott aminósavat a saját aminósavjaihoz
     * @param aminoAcid             Ezt az aminósavat adja hozzá
     */
    public void AddAmino(AminoAcid aminoAcid){
        System.out.println("-> AddAmino(AminoAcid aminoAcid) \n! Hozzáadja a paraméterként kapott aminósavat a saját aminósavjaihoz\n\n");
    }

    /**
     * Hozzáadja a paraméterként kapott nukleotidot a saját nukleotidjaihoz
     * @param nucleotid             Ezt a nukleotidot adja hozzá
     */
    public void AddNucleo(Nucleotid nucleotid){
        System.out.println("-> AddNucleo(Nucleotid nucleotid)\n! Hozzáadja a paraméterként kapott nukleotidot a saját nukleotidjaihoz\n\n");
    }

    /**
     * Hozzáadja a paraméterként kapott felszerelést a saját felszerelést
     * @param equipment             Ezt a felszerelést adja hozzá
     */
    public void AddEquipment(Equipment equipment){
        System.out.println("-> AddEquipment(Equipment equipment)\n ! Hozzáadja a paraméterként kapott felszerelést a saját felszerelést\n\n");
    }

    /**
     * Elkészít egy ágenst, megnézi van e elég aminósav és nukleotid, majd kivonja a tárolóiból ha van, és létrehozza az ágenst
     * @param genCode               Ez a genetikai kód alapján hozza létre az ágenst
     */
    public void MakeAgent(GenCode genCode){
        System.out.println("-> MakeAgent(GenCode genCode)\n ! Elkészít egy ágenst, megnézi van e elég aminósav és nukleotid, majd kivonja a tárolóiból ha van, és létrehozza az ágenst\n\n");
        if(aminos.size() == genCode.getAmino_needed() && nucleos.size() == genCode.getNucleo_needed()){
            for(int i = 0; i < genCode.getNucleo_needed(); i++){
                aminos.remove(i);
                nucleos.remove(i);
            }
            genCode.RevealAgent();
        }

    }

    /**
     * Eltávolítja a paraméterként kapott genetikai kódot a saját genetikai kódjaiból
     */
    public void DeleteGenCodes(){
        System.out.println("DeleteGenCodes()\n! Eltávolítja a paraméterként kapott genetikai kódot a saját genetikai kódjaiból\n\n");
    }

    /**
     * Eltávolítja a paraméterként kapott aminósavat a saját aminósavjaiból
     * @param aminoAcid             Ezt az aminósavat tővolítja el
     */
    public void RemoveAmino(AminoAcid aminoAcid){
    System.out.println("-> RemoveAmino(AminoAcid aminoAcid)\n! Eltávolítja a paraméterként kapott aminósavat a saját aminósavjaiból\n\n");
    }

    /**
     * Eltávolítja a paraméterként kapott nukleotidot a saját nukleotidjaiból
     * @param nucleotid             Ezt a nukleotidot tővolítja el
     */
    public void RemoveNucleo(Nucleotid nucleotid){
        System.out.println("-> RemoveNucleo(Nucleotid nucleotid)\n! Eltávolítja a paraméterként kapott nukleotidot a saját nukleotidjaiból\n\n");
    }

    /**
     * Eltávolítja a paraméterként kapott felszerelést a saját felszerelést
     * @param equipment             Ezt a felszerelést tővolítja el
     */
    public void RemoveEqupment(Equipment equipment){
        System.out.println("-> RemoveEqupment(Equipment equipment)\n! Eltávolítja a paraméterként kapott felszerelést a saját felszerelést\n\n");
    }

    /**
     * Eltávolítja a paraméterként kapott ágenst a saját ágenseiből
     * @param agent                 Ezt az ágenst tővolítja el
     */
    public void RemoveAgent(Agent agent){
        System.out.println("-> RemoveAgent(Agent agent)\n! Eltávolítja a paraméterként kapott ágenst a saját ágenseiből\n\n");
    }

    /**
     * equipments setterje
     * @param equipments            Erre állítja be a felszerelést
     */
    public void setEquipments(List<Equipment> equipments) {
        System.out.println("-> setEquipments(List<Equipment> equipments)\n! equipments setterje");
        this.equipments = equipments;
    }

    /**
     * max_material setterje
     * @param n                     Erre az értékre állítja be
     */
    public void setMax_material(int n){
        System.out.println("-> setMax_material(int n)\n! max_material setterje");
        max_material=max_material+n;

    }



    public List<Equipment> getEquipments() {
        return equipments;
    }
}
