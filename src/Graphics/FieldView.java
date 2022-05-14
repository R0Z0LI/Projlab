package Graphics;

import Field.Field;
import Virologist.Virologist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FieldView extends JPanel implements ActionListener {
    private Field myField;
    private Virologist activeVirologist;
    private ArrayList<JButton> neighbours = new ArrayList<>();
    private ArrayList<JLabel> neighbourNames = new ArrayList<>();
    private JLabel virologistIcon, chosenVirologistIcon;

    /**
     * Empty constructor
     */
    public FieldView(Virologist v) {
        activeVirologist = v;
        update();
    }

    /*
        -void neighborButtonPressed(JButton pressedButton): a kiválasztott mezőre lépteti a virológust
        + void setVirologistIcon(ImageIcon icon): megjeleníti a virológus képét
        + void setChosenVirologistIcon(ImageIcon icon): megjeleníti az akcióhoz kiválasztott másik virológus képét
     */
    private void neighborButtonPressed(JButton pressedButton) {

    }

    /**
     * Updates the shown FieldView
     */
    public void update() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        // adding neighbour buttons
        this.myField = activeVirologist.getCurrentField();
        ArrayList<Field> myFieldNeighbours = myField.getNeighbours();
        for (int i = 0; i < myFieldNeighbours.size(); i++) {
            c.gridx = i;
            c.gridy = 4;
            JButton neighbourButton = new JButton(myFieldNeighbours.get(i).getName());
            neighbours.add(neighbourButton);
            this.add(neighbourButton, c);
        }

        // TODO - ICONS

        this.myField.setView(this);
    }

    /**
     * Beállítja megjelenésre az aktuális View-t
     */
    public void activateView(){
        GameFrame.Instance().setView(this);
    }

    /**
     * beállítja a mezőn álló aktív virológust és egyben update-eli magát
     * @param v
     */
    public void setActiveVirologist(Virologist v) {
        activeVirologist = v;
        this.update();
    }

    public void setVirologistIcon(ImageIcon icon) {}
    public void setChosenVirologistIcon(ImageIcon icon) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO - step
    }
}
