package Game;

import Exceptions.FieldNotFoundException;
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

    public void startGame(){
        initTest();
        while(true){

        }
    }

    private void initTest() {
        System.out.println("Give your commands fella");
        Scanner scan = new Scanner(System.in);
        while(!testingFinished){
            String commands = scan.nextLine();
            if(commands.contains("CreateVirologist")){
                String[] splitStrings = commands.split("s+");
                String second = splitStrings[1];
                if(second.contains("lab")){
                    creatVirologistOnField(second);
                } else if(second.contains("who")){
                    creatVirologistOnField(second);
                }else if(second.contains("shl")){
                    creatVirologistOnField(second);
                }else if(second.contains("fid")){
                    creatVirologistOnField(second);
                } else {
                    System.out.println("Wrong command");
                }
            }else if(commands.contains("CreateField")){
                String[] splitStrings = commands.split("s+");
                Field field = new Field();
                for(int i = 1; i < splitStrings.length - 1; i++){
                    String splitString = splitStrings[i];
                    if(splitString.contains("lab")){
                        field.addNeighbour(findFieldByName(splitString));
                    } else if(splitString.contains("fid")){
                        field.addNeighbour(findFieldByName(splitString));
                    } else if(splitString.contains("shl")){
                        field.addNeighbour(findFieldByName(splitString));
                    } else if(splitString.contains("who")){
                        field.addNeighbour(findFieldByName(splitString));
                    }
                }
            }
            for(Field field : Field.getFields()) {
                System.out.println(field.getName() + " " + field.getNeighbours());
            }

        }
    }

    private void creatVirologistOnField(String nextString) {
        try {
            Field field = findFieldByName(nextString);
            Virologist virologist = new Virologist(field);
        } catch(FieldNotFoundException e){
            System.out.println("Field not found with this name: " + nextString);
        }
    }


    private Field findFieldByName(String nextString) {
        for(Field field : Field.getFields()){
            if(field.getName().equals(nextString)) {
                return field;
            }
        }
        throw new FieldNotFoundException();
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
