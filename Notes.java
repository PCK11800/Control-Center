import javax.swing.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;
import java.io.*;

public class Notes extends Main{
    
    //Component Order - starts from 0
    int componentNumber = 1;
    int x = ((componentNumber % 4) * componentSize);
    int y = ((componentNumber / 4) * componentSize);
    String input;

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
    private JButton printText = new JButton("PRINT");

    int width = 200;
    int height = 100;
    int noteNumber = 0;

    void iniComponents(){
        mainPane.add(noteArea, new Integer(1));
        mainPane.add(inputButton, new Integer(1));
        mainPane.add(cancelButton, new Integer(1));
        mainPane.add(printText, new Integer(1));
        
        //Components Settings
        noteArea.setBounds(50, 50, 300, 300);
        noteArea.setLineWrap(true);
        noteArea.setWrapStyleWord(true);
        inputButton.setBounds(50, 400, 100, 50);
        cancelButton.setBounds(50, 500, 100, 50);
        printText.setBounds(50, 600, 100, 50);
        
        //inputButton ActionListener
        inputButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Notes notes = new Notes();     
                int x_pos = 500;
                int y_pos = (noteNumber * height);       
                noteNumber++;
                notes.changenoteNumber(noteNumber);
                input = noteArea.getText();
                notes.newText(x_pos, y_pos, input);

                //To avoid throwsfileexception error
                try {
                    notes.storeTextinFile(input);
                } catch (Exception a) {
                    a.printStackTrace();
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

        //PrintText ActionListener
        printText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Notes notes = new Notes();
                try {
                    notes.readTextinFile();
                } catch (Exception a) {
                    a.printStackTrace();
                }
            }
        });
    }

    void newText(int x, int y, String input){
        JTextArea resultArea = new JTextArea();
        mainPane.add(resultArea, new Integer(1));
        Border blackline = BorderFactory.createLineBorder(Color.black);

        //textArea settings
        resultArea.setBorder(blackline);
        resultArea.setEditable(false);
        resultArea.setCursor(null);
        resultArea.setFocusable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setBounds(x, y, width, height);

        //show input
        resultArea.setText(input);
    }

    //This calls the FileWriter explictily and stores each new input as a new line.
    void storeTextinFile(String input) throws IOException{
        BufferedWriter out = new BufferedWriter(new FileWriter("textstorage.txt", true));
        out.write(input);
        out.write("\n");
        out.write("%");
        out.write("\n");
        out.close();
    }

    //Read from File and prints everything back - work in progress
    void readTextinFile() throws IOException{
        FileReader textfile = new FileReader("textstorage.txt");
        BufferedReader fileRead = new BufferedReader(textfile);
        try{
            String line = fileRead.readLine();
            while (line != null){
                if(!(line.equals("%"))){
                    Notes notes = new Notes();
                    int x_pos = 500;
                    int y_pos = (noteNumber * height);  
                    notes.newText(x_pos, y_pos, line);
                    noteNumber++;
                    notes.changenoteNumber(noteNumber);
                    line = fileRead.readLine();
                }
                else{ //THIS MANAGES TO SKIP THE % YAYAYAYA
                    line = fileRead.readLine();
                }
            }
        }
        finally{
        }
    }

    int changenoteNumber(int x){
        noteNumber = x;
        return noteNumber;
    }

}