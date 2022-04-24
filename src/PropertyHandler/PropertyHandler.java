package PropertyHandler;

import Agent.Agent;
import Equipments.Equipment;
import Gencode.GenCode;
import Materials.AminoAcid;
import Materials.Nucleotid;
import TestSets.TestInOutHandler;
import Virologist.Virologist;
import Game.Game;

import java.util.*;

/**
 * A virológus felszerelését, nyersanyagait, genetikai kódjait, és ágenseit tároló osztály
 */
public class PropertyHandler {
    private int maxMaterial;
    private int maxEquipment;
    private int maxGencode;

    private Virologist virologist;
    private HashMap<Integer, GenCode> genCodes = new HashMap<>();
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
        this.maxMaterial = 6;
        this.maxGencode = 4;
    }

    /**
     * Hozzáadja a paraméterként kapott genetikai kódot a saját genetikai kódjaihoz
     * Ha összegyűlt az összes, szól a játéknak, hogy a virológus győzött
     * @param genCode Ezt adja hozzá
     */
    public void add(GenCode genCode) {
        genCodes.put(genCode.getUid(), genCode);
        System.out.println("Successful collect: "+ genCode.getName()+" collected by "+virologist.getName()+".");
        TestInOutHandler.appendToTestOutput("Successful collect: "+ genCode.getName()+" collected by "+virologist.getName()+".\n");
        if(genCodes.size() == maxGencode)
            Game.endGame(virologist);
    }

    /**
     * Hozzáadja a paraméterként kapott aminósavat a saját aminósavjaihoz
     *
     * @param aminoAcid Ezt az aminósavat adja hozzá
     */
    public void add(AminoAcid aminoAcid) {
        if (maxMaterial > aminoAcids.size()+nucleotids.size()) {
            aminoAcids.add(aminoAcid);
            System.out.println("Successful collect: "+ aminoAcid.getName()+" collected by "+virologist.getName()+".");
            TestInOutHandler.appendToTestOutput("Successful collect: "+ aminoAcid.getName()+" collected by "+virologist.getName()+".\n");
        }
        else{
            System.out.println("There is not enough space in your inventory for "+aminoAcid.getName());
            TestInOutHandler.appendToTestOutput("There is not enough space in your inventory for "+aminoAcid.getName()+"\n");
        }
    }

    /**
     * Hozzáadja a paraméterként kapott nukleotidot a saját nukleotidjaihoz
     *
     * @param nucleotid Ezt a nukleotidot adja hozzá
     */
    public void add(Nucleotid nucleotid) {
        if (maxMaterial > nucleotids.size()+aminoAcids.size()) {
            nucleotids.add(nucleotid);
            System.out.println("Successful collect: "+ nucleotid.getName()+" collected by "+virologist.getName()+".");
            TestInOutHandler.appendToTestOutput("Successful collect: "+ nucleotid.getName()+" collected by "+virologist.getName()+".\n");
        }
        else{
            System.out.println("There is not enough space in your inventory for "+nucleotid.getName());
            TestInOutHandler.appendToTestOutput("There is not enough space in your inventory for "+nucleotid.getName()+"\n");
        }
    }

    /**
     * Hozzáadja a paraméterként kapott felszerelést a saját felszerelést
     *
     * @param equipment Ezt a felszerelést adja hozzá
     */
    public void add(Equipment equipment) {
        if (maxEquipment > equipments.size()) {
            equipments.add(equipment);
            equipment.addBehaviour(virologist);
            System.out.println("Successful collect: "+ equipment.getName()+" collected by "+virologist.getName()+".");
            TestInOutHandler.appendToTestOutput("Successful collect: "+ equipment.getName()+" collected by "+virologist.getName()+".\n");
        }
        else{
            System.out.println("There is not enough space in your inventory for "+equipment.getName());
            TestInOutHandler.appendToTestOutput("There is not enough space in your inventory for "+equipment.getName()+"\n");
        }

    }
    /**
     * Hozzáadja a paraméterként kapott ágenst a saját ágenseihez.
     *
     * @param agent Ezt az ágenst adja hozzá
     */
    public void add(Agent agent) {
        agents.add(agent);
    }
    /**
     * Elkészít egy ágenst, megnézi van e elég aminósav és nukleotid, majd kivonja a tárolóiból ha van, és létrehozza az ágenst
     *
     * @param genCode Ez a genetikai kód alapján hozza létre az ágenst
     */
    public void makeAgent(GenCode genCode) {
        int aminoNeeded = genCode.getAminoNeeded();
        int nucleoNeeded = genCode.getNucleoNeeded();
        if (aminoAcids.size() >= aminoNeeded && nucleotids.size() >= nucleoNeeded) {
            for (int i = 0; i < nucleoNeeded; ++i) {
                nucleotids.remove(0);
            }
            for (int i = 0; i < aminoNeeded;++i) {
                aminoAcids.remove(0);
            }
            Agent createdAgent=genCode.revealAgent();
            add(createdAgent);
            System.out.println(createdAgent.getName()+" successfully created.\n");
        } else {
            System.out.println("There is not enough material in your inventory for this agent to be created.\n");
        }

    }
    /**
     * Eltávolítja a paraméterként kapott genetikai kódot a saját genetikai kódjaiból
     */
    public void deleteGenCodes() {
        genCodes.clear();
    }
    public void deleteGenCode(GenCode code){genCodes.remove(code.getUid());}

    /**
     * Eltávolítja a paraméterként kapott aminósavat a saját aminósavjaiból
     *
     * @param aminoAcid Ezt az aminósavat tővolítja el
     */
    public void remove(AminoAcid aminoAcid) {
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
        if (equipments.size() != 0) {
            equipments.remove(equipment);
            equipment.removeBehavior(virologist);
            System.out.println(equipment.getName()+" successfully removed from "+virologist.getName()+".");
            TestInOutHandler.appendToTestOutput(equipment.getName()+" successfully removed from "+virologist.getName()+".\n");
        }
    }

    /**
     * Eltávolítja a paraméterként kapott ágenst a saját ágenseiből
     *
     * @param agent Ezt az ágenst tővolítja el
     */
    public void remove(Agent agent) {
        if (agents.size() != 0) {
            agents.remove(agent);
        }
    }
    public String toString(){
        String eqips= "";
        String material="";
        String codes="";
        String agen="";
        for(Agent a: agents)
            agen+=a.getName();
        if(agen.equals(""))
            agen="0";
        for(GenCode g: genCodes.values())
            codes+=g.getName();
        if(codes.equals(""))
            codes="0";
        for(AminoAcid a: aminoAcids)
            material+=a.getName();
        for(Nucleotid n: nucleotids)
            material+=n.getName();
        if(material.equals(""))
            material="0";
        for(Equipment e: equipments)
            eqips+=e.getName();
        if(eqips.equals(""))
            eqips="0";

        return material+"\n"+agen+"\n"+eqips+"\n"+codes;
    }

    /**
     * max_material setterje
     *
     * @param n Ezzel az értékkel növeli
     */
    public void changeMaxMaterial(int n) {
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
    public HashMap<Integer, GenCode> getGenCodes() {
        return genCodes;
    }

    public void setVirologist(Virologist virologist) {
        this.virologist = virologist;
    }
}
