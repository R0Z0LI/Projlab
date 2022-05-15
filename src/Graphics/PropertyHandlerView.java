package Graphics;

import Agent.*;
import Equipments.*;
import Game.Game;
import Gencode.GenCode;
import Gencode.*;
import PropertyHandler.PropertyHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
        Collection<GenCode> genCodes = myPropertyHandler.getGenCodes().values();
        int j=0;
        for (GenCode g : genCodes) {
            c.gridx = 1 + j++;
            genButtons.add(new JButton(g.getName()));
            this.add(genButtons.get(genButtons.size()-1), c);
        }

        // agents
        c.gridx = 0;
        c.gridy = 3;
        this.add(agentLabel, c);
        List<Agent> agents = myPropertyHandler.getAgents();
        for (int i = 0; i < agents.size(); i++) {
            c.gridx = 1 + i;
            agentButtons.add(new JButton(agents.get(i).getName()));
            this.add(agentButtons.get(agentButtons.size()-1), c);
        }

        // equipment
        c.gridx = 0;
        c.gridy = 4;
        this.add(equipmentLabel, c);
        List<Equipment> equipments = myPropertyHandler.getEquipments();
        for (int i = 0; i < equipments.size(); i++) {
            c.gridx = 1 + i;
            equipmentButtons.add(new JButton(equipments.get(i).getName()));
            this.add(equipmentButtons.get(equipmentButtons.size()-1), c);
        }

        this.validate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton)e.getSource();
        String name = b.getText();
        if (name.contains("amc") || name.contains("cdc") || name.contains("pac") || name.contains("prc") ) {
            genButtonPressed(name);
            Game.actionHappened();
        } else if (name.contains("ama") || name.contains("baa") || name.contains("cda") || name.contains("paa") || name.contains("pra") ) {
            agentButtonPressed(name);
            Game.actionHappened();
        } else if (name.contains("axe") || name.contains("glv") || name.contains("sck") || name.contains("cpe")) {
            equipmentButtonPressed(name);
            Game.actionHappened();
        }
    }

    private void genButtonPressed(String genName) {
        if(genName.contains("amc")){
            for(int i=0; i<myPropertyHandler.getGenCodes().size(); i++){
                if(myPropertyHandler.getGenCodes().get(i).getName().contains("amc")){
                    AmnesiaCode ac= (AmnesiaCode) myPropertyHandler.getGenCodes().get(i);
                    if(myPropertyHandler.getNucleotids().size()>= ac.getNucleoNeeded() && myPropertyHandler.getAminoAcids().size()>=ac.getAminoNeeded()){
                        Agent agent= ac.revealAgent();
                        myPropertyHandler.add(agent);
                        myPropertyHandler.deleteGenCode(ac);
                        update();
                    }
                    return;
                }
            }
        }
        else if(genName.contains("cdc")){
            for(int i=0; i<myPropertyHandler.getGenCodes().size(); i++){
                if(myPropertyHandler.getGenCodes().get(i).getName().contains("cdc")){
                    CrazyDanceCode cc= (CrazyDanceCode) myPropertyHandler.getGenCodes().get(i);
                    if(myPropertyHandler.getNucleotids().size()>= cc.getNucleoNeeded() && myPropertyHandler.getAminoAcids().size()>=cc.getAminoNeeded()){
                        Agent agent= cc.revealAgent();
                        myPropertyHandler.add(agent);
                        myPropertyHandler.deleteGenCode(cc);
                        update();
                    }
                    return;
                }
            }
        }
        else if(genName.contains("pac")){
            for(int i=0; i<myPropertyHandler.getGenCodes().size(); i++){
                if(myPropertyHandler.getGenCodes().get(i).getName().contains("pac")){
                    ParalyseCode pc= (ParalyseCode) myPropertyHandler.getGenCodes().get(i);
                    if(myPropertyHandler.getNucleotids().size()>= pc.getNucleoNeeded() && myPropertyHandler.getAminoAcids().size()>=pc.getAminoNeeded()){
                        Agent agent= pc.revealAgent();
                        myPropertyHandler.add(agent);
                        myPropertyHandler.deleteGenCode(pc);
                        update();
                    }
                    return;
                }
            }
        }
        else if(genName.contains("prc")){
            for(int i=0; i<myPropertyHandler.getGenCodes().size(); i++){
                if(myPropertyHandler.getGenCodes().get(i).getName().contains("prc")){
                    ProtecionCode prc= (ProtecionCode) myPropertyHandler.getGenCodes().get(i);
                    if(myPropertyHandler.getNucleotids().size()>= prc.getNucleoNeeded() && myPropertyHandler.getAminoAcids().size()>=prc.getAminoNeeded()){
                        Agent agent= prc.revealAgent();
                        myPropertyHandler.add(agent);
                        myPropertyHandler.deleteGenCode(prc);
                        update();
                    }
                    return;
                }
            }
        }
    }

    private void agentButtonPressed(String agentName) {
        if(agentName.contains("ama")){
            for(int i=0; i<myPropertyHandler.getAgents().size(); i++){
                if(myPropertyHandler.getAgents().get(i).getName().contains("ama")){
                    AmnesiaAgent aa=(AmnesiaAgent) myPropertyHandler.getAgents().get(i);
                    aa.addBehavior(myPropertyHandler.getVirologist());
                    myPropertyHandler.remove(aa);
                    update();
                }
            }
        }

        else if(agentName.contains("baa")){
            for(int i=0; i<myPropertyHandler.getAgents().size(); i++){
                if(myPropertyHandler.getAgents().get(i).getName().contains("baa")){
                    BearDanceAgent bda=(BearDanceAgent) myPropertyHandler.getAgents().get(i);
                    bda.addBehavior(myPropertyHandler.getVirologist());
                    myPropertyHandler.remove(bda);
                    update();
                }
            }
        }

        else if(agentName.contains("cda")){
            for(int i=0; i<myPropertyHandler.getAgents().size(); i++){
                if(myPropertyHandler.getAgents().get(i).getName().contains("cda")){
                    CrazyDanceAgent cda=(CrazyDanceAgent) myPropertyHandler.getAgents().get(i);
                    cda.addBehavior(myPropertyHandler.getVirologist());
                    myPropertyHandler.remove(cda);
                    update();
                }
            }
        }

        else if(agentName.contains("paa")){
            for(int i=0; i<myPropertyHandler.getAgents().size(); i++){
                if(myPropertyHandler.getAgents().get(i).getName().contains("paa")){
                    ParalyseAgent paa=(ParalyseAgent) myPropertyHandler.getAgents().get(i);
                    paa.addBehavior(myPropertyHandler.getVirologist());
                    myPropertyHandler.remove(paa);
                    update();
                }
            }
        }

        else if(agentName.contains("pra")){
            for(int i=0; i<myPropertyHandler.getAgents().size(); i++){
                if(myPropertyHandler.getAgents().get(i).getName().contains("pra")){
                    ProtectionAgent pra=(ProtectionAgent) myPropertyHandler.getAgents().get(i);
                    pra.addBehavior(myPropertyHandler.getVirologist());
                    myPropertyHandler.remove(pra);
                    update();
                }
            }
        }
    }

    private void equipmentButtonPressed(String equipmentName) {
        // get the needed equipment
        Equipment eq = null;
        for(int i = 0; i < myPropertyHandler.getEquipments().size(); i++){
            if(myPropertyHandler.getEquipments().get(i).getName().equals(equipmentName)) {
                eq = myPropertyHandler.getEquipments().get(i);
                break;
            }
        }
        Game.getActiveVirologist().destroy(eq);
        this.update();
    }

    public void activateView(){
        GameFrame.instance().setView(this);
    }

}
