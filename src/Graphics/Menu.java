package Graphics;

import Game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Menu extends JPanel implements ActionListener {
    private int virologistNum;
    JButton startButton;
    JButton addButton, removeButton;
    JLabel numberLabel;
    ArrayList<JTextField> names = new ArrayList<>();
    JTextField file;

    /**
     * Menu constructor
     */
    public Menu() {
        this.setLayout(new GridBagLayout());

        // creating the components
        virologistNum = 2;
        names.add(new JTextField("Bob"));
        names.add(new JTextField("John"));
        numberLabel = new JLabel(String.valueOf(virologistNum));
        file = new JTextField("defaultMap.txt");
        startButton = new JButton("Start");
        addButton = new JButton("^");
        removeButton = new JButton("v");

        // placing the components
        GridBagConstraints c = new GridBagConstraints();

        this.add(startButton, c);

        c.gridy = 2;
        c.gridx = 0;
        this.add(addButton, c);

        c.gridy = 3;
        c.gridx = 0;
        this.add(numberLabel, c);

        c.gridy = 4;
        c.gridx = 0;
        this.add(removeButton, c);

        c.gridy = 7;
        c.gridx = 0;
        this.add(file, c);

        drawVirologistNames();

        // setting up buttons
        addButton.addActionListener(this);
        removeButton.addActionListener(this);
        startButton.addActionListener(this);
    }

    /**
     * Handles events
     * @param e the event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(startButton)) {
            startButtonPressed();
        } else if (e.getSource().equals(addButton)) {
            addButtonPressed();
        } else if (e.getSource().equals(removeButton)) {
            removeButtonPressed();
        }
    }

    /**
     * Starts a game
     */
    private void startButtonPressed() {
        Game game = new Game();
        game.start("src//defaultMap.txt");
    }

    /**
     * Adding an extra virologist
     */
    private void addButtonPressed() {
        virologistNum++;
        names.add(new JTextField("Lajos" + virologistNum));
        updateVirologistNum();
        drawVirologistNames();
    }

    /**
     * Removing a virologist
     */
    private void removeButtonPressed() {
        if (virologistNum > 2) {
            virologistNum--;
            removeDrawnVirologistNames();
            names.remove(virologistNum);
            drawVirologistNames();
            updateVirologistNum();
        }
    }


    private void removeDrawnVirologistNames(){
        for(int i = 0; i < virologistNum + 1; i++){
            this.remove(names.get(i));
        }
        this.updateUI();
    }

    /**
     * Draws/Puts the virologist names on the menu
     */
    private void drawVirologistNames() {
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 4;
        for (int i = 0; i < virologistNum; i++) {
            c.gridy = i;
            this.add(names.get(i), c);
        }
        this.updateUI();
    }

    private void updateVirologistNum(){
        numberLabel.setText(String.valueOf(virologistNum));
    }
}
