package Graphics;

import Virologist.Virologist;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EndGameView extends JPanel implements ActionListener {
    JButton restartButton;
    JButton exitButton;
    Image backgroundImage;

    public EndGameView(Virologist v) {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(600,600));

        try {
            BufferedImage inputimage = ImageIO.read(new File("src/pictures/end_backGround.jpg"));
            backgroundImage = inputimage.getScaledInstance(1900, 1100, Image.SCALE_DEFAULT);
        } catch(IOException ex ){}

        // initializing the components
        restartButton = new JButton("Restart");
        exitButton = new JButton("Exit");

        // placing the components
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        this.add(new JLabel("A gyoztes nem mas mint: "));
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

        this.validate();
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);
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
        GameFrame.Init();
        GameFrame window = GameFrame.instance();
        window.displayStartGame();
    }

}
