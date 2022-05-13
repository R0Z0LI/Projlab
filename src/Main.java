import Graphics.*;

/**
 * Starts the game in a window, the menu will be shown
 */
public class Main {
    public static void main(String[] args) {
        GameFrame.Init();
        GameFrame window = GameFrame.Instance();
        window.displayStartGame();
    }

}
