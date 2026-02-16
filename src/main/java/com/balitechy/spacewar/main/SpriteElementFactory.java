package com.balitechy.spacewar.main;

import java.io.IOException;

public class SpriteElementFactory implements GameElementFactory {

    private SpritesImageLoader sprites;

    public SpriteElementFactory() {
        sprites = new SpritesImageLoader("/sprites.png");
        try {
            sprites.loadImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PlayerRenderer createPlayerRenderer() {
        return new SpritePlayerRenderer(sprites);
    }

    @Override
    public BulletRenderer createBulletRenderer() {
        return new SpriteBulletRenderer(sprites);
    }

    @Override
    public GameBackgroundRenderer createBackgroundRenderer() {
        return new BitmapBackgroundRenderer();
    }
}
