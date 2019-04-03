import javax.swing.*;
import java.awt.event.*;

public class Main{

    static JFrame mainFrame = new JFrame();
    static JLayeredPane mainPane = new JLayeredPane();
    static Main mainControl = new Main();
    static int frameSize = 800;
    static int componentSize = (frameSize / 4);

    //Add External Components 
    static CoinFlip coinFlip = new CoinFlip();
    static Notes notes = new Notes();

    void frameSetup(int x, int y){
        //Frame Settings
        mainFrame.setSize(x, y);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);

        //Add Components
        mainFrame.add(mainPane);
        mainPane.setSize(x, y);
    }

    void paneSetup(int x, int y){
        //Pane Settings
        mainPane.setSize(x, y);
        mainPane.setVisible(true);
    }

    void iniAll(){
        coinFlip.iniCoinFlip();
        notes.iniNotes();
    }

    public static void main(String[] args){
        mainControl.frameSetup(800, 800);
        Main main = new Main();
        main.iniAll();
    }

}