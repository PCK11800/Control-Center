import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Notes extends Main {

    // Component Order - starts from 0
    int componentNumber = 1;
    int x = ((componentNumber % 4) * componentSize);
    int y = ((componentNumber / 4) * componentSize);
    String input;
    String output;

    // Main Component Setup
    private JButton selectButton = new JButton("Notes");
    private JButton cancelButton = new JButton("Return");

    void iniNotes() {
        mainPane.add(selectButton, new Integer(1));
        selectButton.setBounds(x, y, componentSize, componentSize);
        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPane.removeAll();
                mainPane.repaint();
                Notes notes = new Notes();
                notes.iniComponents();
            }
        });
    }

    // Panel Setup
    private JTextArea noteArea = new JTextArea(10, 10);
    private JButton saveButton = new JButton("Save");

    void iniComponents() {
        mainPane.add(noteArea, new Integer(1));
        mainPane.add(cancelButton, new Integer(1));
        mainPane.add(saveButton, new Integer(1));

        // Components Settings
        noteArea.setBounds(50, 50, 700, 600);
        noteArea.setLineWrap(true);
        noteArea.setWrapStyleWord(true);
        cancelButton.setBounds(50, 680, 200, 70);
        saveButton.setBounds(250, 680, 500, 70);

        //What to do
        try {
            FileReader textfile = new FileReader("textstorage.txt");
            BufferedReader fileRead = new BufferedReader(textfile);
            noteArea.read(fileRead, null);
        } catch (Exception a) {
            System.out.println("Load Failed!");
        }

        // saveButton ActionListener
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = noteArea.getText();
                try {
                    FileWriter out = new FileWriter("textstorage.txt");
                    out.write(input);
                    out.close();
                } catch (Exception a) {
                    System.out.println("Save Failed!");
                }
            }
        });

        //CancelButton ActionListener
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainPane.removeAll();
                mainPane.repaint();
                Main main = new Main();
                main.iniAll();
            }
        });
    }
}    