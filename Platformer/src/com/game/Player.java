package com.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Player {

    double x = 200, y = 200;
    double velX = 0;
    double velY = 0;
    double jumpingSpeed = 0;
    int idle_index;
    int run_index;
    int delay = 0;
    int width = 48, height = 48;
    boolean grounded;
    int jumpCount = 0;
    Rectangle playerRec;

    BufferedImage player;
    BufferedImage[] player_idle = new BufferedImage[4];
    BufferedImage[] player_run = new BufferedImage[6];
    BufferedImage[] player_run_left = new BufferedImage[6];

    public static boolean up, left, right, down;

    public Player() throws IOException {
        //idle anims
        player_idle[0] = ImageIO.read(new File("res/sunnyland/PNG/sprites/player/idle/player-idle-1.png"));
        player_idle[1] = ImageIO.read(new File("res/sunnyland/PNG/sprites/player/idle/player-idle-2.png"));
        player_idle[2] = ImageIO.read(new File("res/sunnyland/PNG/sprites/player/idle/player-idle-3.png"));
        player_idle[3] = ImageIO.read(new File("res/sunnyland/PNG/sprites/player/idle/player-idle-4.png"));

        //running anims
        player_run[0] = ImageIO.read(new File("res/sunnyland/PNG/sprites/player/Run/player-run-1.png"));
        player_run[1] = ImageIO.read(new File("res/sunnyland/PNG/sprites/player/Run/player-run-2.png"));
        player_run[2] = ImageIO.read(new File("res/sunnyland/PNG/sprites/player/Run/player-run-3.png"));
        player_run[3] = ImageIO.read(new File("res/sunnyland/PNG/sprites/player/Run/player-run-4.png"));
        player_run[4] = ImageIO.read(new File("res/sunnyland/PNG/sprites/player/Run/player-run-5.png"));
        player_run[5] = ImageIO.read(new File("res/sunnyland/PNG/sprites/player/Run/player-run-6.png"));

        player_run_left[0] = ImageIO.read(new File("res/sunnyland/PNG/sprites/player/Runleft/player-run-1.png"));
        player_run_left[1] = ImageIO.read(new File("res/sunnyland/PNG/sprites/player/Runleft/player-run-2.png"));
        player_run_left[2] = ImageIO.read(new File("res/sunnyland/PNG/sprites/player/Runleft/player-run-3.png"));
        player_run_left[3] = ImageIO.read(new File("res/sunnyland/PNG/sprites/player/Runleft/player-run-4.png"));
        player_run_left[4] = ImageIO.read(new File("res/sunnyland/PNG/sprites/player/Runleft/player-run-5.png"));
        player_run_left[5] = ImageIO.read(new File("res/sunnyland/PNG/sprites/player/Runleft/player-run-6.png"));
    }

    public void update(ArrayList<Rectangle> tiles) {
        playerRec = new Rectangle((int) x + 10, (int) y + 10, width - 20, height - 10);
        delay++;
        CollisionCheck(tiles, playerRec);

        if (up && jumpCount == 1 && jumpingSpeed < 5) {
            while (jumpingSpeed < 5) {
                jumpingSpeed += 0.75;
                velY -= jumpingSpeed;
            }
            KeyHandler.over = false;
            jumpingSpeed = 10;
            jumpCount = 0;
        }

        if (right) {
            player = player_run[run_index];
            velX = 5;
        } else if (left) {
            player = player_run_left[run_index];
            velX = -5;
        }

        if (down) velY = 5;

        if (!right && !left && !up && !down) {
            player = player_idle[idle_index];
        }

        if (!right && !left) velX = 0;
        if (!up && !down) velY = 0;

        if (idle_index >= 3)
            idle_index = 0;
        if (run_index >= 5)
            run_index = 0;
        if (delay >= 7) {
            delay = 0;
            idle_index++;
            run_index++;
        }

        x += velX;
        y += velY;
        if (!grounded)
            y += 3;
    }

    public void CollisionCheck(ArrayList<Rectangle> tiles, Rectangle playerRec)
    {
        for(Rectangle re : tiles)
        {
            double w = 0.5 * (re.width + playerRec.width); // 48
            double h = 0.5 * (re.height + playerRec.height); // 48
            double dx = re.getCenterX() - playerRec.getCenterX(); // 24
            double dy = re.getCenterY() - playerRec.getCenterY();  // 24

            if (Math.abs(dx) < w && Math.abs(dy) < h)//collision checks if the middle of x and y is less than the w & h
            {
                double wy = w * dy; // 1152
                double hx = h * dx; // 1152
                if (wy >= hx) // checks if the width is greater or equal to the height
                    if (wy >= -hx) {//top of block
                        y = (re.y-12) - playerRec.height; //align edges
                        grounded = true;
                        jumpCount = 1;
                    }
                    else { //right of block
                        x = re.x + re.width - 14; //align edges
                    }
                else if (wy >= -hx) { //left of block checks for left collision
                    x = re.x - playerRec.width - 14; //align edges
                }
                else { //bottom of block
                    y = re.y + re.height;//align edges
                }
            } else grounded = false;
        }
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.red);
        g.drawRect(playerRec.x, playerRec.y, playerRec.width, playerRec.height);
        g.drawImage(player, (int)x, (int)y, width, height, null);
    }
}
