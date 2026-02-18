package com.balitechy.spacewar.main;

import java.awt.Color;
import java.awt.Graphics;

public class VectorPlayerRenderer implements PlayerRenderer {

    @Override
    public void render(Graphics g, double x, double y) {
        g.setColor(Color.BLACK);

        int cx = (int) x + Player.WIDTH / 2;
        int top = (int) y;
        int bottomLeft = (int) y + Player.HEIGHT;

        int[] xPoints = { cx, (int) x, (int) x + Player.WIDTH };
        int[] yPoints = { top, bottomLeft, bottomLeft };
        g.drawPolygon(xPoints, yPoints, 3);
    }
}
