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
    }

    /**
     * Initializes a game instance
     */
    public static void Init(){
        theGameFrame = new GameFrame();
    }

    /**
     * this is the singelton object of GameFrame, available from everywhere
     * @return theGameFrame of this game
     */
    public static GameFrame Instance(){
        return theGameFrame;
    }

    /**
     * Displays the start of the game - MENU
     */
    public void displayStartGame(){
        this.add(startMenu);
        this.setVisible(true);
    }

    /**
     * Displays the game itself
     */
    public void displayGameView() {
        this.getContentPane().removeAll();

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 2;
        //c.insets = new Insets(10, 10, 10, 10);
        this.add(actualFieldView);
        actualFieldView.setBackground(Color.CYAN);

        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1;
        this.add(actualPropertyHandlerView);
        actualPropertyHandlerView.setBackground(Color.BLUE);

        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        this.add(actualCommandView);
        actualCommandView.update();
        actualCommandView.setBackground(Color.PINK);

        this.validate();
        this.repaint();
    }

    // TODO
    public void displayEndGame() {}

    public void setView(FieldView fv) { actualFieldView = fv; }
    public void setView(CommandView cv) { actualCommandView = cv; }
    public void setView(PropertyHandlerView phv) { actualPropertyHandlerView = phv; }
    public void setView(EndGameView egv) { actualEndGameView = egv; }
}
