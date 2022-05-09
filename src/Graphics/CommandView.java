package Graphics;

import Agent.Agent;
import Collectible.Collectible;
import Field.Field;
import Virologist.Virologist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

public class CommandView extends JPanel implements ActionListener {
    private Virologist myVirologist;
    private Virologist chosenVirologist;
    private JLabel fieldName;
    private JLabel chosenViroName;
    private HashMap<JButton, Virologist> virButtons;
    //?? akkor végül is csak 1 lehet
    private HashMap<JButton, Collectible> thingButtons;
    private JButton applyButton;
    private JButton attackButton;
    private JButton stealButton;
    private JComboBox<String> agentChooser;
    private JComboBox<String> stealableChooser;
    private JButton backButton;

    public CommandView(Virologist myViro){
        myVirologist=myViro;
        applyButton=new JButton("Apply");
        applyButton.addActionListener(this);
        attackButton=new JButton("Attack");
        attackButton.addActionListener(this);
        stealButton=new JButton("Steal");
        stealButton.addActionListener(this);
        backButton=new JButton("Back");
        backButton.addActionListener(this);
        fieldName=new JLabel();
        chosenViroName=new JLabel();
        virButtons=new HashMap<>();
        thingButtons=new HashMap<>();
        update();
    }

    /**
     * displays fieldname, touchable virologists, collectible things
     */
    public void update(){
        this.removeAll();
        //asking for info about viro
        //fieldinfo
        Field field = myVirologist.getCurrentField();
        fieldName.setText(field.getName());
        //otherviros info
        List<Virologist> viros=field.GetTouchableVirologists();
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new GridLayout(10,2,30,50));
        int i=5;
        for(Virologist v :viros){
            JButton vButton=new JButton(v.getName());
            virButtons.put(vButton, v);
            innerPanel.add(vButton, i++);
        }
        //collectible info
        Collectible coll=field.getCollectible();
        JButton thing = new JButton(coll.getName());
        thingButtons.put(thing, coll);
        //displaying everything
        innerPanel.add(fieldName,1);
        innerPanel.add(new JLabel("Vir:"),3);
        if(i%2 ==1) i++;
        innerPanel.add(new JLabel("Thing:"),i);
        innerPanel.add(thing,++i );

    }
    private void virologistChosen(Virologist v){
        chosenVirologist=v;
        chosenViroName.setText(v.getName());
        agentChooser=new JComboBox<>();
        List<Agent> agents= myVirologist.getPropertyHandler().getAgents();
        for(Agent a : agents){
            agentChooser.addItem(a.getName());
        }
        stealableChooser=new JComboBox<>();
        List<Collectible> stealables=myVirologist.getStealableThings();
        for(Collectible c: stealables){
            stealableChooser.addItem(c.getName());
        }
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new GridLayout(5,2,30,50));
        innerPanel.add(chosenViroName,1);
        innerPanel.add(applyButton,3);
        innerPanel.add(stealButton,5);
        innerPanel.add(attackButton,7);
        innerPanel.add(agentChooser,4);
        innerPanel.add(stealableChooser,6);
        innerPanel.add(backButton,9);
        this.add(innerPanel, BorderLayout.CENTER);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(attackButton)) {
            attackButtonPressed();
        } else if (e.getSource().equals(applyButton)) {
            applyButtonPressed();
        } else if (e.getSource().equals(stealButton)) {
            stealButtonPressed();
        }  else if (e.getSource().equals(backButton)) {
            backButtonPressed();
        } else if(virButtons.containsKey(e.getSource())){
            virologistChosen(virButtons.get(e.getSource()));
        }else if(thingButtons.containsKey(e.getSource())){
            thingButtonPressed(thingButtons.get(e.getSource()));
        }
    }
    private void attackButtonPressed(){
        myVirologist.attack(chosenVirologist);
    }
    private void stealButtonPressed(){
        String sName =(String)stealableChooser.getSelectedItem();
        Collectible stealable=null;
        List<Collectible> stealables=myVirologist.getStealableThings();
        for(Collectible c: stealables){
            if(c.getName().equals(sName))
                stealable=c;
        }
        if(stealable!=null)
             myVirologist.steal(stealable, chosenVirologist);
    }
    private void applyButtonPressed(){
        String aName=(String)agentChooser.getSelectedItem();
        List<Agent> agents= myVirologist.getPropertyHandler().getAgents();
        Agent agent=null;
        for(Agent a : agents){
            if(a.getName().equals(aName))
                agent=a;
        }
        if(agent!=null)
            myVirologist.applyAgent(agent, chosenVirologist);
    }
    private void backButtonPressed(){
        update();
    }
    private void thingButtonPressed(Collectible thing){
        myVirologist.collect(thing);
    }
}
