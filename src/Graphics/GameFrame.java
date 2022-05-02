package Graphics;

import javax.swing.*;

public class GameFrame extends JFrame {
    private Menu startMenu;
    private FieldView actualFieldView;
    private CommandView actualCommandView;
    private PropertyHandlerView actualPropertyHandlerView;
    private EndGameView actualEndGameView;

    /**
     * GameFrame constructor
     * Starts with a simple menu.
     */
    public GameFrame() {
        super("Virologist Jam");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        startMenu = new Menu();
        this.add(startMenu);
        this.setVisible(true);
    }

    public void setView(FieldView fv) { actualFieldView = fv; }
    public void setView(CommandView cv) { actualCommandView = cv; }
    public void setView(PropertyHandlerView phv) { actualPropertyHandlerView = phv; }
    public void setView(EndGameView egv) { actualEndGameView = egv; }

    public void displayGameView() {}
    public void displayEndGame() {}

}
