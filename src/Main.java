import Agent.*;
import Field.Field;
import Graphics.FieldView;
import Graphics.*;
import Virologist.Virologist;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GameFrame.Init();
        GameFrame window = GameFrame.Instance();
        window.displayStartGame();
    }

}
