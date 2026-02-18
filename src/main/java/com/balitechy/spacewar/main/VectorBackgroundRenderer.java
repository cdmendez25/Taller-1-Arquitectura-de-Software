package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class VectorBackgroundRenderer implements GameBackgroundRenderer {

    @Override
    public void render(Graphics g, Canvas c) {

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, c.getWidth(), c.getHeight());

        g.setColor(Color.BLACK);
        g.drawOval(20, 20, 150, 150);
    }
}
