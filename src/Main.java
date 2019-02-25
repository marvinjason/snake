
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.InputStreamReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main
{
    private JFrame frame;
    private JPanel panel;
    private Snake snake;
    
    public Main()
    {
        init();
    }
    
    private void init()
    {
        snake = new Snake();
        
        panel = new JPanel(){

            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                this.setBackground(Color.BLACK);
                g.setColor(Color.DARK_GRAY);
                
                for (int i = 10; i < this.getWidth(); i += 10)
                {
                    g.drawLine(i, 0, i, this.getHeight());
                }
                
                for (int i = 10; i < this.getHeight(); i += 10)
                {
                    g.drawLine(0, i, this.getWidth(), i);
                }
                
                g.setColor(Color.WHITE);
                g.fillRect(snake.getHeadX(), snake.getHeadY(), snake.getLength(), 10);
                
                switch (snake.getDirection())
                {
                    case RIGHT:
                        snake.setHeadX(snake.getHeadX() + 10);
                        break;
                    case LEFT:
                        snake.setHeadX(snake.getHeadX() - 10);
                        break;
                    case UP:
                        snake.setHeadY(snake.getHeadY() - 10);
                        break;
                    case DOWN:
                        snake.setHeadY(snake.getHeadY() + 10);
                        break;
                }
            }
            
        };
        
        panel.setPreferredSize(new Dimension(500, 500));
        
        frame = new JFrame("Snake");
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);
        frame.pack();
        
        frame.addKeyListener(new KeyListener(){

            @Override
            public void keyPressed(KeyEvent e)
            {
                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_RIGHT:
                        if (snake.getDirection() != Direction.RIGHT)
                        {
                            snake.setDirection(Direction.RIGHT);
                            snake.queueTurn();
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (snake.getDirection() != Direction.LEFT)
                        {
                            snake.setDirection(Direction.LEFT);
                            snake.queueTurn();
                        }
                        break;
                    case KeyEvent.VK_UP:
                        if (snake.getDirection() != Direction.UP)
                        {
                            snake.setDirection(Direction.UP);
                            snake.queueTurn();
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (snake.getDirection() != Direction.DOWN)
                        {
                            snake.setDirection(Direction.DOWN);
                            snake.queueTurn();
                        }
                        break;
                    default:
                        break;
                }
            }
            
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
            
        });
        
        try
        {
            while (true)
            {
                Thread.sleep(snake.getSpeed());
                panel.repaint();
            }
        }
        catch (Exception ex)
        {
            System.out.println("Exception Thrown: " + ex.getMessage());
        }
    }
    
    public static void main(String[] args)
    {
        Main main = new Main();
    }
}