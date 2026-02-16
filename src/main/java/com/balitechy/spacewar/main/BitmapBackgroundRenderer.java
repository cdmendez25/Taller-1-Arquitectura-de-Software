package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BitmapBackgroundRenderer implements GameBackgroundRenderer {

    private BufferedImage background;

    public BitmapBackgroundRenderer() {
        try {
            SpritesImageLoader bg = new SpritesImageLoader("/bg.png");
            bg.loadImage();
            background = bg.getImage(0, 0, 640, 480);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(Graphics g, Canvas c) {
        g.drawImage(background, 0, 0, c.getWidth(), c.getHeight(), c);
    }
}
