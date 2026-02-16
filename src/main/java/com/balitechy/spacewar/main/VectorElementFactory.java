package com.balitechy.spacewar.main;

public class VectorElementFactory implements GameElementFactory {

    @Override
    public PlayerRenderer createPlayerRenderer() {
        return new VectorPlayerRenderer();
    }

    @Override
    public BulletRenderer createBulletRenderer() {
        return new VectorBulletRenderer();
    }

    @Override
    public GameBackgroundRenderer createBackgroundRenderer() {
        return new VectorBackgroundRenderer();
    }
}
