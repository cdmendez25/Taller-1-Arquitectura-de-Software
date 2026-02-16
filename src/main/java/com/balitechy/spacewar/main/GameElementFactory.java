package com.balitechy.spacewar.main;

public interface GameElementFactory {
    PlayerRenderer createPlayerRenderer();

    BulletRenderer createBulletRenderer();

    GameBackgroundRenderer createBackgroundRenderer();
}
