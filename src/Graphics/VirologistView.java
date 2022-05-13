package Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//TODO beállítani a pontos méreteket
public class VirologistView extends Canvas {
    private Image viroIcon;
    private Image stunnedIcon;
    private Image bearIcon;
    private Image actionIcon;
    final public static int ACTIVE_MODE=0;
    final public static int PASSIVE_MODE=1;

    /**
     * initialize pics dependent on viroNumber
     * @param viroNumber the id of the viro
     */
    public VirologistView(int viroNumber){
        BufferedImage inputimage;
        try {
            inputimage = ImageIO.read(new File("src//pictures//stunnedicon.png"));
            stunnedIcon = inputimage.getScaledInstance(100,100,Image.SCALE_DEFAULT);
            inputimage = ImageIO.read(new File("src//pictures//bearicon.png"));
            bearIcon = inputimage.getScaledInstance(100,100, Image.SCALE_DEFAULT);
            inputimage = ImageIO.read(new File("src//pictures//actionicon.png"));
            actionIcon = inputimage.getScaledInstance(100,100,Image.SCALE_DEFAULT);
            int viroPic=viroNumber%5;
            switch(viroPic){
                case 0:
                    inputimage = ImageIO.read(new File("src//pictures//viro.png"));
                    break;
                case 1:
                    inputimage = ImageIO.read(new File("src//pictures//viro2.png"));
                    break;
                case 2:
                    inputimage = ImageIO.read(new File("src//pictures//viro3.png"));
                    break;
                case 3:
                    inputimage = ImageIO.read(new File("src//pictures//viro4.png"));
                    break;
                case 4:
                    inputimage = ImageIO.read(new File("src//pictures//viro5.png"));
                    break;
            }
            viroIcon = inputimage.getScaledInstance(200,250,Image.SCALE_DEFAULT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * displays a virologist
     * @param mode passive or active: determines the position of the viro
     * @param fv the field panel
     */
    public void displayVirologist(FieldView fv, int mode) {
        int x =5;
        int y =5;
        if (mode == ACTIVE_MODE){
            x = 10;
            y = 10;
        }
        Graphics g = fv.getGraphics();
        g.drawImage(viroIcon,x,y,this);
    }

    /**
     * displays a bear infected virologist
     * @param mode passive or active: determines the position of the viro
     *@param fv the field panel
     */
    public void displayBearVirologist(FieldView fv, int mode){
        int x =5;
        int y =5;
        if (mode == ACTIVE_MODE){
            x = 10;
            y = 10;
        }
        Graphics g=fv.getGraphics();
        g.drawImage(viroIcon,x,y,this);
        g.drawImage(bearIcon,x-10,y+10,this);
    }

    /**
     * displays a stunned virologist
     * @param mode passive or active: determines the position of the viro
     * @param fv the field panel
     */
    public void displayStunnedVirologist(FieldView fv, int mode){
        int x =5;
        int y =5;
        if (mode == ACTIVE_MODE){
            x = 10;
            y = 10;
        }
        Graphics g=fv.getGraphics();
        g.drawImage(viroIcon,x,y,this);
        g.drawImage(stunnedIcon,x-10,y+10,this);

    }

    /**
     * displays an action icon
     * @param fv the field panel
     */
    public void displayAction(FieldView fv){
        Graphics g=fv.getGraphics();
        g.drawImage(viroIcon,15,15,this);
    }
}
