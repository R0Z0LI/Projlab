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
        startMenu = new Menu();
        this.add(startMenu);
        this.setVisible(true);
    }

    /**
     * this is the singelton object of GameFrame, available from everywhere
     * @return theGameFrame of this game
     */
    public static GameFrame Instance(){
        theGameFrame=new GameFrame();
        return theGameFrame;
    }

    public void setView(FieldView fv) { actualFieldView = fv; }
    public void setView(CommandView cv) { actualCommandView = cv; }
    public void setView(PropertyHandlerView phv) { actualPropertyHandlerView = phv; }
    public void setView(EndGameView egv) { actualEndGameView = egv; }

    public void displayGameView() {
        this.remove(startMenu);
        this.add(actualCommandView, BorderLayout.EAST);

    }
    public void displayEndGame() {}

}
