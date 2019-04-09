import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.EventQueue;

public class Snake extends Main{

    //Component Order - starts from 0
    int componentNumber = 2;
    int x = ((componentNumber % 4) * componentSize);
    int y = ((componentNumber / 4) * componentSize);

    //Main Component Setup
    private JButton selectButton = new JButton("Snake");
    void iniSnake(){
        mainPane.add(selectButton, new Integer(1));
        selectButton.setBounds(x, y, componentSize, componentSize);
        selectButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainPane.removeAll();
                mainPane.repaint();
                Snake snake = new Snake();
                snake.iniComponents();
            }
        });
    }

    // Panel Setup
    private JButton cancelButton = new JButton("Return");
    private JPanel snakePane = new JPanel();

    void iniComponents(){
        mainPane.add(cancelButton, new Integer(1));
        mainPane.add(snakePane, new Integer(2));

        //Components Settings
        //x_pos, y_pos, width, height
        cancelButton.setBounds(350, 700, 100, 50);
        snakePane.setBounds(50, 10, 680, 680);
            snakePane.setBackground(Color.BLACK);
        
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