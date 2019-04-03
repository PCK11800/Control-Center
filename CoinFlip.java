import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class CoinFlip extends Main{

    //Component Order - starts from 0
    int componentNumber = 0;
    int x = ((componentNumber % 4) * componentSize);
    int y = ((componentNumber / 4) * componentSize);

    //Main Component Setup
    private JButton selectButton = new JButton("FlipACoin!");
    void iniCoinFlip(){
        mainPane.add(selectButton, new Integer(1));
        selectButton.setBounds(x, y, componentSize, componentSize);
        selectButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainPane.removeAll();
                mainPane.repaint();
                CoinFlip coinFlip = new CoinFlip();
                coinFlip.iniComponents();
            }
        });
    }


    //Panel Setup
    private Random rand = new Random();
    private int randomNumber;
    private JButton flipButton = new JButton("Flip!");
    private JLabel resultLabel = new JLabel();
    private ImageIcon heads = new ImageIcon("Heads.jpg");
    private ImageIcon tails = new ImageIcon("Tails.jpg");
    private JButton cancelButton = new JButton("Return");
    
    void iniComponents(){
        mainPane.add(flipButton, new Integer(1));
        mainPane.add(resultLabel, new Integer(1));
        mainPane.add(cancelButton, new Integer(1));

        //Components Settings
        //x_pos, y_pos, width, height
        resultLabel.setBounds(250, 50, 300, 300); 
        flipButton.setBounds(300, 400, 200, 100); 
        cancelButton.setBounds(350, 500, 100, 50); 

        //FlipButton ActionListener
        flipButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                randomNumber = rand.nextInt(2);
                resultLabel.setIcon(heads);
                if(randomNumber == 1){
                    resultLabel.setIcon(tails);
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