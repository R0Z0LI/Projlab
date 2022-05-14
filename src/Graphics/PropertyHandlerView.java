package Graphics;

import PropertyHandler.PropertyHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PropertyHandlerView extends JPanel implements ActionListener {
    private PropertyHandler myPropertyHandler;
    private JLabel aminoLabel = new JLabel(), nucleoLabel = new JLabel();
    private JLabel genLabel = new JLabel("GCs:");
    private ArrayList<JButton> genButtons = new ArrayList<>();
    private JLabel agentLabel = new JLabel("Ag:");
    private ArrayList<JButton> agentButtons = new ArrayList<>();
    private JLabel equipmentLabel = new JLabel("Eq");
    private ArrayList<JButton> equipmentButtons = new ArrayList<>();

    public PropertyHandlerView(PropertyHandler ph) {
        myPropertyHandler = ph;

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // labels
        c.gridx = 0;
        c.gridy = 0;
        aminoLabel.setText("Am: " + myPropertyHandler.getAminoAcids().size());
        this.add(aminoLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        aminoLabel.setText("Nu: " + myPropertyHandler.getNucleotids().size());
        this.add(nucleoLabel, c);

        c.gridx = 0;
        c.gridy = 2;
        this.add(genLabel, c);

        c.gridx = 0;
        c.gridy = 4;
        this.add(agentLabel, c);

        c.gridx = 0;
        c.gridy = 6;
        this.add(equipmentLabel, c);

        // buttons

    }

    public void update() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void genButtonPressed(String genName) {}
    private void agentButtonPressed(String agentName) {}
    private void equipmentButtonPressed(String equipmentName) {}

    public void activateView(){
        GameFrame.Instance().setView(this);
    }

}
