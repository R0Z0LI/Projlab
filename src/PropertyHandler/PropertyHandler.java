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
    private List<Equipment> equipments = new ArrayList<>();

    public PropertyHandler(int max_equipment, int max_gencode, int max_material, Virologist viro){
        this.max_equipment = max_equipment;
        this.max_gencode = max_gencode;
        this.max_material = max_material;
        this.viro = viro;
    }

    public PropertyHandler(Virologist v) {
        this.viro=v;
        this.max_equipment=3;
        this.max_material=10;
    }
    public PropertyHandler() {}

    /**
     * Hozzáadja a paraméterként kapott genetikai kódot a saját genetikai kódjaihoz
     * @param genCode               Ezt adja hozzá
     */
    public void addGenCode(GenCode genCode){
        System.out.println("-> AddGenCode(GenCode genCode) \n! Hozzáadja a paraméterként kapott genetikai kódot a saját genetikai kódjaihoz \n\n");
    }

    /**
     * Hozzáadja a paraméterként kapott aminósavat a saját aminósavjaihoz
     * @param aminoAcid             Ezt az aminósavat adja hozzá
     */
    public void addAmino(AminoAcid aminoAcid){
        System.out.println("-> AddAmino(AminoAcid aminoAcid) \n! Hozzáadja a paraméterként kapott aminósavat a saját aminósavjaihoz\n\n");
        if (max_material > aminos.size())
            aminos.add(aminoAcid);
    }

    /**
     * Hozzáadja a paraméterként kapott nukleotidot a saját nukleotidjaihoz
     * @param nucleotid             Ezt a nukleotidot adja hozzá
     */
    public void addNucleo(Nucleotid nucleotid){
        System.out.println("-> AddNucleo(Nucleotid nucleotid)\n! Hozzáadja a paraméterként kapott nukleotidot a saját nukleotidjaihoz\n\n");
        if (max_material > nucleos.size())
            nucleos.add(nucleotid);
    }

    /**
     * Hozzáadja a paraméterként kapott felszerelést a saját felszerelést
     * @param equipment             Ezt a felszerelést adja hozzá
     */
    public void addEquipment(Equipment equipment){
        System.out.println("-> AddEquipment(Equipment equipment)\n ! Hozzáadja a paraméterként kapott felszerelést a saját felszerelést\n\n");
        if (max_equipment > equipments.size()) {
            equipments.add(equipment);
            equipment.addBehToStack(viro);
        }
    }

    /**
     * Hozzáadja a paraméterként kapott ágenst a saját ágenseihez.
     * @param agent             Ezt az ágenst adja hozzá
     */
    public void addAgent(Agent agent){
        System.out.println("-> AddAgent(Agent Agent)\n ! Hozzáadja a paraméterként kapott ágenst a saját ágenseihez\n\n");
        agents.add(agent);
    }

    /**
     * Elkészít egy ágenst, megnézi van e elég aminósav és nukleotid, majd kivonja a tárolóiból ha van, és létrehozza az ágenst
     * @param genCode               Ez a genetikai kód alapján hozza létre az ágenst
     */
    public void makeAgent(GenCode genCode){
        System.out.println("-> MakeAgent(GenCode genCode)\n ! Megpróbálja elkészíteni az ágenst.");
        int a=genCode.getAmino_needed();
        int n=genCode.getNucleo_needed();
        if(aminos.size() >= a && nucleos.size() >= n){
            System.out.println("! Van elég anyag az elkészítéshez.\n");
            for(int i = 0; i < n; i++)
                nucleos.remove(0);
            for(int i = 0; i < a; i++)
                aminos.remove(0);
            genCode.revealAgent();
        } else {
            System.out.println("! Nince elég nyersanyag az elkészítéshez.\n");
        }

    }

    /**
     * Eltávolítja a paraméterként kapott genetikai kódot a saját genetikai kódjaiból
     */
    public void deleteGenCode(GenCode gc){
        System.out.println("DeleteGenCodes()\n! Eltávolítja a paraméterként kapott genetikai kódot a saját genetikai kódjaiból\n\n");
    }

    /**
     * Eltávolítja a paraméterként kapott genetikai kódot a saját genetikai kódjaiból
     */
    public void deleteGenCodes(){
        System.out.println("DeleteGenCodes()\n! Eltávolítja az összes genetikai kódot a saját genetikai kódjaiból\n\n");
    }

    /**
     * Eltávolítja a paraméterként kapott aminósavat a saját aminósavjaiból
     * @param aminoAcid             Ezt az aminósavat tővolítja el
     */
    public void removeAmino(AminoAcid aminoAcid){
        System.out.println("-> RemoveAmino(AminoAcid aminoAcid)\n! Eltávolítja a paraméterként kapott aminósavat a saját aminósavjaiból\n\n");
        if (aminos.size() != 0)
            aminos.remove(aminoAcid);
    }

    /**
     * Eltávolítja a paraméterként kapott nukleotidot a saját nukleotidjaiból
     * @param nucleotid             Ezt a nukleotidot tővolítja el
     */
    public void removeNucleo(Nucleotid nucleotid){
        System.out.println("-> RemoveNucleo(Nucleotid nucleotid)\n! Eltávolítja a paraméterként kapott nukleotidot a saját nukleotidjaiból\n\n");
        if (nucleos.size() != 0)
            nucleos.remove(nucleotid);
    }

    /**
     * Eltávolítja a paraméterként kapott felszerelést a saját felszerelést
     * @param equipment             Ezt a felszerelést tővolítja el
     */
    public void removeEquipment(Equipment equipment){
        System.out.println("-> RemoveEquipment(Equipment equipment)\n! Eltávolítja a paraméterként kapott felszerelést a saját felszerelést\n\n");
        if (equipments.size() != 0)
            equipments.remove(equipment);
    }

    /**
     * Eltávolítja a paraméterként kapott ágenst a saját ágenseiből
     * @param agent                 Ezt az ágenst tővolítja el
     */
    public void removeAgent(Agent agent){
        System.out.println("-> RemoveAgent(Agent Agent)\n! Eltávolítja a paraméterként kapott ágenst a saját ágenseiből\n\n");
        if (agents.size() != 0)
            agents.remove(agent);
    }

    /**
     * max_material setterje
     * @param n                     Erre az értékre állítja be
     */
    public void setMax_material(int n){
        System.out.println("-> setMax_material(int n)\n! max_material setterje");
        max_material=max_material+n;

    }



    public List<Equipment> getEquipments() { return equipments; }

    // getterek teszteléshez
    public List<AminoAcid> getAminos() { return aminos; }
    public List<Nucleotid> getNucleos() { return nucleos; }
    public List<Agent> getAgents() { return agents; }

    public void setViro(Virologist viro) {
        this.viro = viro;
    }
}
