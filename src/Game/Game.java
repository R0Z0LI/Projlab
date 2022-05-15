package Game;

import Field.*;
import Graphics.*;
import Virologist.Virologist;

import java.io.File;
import java.util.ArrayList;

public class Game {
    private static ArrayList<Steppable> steppables = new ArrayList<>();
    private static boolean gameRunning = false;
    private static ArrayList<Virologist> virologists = new ArrayList<>();
    private static Virologist activeVirologist;
    private ArrayList<Field> fields = new ArrayList<>();

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
     * Initializes the map and its virologists
     * @param filePath
     */
    private void gameInit(String filePath) {
        MapInitiater mapIn = new MapInitiater(this);
        mapIn.readFromFile(new File(filePath));
        mapIn.putVirosOnFields(virologists);
    }

    /**
     * futtatja a játékot, sorban meghívja a virológusok yourTurn függvényét a fájl input paraméterekkel
     */
    public static void runGame(){
        if (!gameRunning)
            return;

        GameFrame window = GameFrame.instance();

        // setting active virologist
        if (activeVirologist == null) // start of the game
            activeVirologist = virologists.get(0);
        else if (virologists.indexOf(activeVirologist) + 1 < virologists.size()) // next virologist
            activeVirologist = virologists.get(virologists.indexOf(activeVirologist) + 1);
        else { // if a new round begins
            activeVirologist = virologists.get(0);
            stepSteppabbles();
        }

        // show game parts on the screen
        window.setView(new CommandView(activeVirologist));
        window.setView(new FieldView(activeVirologist));
        window.setView(new PropertyHandlerView(activeVirologist.getPropertyHandler()));
        window.displayGameView();

        activeVirologist.yourTurn(); // automatic behavior, and giving action points
    }

    /**
     * If a virologist did something, then this function is called
     */
    public static void actionHappened() {
        GameFrame.instance().displayGameView(); // update shown screen

        // if end of turn, then step steppables
        if (activeVirologist.getActionCounter() <= 0) {
            runGame();
        }
    }

    public static void removeVirologist(Virologist v){virologists.remove(v);}

    public static void removeSteppable(Steppable s) {
        steppables.remove(s);
    }

    public static void addSteppable(Steppable s) {
        steppables.add(s);
    }

    public static void stepSteppabbles() {
        for (Steppable s : steppables) {
            s.step();
        }
    }

    public static void endGame() {
        gameRunning=false;
        System.out.println("A jatek veget ert.");
        EndGameView endView = new EndGameView(new Virologist("noone"));
        GameFrame.instance().setView(endView);
        GameFrame.instance().displayEndGame();
    }

    public static void endGame(Virologist v) {
        gameRunning = false;
        System.out.println(v.getName()+ " won the game.");
        EndGameView endView = new EndGameView(v);
        GameFrame.instance().setView(endView);
        GameFrame.instance().displayEndGame();
    }

    public void setFields(ArrayList<Field> f) { fields = f; }
    public void setVirologists(ArrayList<Virologist> v) { virologists = v; }

    public static Virologist getActiveVirologist() { return activeVirologist; }
}
