package google.com;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        File a = getDataFolderFromSystem();
        HashSet number = new HashSet();
         HashSet id = new HashSet();
         HashSet operator = new HashSet();
         HashSet keyword = new HashSet();
        }
    private static File getDataFolderFromSystem() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDragEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int choice = chooser.showOpenDialog(null);
        if (choice != JFileChooser.APPROVE_OPTION) {
            System.out.println("File not selected");
        }
        return chooser.getSelectedFile();

    }
}

    class Extractor {
    public static void Extractor(File f){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f + "//Lex.txt"));
            while (reader.ready()) {
                String line = reader.readLine();
                String[] s = line.split(" ");
                ArrayList lin=new ArrayList();
                for(int i=0 ; i<s.length ; i++)
                    lin.add(s[i]);

            }
            reader.close();
        } catch(
        IOException e)
        {
            System.out.print("Error");
        }
    }
}
