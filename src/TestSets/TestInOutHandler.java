package TestSets;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//TODO ezt használni és beállítani a fájlneveket
public class TestInOutHandler {
    private  File outFile=new File("testout.txt");
    private  File inFile=new File("testin.txt");
    /**
     * több példányt is létre lehet hozni, de mindegyik ezt a kimeneti fájlt fogja szerkeszteni
     */
    private static String fullTestOutput;

    public void setOutputFile(String fileName){
        outFile = new File(fileName);
    }
    public void setInputFile(String fileName){ inFile = new File(fileName); }

    /**+
     * hozzáfűzi a kimeneti stringhez a megadott szöveget
     * @param output ezt kell hozzáfűzni
     */
    public static void appendToTestOutput(String output){
       fullTestOutput= fullTestOutput.concat(output);
    }

    /**+
     * kiírja a tárolt stringet fájlba
     */
    public void writeInFile(){
        try {
            FileWriter writer = new FileWriter(outFile);
            writer.write(fullTestOutput);
            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /**+
     * mindent beolvas az inputfile-ból
     * @return az inputfáj tartalma string-ként változatlanul
     */
    public String getInput(){
        try {
            Scanner sc = new Scanner(inFile);
            String input = new String();
            while(sc.hasNext())
                input=input + sc.next() + "\n";
            sc.close();
            return input;
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    //TODO legyen ilyen?
    public static void writeToConsole(){}
}
