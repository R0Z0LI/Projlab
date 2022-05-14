package Graphics;

import Agent.Agent;
import Equipments.Equipment;
import Gencode.GenCode;
import PropertyHandler.PropertyHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PropertyHandlerView extends JPanel implements ActionListener {
    private PropertyHandler myPropertyHandler;
    private JLabel aminoLabel = new JLabel(), nucleoLabel = new JLabel();
    private JLabel genLabel = new JLabel("GCs:");
    private ArrayList<JButton> genButtons = new ArrayList<>();
    private JLabel agentLabel = new JLabel("Ag:");
    private ArrayList<JButton> agentButtons = new ArrayList<>();
    private JLabel equipmentLabel = new JLabel("Eq:");
    private ArrayList<JButton> equipmentButtons = new ArrayList<>();

    public PropertyHandlerView(PropertyHandler ph) {
        myPropertyHandler = ph;
        this.setLayout(new GridBagLayout());

        this.update();
    }

    public void update() {
        this.removeAll();

        GridBagConstraints c = new GridBagConstraints();
        c.gridheight = 1;

        // amino
        c.gridx = 0;
        c.gridy = 0;
        aminoLabel.setText("Am: " + myPropertyHandler.getAminoAcids().size());
        this.add(aminoLabel, c);

        // nucleo
        c.gridx = 0;
        c.gridy = 1;
        nucleoLabel.setText("Nu: " + myPropertyHandler.getNucleotids().size());
        this.add(nucleoLabel, c);

        // genCodes
        c.gridx = 0;
        c.gridy = 2;
        this.add(genLabel, c);
        List<GenCode> genCodes = myPropertyHandler.getGenCodes().values().stream().toList();
        for (int i = 0; i < genCodes.size(); i++) {
            c.gridx = 1 + i;
            genButtons.add(new JButton(genCodes.get(i).getName()));
            this.add(genButtons.get(genButtons.size()), c);
        }

        // agents
        c.gridx = 0;
        c.gridy = 3;
        this.add(agentLabel, c);
        List<Agent> agents = myPropertyHandler.getAgents();
        for (int i = 0; i < agents.size(); i++) {
            c.gridx = 1 + i;
            agentButtons.add(new JButton(agents.get(i).getName()));
            this.add(agentButtons.get(agentButtons.size()), c);
        }

        // equipment
        c.gridx = 0;
        c.gridy = 4;
        this.add(equipmentLabel, c);
        List<Equipment> equipments = myPropertyHandler.getEquipments();
        for (int i = 0; i < equipments.size(); i++) {
            c.gridx = 1 + i;
            equipmentButtons.add(new JButton(equipments.get(i).getName()));
            this.add(equipmentButtons.get(equipmentButtons.size()), c);
        }

        this.validate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void genButtonPressed(String genName) {}
    private void agentButtonPressed(String agentName) {}
    private void equipmentButtonPressed(String equipmentName) {}

    public void activateView(){
        GameFrame.instance().setView(this);
    }

}
