package com.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TileMap {

    int[][] tileMap = new int[8][26];
    public ArrayList<Rectangle> tileRecs = new ArrayList<>();
    private final BufferedImage image = ImageIO.read(new File("res/sunnyland/PNG/environment/layers/tileset.png"));
    private final BufferedImage background = ImageIO.read(new File("res/sunnyland/PNG/environment/layers/back.png"));

    public TileMap() throws IOException {
        loadMap();
    }

    public BufferedImage grabImage(int row, int col, int width, int height) {
        return image.getSubimage((col*32)-32, (row*32)-32, width, height);
    }

    public void loadMap() throws FileNotFoundException {
        tileRecs.clear();
        Scanner input = new Scanner(new File("res/maps/map1.txt"));
        input.useDelimiter(" ");
        while(input.hasNext())
        {
            for(int row = 0; row < 8; row++)
                for(int col = 0; col < 26; col++) {
                    tileMap[row][col] = Integer.parseInt(input.next());
                    if(tileMap[row][col] != 2)
                        tileRecs.add(new Rectangle(col * 24, row * 24 + 250, 32, 48));
                }
        }
        input.close();
    }

    private final BufferedImage dirt = grabImage(1, 4, 32, 32);
    private final BufferedImage grass = grabImage(1, 2, 32, 32);

    public void draw(Graphics g)
    {
        g.drawImage(background, 0, 0, 640, 400, null);
        for(int row = 0; row < 26; row++){
           for(int col = 0; col < 8; col++){
               if(tileMap[col][row] == 0) {
                  // g.setColor(Color.blue);
                   g.drawImage(grass, row * 24 - 24, col * 24 + 225, 48, 48, null);
                   //g.drawRect(row * 24, col * 24 + 250, 23, 48);
               }
               if(tileMap[col][row] == 1) {
                  // g.setColor(Color.blue);
                   g.drawImage(dirt, row * 24 - 24, col * 24 + 225, 48, 48, null);
                   //g.drawRect(row * 24, col * 24 + 250, 23, 48);
               }
            }
       }
    }
}
