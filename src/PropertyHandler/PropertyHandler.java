package PropertyHandler;

import Agent.Agent;
import Equipments.Equipment;
import Gencode.GenCode;
import Materials.AminoAcid;
import Materials.Nucleotid;
import Virologist.Virologist;

import java.util.ArrayList;
import java.util.List;

/**
 * A virológus felszerelését, nyersanyagait, genetikai kódjait, és ágenseit tároló osztály
 */
public class PropertyHandler {
    private int max_material;
    private int max_equipment;
    private int max_gencode;

    private Virologist viro;
    private List<GenCode> gencodes = new ArrayList<>();
    private List<AminoAcid> aminos = new ArrayList<>();
    private List<Nucleotid> nucleos = new ArrayList<>();
    private List<Agent> agents = new ArrayList<>();
    private List<Equipment> equipments  =new ArrayList<>();

    public PropertyHandler(int max_equipment, int max_gencode, int max_material, Virologist viro){
        this.max_equipment = max_equipment;
        this.max_gencode = max_gencode;
        this.max_material = max_material;
        this.viro = viro;
        this.gencodes = null;
        this.aminos = null;
        this.nucleos = null;
        this.agents = null;
        this.equipments = null;
    }

    public PropertyHandler(Virologist v) {
        this.viro=v;
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
     * Hozzáadja a paraméterként kapott ágenst a saját ágenseihez.
     * @param agent             Ezt az ágenst adja hozzá
     */
    public void AddAgent(Agent agent){
        System.out.println("-> AddAgent(Agent Agent)\n ! Hozzáadja a paraméterként kapott ágenst a saját ágenseihez\n\n");
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
    public void RemoveEquipment(Equipment equipment){
        System.out.println("-> RemoveEqupment(Equipment equipment)\n! Eltávolítja a paraméterként kapott felszerelést a saját felszerelést\n\n");
    }

    /**
     * Eltávolítja a paraméterként kapott ágenst a saját ágenseiből
     * @param agent                 Ezt az ágenst tővolítja el
     */
    public void RemoveAgent(Agent agent){
        System.out.println("-> RemoveAgent(Agent Agent)\n! Eltávolítja a paraméterként kapott ágenst a saját ágenseiből\n\n");
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

    public void setViro(Virologist viro) {
        this.viro = viro;
    }
}
