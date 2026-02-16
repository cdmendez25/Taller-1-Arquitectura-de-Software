package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;

public class VectorBulletRenderer implements BulletRenderer {

    @Override
    public void render(Graphics g, double x, double y) {
        g.setColor(Color.BLACK);
        // Draw bullet as small dashes/rectangles
        g.fillRect((int) x + Bullet.WIDTH / 2 - 2, (int) y, 4, 10);
    }
}
