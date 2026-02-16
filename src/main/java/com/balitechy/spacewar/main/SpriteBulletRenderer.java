package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpriteBulletRenderer implements BulletRenderer {

    private BufferedImage image;

    public SpriteBulletRenderer(SpritesImageLoader sprites) {
        image = sprites.getImage(35, 52, Bullet.WIDTH, Bullet.HEIGHT);
    }

    @Override
    public void render(Graphics g, double x, double y) {
        g.drawImage(image, (int) x, (int) y, null);
    }
}
