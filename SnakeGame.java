import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.Random;

public class SnakeGame{

    private final JPanel boardPanel = new JPanel();
    private final JFrame boardFrame = new JFrame();

    //Direction (Right = 0, Down = 1, Left = 2, Up = 3)
    private static int DIRECTION = 0;

    //Move Amount and Game Speed
    private final static int MOVE = 10;
    private final static int GAME_SPEED = 20;

    //Game Running Boolean 
    private boolean GAME_RUNNING = true;

    //Board Size and Number of Dots
    private final int B_WIDTH = 680;
    private final int B_HEIGHT = 680;
    private final int DOT_SIZE = 10;
    private static int DOT_NUMBER = 4624;

    //Array to store x and y values
    private static int x_snake[] = new int[DOT_NUMBER];
    private static int y_snake[] = new int[DOT_NUMBER];
    private static int x_apple[] = new int[1];
    private static int y_apple[] = new int[1];

    //Load Icons
    private final ImageIcon iia = new ImageIcon("apple.png");
        private final JLabel apple = new JLabel(iia);

    private final ImageIcon iih = new ImageIcon("head.png");
        private final JLabel snakeHead = new JLabel(iih);

    private final ImageIcon iib = new ImageIcon("dot.png");
        private final JLabel snakeBody = new JLabel(iib);

    //Test Components
    private final JButton moveLeft = new JButton("Left");

    private void iniBoard(){
        boardFrame.setSize(B_WIDTH, B_HEIGHT);
        boardFrame.setVisible(true);
        boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boardFrame.setLayout(null);

        boardPanel.setBounds(0, 0, B_WIDTH, B_HEIGHT);
        boardPanel.setVisible(true);
        boardPanel.setBackground(Color.black);
        boardPanel.setFocusable(true);
        boardPanel.requestFocusInWindow();
        
        boardFrame.add(boardPanel);
    }

    void iniGame(){    
        Random randomNumber = new Random();
        //Make sure all x and y values are multiples of 10 and <= 680)
        //Add Apple
        int appleStartingLocation_x = randomNumber.nextInt(68);
        int appleStartingLocation_y = randomNumber.nextInt(68);
        appleStartingLocation_x = (appleStartingLocation_x * 10);
        appleStartingLocation_y = (appleStartingLocation_y * 10);

        x_apple[0] = appleStartingLocation_x;
        y_apple[0] = appleStartingLocation_y;

        boardPanel.add(apple);
        apple.setBounds(DOT_SIZE, DOT_SIZE, x_apple[0], y_apple[0]);

        //Add Snake Head
        x_snake[0] = 340;
        y_snake[0] = 340;

        boardPanel.add(snakeHead);
        snakeHead.setBounds(DOT_SIZE, DOT_SIZE, x_snake[0], y_snake[0]);
    }

    //(Right = 0, Down = 1, Left = 2, Up = 3)
    void keyListener(){
        boardPanel.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {}
            public void keyPressed(KeyEvent e) {
                SnakeGame snakeGame = new SnakeGame();
                if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
                    DIRECTION = 0;
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
                    DIRECTION = 2;
                } else if (e.getKeyCode() == KeyEvent.VK_UP ) {
                    DIRECTION = 3;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
                    DIRECTION = 1;
                }
            }
        });
    }

    void moveLeft(){
        x_snake[0] = x_snake[0] - MOVE;
        snakeHead.setBounds(DOT_SIZE, DOT_SIZE, x_snake[0], y_snake[0]);
        boardPanel.repaint();
    }

    void moveRight(){
        x_snake[0] = x_snake[0] + MOVE;
        snakeHead.setBounds(DOT_SIZE, DOT_SIZE, x_snake[0], y_snake[0]);
        boardPanel.repaint();     
    }

    void moveUp(){
        y_snake[0] = y_snake[0] - MOVE;
        snakeHead.setBounds(DOT_SIZE, DOT_SIZE, x_snake[0], y_snake[0]);
        boardPanel.repaint();
    }

    void moveDown(){
        y_snake[0] = y_snake[0] + MOVE;
        snakeHead.setBounds(DOT_SIZE, DOT_SIZE, x_snake[0], y_snake[0]);
        boardPanel.repaint();
    }

    //(Right = 0, Down = 1, Left = 2, Up = 3)
    void move() throws InterruptedException{
        while(GAME_RUNNING){
            Thread.sleep(GAME_SPEED);
            if (DIRECTION == 0){
                moveRight();
            }
            else if (DIRECTION == 1){
                moveDown();
            }
            else if (DIRECTION == 2){
                moveLeft();
            }
            else if (DIRECTION == 3){
                moveUp();
            }
        }
    }

    void addRandomApple(){
        Random randomNumber = new Random();
        int appleLocation_x = randomNumber.nextInt(68);
        int appleLocation_y = randomNumber.nextInt(68);
        appleLocation_x = (appleLocation_x * 10);
        appleLocation_y = (appleLocation_y * 10);

        x_apple[0] = appleLocation_x;
        y_apple[0] = appleLocation_y;

        apple.setBounds(DOT_SIZE, DOT_SIZE, x_apple[0], y_apple[0]);
        boardPanel.repaint();
    }

    void detectApple(){
        if (x_snake[0] == x_apple[0] && y_snake[0] == y_apple[0]){
            SnakeGame snakeGame = new SnakeGame();
            snakeGame.addRandomApple();
        }
        else{
        }
    }


    public static void main(String[] args) throws InterruptedException{
        SnakeGame snakeGame = new SnakeGame();
        snakeGame.iniBoard();
        snakeGame.iniGame();
        snakeGame.keyListener();
        System.out.println(x_apple[0] + ", " + y_apple[0]);
        snakeGame.move();
    }
}

/*  

*/
