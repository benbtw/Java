import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.concurrent.ExecutionException;

public class PongGame extends JPanel implements MouseMotionListener {
    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;

    private Ball gameBall;
    private Paddle userPaddle, pcPaddle;

    private int userScore, pcScore;
    private int userMouseY;

    int bounceCount = 0;

    public PongGame()
    {
        gameBall = new Ball(300, 200, 3, 3, 3, 10, Color.yellow);
        userPaddle = new Paddle(75, 10, 200, 3, Color.blue);
        pcPaddle = new Paddle(75, 610, 200, 3,  Color.red);

        userMouseY = 0;

        userScore = 0;
        pcScore = 0;

        addMouseMotionListener(this);
    }

    public void gameLogic()
    {
        gameBall.moveBall();
        gameBall.bounceOffEdges();
        userPaddle.moveTowards(userMouseY);
        pcPaddle.moveTowards(gameBall.getY());

        if(pcPaddle.checkCollision(gameBall) || userPaddle.checkCollision(gameBall)){
            gameBall.reverseX();
            bounceCount++;
        }

        if(bounceCount == 5) {
            bounceCount = 0;
            gameBall.increaseSpeed();
        }

        if(gameBall.getX() < 0){
            pcScore++;
            reset();
        } else if(gameBall.getX() > WINDOW_WIDTH){
            userScore++;
            reset();
        }
    }

    public void reset()
    {
        try{
            Thread.sleep(1000);
        } catch (Exception e){
            e.printStackTrace();
        }

        gameBall.setX(300);
        gameBall.setY(200);
        gameBall.setCx(3);
        gameBall.setCy(3);
        gameBall.setSpeed(3);
        bounceCount = 0;
    }

    public void paintComponent(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);

        g.setColor(Color.white);
        g.drawString("Score - User [ " + userScore + " ]  PC [ " + pcScore + " ]", 250, 20);

        gameBall.paint(g);

        userPaddle.paint(g);
        pcPaddle.paint(g);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        userMouseY = e.getY();
    }
}
