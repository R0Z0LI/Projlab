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
    final public static int ACTIVE_MODE = 0;
    final public static int PASSIVE_MODE = 1;

    /**
     * initialize pics dependent on viroNumber
     *
     * @param viroNumber the id of the viro
     */
    public VirologistView(int viroNumber) {
        BufferedImage inputimage;
        try {
            inputimage = ImageIO.read(new File("src/pictures/stunnedicon.png"));
            stunnedIcon = inputimage.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            inputimage = ImageIO.read(new File("src/pictures/bearicon.png"));
            bearIcon = inputimage.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            inputimage = ImageIO.read(new File("src/pictures/actionicon.png"));
            actionIcon = inputimage.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            int viroPic = viroNumber % 5;
            switch (viroPic) {
                case 0:
                    inputimage = ImageIO.read(new File("src/pictures/viro.png"));
                    break;
                case 1:
                    inputimage = ImageIO.read(new File("src/pictures/viro2.png"));
                    break;
                case 2:
                    inputimage = ImageIO.read(new File("src/pictures/viro3.png"));
                    break;
                case 3:
                    inputimage = ImageIO.read(new File("src/pictures/viro4.png"));
                    break;
                case 4:
                    inputimage = ImageIO.read(new File("src/pictures/viro5.png"));
                    break;
            }
            viroIcon = inputimage.getScaledInstance(200, 250, Image.SCALE_DEFAULT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * displays a virologist
     *
     * @param mode passive or active: determines the position of the viro
     */
    public void displayVirologist(FieldView fv, int mode) {
        if (mode == ACTIVE_MODE) {
            Icon vir= new ImageIcon(viroIcon);
           fv.add(new JLabel(vir));
            return;
        }

    }

    /**
     * displays a bear infected virologist
     *
     * @param mode passive or active: determines the position of the viro
     */
    public void displayBearVirologist(FieldView fv, int mode) {
        ImageIcon icon= new ImageIcon(bearIcon);
        if (mode == ACTIVE_MODE) {
            fv.setVirologistIcon(icon);
            return;
        }
        fv.setChosenVirologistIcon(icon);
    }

    /**
     * displays a stunned virologist
     *
     * @param mode passive or active: determines the position of the viro
     */
    public void displayStunnedVirologist(FieldView fv, int mode) {
        ImageIcon icon= new ImageIcon(stunnedIcon);
        if (mode == ACTIVE_MODE) {
           fv.setVirologistIcon(icon);
           return;
        }
        fv.setChosenVirologistIcon(icon);

    }

    /**
     * displays an action icon
     *
     */
    public void displayAction(FieldView fv) {
        Graphics g = fv.getGraphics();
        g.drawImage(viroIcon, 15, 15, this);
    }
}
