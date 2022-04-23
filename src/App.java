import Game.Game;
import TestSets.TestInOutHandler;

public class App {
    public static void main(String[] args){
        //TODO megadni a bemeneti fájlt inicializáláshoz és parancsokhoz pl konstruktorban
        Game game = new Game();
        game.start();
       //TestInOutHandler testHandler = new TestInOutHandler();
        //TODO a többi tesztnél még testHandler.setOutputFile(fájlnév);
        //testHandler.writeInFile();
    }
}
