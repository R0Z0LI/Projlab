package Graphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class VirologistView extends Canvas {
    private Image viroIcon;
    private Image stunnedViroIcon;
    private Image bearIcon;
    private Image actionIcon;

    /**
     * initialize pics dependent on viroNumber
     * @param viroNumber the id of the viro
     */
    public VirologistView(int viroNumber){
        try {
            stunnedViroIcon = ImageIO.read(new File("src//pictures//stunnedicon.png"));
            bearIcon = ImageIO.read(new File("src//pictures//bearicon.png"));
            actionIcon = ImageIO.read(new File("src//pictures//actionicon.png"));
            int viroPic=viroNumber%5;
            switch(viroPic){
                case 0:
                    stunnedViroIcon = ImageIO.read(new File("src//pictures//viro.png"));
                    break;
                case 1:
                    stunnedViroIcon = ImageIO.read(new File("src//pictures//viro2.png"));
                    break;
                case 2:
                    stunnedViroIcon = ImageIO.read(new File("src//pictures//viro3.png"));
                    break;
                case 3:
                    stunnedViroIcon = ImageIO.read(new File("src//pictures//viro4.png"));
                    break;
                case 4:
                    stunnedViroIcon = ImageIO.read(new File("src//pictures//viro5.png"));
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * displays a virologist
     * @param x coordinate
     * @param y coordinate
     */
    public void displayVirologist(int x, int y){

    }

    /**
     * displays a bear infected virologist
     * @param x coordinate
     * @param y coordinate
     */
    public void displayBearVirologist(int x, int y){

    }

    /**
     * displays a stunned virologist
     * @param x coordinate
     * @param y coordinate
     */
    public void displayStunnedVirologist(int x, int y){

    }

    /**
     * displays an action icon
     * @param x coordinate
     * @param y coordinate
     */
    public void displayAction(int x, int y){

    }
}
