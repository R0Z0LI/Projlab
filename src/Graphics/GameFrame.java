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

    public void displayGameView() {
        this.removeAll();
        /*this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight=2;
        this.add(actualFieldView, c);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        this.add(actualPropertyHandlerView, c);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;*/
        this.add(actualCommandView, BorderLayout.CENTER);
        this.setVisible(true);
    }
    public void displayEndGame() {}


}
