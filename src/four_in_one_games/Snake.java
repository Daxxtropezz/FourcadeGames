package four_in_one_games;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.*;

public class Snake extends JFrame implements KeyListener, Runnable {
    // Game Constants
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 530;
    private static final int UNIT_SIZE = 10;
    private static final int DELAY = 100;
    
    // Game Components
    private JPanel gamePanel, scorePanel;
    private JLabel scoreLabel;
    private JButton[] snakeBody = new JButton[500]; // Reduced from 600 to safe value
    private JButton food, bonusFood;
    
    // Game Variables
    private int bodyLength = 3;
    private int score = 0;
    private int[] x = new int[500];
    private int[] y = new int[500];
    private int directionX = UNIT_SIZE;
    private int directionY = 0;
    private boolean running = false;
    private boolean canTurn = true;
    private Thread gameThread;
    private Random random = new Random();

    public Snake() {
        super("SNAKE GAME");
        initializeUI();
        initializeGame();
        
        addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                requestFocusInWindow();
            }
        });
    }

    private void initializeUI() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        
        // Game Panel
        gamePanel = new JPanel();
        gamePanel.setLayout(null);
        gamePanel.setBackground(Color.PINK);
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(gamePanel, BorderLayout.CENTER);
        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();
        
        // Score Panel
        scorePanel = new JPanel();
        scorePanel.setBackground(Color.BLACK);
        scoreLabel = new JLabel("SCORE: 0", JLabel.CENTER);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 18));
        scorePanel.add(scoreLabel);
        add(scorePanel, BorderLayout.SOUTH);
        
        // Food
        food = new JButton();
        food.setEnabled(false);
        food.setBackground(Color.RED);
        food.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        food.setOpaque(true);
        
        bonusFood = new JButton();
        bonusFood.setEnabled(false);
        bonusFood.setBackground(Color.YELLOW);
        bonusFood.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        bonusFood.setOpaque(true);
        
        addKeyListener(this);
        setFocusable(true);
    }

    private void initializeGame() {
        // Clear existing components
        gamePanel.removeAll();
        
        // Initialize snake
        for (int i = 0; i < bodyLength; i++) {
            snakeBody[i] = new JButton();
            snakeBody[i].setEnabled(false);
            snakeBody[i].setBackground(i == 0 ? Color.GREEN.darker() : Color.GREEN);
            snakeBody[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            snakeBody[i].setOpaque(true);
            gamePanel.add(snakeBody[i]);
            
            x[i] = 200 - i * UNIT_SIZE;
            y[i] = 200;
            snakeBody[i].setBounds(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
        }
        
        // Place food
        placeFood();
        gamePanel.add(food);
        
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    private void placeFood() {
        int foodX, foodY;
        boolean validPosition;
        
        do {
            validPosition = true;
            foodX = random.nextInt((WIDTH - UNIT_SIZE) / UNIT_SIZE) * UNIT_SIZE;
            foodY = random.nextInt((HEIGHT - UNIT_SIZE - 30) / UNIT_SIZE) * UNIT_SIZE;
            
            // Check if food overlaps with snake
            for (int i = 0; i < bodyLength; i++) {
                if (x[i] == foodX && y[i] == foodY) {
                    validPosition = false;
                    break;
                }
            }
        } while (!validPosition);
        
        food.setBounds(foodX, foodY, UNIT_SIZE, UNIT_SIZE);
    }

    private void move() {
        if (!running) return;
        
        // Store current positions
        for (int i = bodyLength; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        
        // Move head
        x[0] += directionX;
        y[0] += directionY;
        
        // Wrap around screen edges
        if (x[0] >= WIDTH) x[0] = 0;
        else if (x[0] < 0) x[0] = WIDTH - UNIT_SIZE;
        if (y[0] >= HEIGHT - 30) y[0] = 0;
        else if (y[0] < 0) y[0] = HEIGHT - 30 - UNIT_SIZE;
        
        // Update positions
        for (int i = 0; i < bodyLength; i++) {
            snakeBody[i].setBounds(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
        }
        
        // Check food collision
        if (x[0] == food.getX() && y[0] == food.getY()) {
            growSnake();
            placeFood();
        }
        
        // Check self collision
        for (int i = bodyLength - 1; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                gameOver();
                return;
            }
        }
        
        canTurn = true;
        gamePanel.repaint();
    }

    private void growSnake() {
        snakeBody[bodyLength] = new JButton();
        snakeBody[bodyLength].setEnabled(false);
        snakeBody[bodyLength].setBackground(Color.GREEN);
        snakeBody[bodyLength].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        snakeBody[bodyLength].setOpaque(true);
        gamePanel.add(snakeBody[bodyLength]);
        
        bodyLength++;
        score += 5;
        scoreLabel.setText("SCORE: " + score);
    }

    private void gameOver() {
        running = false;

        // Show game over message
        int option = JOptionPane.showConfirmDialog(
            this, 
            "Game Over! Final Score: " + score + "\nReturn to Game Selection?", 
            "Game Over", 
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE
        );

        // Return to GameSelection regardless of which option is chosen
        EventQueue.invokeLater(() -> {
            this.dispose(); // Close the Snake game window
            new GameSelection().setVisible(true); // Open GameSelection
        });
    }
    
    private void resetGame() {
        bodyLength = 3;
        score = 0;
        directionX = UNIT_SIZE;
        directionY = 0;
        initializeGame();
        scoreLabel.setText("SCORE: 0");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!canTurn) return;
        
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (directionX != UNIT_SIZE) {
                    directionX = -UNIT_SIZE;
                    directionY = 0;
                    canTurn = false;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (directionX != -UNIT_SIZE) {
                    directionX = UNIT_SIZE;
                    directionY = 0;
                    canTurn = false;
                }
                break;
            case KeyEvent.VK_UP:
                if (directionY != UNIT_SIZE) {
                    directionX = 0;
                    directionY = -UNIT_SIZE;
                    canTurn = false;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (directionY != -UNIT_SIZE) {
                    directionX = 0;
                    directionY = UNIT_SIZE;
                    canTurn = false;
                }
                break;
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    @Override
    public void run() {
        while (running) {
            move();
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Snake game = new Snake();
            game.setVisible(true);
            game.setLocationRelativeTo(null);
        });
    }
}