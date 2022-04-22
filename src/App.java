import Game.Game;
import TestSets.TestInOutHandler;

public class App {
    public static void main(String[] args){
        Game game = new Game();
        game.start();
        TestInOutHandler testHandler = new TestInOutHandler();
        testHandler.writeInFile();
    }
}
