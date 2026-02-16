package com.balitechy.spacewar.main;

import java.awt.Graphics;

public class Player {

	private double x;
	private double y;

	private double velX;
	private double velY;

	public static final int WIDTH = 56;
	public static final int HEIGHT = 28;

	private PlayerRenderer renderer;
	private BulletRenderer bulletRenderer;
	private BulletController bullets;

	public Player(double x, double y, PlayerRenderer renderer, BulletRenderer bulletRenderer,
			BulletController bullets) {
		this.x = x;
		this.y = y;
		this.renderer = renderer;
		this.bulletRenderer = bulletRenderer;
		this.bullets = bullets;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	public void shoot() {
		Bullet b = new Bullet(x + (WIDTH / 2) - 5, y - 18, bulletRenderer);
		bullets.addBullet(b);
	}

	public void tick() {
		x += velX;
		y += velY;

		// To avoid player go outside the arena.
		if (x <= 0)
			x = 0;
		if (x >= (Game.WIDTH * Game.SCALE) - WIDTH)
			x = (Game.WIDTH * Game.SCALE) - WIDTH;
		if (y <= 0)
			y = 0;
		if (y >= (Game.HEIGHT * Game.SCALE) - HEIGHT)
			y = (Game.HEIGHT * Game.SCALE) - HEIGHT;
	}

	public void render(Graphics g) {
		renderer.render(g, x, y);
	}
}
