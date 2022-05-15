package Graphics;

import Virologist.Virologist;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EndGameView extends  JPanel implements ActionListener {
    JButton restartButton;
    JButton exitButton;


    public EndGameView(Virologist v) {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(600,600));

        // initializing the components
        restartButton = new JButton("Restart");
        exitButton = new JButton("Exit");

        // placing the components
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        this.add(new JLabel("A győztes nem más mint: "));
        this.add(new JLabel(v.getName()));

        c.gridx = 0;
        c.gridy = 3;
        this.add(restartButton, c);

        c.gridx = 0;
        c.gridy = 4;
        this.add(exitButton, c);

        // setting up buttons
        restartButton.addActionListener(this);
        exitButton.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(restartButton)) {
            restartButtonPressed();
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
        if (e.getSource().equals(exitButton)) {
            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
    }

    private void restartButtonPressed() {
        GameFrame gameFrame = GameFrame.instance();
        gameFrame.Init();
    }

}
