package Game;

import Field.*;
import Graphics.CommandView;
import Graphics.FieldView;
import Graphics.GameFrame;
import Graphics.PropertyHandlerView;
import TestSets.TestInOutHandler;
import Virologist.Virologist;

import java.io.File;
import java.util.ArrayList;

public class Game {
    private static ArrayList<Steppable> steppables = new ArrayList<>();
    private static boolean gameRunning = false;
    private static ArrayList<Virologist> virologists = new ArrayList<>();
    private ArrayList<Field> fields = new ArrayList<>();
    TestInOutHandler handler = new TestInOutHandler();

    /**
     * Initializes the map and its virologists
     * @param filePath
     */
    private void gameInit(String filePath) {
        MapInitiater mapIn = new MapInitiater(this);
        mapIn.readFromFile(new File(filePath));
        //putting down virologists on random fields
        mapIn.putVirosOnFields(virologists);
    }

    /**
     * Initializes the map, and starts the game.
     * @param path path to the file that contains the map initialization
     */
    public void start(String path, ArrayList<String> viroNames) {
        //creating the player viros
        for(String name : viroNames){
            virologists.add(new Virologist(name));  //valamiért üres marad...
        }

        gameInit(path); // reading from a file and initializing a map
        gameRunning = true;
        runGame(); // start running the game
    }

    /**
     * futtatja a játékot, sorban meghívja a virológusok yourTurn függvényét a fájl input paraméterekkel
     */
    public void runGame(int test){
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
                        if(currCommand[0].equals("List")) {
                            Field.list(currCommand[1]);
                            currentCommandNum++;
                        }
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
    public void runGame(){
        /*teszt
        GameFrame window = GameFrame.Instance();
        CommandView cv=new CommandView(new Virologist("Alice"));
        cv.activateView();
        window.setView(new PropertyHandlerView());
        window.setView(new FieldView());
        window.displayGameView();
        */
        //TODO
        while(gameRunning){
            for (Virologist activeViro: virologists) {
                activeViro.yourTurn();
            }
            stepSteppabbles();
        }
    }

    public static void removeVirologist(Virologist v){virologists.remove(v);}

    public static void removeSteppable(Steppable s) {
        steppables.remove(s);
    }

    public static void addSteppable(Steppable s) {
        steppables.add(s);
    }

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
        gameRunning = false;
        System.out.println(v.getName()+ " won the game.");
        TestInOutHandler.appendToTestOutput(v.getName()+ " won the game.");
    }

    public TestInOutHandler getHandler() { return handler; }

    public void setFields(ArrayList<Field> f) { fields = f; }
    public void setVirologists(ArrayList<Virologist> v) { virologists = v; }

}
