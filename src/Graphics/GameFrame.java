package Graphics;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private Menu startMenu;
    private FieldView actualFieldView;
    private CommandView actualCommandView;
    private PropertyHandlerView actualPropertyHandlerView;
    private EndGameView actualEndGameView;
    private static GameFrame theGameFrame;

    /**
     * GameFrame constructor
     * Starts with a simple menu.
     */
    private GameFrame() {
       super("Virologist Jam");
       this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       this.setSize(500, 500);
    }
    public static void Init(){
        theGameFrame=new GameFrame();
    }

    /**
     * this is the singelton object of GameFrame, available from everywhere
     * @return theGameFrame of this game
     */
    public static GameFrame Instance(){
        return theGameFrame;
    }

    public void setView(FieldView fv) { actualFieldView = fv; }
    public void setView(CommandView cv) { actualCommandView = cv; }
    public void setView(PropertyHandlerView phv) { actualPropertyHandlerView = phv; }
    public void setView(EndGameView egv) { actualEndGameView = egv; }

    /**
     * Displays the start of the game - MENU
     */
    public void displayStartGame(){
        startMenu = new Menu();
        this.add(startMenu);
        this.setVisible(true);
    }

    /**
     * Displays the game itself
     */
    public void displayGameView() {
        this.remove(startMenu);
        this.getContentPane().removeAll();
        this.add(actualFieldView);
        actualFieldView.setBackground(Color.CYAN);
        this.add(actualPropertyHandlerView);
        actualPropertyHandlerView.setBackground(Color.BLUE);
        this.add(actualCommandView);
        actualCommandView.setBackground(Color.PINK);
        validate();
    }

    // TODO
    public void displayEndGame() {}
}
