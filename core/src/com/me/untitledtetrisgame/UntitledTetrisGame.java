package com.me.untitledtetrisgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UntitledTetrisGame extends Game{
    public SpriteBatch batch;
    public BitmapFont font;

    MainMenuScreen mainMenuScreen;

    public final int GAME_WIDTH = 360;
    public final int GAME_HEIGHT = 800;

    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont(); // use libGDX's default Arial font

        mainMenuScreen = new MainMenuScreen(this);

        this.setScreen(mainMenuScreen);
    }

    public void render() {
        super.render(); // important!
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
        mainMenuScreen.getGameScreen().dispose();
        mainMenuScreen.dispose();
    }
}
