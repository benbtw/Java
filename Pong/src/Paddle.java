import java.awt.*;
public class Paddle {

    private int height, x, y, speed;
    private Color color;

    static final int PADDLE_WIDTH = 15;

    public Paddle(int height, int x, int y, int speed, Color color) {
        this.height = height;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.color = color;
    }

    public void moveTowards(int moveToY)
    {
        int center = y + height / 2; //center of paddle

        if(Math.abs(center - moveToY) > speed) {
            if (center > moveToY)
                y -= speed;

            if (center < moveToY)
                y += speed;
        }
    }

    public boolean checkCollision(Ball b)
    {
        int rightX = x + PADDLE_WIDTH;
        int bottomY = y + height;

        if(b.getX() > (x - b.getSize()) && b.getX() < rightX){
            return b.getY() > y && b.getY() < bottomY;
        }
        return false;
    }

    public void paint(Graphics g)
    {
        g.setColor(color);
        g.fillRect(x, y, PADDLE_WIDTH, height);
    }
}
