package Game;

import Field.Field;
import Virologist.Virologist;

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
                    if (parameter.contains("lab") || parameter.contains("fid") || parameter.contains("shl") || parameter.contains("who")) {
                        Field neighbour = findFieldByName(parameter);
                        if (neighbour != null) {
                            field.addNeighbour(neighbour);
                        } else {
                            System.out.println("Field does not exist with this name: " + parameter);
                        }
                    } else if (!parameter.equals("")) {
                        System.out.println("'" + parameter + "' is not a valid parameter.");
                    }
                }
                System.out.println("Created Field: " + field.toString());
            }
        }
    }

    private void createVirologistOnField(String fieldName) {
        Field field = findFieldByName(fieldName);
        if (field != null) {
            Virologist virologist = new Virologist(field);
            System.out.println("Created virologist with name " + virologist.getName() + ", on field: " + field.getName());
        } else {
            System.out.println("Field does not exist with this name: " + fieldName);
        }
    }


    private Field findFieldByName(String nextString) {
        for (Field field : Field.getFields()) {
            if (field.getName().equals(nextString)) {
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
