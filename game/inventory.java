package com.mygdx231.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Timer;

public class inventory extends Game {
    final MyGdxGame1 game;
    Texture inventorybar;
    Texture inventoryfull;
    Texture icontop;
    SpriteBatch batch;
    Texture potions;
    Texture potionshield;
    OrthographicCamera camera;
    public Vector3 touchPos7;
    boolean b1 = true;
    boolean b2 =true;
    boolean b3 =true;
    public int b = 0;
    public String potion;
    BitmapFont FontRed1;
    public String potion2;
    Texture potionhelth;
    public String v1;
    public String shield;

    public inventory(final MyGdxGame1 myGdxGame) { game = myGdxGame; }

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        FontRed1 = new BitmapFont();
        FontRed1.setColor(Color.WHITE);

        batch = new SpriteBatch();
        icontop = new Texture("icontop.png");
        potionhelth = new Texture("potionh.png");
        inventoryfull = new Texture("fullinventory.png");
        inventorybar = new Texture("inventory.png");
        potions = new Texture("potions.png");
        potionshield = new Texture("potionshield.png");
    }

    @Override
    public void render() {
        potion = Integer.toString(game.potionh);
        potion2 = Integer.toString(game.potions);
        shield=Integer.toString(game.shield);
        v1 = Integer.toString(game.v);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(inventorybar, 270, 60);
        batch.draw(icontop, 486, 87);
        if (Gdx.input.justTouched()) {
            // if program caught touch on screen
            game.touchPos6.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
            game.camera.unproject(game.touchPos6);

            if ((game.touchPos6.x >= 480 && game.touchPos6.x <= 534) && (game.touchPos6.y >= 60 && game.touchPos6.y <= 125) && game.pause==0) {
                if (b == 1) {
                    b = 0;
                } else
                    b = 1;
            }
        }
            if (b == 1) {
                game.r=false;
                batch.draw(inventoryfull, 10, 288);
                if (Gdx.input.justTouched()) {

                    game.touchPos6.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
                    game.camera.unproject(game.touchPos6);
                    if (game.potionh > 0) {
                        if ((game.touchPos6.x >= 10 && game.touchPos6.x <= 60) && (game.touchPos6.y >= 288 && game.touchPos6.y <= 348) && (game.a < 7) && (game.health < 7) && (game.health > 0) && (game.a > 0) && (game.potionh > 0)) {
                            if (game.potionh >= 1 && b1 == true) {
                                game.potionh--;
                            }
                            if (game.potionh >= 0) {
                                if (b1 == true) {
                                    b1 = false;
                                    Timer.schedule(new Timer.Task() { // задержка и код который должен выполняться после этого времени
                                        @Override
                                        public void run() {
                                            game.a += 1;
                                            game.health += 1;
                                            b1 = true;
                                        }
                                    }, 3);

                                }
                            }
                        }
                    }

                    if ((game.touchPos6.x >= 61 && game.touchPos6.x <= 111) && (game.touchPos6.y >= 288 && game.touchPos6.y <= 348) && (game.potions > 0)) {
                        if (b3 == true && game.potions >= 1) {
                            game.potions--;
                            game.speed += 100;
                        }
                        if (game.potions >= 0) {
                            if (b3 == true) {
                                b3 = false;
                                Timer.schedule(new Timer.Task() { // задержка и код который должен выполняться после этого времени
                                    @Override
                                    public void run() {
                                        game.speed -= 100;
                                        b3 = true;
                                    }
                                }, 10);

                            }
                        }
                    }
                    if ((game.touchPos6.x >= 112 && game.touchPos6.x <= 162) && (game.touchPos6.y >= 288 && game.touchPos6.y <= 348) && (game.shield > 0) && (game.shieldh<=4)) {
                       game.shield--;
                       game.shieldh++;
                    }
                }
                if(game.v>5 || game.potionh>0){
                    FontRed1.draw(batch, potion, 48, 341);
                    batch.draw(potionhelth , 24, 299);
                }
                if(game.potions>0){
                    FontRed1.draw(batch,potion2,101, 341);
                    batch.draw(potions, 76,299);
                }
                if(game.shield>0) {
                    FontRed1.draw(batch, shield, 152, 341);
                    batch.draw(potionshield, 128,299);
                }

            }
            else{
                game.r=true;
            }

            // low bar
        if (Gdx.input.justTouched()) {

            game.touchPos6.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
            game.camera.unproject(game.touchPos6);
            if ((game.touchPos6.x >= 270 && game.touchPos6.x <= 324) && (game.touchPos6.y >= 60 && game.touchPos6.y <= 125) && (game.a < 7) && (game.health < 7) && (game.health > 0) && (game.a > 0) && (game.v <= 10) && (game.v > 0) && game.pause==0) {
                if (game.v >= 1 && b2 == true) {
                    game.v--;
                }
                if (game.v >= 0) {
                    if (b2 == true) {
                        b2 = false;
                        Timer.schedule(new Timer.Task() { // задержка и код который должен выполняться после этого времени
                            @Override
                            public void run() {
                                game.a += 1;
                                game.health += 1;
                                b2 = true;
                            }
                        }, 3);
                    }
                }
            }
        }
        if(game.v>0 ){
            FontRed1.draw(batch, v1, 310, 113);
            batch.draw(potionhelth , 285, 69);
        }
        if(game.potionh==6){
            game.potionh--;
        }
        batch.end();
    }

    @Override
    public void dispose() {
        inventorybar.dispose();
        inventoryfull.dispose();
        icontop.dispose();
        potions.dispose();
        potionshield.dispose();
        batch.dispose();
    }
}