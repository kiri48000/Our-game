package com.mygdx231.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

public class mainmenu extends Game {

    final MyGdxGame1 game;
    SpriteBatch batch;
    OrthographicCamera camera;
    Texture begin1;
    Texture begin2;
    public boolean loading;

    public mainmenu(MyGdxGame1 game) {
        this.game = game;
    }

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        begin1 = new Texture("begin1.jpg");
        begin2 = new Texture("begin2.jpg");
    }

    @Override
    public void render() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        if(game.rand==1) {
            batch.draw(begin1, 0, 0);
        }
        if(game.rand==2){
            batch.draw(begin2,0,0);
        }
        if (Gdx.input.justTouched()) {
            // if program caught touch on screen
            game.touchPos6.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
            game.camera.unproject(game.touchPos6);
            if ((game.touchPos6.x >= 536 && game.touchPos6.x <= 718) && (game.touchPos6.y >= 349 && game.touchPos6.y <= 440)) {
                game.buttons.play();
                loading=true;
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        game.begin = false;
                        game.pause = 0;
                        loading=false;
                    }
                }, 3);
            }
            if ((game.touchPos6.x >= 536 && game.touchPos6.x <= 718) && (game.touchPos6.y >= 91 && game.touchPos6.y <= 182)) {
                game.exit=true;
                game.buttons.play();
            }
        }
        if(loading==true){
            game.nxt.render();
        }
        batch.end();
    }

    @Override
    public void dispose(){
        batch.dispose();
        begin1.dispose();
        begin2.dispose();
    }
}