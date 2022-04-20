package Game;

import Field.Field;
import Gencode.AmnesiaCode;
import Gencode.CrazyDanceCode;
import Gencode.ParalyseCode;
import Gencode.ProtecionCode;
import Materials.AminoAcid;
import Materials.Nucleotid;
import Virologist.Virologist;
import Field.Laboratory;
import Field.Shelter;
import Field.Warehouse;
import Equipments.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private final ArrayList<Steppable> steppables;
    private boolean testingFinished = false;

    public Game() {
        steppables = new ArrayList<>();
    }

    public void addSteppable(Steppable s) {
        steppables.add(s);
    }

    public void startGame() {
        initTest();
        while (true) {

        }
    }

    private void initTest() {
        System.out.println("Give your commands fella");
        Scanner scan = new Scanner(System.in);
        while (!testingFinished) {
            String input = scan.nextLine();
            if (input.contains("CreateVirologist")) {
                String[] split = input.split(" ");
                String parameter = split[1];
                if (parameter.contains("lab") || parameter.contains("who") || parameter.contains("shl") || parameter.contains("fid")) {
                    createVirologistOnField(parameter);
                } else {
                    System.out.println("'" + parameter + "' is not a valid parameter");
                }
            } else if (input.contains("CreateField")) {
                String[] parameters = input.split(" ");
                Field field = new Field();
                for (int i = 1; i < parameters.length; i++) {
                    String parameter = parameters[i];
                    checkAndAddNeighbors(parameter, field);

                }
                System.out.println("Created Field: " + field.toString());
            } else if(input.contains("CreateLabor")){
                String[] parameters = input.split(" ");
                Laboratory laboratory = new Laboratory();
                for(int i = 1; i < parameters.length; i++){
                    String parameter = parameters[i];
                    checkAndAddNeighbors(parameter, laboratory);
                }
            } else if(input.contains("CreateShelter")){
                String[] parameters = input.split(" ");
                Shelter shelter = new Shelter();
                for(int i = 1; i < parameters.length; i++){
                    String parameter = parameters[i];
                    checkAndAddNeighbors(parameter, shelter);
                }
            } else if(input.contains("CreateWareHouse")){
                String[] parameters = input.split(" ");
                Warehouse warehouse = new Warehouse();
                for(int i = 1; i < parameters.length; i++){
                    String parameter = parameters[i];
                    checkAndAddNeighbors(parameter, warehouse);
                }
            } else if(input.contains("CreateAmino")){
                String[] split = input.split(" ");
                String parameter = split[1];
                if (parameter.contains("who")) {
                    createAminoOnField(parameter);
                } else {
                    System.out.println("'" + parameter + "' is not a valid parameter");
                }
            } else if(input.contains("CreateNucleo")){
                String[] split = input.split(" ");
                String parameter = split[1];
                if(parameter.contains("who")){
                    createNucleoOnField(parameter);
                } else {
                    System.out.println("'" + parameter + "' is not a valid parameter");
                }
            } else if(input.contains("CreateGlove")){
                String[] split = input.split(" ");
                String parameter = split[1];
                if(parameter.contains("shl")){
                    createGloveOnField(parameter);
                } else {
                    System.out.println("'" + parameter + "' is not a valid parameter");
                }
            } else if(input.contains("CreateCape")){
                String[] split = input.split(" ");
                String parameter = split[1];
                if(parameter.contains("shl")){
                    createCapeOnField(parameter);
                } else {
                    System.out.println("'" + parameter + "' is not a valid parameter");
                }
            } else if(input.contains("CreateAxe")){
                String[] split = input.split(" ");
                String parameter = split[1];
                if(parameter.contains("shl")){
                    createGloveOnField(parameter);
                } else {
                    System.out.println("'" + parameter + "' is not a valid parameter");
                }
            } else if(input.contains("CreateSack")){
                String[] split = input.split(" ");
                String parameter = split[1];
                if(parameter.contains("shl")){
                    createSackOnField(parameter);
                } else {
                    System.out.println("'" + parameter + "' is not a valid parameter");
                }
            } else if(input.contains("CreateParalyseCode")){
                String[] split = input.split(" ");
                String parameter = split[1];
                if(parameter.contains("lab")){
                    createParalyseCodeOnField(parameter);
                } else {
                    System.out.println("'" + parameter + "' is not a valid parameter");
                }
            } else if(input.contains("CreateAmnesiaCode")){
                String[] split = input.split(" ");
                String parameter = split[1];
                if(parameter.contains("lab")){
                    createAmnesiaCodeOnField(parameter);
                } else {
                    System.out.println("'" + parameter + "' is not a valid parameter");
                }
            } else if(input.contains("CreateProtectionCode")){
                String[] split = input.split(" ");
                String parameter = split[1];
                if(parameter.contains("lab")){
                    createProtectionCodeOnField(parameter);
                } else {
                    System.out.println("'" + parameter + "' is not a valid parameter");
                }
            } else if(input.contains("CreateCrazeyDanceCode")){
                String[] split = input.split(" ");
                String parameter = split[1];
                if(parameter.contains("lab")){
                    createCrazyDanceCodeOnField(parameter);
                } else {
                    System.out.println("'" + parameter + "' is not a valid parameter");
                }
            }
        }
    }

    //TODO kiírásokat átnézni, mert szerintem nem az amit megadtunk
    private void createCrazyDanceCodeOnField(String parameter) {
        Laboratory laboratory = (Laboratory) findFieldByName(parameter);
        if (laboratory != null) {
            //TODO pontos értékek az amino, nucleonak
            ProtecionCode protecionCode = new ProtecionCode(4, 1, laboratory);
            laboratory.add(protecionCode);
            System.out.println("Created ProtectionCode with name " + protecionCode.toString() + ", on field: " + laboratory.toString());
        } else {
            System.out.println("Field does not exist with this name: " + parameter);
        }
    }

    private void createProtectionCodeOnField(String parameter) {
        Laboratory laboratory = (Laboratory) findFieldByName(parameter);
        if (laboratory != null) {
            //TODO pontos értékek az amino, nucleonak
            CrazyDanceCode crazyDanceCode = new CrazyDanceCode(4, 1, laboratory);
            laboratory.add(crazyDanceCode);
            System.out.println("Created CrazyDanceCode with name " + crazyDanceCode.toString() + ", on field: " + laboratory.toString());
        } else {
            System.out.println("Field does not exist with this name: " + parameter);
        }
    }

    private void createAmnesiaCodeOnField(String parameter) {
        Laboratory laboratory = (Laboratory) findFieldByName(parameter);
        if (laboratory != null) {
            //TODO pontos értékek az amino, nucleonak
            AmnesiaCode amnesiaCode = new AmnesiaCode(4, 1, laboratory);
            laboratory.add(amnesiaCode);
            System.out.println("Created AmnesiaCode with name " + amnesiaCode.toString() + ", on field: " + laboratory.toString());
        } else {
            System.out.println("Field does not exist with this name: " + parameter);
        }
    }

    private void createParalyseCodeOnField(String parameter) {
        Laboratory laboratory = (Laboratory) findFieldByName(parameter);
        if (laboratory != null) {
            //TODO pontos értékek az amino, nucleonak
            ParalyseCode paralyseCode = new ParalyseCode(4, 1, laboratory);
            laboratory.add(paralyseCode);
            System.out.println("Created ParalyseCode with name " + paralyseCode.toString() + ", on field: " + laboratory.toString());
        } else {
            System.out.println("Field does not exist with this name: " + parameter);
        }
    }

    private void createSackOnField(String parameter) {
        Shelter shelter = (Shelter) findFieldByName(parameter);
        if (shelter != null) {
            Sack sack = new Sack(shelter);
            shelter.add(sack);
            System.out.println("Created Sack with name " + sack.toString() + ", on field: " + shelter.toString());
        } else {
            System.out.println("Field does not exist with this name: " + parameter);
        }
    }

    private void createCapeOnField(String parameter) {
        Shelter shelter = (Shelter) findFieldByName(parameter);
        if (shelter != null) {
            Cape cape = new Cape(shelter);
            shelter.add(cape);
            System.out.println("Created Cape with name " + cape.toString() + ", on field: " + shelter.toString());
        } else {
            System.out.println("Field does not exist with this name: " + parameter);
        }
    }

    private void createGloveOnField(String parameter) {
        Shelter shelter = (Shelter) findFieldByName(parameter);
        if (shelter != null) {
            Gloves glove = new Gloves(shelter);
            shelter.add(glove);
            System.out.println("Created Glove with name " + glove.toString() + ", on field: " + shelter.toString());
        } else {
            System.out.println("Field does not exist with this name: " + parameter);
        }
    }

    private void createNucleoOnField(String fieldName) {
        Warehouse warehouse = (Warehouse)findFieldByName(fieldName);
        if (warehouse != null) {
            Nucleotid nucleotid = new Nucleotid(warehouse);
            warehouse.add(nucleotid);
            System.out.println("Created Nucleotid with name " + nucleotid.toString() + ", on field: " + warehouse.toString());
        } else {
            System.out.println("Field does not exist with this name: " + fieldName);
        }
    }

    private void createAminoOnField(String fieldName) {
        Warehouse warehouse = (Warehouse) findFieldByName(fieldName);
        if (warehouse != null) {
            AminoAcid aminoAcid = new AminoAcid(warehouse);
            warehouse.add(aminoAcid);
            System.out.println("Created AminoAcid with name " + aminoAcid.toString() + ", on field: " + warehouse.toString());
        } else {
            System.out.println("Field does not exist with this name: " + fieldName);
        }
    }

    private void checkAndAddNeighbors(String parameter, Field field){
        if (parameter.contains("lab") || parameter.contains("fid") || parameter.contains("shl") || parameter.contains("who")) {
            Field neighbour = findFieldByName(parameter);
            if (neighbour != null) {
                field.addNeighbour(neighbour);
                neighbour.addNeighbour(field);
            } else {
                System.out.println("Field does not exist with this name: " + parameter);
            }
        } else if (!parameter.equals("")) {
            System.out.println("'" + parameter + "' is not a valid parameter.");
        }
    }

    private void createVirologistOnField(String fieldName) {
        Field field = findFieldByName(fieldName);
        if (field != null) {
            Virologist virologist = new Virologist(field);
            System.out.println("Created virologist with name " + virologist.getName() + ", on field: " + field.toString());
        } else {
            System.out.println("Field does not exist with this name: " + fieldName);
        }
    }


    private Field findFieldByName(String nextString) {
        for (Field field : Field.getFields()) {
            if (field.toString().equals(nextString)) {
                return field;
            }
        }
        return null;
    }

    public void removeSteppable(Steppable s) {
        steppables.remove(s);
    }

    public void stepSteppabbles() {
        for (Steppable s : steppables) {
            s.step();
        }
    }

    public void endGame() {
        System.out.println("! A jatek veget ert.");
    }


}
