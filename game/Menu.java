package com.mygdx231.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Menu extends Game {
    final MyGdxGame1 game;
    SpriteBatch batch;
    OrthographicCamera camera;
    Texture pause;
    Texture  returnbig;
    Texture  continueb;
    Texture homepage;
    Texture pause2;

    public Menu(final MyGdxGame1 myGdxGame) { game = myGdxGame; }

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        pause = new Texture("pause.png");
        returnbig = new Texture("returnbig.png");
        continueb = new Texture("continue.png");
        homepage = new Texture("homepage.png");
        pause2 = new Texture("pause2.png");
    }

    @Override
    public void render() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(pause, 740, 420);
        batch.draw(pause, 740, 420);
        if (Gdx.input.justTouched()) {
            // if program caught touch on screen
            game.touchPos6.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
            game.camera.unproject(game.touchPos6);
            if ((game.touchPos6.x >= 740 && game.touchPos6.x <= 790) && (game.touchPos6.y >= 420 && game.touchPos6.y <= 470)) {
                game.buttons.play();
                if (game.pause == 1) {
                    game.pause = 0;
                } else {
                    game.pause = 1;
                }
            }
        }
        if (game.pause == 1) {
            batch.draw(pause2,0,0);
            batch.draw(returnbig, 360, 300);
            batch.draw(returnbig, 360, 300);
            batch.draw(continueb, 500, 300);
            batch.draw(continueb, 500, 300);
            batch.draw(homepage,220,300);
            batch.draw(homepage,220,300);
            batch.draw(returnbig, 360, 300);
            batch.draw(returnbig, 360, 300);
            batch.draw(continueb, 500, 300);
            batch.draw(continueb, 500, 300);
            batch.draw(homepage,220,300);
            batch.draw(homepage,220,300);
            batch.draw(returnbig, 360, 300);
            batch.draw(returnbig, 360, 300);
            batch.draw(continueb, 500, 300);
            batch.draw(continueb, 500, 300);
            batch.draw(homepage,220,300);
            batch.draw(homepage,220,300);
            batch.draw(returnbig, 360, 300);
            batch.draw(returnbig, 360, 300);
            batch.draw(continueb, 500, 300);
            batch.draw(continueb, 500, 300);
            batch.draw(homepage,220,300);
            batch.draw(homepage,220,300);
            batch.draw(returnbig, 360, 300);
            batch.draw(returnbig, 360, 300);
            batch.draw(continueb, 500, 300);
            batch.draw(continueb, 500, 300);
            batch.draw(homepage,220,300);
            batch.draw(homepage,220,300);
            batch.draw(returnbig, 360, 300);
            batch.draw(returnbig, 360, 300);
            batch.draw(continueb, 500, 300);
            batch.draw(continueb, 500, 300);
            batch.draw(homepage,220,300);
            batch.draw(homepage,220,300);
            batch.draw(returnbig, 360, 300);
            batch.draw(returnbig, 360, 300);
            batch.draw(continueb, 500, 300);
            batch.draw(continueb, 500, 300);
            batch.draw(homepage,220,300);
            batch.draw(homepage,220,300);
            batch.draw(returnbig, 360, 300);
            batch.draw(returnbig, 360, 300);
            batch.draw(continueb, 500, 300);
            batch.draw(continueb, 500, 300);
            batch.draw(homepage,220,300);
            batch.draw(homepage,220,300);
            if (Gdx.input.justTouched()) {
                // if program caught touch on screen
                game.touchPos6.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
                game.camera.unproject(game.touchPos6);
                if ((game.touchPos6.x >= 360 && game.touchPos6.x <= 440) && (game.touchPos6.y >= 300 && game.touchPos6.y <= 380)) {
                    game.returnp=true;
                    game.buttons.play();
                }
                if ((game.touchPos6.x >= 500 && game.touchPos6.x <= 580) && (game.touchPos6.y >= 300 && game.touchPos6.y <= 380)) {
                    game.pause=0;
                    game.buttons.play();
                }
                if ((game.touchPos6.x >= 220 && game.touchPos6.x <= 300) && (game.touchPos6.y >= 300 && game.touchPos6.y <= 380)) {
                       game.begin=true;
                       game.rand = (MathUtils.random(1, 2));
                       game.buttons.play();
                }
            }
        }
        batch.end();
    }

    @Override
    public void dispose() {
        returnbig.dispose();
        continueb.dispose();
        continueb.dispose();
        homepage.dispose();
        pause2.dispose();
    }
}
