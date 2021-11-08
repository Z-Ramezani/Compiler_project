package google.com;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        File file = getDataFolderFromSystem();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file+ "//3.txt"));
            String lin = reader.readLine();
            while (reader.ready()) {
                String line = reader.readLine();
                String[]s = line.split(" ");
            }
            reader.close();
        } catch (IOException e) {
            System.out.print("Error");
        }
    }
    private static File getDataFolderFromSystem(){
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
