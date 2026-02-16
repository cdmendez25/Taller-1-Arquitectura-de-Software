package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpritePlayerRenderer implements PlayerRenderer {

    private BufferedImage image;

    public SpritePlayerRenderer(SpritesImageLoader sprites) {
        image = sprites.getImage(219, 304, Player.WIDTH, Player.HEIGHT);
    }

    @Override
    public void render(Graphics g, double x, double y) {
        g.drawImage(image, (int) x, (int) y, null);
    }
}
