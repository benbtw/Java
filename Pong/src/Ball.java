import java.awt.*;

public class Ball {

    private int x, y, cx, cy, speed, size;

    static final int MAX_SPEED = 7;
    private Color color;

    public Ball(int x, int y, int cx, int cy, int speed, int size, Color color) {
        this.x = x;
        this.y = y;
        this.cx = cx;
        this.cy = cy;
        this.speed = speed;
        this.size = size;
        this.color = color;
    }

    public void bounceOffEdges()
    {
        if(y > 470 - size)
            reverseY();
        else if(y < 0)
            reverseY();
    }

    public void increaseSpeed()
    {
        if(speed < MAX_SPEED){
            speed++;

            cx = (cx / Math.abs(cx)*speed);
            cy = (cy / Math.abs(cy)*speed);
        }
    }

    public void reverseY(){
        cy *= -1;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCx(int cx) {
        this.cx = cx;
    }

    public void setCy(int cy) {
        this.cy = cy;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void reverseX(){
        cx *= -1;
    }

    public void moveBall()
    {
        x += cx;
        y += cy;
    }

    public void paint(Graphics g)
    {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }

    public int getY() {return y;}
    public int getX() {return x;}

    public int getSize() {return size;}
}
