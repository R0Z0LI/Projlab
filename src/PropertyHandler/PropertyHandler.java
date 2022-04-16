package PropertyHandler;

import Agent.Agent;
import Equipments.Equipment;
import Gencode.GenCode;
import Materials.AminoAcid;
import Materials.Nucleotid;
import Virologist.Virologist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A virológus felszerelését, nyersanyagait, genetikai kódjait, és ágenseit tároló osztály
 */
public class PropertyHandler {
    private int maxMaterial;
    private int maxEquipment;
    private int maxGencode;

    private Virologist virologist;
    private List<GenCode> genCodes = new ArrayList<>();
    private List<AminoAcid> aminoAcids = new ArrayList<>();
    private List<Nucleotid> nucleotids = new ArrayList<>();
    private List<Agent> agents = new ArrayList<>();
    private List<Equipment> equipments = new ArrayList<>();

    public PropertyHandler(int maxEquipment, int maxGencode, int maxMaterial, Virologist virologist) {
        this.maxEquipment = maxEquipment;
        this.maxGencode = maxGencode;
        this.maxMaterial = maxMaterial;
        this.virologist = virologist;
    }

    public PropertyHandler(Virologist v) {
        this.virologist = v;
        this.maxEquipment = 3;
        this.maxMaterial = 10;
    }

    public PropertyHandler() {
    }

    /**
     * Hozzáadja a paraméterként kapott genetikai kódot a saját genetikai kódjaihoz
     *
     * @param genCode Ezt adja hozzá
     */
    public void add(GenCode genCode) {
        System.out.println("-> Add(GenCode genCode) \n! Hozzáadja a paraméterként kapott genetikai kódot a saját genetikai kódjaihoz \n\n");
        genCodes.add(genCode);
        System.out.println("Ezzel osszegyult az osszes genetikai kód? [i/n]");
        Scanner sc = new Scanner(System.in);
        //TODO lehet automatikus
        if (sc.next().equals("i")) {
            System.out.println("! Játék vége.\n\n");
        }
    }

    /**
     * Hozzáadja a paraméterként kapott aminósavat a saját aminósavjaihoz
     *
     * @param aminoAcid Ezt az aminósavat adja hozzá
     */
    public void add(AminoAcid aminoAcid) {
        System.out.println("-> AddAmino(AminoAcid aminoAcid) \n! Hozzáadja a paraméterként kapott aminósavat a saját aminósavjaihoz\n\n");
        //TODO összes lista size-ra kell ellenőrizni
        if (maxMaterial > aminoAcids.size()) {
            aminoAcids.add(aminoAcid);
        }
    }

    /**
     * Hozzáadja a paraméterként kapott nukleotidot a saját nukleotidjaihoz
     *
     * @param nucleotid Ezt a nukleotidot adja hozzá
     */
    public void add(Nucleotid nucleotid) {
        System.out.println("-> AddNucleo(Nucleotid nucleotid)\n! Hozzáadja a paraméterként kapott nukleotidot a saját nukleotidjaihoz\n\n");
        //TODO összes lista size-ra kell ellenőrizni
        if (maxMaterial > nucleotids.size()) {
            nucleotids.add(nucleotid);
        }
    }

    /**
     * Hozzáadja a paraméterként kapott felszerelést a saját felszerelést
     *
     * @param equipment Ezt a felszerelést adja hozzá
     */
    public void add(Equipment equipment) {
        System.out.println("-> AddEquipment(Equipment equipment)\n ! Hozzáadja a paraméterként kapott felszerelést a saját felszerelést\n\n");
        if (maxEquipment > equipments.size()) {
            equipments.add(equipment);
            equipment.addBehaviour(virologist);
        }
    }

    /**
     * Hozzáadja a paraméterként kapott ágenst a saját ágenseihez.
     *
     * @param agent Ezt az ágenst adja hozzá
     */
    public void add(Agent agent) {
        System.out.println("-> AddAgent(Agent Agent)\n ! Hozzáadja a paraméterként kapott ágenst a saját ágenseihez\n\n");
        agents.add(agent);
    }

    /**
     * Elkészít egy ágenst, megnézi van e elég aminósav és nukleotid, majd kivonja a tárolóiból ha van, és létrehozza az ágenst
     *
     * @param genCode Ez a genetikai kód alapján hozza létre az ágenst
     */
    public void makeAgent(GenCode genCode) {
        System.out.println("-> MakeAgent(GenCode genCode)\n ! Megpróbálja elkésziteni az ágenst.");
        int aminoNeeded = genCode.getAminoNeeded();
        int nucleoNeeded = genCode.getNucleoNeeded();
        if (aminoAcids.size() >= aminoNeeded && nucleotids.size() >= nucleoNeeded) {
            System.out.println("! Van elég anyag az elkészitéshez.\n");
            for (int i = 0; i < nucleoNeeded; i++) {
                nucleotids.remove(0);
            }
            for (int i = 0; i < aminoNeeded; i++) {
                aminoAcids.remove(0);
            }
            genCode.revealAgent();
        } else {
            System.out.println("! Nince elég nyersanyag az elkészitéshez.\n");
        }

    }

    /**
     * Eltávolítja a paraméterként kapott genetikai kódot a saját genetikai kódjaiból
     */
    public void deleteGenCode(GenCode genCode) {
        System.out.println("DeleteGenCodes()\n! Eltávolitja a paraméterként kapott genetikai kódot a saját genetikai kódjaiból\n\n");
    }

    /**
     * Eltávolítja a paraméterként kapott genetikai kódot a saját genetikai kódjaiból
     */
    public void deleteGenCodes() {
        System.out.println("DeleteGenCodes()\n! Eltávolitja az összes genetikai kódot a saját genetikai kódjaiból\n\n");
    }

    /**
     * Eltávolítja a paraméterként kapott aminósavat a saját aminósavjaiból
     *
     * @param aminoAcid Ezt az aminósavat tővolítja el
     */
    public void remove(AminoAcid aminoAcid) {
        System.out.println("-> RemoveAmino(AminoAcid aminoAcid)\n! Eltávolitja a paraméterként kapott aminósavat a saját aminósavjaiból\n\n");
        if (aminoAcids.size() != 0) {
            aminoAcids.remove(aminoAcid);
        }
    }

    /**
     * Eltávolítja a paraméterként kapott nukleotidot a saját nukleotidjaiból
     *
     * @param nucleotid Ezt a nukleotidot tővolítja el
     */
    public void remove(Nucleotid nucleotid) {
        System.out.println("-> RemoveNucleo(Nucleotid nucleotid)\n! Eltávolitja a paraméterként kapott nukleotidot a saját nukleotidjaiból\n\n");
        if (nucleotids.size() != 0) {
            nucleotids.remove(nucleotid);
        }
    }

    /**
     * Eltávolítja a paraméterként kapott felszerelést a saját felszerelést
     *
     * @param equipment Ezt a felszerelést tővolítja el
     */
    public void remove(Equipment equipment) {
        System.out.println("-> RemoveEquipment(Equipment equipment)\n! Eltávolitja a paraméterként kapott felszerelést a saját felszerelést\n\n");
        if (equipments.size() != 0) {
            equipments.remove(equipment);
        }
    }

    /**
     * Eltávolítja a paraméterként kapott ágenst a saját ágenseiből
     *
     * @param agent Ezt az ágenst tővolítja el
     */
    public void remove(Agent agent) {
        System.out.println("-> RemoveAgent(Agent Agent)\n! Eltávolitja a paraméterként kapott ágenst a saját ágenseiből\n\n");
        if (agents.size() != 0) {
            agents.remove(agent);
        }
    }

    /**
     * max_material setterje
     *
     * @param n Erre az értékre állítja be
     */
    public void setMaxMaterial(int n) {
        System.out.println("-> setMax_material(int n)\n! max_material setterje");
        maxMaterial = maxMaterial + n;

    }

    public int getMaxEquipment() {
        return maxEquipment;
    }

    public int getMaxMaterial() {
        return maxMaterial;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    // getterek teszteléshez
    public List<AminoAcid> getAminoAcids() {
        return aminoAcids;
    }

    public List<Nucleotid> getNucleotids() {
        return nucleotids;
    }

    public List<Agent> getAgents() {
        return agents;
    }
    public List<GenCode> getGenCodes() {
        return genCodes;
    }

    public void setVirologist(Virologist virologist) {
        this.virologist = virologist;
    }
}
