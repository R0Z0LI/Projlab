package Graphics;
import Agent.Agent;
import Collectible.Collectible;
import Field.Field;
import Game.Game;
import Virologist.Virologist;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
public class CommandView extends JPanel implements ActionListener {
    private Image backgroundImage;
    private Virologist myVirologist;
    private Virologist chosenVirologist;
    private JLabel fieldName;
    private JLabel chosenViroName;
    private HashMap<JButton, Virologist> virButtons;
    private HashMap<JButton, Collectible> thingButtons;
    private JButton applyButton;
    private JButton attackButton;
    private JButton stealButton;
    private JComboBox<String> agentChooser;
    private JComboBox<String> stealableChooser;
    private JButton backButton;
    private JButton endTurnButton;
    private JButton endGameButton;

    public CommandView(Virologist myViro){
        myVirologist = myViro;
        try {
            BufferedImage inputimage = ImageIO.read(new File("src/pictures/commandViewBackground.png"));
            backgroundImage = inputimage.getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        } catch(IOException ex ){}

        applyButton = new JButton("Apply");
        applyButton.addActionListener(this);
        attackButton = new JButton("Attack");
        attackButton.addActionListener(this);
        stealButton = new JButton("Steal");
        stealButton.addActionListener(this);
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        endTurnButton = new JButton("End Turn");
        endTurnButton.addActionListener(this);
        endGameButton = new JButton("End Game");
        endGameButton.addActionListener(this);

        fieldName = new JLabel();
        chosenViroName = new JLabel();
        virButtons = new HashMap<>();
        thingButtons = new HashMap<>();
    }

    /**
     * displays fieldname, touchable virologists, collectible things
     */
    public void update(){
        this.removeAll(); // clears everything
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalGlue());
        this.add(new JLabel("Player: "+myVirologist.getName()));

        // fieldinfo
        Field field = myVirologist.getCurrentField();
        fieldName.setText(field.getName());

        // display labels
        JPanel innerPanel = new JPanel();
        innerPanel.setBackground(new Color(255,201,14));
        innerPanel.setLayout(new GridLayout(0,2,30,50));
        innerPanel.add(new JLabel("Field:"));
        innerPanel.add(fieldName);
        innerPanel.add(new JLabel("Vir:"),2);

        // otherviros info + display viro buttons
        int i = 0;
        List<Virologist> viros = field.GetTouchableVirologists();

        for (Virologist v : viros) {
            JButton vButton = new JButton(v.getName());
            vButton.addActionListener(this);
            vButton.setMaximumSize(new Dimension(1,1));
            virButtons.put(vButton, v);
            innerPanel.add(vButton);
            ++i;
        }

        //ez csak kitoltes
        if(i % 2 == 0) innerPanel.add(new JLabel());
        innerPanel.add(new JLabel("Thing:"));

        //collectible info
        Collectible coll = field.getCollectible();
        JButton thing = null;
        if(coll != null) {
            thing = new JButton(coll.getName());
            thing.addActionListener(this);
            thingButtons.put(thing, coll);
        }

        //displaying collectible thing
        if(coll != null)
            innerPanel.add(thing);


        innerPanel.setMaximumSize(new Dimension(200,(i/2+2)*100));
        this.add(Box.createVerticalGlue());
        this.add(innerPanel);
        this.add(Box.createVerticalGlue());
        this.add(endTurnButton);
        this.add(Box.createVerticalGlue());
        this.add(new JLabel("Actions: "+myVirologist.getActionCounter()+"/3"));
        this.add(Box.createVerticalGlue());
        this.add(endGameButton);
        this.add(Box.createVerticalGlue());


        this.validate();
        this.repaint();

        boolean sad = false;
        if (sad) { GameFrame.instance().displayGameView(); } else { sad = false; }
    }

    /**
     * főképernyőn megjelenít
     */
    public void activateView(){
        GameFrame.instance().setView(this);
    }

    /**
     * virológus gomb megnyomásakor kijelöl egy virológust
     * megjeleníti a vele lehetséges akciókat
     * megjeleníti a kiválasztott virológus képét
     * @param v virológus
     */
    private void virologistChosen(Virologist v){
        this.removeAll();
        //chosen viro
        chosenVirologist=v;
        chosenViroName.setText(v.getName());
        FieldView fv=myVirologist.getCurrentField().getView();
        chosenVirologist.getVirologistView().displayVirologist(fv, VirologistView.PASSIVE_MODE);
        try {
            //agents
            agentChooser = new JComboBox<>();
            List<Agent> agents = myVirologist.getPropertyHandler().getAgents();
            for (Agent a : agents) {
                agentChooser.addItem(a.getName());
            }
            //stealables
            stealableChooser = new JComboBox<>();
            List<Collectible> stealables = myVirologist.getStealableThings();
            for (Collectible c : stealables) {
                stealableChooser.addItem(c.getName());
            }
        }
        catch(NullPointerException ex) {}
        //layout
        JPanel innerPanel = new JPanel();
        innerPanel.setBackground(new Color(255,201,14));
        innerPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        innerPanel.add(chosenViroName,c);
        c.gridx=0;
        c.gridy=1;
        innerPanel.add(applyButton,c);
        c.gridx=0;
        c.gridy=2;
        innerPanel.add(stealButton,c);
        c.gridx=0;
        c.gridy=3;
        innerPanel.add(attackButton,c);
        c.gridx=1;
        c.gridy=1;
        innerPanel.add(agentChooser,c);
        c.gridx=1;
        c.gridy=2;
        innerPanel.add(stealableChooser,c);
        c.gridx=0;
        c.gridy=4;
        innerPanel.add(backButton,c);
        this.add(innerPanel);
        this.validate();
        this.repaint();
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(attackButton)) {
            attackButtonPressed();
            Game.actionHappened();
        } else if (e.getSource().equals(applyButton)) {
            applyButtonPressed();
            Game.actionHappened();
        } else if (e.getSource().equals(stealButton)) {
            stealButtonPressed();
            Game.actionHappened();
        }  else if (e.getSource().equals(backButton)) {
            backButtonPressed();
        }else if(e.getSource().equals(endTurnButton)){
            endTurnButtonPressed();
        }else if(e.getSource().equals(endGameButton)){
            endGameButtonPressed();
        }else if(virButtons.containsKey(e.getSource())){
            virologistChosen(virButtons.get(e.getSource()));
        }else if(thingButtons.containsKey(e.getSource())){
            thingButtonPressed(thingButtons.get(e.getSource()), (JButton)e.getSource());
            GameFrame.instance().getActualPropertyHandlerView().update();
            Game.actionHappened();
        }
    }

    /**
     * támadást indít
     */
    private void attackButtonPressed(){
        myVirologist.attack(chosenVirologist);
        update();
    }

    /**
     * lopást indít
     */
    private void stealButtonPressed(){
        String sName =(String)stealableChooser.getSelectedItem();
        Collectible stealable=null;
        List<Collectible> stealables=myVirologist.getStealableThings();
        for(Collectible c: stealables){
            if(c.getName().equals(sName))
                stealable=c;
        }
        if(stealable!=null) {
            myVirologist.steal(stealable, chosenVirologist);
            update();
        }

    }

    /**
     * kenést indít
     */
    private void applyButtonPressed(){
        String aName=(String)agentChooser.getSelectedItem();
        List<Agent> agents= myVirologist.getPropertyHandler().getAgents();
        Agent agent=null;
        for(Agent a : agents){
            if(a.getName().equals(aName))
                agent=a;
        }
        if(agent!=null)
            if(agent!=null) {
                myVirologist.applyAgent(agent, chosenVirologist);
                update();
            }
    }

    /**
     * törli a kiválasztott virológust, eltünteti a képernyőről
     * frissíti a megjelenítést alaphelyzetbe
     */
    private void backButtonPressed(){
        this.update();
        FieldView fv=myVirologist.getCurrentField().getView();
        fv.removeChosenVirologistIcon();
        fv.update();
    }

    /**
     * a virológus körét befejezi
     */
    private void endTurnButtonPressed() {
        myVirologist.setActionCounter(0);
        Game.actionHappened();
    }

    /**
     * befejezi a játékot
     */
    private void endGameButtonPressed(){
        Game.endGame();
    }
    private void thingButtonPressed(Collectible thing, JButton thingButton){
        myVirologist.collect(thing);
        thingButtons.remove(thingButton);
        this.remove(thingButton);
        update();
    }

    /**
     * beállítja a háttérképet
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);
    }
}