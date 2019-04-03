import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;

public class Notes extends Main{
    
    //Component Order - starts from 0
    int componentNumber = 1;
    int x = ((componentNumber % 4) * componentSize);
    int y = ((componentNumber / 4) * componentSize);
    String var;

    //Main Component Setup
    private JButton selectButton = new JButton("Notes");
    void iniNotes(){
        mainPane.add(selectButton, new Integer(1));
        selectButton.setBounds(x, y, componentSize, componentSize);
        selectButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainPane.removeAll();
                mainPane.repaint();
                Notes notes = new Notes();
                notes.iniComponents();
            }
        });
    }

    //Panel Setup
    private JTextArea noteArea = new JTextArea(10, 10);
    private JButton inputButton = new JButton("Enter");
    private JButton cancelButton = new JButton("Return");

    int width = 200;
    int height = 100;
    int noteNumber = 0;

    void iniComponents(){
        mainPane.add(noteArea, new Integer(1));
        mainPane.add(inputButton, new Integer(1));
        mainPane.add(cancelButton, new Integer(1));
        
        //Components Settings
        noteArea.setBounds(50, 50, 200, 100);
        inputButton.setBounds(50, 300, 100, 50);
        cancelButton.setBounds(50, 500, 100, 50);
        
        //inputButton ActionListener
        inputButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Notes notes = new Notes();
                int x_pos = 500;
                int y_pos = (noteNumber * height);
                noteNumber++;
                var = noteArea.getText();

                //New Text
                JTextArea resultArea = new JTextArea();
                mainPane.add(resultArea, new Integer(1));
                resultArea.setEditable(false);
                resultArea.setCursor(null);
                Border blackline = BorderFactory.createLineBorder(Color.black);
                resultArea.setBorder(blackline);
                resultArea.setFocusable(false);
                resultArea.setBounds(x_pos, y_pos, width, height);
                resultArea.setText(var);
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