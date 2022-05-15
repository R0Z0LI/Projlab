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
       this.setExtendedState(JFrame.MAXIMIZED_BOTH); // full screen

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
    public static GameFrame instance(){
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
        if (actualEndGameView != null)
            return;

        this.getContentPane().removeAll();
        actualCommandView.setMaximumSize(new Dimension(this.getWidth()*3/10,this.getHeight()/2));
        actualFieldView.setPreferredSize(new Dimension(this.getWidth()*7/10, this.getHeight()));

        // general
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;

        // Field view
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 2;
        this.add(actualFieldView, c);

        // PH view
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1;
        this.add(actualPropertyHandlerView, c);

        // command view
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        this.add(actualCommandView, c);
        actualCommandView.update();
        //actualCommandView.setBackground(Color.PINK);

        this.validate();
        this.repaint();
    }

    /**
     * Displays the end of the game
     */
    public void displayEndGame() {
        this.getContentPane().removeAll();
        this.setLayout(new BorderLayout());
        this.add(actualEndGameView, BorderLayout.CENTER);
        validate();
        repaint();
    }

    public void setView(FieldView fv) { actualFieldView = fv; }
    public void setView(CommandView cv) { actualCommandView = cv; }
    public void setView(PropertyHandlerView phv) { actualPropertyHandlerView = phv; }
    public void setView(EndGameView egv) { actualEndGameView = egv; }

    public CommandView getActualCommandView() {
        return actualCommandView;
    }
    public PropertyHandlerView getActualPropertyHandlerView() {
        return actualPropertyHandlerView;
    }
}
