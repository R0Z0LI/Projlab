package Game;

import Agent.*;
import Behaviors.AxeAttackBehavior;
import Behaviors.CapeDefenseBehavior;
import Behaviors.GloveDefBehavior;
import Gencode.*;
import Materials.*;
import Field.*;
import Equipments.*;
import TestSets.TestInOutHandler;
import Virologist.Virologist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static ArrayList<Steppable> steppables;
    private static boolean gameRunning = false;
    private static ArrayList<Virologist> virologists = new ArrayList<>();
    private ArrayList<Field> fields = new ArrayList<>();
    TestInOutHandler handler = new TestInOutHandler();

    public Game() {
        steppables = new ArrayList<>();
    }

    public static void addSteppable(Steppable s) {
        steppables.add(s);
    }

    /**
     * Initializes the map, and starts the game.
     * @param path path to the file that contains the map initialization
     */
    public void start(String path) {
        readFromFile(new File(path)); // reading from a file and initializing a map
        runGame(); // start running the game
    }

    public ArrayList<Virologist> getVirologists(){
        return virologists;
    }

    /**
     * Reads from a given file, and initializes a map
     * @param file the given file
     */
    private void readFromFile(File file) {
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNext()){
                String input = scan.nextLine();

                // FIELD
                if(input.contains("fid")){
                    Field field = new Field();
                    fields.add(field);

                    // neighbours
                    String fieldNeighbors = scan.nextLine();
                    if(!fieldNeighbors.equals("0")) {
                        String[] split = fieldNeighbors.split(" ");
                        for (int i = 0; i < split.length; i++) {
                            String parameter = split[i];
                            checkAndAddNeighbors(parameter, field);
                        }
                    }

                    // virologists
                    readAfterField(scan, field);

                // LABORATORY
                } else if(input.contains("lab")){
                    Laboratory laboratory = new Laboratory();
                    fields.add(laboratory);

                    // neighbours
                    String fieldNeighbors = scan.nextLine();
                    if(!fieldNeighbors.equals("0")) {
                        String[] split = fieldNeighbors.split(" ");
                        for (int i = 0; i < split.length; i++) {
                            String parameter = split[i];
                            checkAndAddNeighbors(parameter, laboratory);
                        }
                    }

                    // Genetic Codes on lab
                    String codeOnLabor = scan.nextLine();
                    if(!codeOnLabor.equals("0")){
                        if(codeOnLabor.contains("amc")){
                            AmnesiaCode amnesiaCode = new AmnesiaCode(4, 4, laboratory);
                            laboratory.add(amnesiaCode);
                        } else if(codeOnLabor.contains("pac")){
                            ParalyseCode paralyseCode = new ParalyseCode(4, 4, laboratory);
                            laboratory.add(paralyseCode);
                        } else if(codeOnLabor.contains("cdc")){
                            CrazyDanceCode crazyDanceCode = new CrazyDanceCode(4, 4, laboratory);
                            laboratory.add(crazyDanceCode);
                        } else if(codeOnLabor.contains("prc")){
                            ProtecionCode protecionCode = new ProtecionCode(4, 4, laboratory);
                            laboratory.add(protecionCode);
                        }
                    }

                    // Bear agent on lab
                    String bearAgentOnLaboratory = scan.nextLine();
                    if(!bearAgentOnLaboratory.equals("0"))
                        if(bearAgentOnLaboratory.contains("baa"))
                            laboratory.add(new BearDanceAgent());

                    // virologists
                    readAfterField(scan, laboratory);

                // WAREHOUSE
                } else if(input.contains("who")){
                    Warehouse warehouse = new Warehouse();
                    fields.add(warehouse);

                    // neighbours
                    String fieldNeighbors = scan.nextLine();
                    if(!fieldNeighbors.equals("0")){
                        String[] split = fieldNeighbors.split(" ");
                        for (int i = 0; i < split.length; i++) {
                            String parameter = split[i];
                            checkAndAddNeighbors(parameter, warehouse);
                        }
                    }

                    // materials on warhouse
                    String materialOnWareHouse = scan.nextLine();
                    if(!materialOnWareHouse.equals("0")){
                        if(materialOnWareHouse.contains("aac")){
                            AminoAcid aminoAcid = new AminoAcid(warehouse);
                            warehouse.add(aminoAcid);
                        } else if(materialOnWareHouse.contains("ncd")){
                            Nucleotid nucleotid = new Nucleotid(warehouse);
                            warehouse.add(nucleotid);
                        }
                    }

                    // virologists
                    readAfterField(scan, warehouse);

                // SHELTER
                } else if(input.contains("shl")){
                    Shelter shelter = new Shelter();
                    fields.add(shelter);

                    // neighbours
                    String fieldNeighbors = scan.nextLine();
                    if(!fieldNeighbors.equals("0")) {
                        String[] split = fieldNeighbors.split(" ");
                        for (int i = 0; i < split.length; i++) {
                            String parameter = split[i];
                            checkAndAddNeighbors(parameter, shelter);
                        }
                    }

                    // equipment on shelter
                    String equipmentOnShelter = scan.nextLine();
                    if(!equipmentOnShelter.equals("0")){
                        if(equipmentOnShelter.contains("glv")){
                            Gloves gloves = new Gloves(shelter);
                            shelter.add(gloves);
                        } else if(equipmentOnShelter.contains("sck")){
                            Sack sack = new Sack(shelter);
                            shelter.add(sack);
                        } else if(equipmentOnShelter.contains("axe")){
                            Axe axe = new Axe(shelter);
                            shelter.add(axe);
                        } else if(equipmentOnShelter.contains("cpe")){
                            Cape cape = new Cape(shelter);
                            shelter.add(cape);
                        }
                    }
                    // virologists
                    readAfterField(scan, shelter);
                }
            }
            for(Field f: fields){
                System.out.println(f.toString()+"\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reading in virologists
     * @param scan
     * @param field
     */
    private void readAfterField(Scanner scan, Field field) {
        String viro = scan.nextLine();
        // repeatedly reading in virologists until the end of the field init
        do {
            // if there are virologists on the field
            if(!viro.equals("0")) {
                // create and add virologist to the game
                Virologist virologist = new Virologist(field);
                virologists.add(virologist); // adding it to the game
                field.addVirologist(virologist); // adding it to the field

                // materials in the inventory
                String materials = scan.nextLine();
                if (!materials.equals("0")) {
                    String splitMaterial[] = materials.split(" ");
                    for (int i = 0; i < splitMaterial.length; i++) {
                        if (splitMaterial[i].contains("aac")) {
                            AminoAcid aminoAcid = new AminoAcid();
                            virologist.getPropertyHandler().getAminoAcids().add(aminoAcid);
                        } else if (splitMaterial[i].contains(("ncd"))) {
                            Nucleotid nucleotid = new Nucleotid();
                            virologist.getPropertyHandler().getNucleotids().add(nucleotid);
                        }
                    }
                }

                // agents in the inventory
                String agents = scan.nextLine();
                if (!agents.equals("0")) {
                    String splitAgents[] = agents.split(" ");
                    for (int i = 0; i < splitAgents.length; i++) {
                        if (splitAgents[i].contains("ama")) {
                            AmnesiaAgent amnesiaAgent = new AmnesiaAgent(4);
                            virologist.getPropertyHandler().add(amnesiaAgent);
                        } else if (splitAgents[i].contains("paa")) {
                            ParalyseAgent paralyseAgent = new ParalyseAgent();
                            virologist.getPropertyHandler().add(paralyseAgent);
                        } else if (splitAgents[i].contains("cda")) {
                            CrazyDanceAgent crazyDanceAgent = new CrazyDanceAgent(5);
                            virologist.getPropertyHandler().add(crazyDanceAgent);
                        } else if (splitAgents[i].contains("pra")) {
                            ProtectionAgent protectionAgent = new ProtectionAgent(5);
                            virologist.getPropertyHandler().add(protectionAgent);
                        }
                    }
                }

                // equipments in the inventory
                String equipments = scan.nextLine();
                if (!equipments.equals("0")) {
                    String splitEquipments[] = equipments.split(" ");
                    for (int i = 0; i < splitEquipments.length; i++) {
                        if (splitEquipments[i].contains("cpe")) {
                            Cape cape = new Cape();
                            virologist.getPropertyHandler().getEquipments().add(cape);
                            virologist.add(new CapeDefenseBehavior(virologist));
                        } else if (splitEquipments[i].contains("sck")) {
                            Sack sack = new Sack();
                            virologist.getPropertyHandler().getEquipments().add(sack);
                        } else if (splitEquipments[i].contains("glv")) {
                            Gloves gloves = new Gloves();
                            virologist.getPropertyHandler().getEquipments().add(gloves);
                            virologist.add(new GloveDefBehavior(virologist, new Gloves()));
                        } else if (splitEquipments[i].contains("axe")) {
                            Axe axe = new Axe();
                            virologist.getPropertyHandler().getEquipments().add(axe);
                            virologist.add(new AxeAttackBehavior(virologist));
                        }
                    }
                }

                // gencodes in the inventory
                String codes = scan.nextLine();
                if (!codes.equals("0")) {
                    String splitCodes[] = codes.split(" ");
                    for (int i = 0; i < splitCodes.length; i++) {
                        if (splitCodes[i].contains("amc")) {
                            AmnesiaCode amnesiaCode = new AmnesiaCode(4, 4);
                            virologist.getPropertyHandler().getGenCodes().put(amnesiaCode.getUid(),amnesiaCode);
                        } else if (splitCodes[i].contains("prc")) {
                            ProtecionCode protecionCode = new ProtecionCode(4, 4);
                            virologist.getPropertyHandler().getGenCodes().put(protecionCode.getUid(),protecionCode);
                        } else if (splitCodes[i].contains("cdc")) {
                            CrazyDanceCode crazyDanceCode = new CrazyDanceCode(1, 1);
                            virologist.getPropertyHandler().getGenCodes().put(crazyDanceCode.getUid(), crazyDanceCode);
                        } else if (splitCodes[i].contains("pac")) {
                            ParalyseCode paralyseCode = new ParalyseCode(1, 2);
                            virologist.getPropertyHandler().getGenCodes().put(paralyseCode.getUid(), paralyseCode);
                        }
                    }
                }
                scan.nextLine(); // reading in closing vir
            }
            viro = scan.nextLine(); //nextvir or fieldEnd

        } while(viro.startsWith("vir"));
    }

    private void checkAndAddNeighbors(String parameter, Field field){ //lab0 lab1
        if (parameter.contains("lab") || parameter.contains("fid") || parameter.contains("shl") || parameter.contains("who")) {
            for(Field f : fields){
                // if the given neighbour (parameter) is in the game already
                if(f.getName().equals(parameter))
                    field.addNeighbour(f); // just add it as a neighbour
            }
        } else if (!parameter.equals("")) {
            System.out.println("'" + parameter + "' is not a valid parameter.");
        }
    }

    public void addVirologistManually(Virologist virologist){
        virologists.add(virologist);
    }

    /**
     * futtatja a játékot, sorban meghívja a virológusok yourTurn függvényét a fájl input paraméterekkel
     */
    public void runGame(){
        gameRunning = true;
        int roundCounter = 0;
        int currentCommandNum = 0;

        // gets the commands for the test
        String filecontent = handler.getInput();
        String [] allCommands = filecontent.split("\n"); // array with command lines

        // game loop
        while (gameRunning) {
            // 1 turn: goes through every virologist
            for (int i = 1; i <= virologists.size() && allCommands.length > i * roundCounter && gameRunning; ++i) {
                virologists.get(i-1).setActionCounter(2); // every virologist starts with 2 actions

                // TESTING - go through the commands
                while (virologists.get(i-1).getActionCounter() > 0 && allCommands.length > currentCommandNum) {
                    // the current command
                    String[] currCommand = allCommands[currentCommandNum].split(" ");

                    // go through the virologists to find the one that has to the command
                    if (virologists.get(i - 1).getActionCounter() > 0 && currCommand[1].equals(virologists.get(i - 1).getName())) {
                        virologists.get(i - 1).yourTurn(allCommands[currentCommandNum]);
                        currentCommandNum++; // we use up a command
                    } else {
                        // the current command is not directed towards this virologist
                        virologists.get(i - 1).setActionCounter(-1);
                    }

                    // when we kill someone he is removed, it causes bugs -> we don't like that
                    if (currCommand[0].equals("Kill"))
                        i--;

                }

                // stopping the game
                if (allCommands.length <= currentCommandNum )
                    gameRunning = false;
            }
            stepSteppabbles();
            roundCounter++;
        }
    }

    public static void removeSteppable(Steppable s) {
        steppables.remove(s);
    }

    public static void removeVirologist(Virologist v){virologists.remove(v);}

    public void stepSteppabbles() {
        for (Steppable s : steppables) {
            s.step();
        }
    }

    public void endGame() {
        gameRunning=false;
        System.out.println("A jatek veget ert.");
        TestInOutHandler.appendToTestOutput("A jatek veget ert.");
    }

    public static void endGame(Virologist v) {
        gameRunning=false;
        System.out.println("A jatek veget ert.\tGyoztes: "+v.getName());
        TestInOutHandler.appendToTestOutput("A jatek veget ert.\tGyoztes: "+v.getName()+"\n");
    }

    public TestInOutHandler getHandler() { return handler; }

}
