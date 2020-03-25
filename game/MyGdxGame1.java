package com.mygdx231.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
import com.mygdx231.game.menu.Level0;
import com.mygdx231.game.menu.hit;
import java.util.Iterator;

public class MyGdxGame1 extends Game {
	// bucket is main hero
	// raindrops is enemy or zombies
	// gun is sword
	// cemetery is cemetery
	private static final int FRAME_COLS = 3, FRAME_ROWS = 1;
	private static final int FRAME_COLS1 = 6, FRAME_ROWS1 = 1;
	private static final int FRAME_COLS2 = 3, FRAME_ROWS2 = 1;
	private static final int FRAME_COLS3 = 3, FRAME_ROWS3 = 1;
	private static final int FRAME_COLS4 = 1, FRAME_ROWS4 = 5;
	private static final int FRAME_COLS5 = 1, FRAME_ROWS5 = 5;
	// Objects used
	Animation<TextureRegion> walkAnimation;
	Animation<TextureRegion> fireanim;
	Animation <TextureRegion> zombieWalk;
	Animation <TextureRegion> zombie3;
	Animation <TextureRegion> swordan;
	Animation <TextureRegion> knifel;
	// Must declare frame type (TextureRegion)
	// A variable for tracking elapsed time for the animation
	float stateTime;
    float stateTime1;
    float StateTime2;
	float StateTime3;
	float StateTime4;
	float StateTime5;
	inventory inv;
	nextlevel nxt;
	Menu mn;
	mainmenu mm;
	OrthographicCamera camera;
	SpriteBatch batch;
	Texture zombie;
	Texture walkSheet;
	Texture dropImage;
	Texture rightImage;
	Texture sword;
	Texture bucketImage;
	Texture backGround;
	Texture left;
	Texture fire;
	Texture heart;
	Texture knife;
	Texture bullet;
	Texture attack;
	Texture characterleft;
    Texture door;
	Texture enter;
	Texture level2;
	Texture spawn;
	Texture coing;
	Texture npcleft;
	Texture npcright;
	Texture text;
	Texture backGround1;
	Texture backGround2;
	Texture backGround3;
	Texture cemetery;
	Texture cemetery2;
	Texture cemetery3;
	Texture cemetery4;
	Texture cemetery5;
	Texture zombielvl3;
	Texture shieldhealth;
	Texture stairs;
	Texture up;
	Texture knifeleft;
	Texture  down;
	Rectangle bucket;
	Rectangle gun;
	Rectangle leftbut;
	Rectangle right;
	Rectangle bucketf;
	Rectangle cemetery1;
	Rectangle buckety;
	Rectangle door1;
	Rectangle door2;
	Rectangle npc;
	Rectangle stairs4;
	Vector3 touchPos;
	Vector3 touchPos1;
	Vector3 touchPos2;
    Vector3 touchPos10;
	public Vector3 touchPos6;
	Array<Rectangle> raindrops;
	Array<Rectangle> levels2;
	Array<Rectangle> levels3;
	long lastDropTime;
	long lastDropTime2;
	long lastDropTime3;
	public int health = 7;
	public int a = 7;
	public int coins = 0;
	private BitmapFont FontRed1;
	public String coin;
	float delay = 3;
	public int death = 1;
	int sps = 1;
	int sps2 = 1;
	int sps3 = 1;
	public int potionh = 0;
    public int potions = 0;
    public int v = 0;
    boolean f;
    int q = 3;
    int potionrandom;
    public int shield = 0;
    public int shieldh = 0;
    public int speed = 200;
    public boolean r = true;
    public boolean turn = true;
    public int pause = 0;
    public boolean pausep;
    public boolean returnp;
    public boolean begin = true;
    public boolean exit = false;
    public int rand = 1;
    Sound buttons;

	@Override
	public void create () {
		inv = new inventory(this);
		inv.create();
		nxt = new nextlevel(this);
		nxt.create();
		mn = new Menu(this);
		mn.create();
		mm = new mainmenu(this);
		mm.create();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();

		touchPos = new Vector3();
		touchPos1 = new Vector3();
		touchPos2  = new Vector3();
		touchPos6 = new Vector3();
		touchPos10 = new Vector3();

		buttons = Gdx.audio.newSound(Gdx.files.internal("click.wav"));

		zombie = new Texture("zombie2.png");
		zombielvl3 = new Texture("zombie3.png");
		backGround = new Texture("background1.jpg");
		bucketImage = new Texture("knightright.png");
		backGround1 = new Texture("drt1.png");
		backGround2 = new Texture("grd1.png");
		fire = new Texture(Gdx.files.internal("fire.png"));
		rightImage = new Texture("right.png");
		left = new Texture("left.png");
		sword = new Texture("sword.png");
		heart = new Texture("heart.png");
		knife  = new Texture("knife.png");
		bullet = new Texture("bullet.png");
		attack = new Texture("attack.png");
		characterleft = new Texture("knightleft.png");
        door = new Texture("door.png");
		enter = new Texture("enter.png");
		level2 = new Texture("backround3.jpg");
		coing =  new Texture("coin.png");
		npcleft =  new Texture("npc.png");
		text =  new Texture("text.png");
		npcright = new Texture("npc2.png");
		backGround3  = new Texture("background3.png");;
		cemetery = new Texture("cemetery.png");
		cemetery2 = new Texture("cemetery2.png");
		cemetery3 = new Texture("cemetery3.png");
		cemetery4 = new Texture("cemetery4.png");
		cemetery5 = new Texture("cemetery5.png");
		shieldhealth = new Texture("shieldhealth.png");
		stairs = new Texture("stairs.png");
		up = new Texture("up.png");
		down = new Texture("down.png");
		knifeleft = new Texture("knifeleft.png");
		spawn=backGround;

		gun = new Rectangle();
		gun.width = 49;
		gun.height = 10;
		bucket = new Rectangle();
		bucket.x = 490;
		bucket.y = 170;
		bucket.width = 48;
		bucket.height = 43;
		buckety=new Rectangle();
		buckety.x=-10;
		buckety.y=10;
		buckety.width = 14;
		buckety.height = 14;
		bucketf= new Rectangle();
		bucketf.x = 500;
		bucketf.y=	175;
		right = new Rectangle();
		right.x=155;
		right.y=70;
		leftbut = new Rectangle();
		leftbut.x=60;
		leftbut.y=70;
		door1 = new Rectangle();
		door1.x=30;
		door1.y=170;
		door1.width=60;
		door1.height=110;
		door2 = new Rectangle();
		door2.x=0;
		door2.y=0;
		door2.width=0;
		door2.height=0;
		npc = new Rectangle();
		npc.x=686;
		npc.y=155;
		npc.width=50;
		npc.height=50;
		cemetery1 = new Rectangle();
		cemetery1.x=200;
		cemetery1.y=163;
		stairs4 = new Rectangle();
		stairs4.x = 0;
		stairs4.y = 0;
		stairs4.width = 0;
		stairs4.height = 0;

		raindrops = new Array<Rectangle>();
		spawnRaindrop();
		levels2=new Array<Rectangle>();
		spawn2();
		levels3=new Array<Rectangle>();
		spawn3();

		FontRed1 = new BitmapFont();
		FontRed1.setColor(Color.WHITE); //Red


        //анимация зомби
		walkSheet = new Texture(Gdx.files.internal("zombie.png"));
		TextureRegion[][] tmp = TextureRegion.split(walkSheet,
				walkSheet.getWidth() / FRAME_COLS,
				walkSheet.getHeight() / FRAME_ROWS);
		TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS *
				FRAME_ROWS];
		int index = 0;
		for (int i = 0; i < FRAME_ROWS; i++) {
			for (int j = 0; j < FRAME_COLS; j++) {
				walkFrames[index++] = tmp[i][j];
			}
		}
		walkAnimation = new Animation<TextureRegion>(0.15f, walkFrames);
		stateTime = 0f;


        // анимация для костра
		int index1 = 0;
		TextureRegion[][] tm = TextureRegion.split(fire,
				fire.getWidth() / FRAME_COLS1,
				fire.getHeight() / FRAME_ROWS1);
		TextureRegion[] walkFrames1 = new TextureRegion[FRAME_COLS1 *
				FRAME_ROWS1];
		for (int i = 0; i < FRAME_ROWS1; i++) {
			for (int j = 0; j < FRAME_COLS1; j++) {
				walkFrames1[index1++] = tm[i][j];
			}
		}
		fireanim = new Animation<TextureRegion>(0.2f, walkFrames1);
		stateTime1 = 0f;


		// анимация для зомби level 2;
		int index2 = 0;
		TextureRegion[][] tm2 = TextureRegion.split(zombie,
				zombie.getWidth() / FRAME_COLS2,
				zombie.getHeight() / FRAME_ROWS2);
		TextureRegion[] walkframes2 = new TextureRegion[FRAME_COLS2 * FRAME_ROWS2];
		for(int i = 0; i < FRAME_ROWS2; i++) {
			for(int j = 0; j < FRAME_COLS2; j++)
			walkframes2[index2++] = tm2[i][j];
		}
		zombieWalk = new Animation<TextureRegion>(0.2f, walkframes2);
		StateTime2 = 0f;


		// анимация для npc level 2;
		int index3 = 0;
		TextureRegion[][] tm3 = TextureRegion.split(zombielvl3
				, zombielvl3.getWidth() / FRAME_COLS3,
				zombielvl3.getHeight() / FRAME_ROWS3);
		TextureRegion[] walkframes3 = new TextureRegion[FRAME_COLS3 * FRAME_ROWS3];
		for(int i = 0; i < FRAME_ROWS3; i++) {
			for(int j = 0; j < FRAME_COLS3; j++)
				walkframes3[index3++] = tm3[i][j];
		}
		zombie3 = new Animation<TextureRegion>(0.2f, walkframes3);
		StateTime3 = 0f;


		// анимация для меча в правую сторону;
		int index4 = 0;
		TextureRegion[][] tm4 = TextureRegion.split(knife
				, knife.getWidth() / FRAME_COLS4,
				knife.getHeight() / FRAME_ROWS4);
		TextureRegion[] walkframes4 = new TextureRegion[FRAME_COLS4 * FRAME_ROWS4];
		for(int i = 0; i < FRAME_ROWS4; i++) {
			for(int j = 0; j < FRAME_COLS4; j++)
				walkframes4[index4++] = tm4[i][j];
		}
		swordan = new Animation<TextureRegion>(0.11f, walkframes4);
		StateTime4 = 0f;

		// анимация для меча в левую сторону;
		int index5 = 0;
		TextureRegion[][] tm5 = TextureRegion.split(knifeleft
				, knifeleft.getWidth() / FRAME_COLS5,
				knifeleft.getHeight() / FRAME_ROWS5);
		TextureRegion[] walkframes5 = new TextureRegion[FRAME_COLS5 * FRAME_ROWS5];
		for(int i = 0; i < FRAME_ROWS5; i++) {
			for(int j = 0; j < FRAME_COLS5; j++)
				walkframes5[index5++] = tm5[i][j];
		}
		knifel = new Animation<TextureRegion>(0.11f, walkframes5);
		StateTime5 = 0f;
	}
	private void spawnRaindrop() {
		Rectangle raindrop = new Rectangle();
		raindrop.y = MathUtils.random(168, 168);
		raindrop.x = MathUtils.random(800, 800);
		raindrop.width = 25;
		raindrop.height = 64;
		raindrops.add(raindrop);
		lastDropTime = TimeUtils.nanoTime();
	}
	private void spawn2() {
		Rectangle sp = new Rectangle();
		sp.y = MathUtils.random(165, 165);
		sp.x = MathUtils.random(800, 800);
		sp.width = 25;
		sp.height = 64;
		levels2.add(sp);
		lastDropTime2 = TimeUtils.nanoTime();
	}
	private void spawn3() {
		Rectangle sp3 = new Rectangle();
		sp3.y = MathUtils.random(165, 165);
		sp3.x = MathUtils.random(190, 666);
		sp3.width = 25;
		sp3.height = 64;
		levels3.add(sp3);
		lastDropTime3 = TimeUtils.nanoTime();
	}
	final int max_level_jump = 300;//переменная обозначающай до какого уровня будет прыгать человечек, можно сделать супер прыжек
	final int mass_person = 90;//масса человечка
	double ay = 1;//ускорение
	boolean state = false;
	public void jump(float coordY,int mass,final double force){
		if(((state == false) && (coordY > 169))||(state==true) && (coordY > 170)){
			state = true;
			Timer.schedule(new Timer.Task() { // задержка и код который должен выполняться после этого времени
				@Override
				public void run() {
					double a  = force - mass_person;
					bucket.y = Math.round(bucket.y + a/70);
					jump(bucket.y,mass_person,a);
					if (Gdx.input.isTouched()) {
						// обработка касаний для движения
						touchPos10.set(Gdx.input.getX(), Gdx.input.getY(), 0);
						camera.unproject(touchPos10);
						if ((touchPos10.x >= 60 && touchPos10.x <= 110) /*&& (touchPos10.y >= 70 && touchPos10.y <= 120) && (bucket.y <= 170)*/) {
							bucket.x -= speed * Gdx.graphics.getDeltaTime();
						}
						if ((touchPos10.x >= 155 && touchPos10.x <= 205)/* && (touchPos10.y >= 70 && touchPos10.y <= 120) && (bucket.y <= 170)*/) {
							bucket.x += speed * Gdx.graphics.getDeltaTime();
						}

					}
				}
			}, 0.05F);
		}else{
			state = false;
		}

	}
	/*
	* this void is render image in main class
	*
	*
	* */
	@Override
	public void render () {

		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
if(begin==false) {

	stateTime += Gdx.graphics.getDeltaTime();
	stateTime1 += Gdx.graphics.getDeltaTime();// Accumulate elapsed animation
	StateTime2 += Gdx.graphics.getDeltaTime();
	StateTime3 += Gdx.graphics.getDeltaTime();
	StateTime4 += Gdx.graphics.getDeltaTime();
	StateTime5 += Gdx.graphics.getDeltaTime();

	TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
	TextureRegion currentFramefire = fireanim.getKeyFrame(stateTime1, true);
	TextureRegion curentFramezombie = zombieWalk.getKeyFrame(StateTime2, true);
	TextureRegion curentFramezombielvl3 = zombie3.getKeyFrame(StateTime3, true);
	TextureRegion curentFramesword = swordan.getKeyFrame(StateTime4, true);
	TextureRegion curentFrameswordleft = knifel.getKeyFrame(StateTime5, true);

	camera.update();
	batch.setProjectionMatrix(camera.combined);
	batch.begin();
	batch.draw(backGround, 0, 0); // BackGround
	batch.draw(backGround1, 0, 0); // land
	batch.draw(currentFramefire, bucketf.x + 35, bucketf.y - 15);
	batch.draw(door, door1.x, door1.y); // right door
	batch.draw(rightImage, right.x, right.y); // right button of manage
	batch.draw(left, leftbut.x, leftbut.y); // left button of manage
	batch.draw(attack, 630, 55); // attack button
	batch.draw(rightImage, right.x, right.y);
	batch.draw(left, leftbut.x, leftbut.y);
	batch.draw(attack, 630, 55);

	if (door1.overlaps(bucket)) {// if main hero come to door
		if (backGround == level2) {
			batch.draw(enter, 575, 35);
			if (Gdx.input.justTouched()) { // if program caught touch on screen
				touchPos1.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
				camera.unproject(touchPos1);
				if (coins >= 5) {
					if ((touchPos1.x >= 575 && touchPos1.x <= 626) && (touchPos1.y >= 35 && touchPos1.y <= 97)) {  // если касание зафиксировано в зоне кнопки входа в портал
						if (backGround == level2) {
							sps = 0;
							Timer.schedule(new Timer.Task() { // задержка и код который должен выполняться после этого времени
								@Override
								public void run() {
									sps = 1;
									backGround = spawn;
								}
							}, delay);
							//если касание зафиксировано в зоне кнопки входа в портал
						}
						coins = coins - 5;// колличество монет уменьшаем на 5
					}
				}
			}
		} else {
			batch.draw(enter, 575, 35);
			if (Gdx.input.justTouched()) { // if program caught touch on screen
				touchPos1.set(Gdx.input.getX(), Gdx.input.getY(), 0); // data of location of touch
				camera.unproject(touchPos1);
				if (coins >= 5) {
					if ((touchPos1.x >= 575 && touchPos1.x <= 626) && (touchPos1.y >= 35 && touchPos1.y <= 97)) {
						if (backGround == spawn || backGround == backGround3) {
							sps2 = 0;
							Timer.schedule(new Timer.Task() { // задержка и код который должен выполняться после этого времени
								@Override
								public void run() {
									sps2 = 1;
									backGround = level2;
								}
							}, delay);
						}
						coins = coins - 5;// колличество монет уменьшаем на 5
					}
				}
			}
		}

	}
	if (npc.width == 0) {
		if (backGround == level2) {
			if (door2.overlaps(bucket)) {
				batch.draw(enter, 575, 35);// рисует кнопку входа
				if (Gdx.input.justTouched()) { // регистрируем касание
					touchPos1.set(Gdx.input.getX(), Gdx.input.getY(), 0);// считываем положение касания
					camera.unproject(touchPos1);
					if (coins >= 5) {
						if ((touchPos1.x >= 575 && touchPos1.x <= 626) && (touchPos1.y >= 35 && touchPos1.y <= 97)) { // если оно зафиксирвано  зоне кнопки входа то меняем фон на фон 3 уровня
							if (backGround == level2) {
								sps3 = 0;
								backGround = backGround3;
								Timer.schedule(new Timer.Task() { // задержка и код который должен выполняться после этого времени
									@Override
									public void run() {
										sps3 = 1;
									}
								}, delay);
								bucket.x = 40;
							}
							coins = coins - 5;
						}
					}
				}
			}
		}
	}
	batch.draw(up, 560, 105);
	if (npc.width == 0) {
		if (backGround == backGround3) {
			if (stairs4.overlaps(bucket)) {
				batch.draw(down, 560, 40);

				if (Gdx.input.isTouched()) {
					touchPos1.set(Gdx.input.getX(), Gdx.input.getY(), 0);// считываем положение касания
					camera.unproject(touchPos1);
					if (coins >= 5) {
						if ((touchPos1.x >= 560 && touchPos1.x <= 600) && (touchPos1.y >= 105 && touchPos1.y <= 145) && bucket.y < 480 - 70) {  // если оно зафиксирвано  зоне кнопки входа то меняем фон на фон 4 уровня
							bucket.y += speed * Gdx.graphics.getDeltaTime();
						}
					}
					if ((touchPos1.x >= 560 && touchPos1.x <= 600) && (touchPos1.y >= 40 && touchPos1.y <= 80) && bucket.y > 170) {  // если оно зафиксирвано  зоне кнопки входа то меняем фон на фон 4 уровня
						bucket.y -= speed * Gdx.graphics.getDeltaTime();
					}
				}

			}
		}
	}
	// дальше  идет код про отнимание и отрисовку жизней
	if (a == 7) {
		batch.draw(heart, buckety.x + 30, buckety.y + 425);
		batch.draw(heart, buckety.x + 65, buckety.y + 425);
		batch.draw(heart, buckety.x + 100, buckety.y + 425);
		batch.draw(heart, buckety.x + 135, buckety.y + 425);
		batch.draw(heart, buckety.x + 170, buckety.y + 425);
		batch.draw(heart, buckety.x + 205, buckety.y + 425);
		batch.draw(heart, buckety.x + 240, buckety.y + 425);
	}
	if (a == 6) {
		batch.draw(heart, buckety.x + 30, buckety.y + 425);
		batch.draw(heart, buckety.x + 65, buckety.y + 425);
		batch.draw(heart, buckety.x + 100, buckety.y + 425);
		batch.draw(heart, buckety.x + 135, buckety.y + 425);
		batch.draw(heart, buckety.x + 170, buckety.y + 425);
		batch.draw(heart, buckety.x + 205, buckety.y + 425);
	}
	if (a == 5) {
		batch.draw(heart, buckety.x + 30, buckety.y + 425);
		batch.draw(heart, buckety.x + 65, buckety.y + 425);
		batch.draw(heart, buckety.x + 100, buckety.y + 425);
		batch.draw(heart, buckety.x + 135, buckety.y + 425);
		batch.draw(heart, buckety.x + 170, buckety.y + 425);
	}
	if (a == 4) {
		batch.draw(heart, buckety.x + 30, buckety.y + 425);
		batch.draw(heart, buckety.x + 65, buckety.y + 425);
		batch.draw(heart, buckety.x + 100, buckety.y + 425);
		batch.draw(heart, buckety.x + 135, buckety.y + 425);
	}
	if (a == 3) {
		batch.draw(heart, buckety.x + 30, buckety.y + 425);
		batch.draw(heart, buckety.x + 65, buckety.y + 425);
		batch.draw(heart, buckety.x + 100, buckety.y + 425);
	}
	if (a == 2) {
		batch.draw(heart, buckety.x + 30, buckety.y + 425);
		batch.draw(heart, buckety.x + 65, buckety.y + 425);
	}
	if (a == 1) {
		batch.draw(heart, buckety.x + 30, buckety.y + 425);
	}
	// отрисовка щитов
	if (shieldh == 1) {
		batch.draw(shieldhealth, buckety.x + 33, buckety.y + 386);
	}
	if (shieldh == 2) {
		batch.draw(shieldhealth, buckety.x + 33, buckety.y + 386);
		batch.draw(shieldhealth, buckety.x + 68, buckety.y + 386);
	}
	if (shieldh == 3) {
		batch.draw(shieldhealth, buckety.x + 33, buckety.y + 386);
		batch.draw(shieldhealth, buckety.x + 68, buckety.y + 386);
		batch.draw(shieldhealth, buckety.x + 103, buckety.y + 386);
	}
	if (shieldh == 4) {
		batch.draw(shieldhealth, buckety.x + 33, buckety.y + 386);
		batch.draw(shieldhealth, buckety.x + 68, buckety.y + 386);
		batch.draw(shieldhealth, buckety.x + 103, buckety.y + 386);
		batch.draw(shieldhealth, buckety.x + 138, buckety.y + 386);
	}
	if (shieldh == 5) {
		batch.draw(shieldhealth, buckety.x + 33, buckety.y + 386);
		batch.draw(shieldhealth, buckety.x + 68, buckety.y + 386);
		batch.draw(shieldhealth, buckety.x + 103, buckety.y + 386);
		batch.draw(shieldhealth, buckety.x + 138, buckety.y + 386);
		batch.draw(shieldhealth, buckety.x + 173, buckety.y + 386);
	}
	if (backGround == level2) {
		door2.x = 700;
		door2.y = 170;
		door2.height = 60;
		door2.width = 110;
		batch.draw(door, door2.x, door2.y);
		bucketf.x = 800;
		bucketf.y = 480;
		fire = level2;
		//NPC.............................................................................................
		// отрисовка и обработка npc
		batch.draw(npcleft, npc.x, npc.y);
		if (npc.overlaps(bucket)) {
			batch.draw(text, 310, 405);
			FontRed1.draw(batch, "Attention!!!!..........Thanks for attention!", 330, 451);
			Timer.schedule(new Timer.Task() { // задержка и код который должен выполняться после этого времени
				@Override
				public void run() {
					if (Gdx.input.justTouched()) {
						touchPos1.set(Gdx.input.getX(), Gdx.input.getY(), 0);
						camera.unproject(touchPos1);
						npcleft.dispose();
						npc.width = 0;
						npc.height = 0;
						npc.x = -50;
						npc.y = -50;
						if (delay == 3) {
							npcleft = npcright;
						}
					}
				}
			}, delay);
		}
	}
	// отрисовка гробов на 3 уровне
	if (backGround == backGround3) {
		stairs4.x = 690;
		stairs4.y = 210;
		stairs4.width = 32;
		stairs4.height = 457;
		batch.draw(stairs, stairs4.x, stairs4.y);
		batch.draw(cemetery5, cemetery1.x, cemetery1.y);
		batch.draw(cemetery4, cemetery1.x + 45 + 46, cemetery1.y);
		batch.draw(cemetery2, cemetery1.x + 70 + 46 * 2, cemetery1.y);
		batch.draw(cemetery, cemetery1.x + 100 + 46 * 3, cemetery1.y);
		batch.draw(cemetery3, cemetery1.x + 110 + 46 * 4, cemetery1.y);
		batch.draw(cemetery2, cemetery1.x + 125 + 46 * 5, cemetery1.y);
		batch.draw(cemetery, cemetery1.x + 165 + 46 * 6, cemetery1.y);
	}
	if (backGround == spawn) {
		bucketf.x = 500;
		bucketf.y = 175;
		door2.x = 0;
		door2.y = 0;
		door2.height = 0;
		door2.width = 0;
	}
	//NPC...................................................................................................
	if (turn == true) {
		batch.draw(bucketImage, bucket.x, bucket.y);
	}
	if (turn == false) {
		batch.draw(characterleft, bucket.x, bucket.y);
	}
	if (turn == true) {
		if (Gdx.input.isTouched()) {
			// обработка касаний для движения
			touchPos1.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos1);
			if ((touchPos1.x >= 630 && touchPos1.x <= 695) && (touchPos1.y >= 55 && touchPos1.y <= 134)) {
				batch.draw(curentFramesword, bucket.x + 33, bucket.y + 18);
				gun.x = bucket.x + 20;
				gun.y = bucket.y + 40;
			}
		}
	}
	if (turn == false) {
		if (Gdx.input.isTouched()) {
			// обработка касаний для движения
			touchPos1.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos1);
			if ((touchPos1.x >= 630 && touchPos1.x <= 695) && (touchPos1.y >= 55 && touchPos1.y <= 134)) {
				batch.draw(curentFrameswordleft, bucket.x - 36, bucket.y + 18);
				gun.x = bucket.x - 20;
				gun.y = bucket.y + 40;
			}
		}
	}
	// manage buttons
	if (r == true) {
		if (pause == 0) {
			if (Gdx.input.isTouched()) {
				// обработка касаний для движения
				touchPos10.set(Gdx.input.getX(), Gdx.input.getY(), 0);
				camera.unproject(touchPos10);
				if ((touchPos10.x >= 60 && touchPos10.x <= 110) && (touchPos10.y >= 70 && touchPos10.y <= 120) && (bucket.y <= 170)) {
					turn = false;
					bucket.x -= speed * Gdx.graphics.getDeltaTime();
				}
				if ((touchPos10.x >= 155 && touchPos10.x <= 205) && (touchPos10.y >= 70 && touchPos10.y <= 120) && (bucket.y <= 170)) {
					turn = true;
					bucket.x += speed * Gdx.graphics.getDeltaTime();
				}
				if ((touchPos10.x >= 560 && touchPos10.x <= 600) && (touchPos10.y >= 100 && touchPos10.y <= 140) && (bucket.y <= 170)) {
					//bucket.y += ;
					jump(bucket.y, mass_person, 900);
				}
			}
		}
	}

	//конец обработки касаний для движения
	// обработка генерации противников
	for (Rectangle raindrop : raindrops) {
		batch.draw(currentFrame, raindrop.x, raindrop.y);  // Draw current frame at (50, 50)
	}
	if (npc.width == 0) {
		for (Rectangle sp : levels2) {
			batch.draw(curentFramezombie, sp.x, sp.y);
		}
	}
	for (Rectangle sp3 : levels3) {
		batch.draw(curentFramezombielvl3, sp3.x, sp3.y);
	}
	// конец обработки генерации противников
	// отрисовка кол-ва коинов
	batch.draw(backGround2, buckety.x, 160);
	coin = Integer.toString(coins);
	if (r == false) {
		FontRed1.draw(batch, coin, 680, 454);
		batch.draw(coing, 655, 441);
	}
	batch.end();

	// the end of draw
	inv.render();
	mn.render();
	if (sps == 0 || sps2 == 0 || sps3 == 0) {
		nxt.render();
	}
	// конец отрисовки кол-ва коинов
	if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) bucket.x -= 200 * Gdx.graphics.getDeltaTime();
	if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) bucket.x += 200 * Gdx.graphics.getDeltaTime();

	if (bucket.x < 0) {
		bucket.x = 0;
	}
	if (bucket.x > 800 - 64) {
		bucket.x = 800 - 64;
	}
	if (bucket.y < 170) {
		bucket.y = 170;
	}

// Первый уровень...............................................................................................................................
	// отрисовка противников для первого уровня
	if (backGround == spawn) {
		if (TimeUtils.nanoTime() - lastDropTime > (MathUtils.random(1000000000, 1000000000))) {
			spawnRaindrop();
		}
	}
	Iterator<Rectangle> iter = raindrops.iterator();
	while (iter.hasNext()) {
		Rectangle raindrope = iter.next();
		if (pause == 0) {
			pausep = true;
		}
		if (r == true) {
			if (pausep == true) {
				raindrope.x -= (MathUtils.random(25, 200)) * Gdx.graphics.getDeltaTime();
			}
		}
		if (pause == 1) {
			pausep = false;
		}
		if (r == false) {
			if (pausep == false) {
				raindrope.x -= (MathUtils.random(0, 0)) * Gdx.graphics.getDeltaTime();
			}
		}
		if (raindrope.overlaps(bucket)) {
			if (shieldh == 0) {
				health = health - 1;
				a = a - 1;
				setScreen(new hit(this));
				super.render();
			} else {
				shieldh--;
			}
		}
		if (raindrope.overlaps(gun)) {
			potionrandom = MathUtils.random(1, 5);
			if (potionrandom == 5) {
				if (potionh < 5 || v < 5) {
					if (v >= 4) {
						potionh++;
					}
					if (v < 5) {
						v++;
					}
				}
			}
			coins += 1;
		}

		if (backGround != spawn || death == 0 || sps2 == 0 || raindrope.overlaps(gun) || raindrope.overlaps(bucket) || raindrope.x <= 0 || begin==true) {
			iter.remove();
		}

	}


//....................................................................................................................................................
// Второй уровень.....................................................................................................................................
	// отрисовка противников для второго уровня
	if (backGround == level2) {
		if (TimeUtils.nanoTime() - lastDropTime2 > (MathUtils.random(1000000000, 1000000000))) {
			spawn2();
		}
	}
	Iterator<Rectangle> iter2 = levels2.iterator();
	while (iter2.hasNext()) {
		Rectangle raindrope = iter2.next();
		if (pause == 0) {
			pausep = true;
		}
		if (r == true) {
			if (pausep == true) {
				raindrope.x -= (MathUtils.random(25, 200)) * Gdx.graphics.getDeltaTime();
			}
		}
		if (pause == 1) {
			pausep = false;
		}
		if (r == false) {
			if (pausep == false) {
				raindrope.x -= (MathUtils.random(0, 0)) * Gdx.graphics.getDeltaTime();
			}
		}
		if (raindrope.overlaps(bucket)) {
			if (shieldh == 0) {
				health = health - 1;
				a = a - 1;
				setScreen(new hit(this));
				super.render();
			} else {
				shieldh--;
			}
		}
		if (raindrope.overlaps(gun)) {
			int potion2 = MathUtils.random(1, 5);
			if (potion2 == 4) {
				if (potions < 5) {
					potions++;
				}
			}
			if (potion2 == 5) {
				if (shield < 5) {
					shield++;
				}
			}
			coins = coins + 1;

		}
		if (backGround != level2 || npc.width != 0 || sps == 0 || raindrope.overlaps(gun) || raindrope.overlaps(bucket) || raindrope.x <= 0 || begin==true) {
			iter2.remove();
		}


	}

//....................................................................................................................................................
// третий уровень
	// отрисовка противников на третьем уровне
	if (backGround == backGround3) {
		if (TimeUtils.nanoTime() - lastDropTime3 > (MathUtils.random(1000000000, 1000000000))) {
			spawn3();
		}
	}
	Iterator<Rectangle> iter3 = levels3.iterator();
	while (iter3.hasNext()) {
		Rectangle raindrope = iter3.next();
		if (pause == 0) {
			pausep = true;
		}
		if (r == true) {
			if (pausep == true) {
				raindrope.x -= (MathUtils.random(25, 200)) * Gdx.graphics.getDeltaTime();
			}
		}
		if (pause == 1) {
			pausep = false;
		}
		if (r == false) {
			if (pausep == false) {
				raindrope.x -= (MathUtils.random(0, 0)) * Gdx.graphics.getDeltaTime();
			}
		}
		if (raindrope.overlaps(bucket)) {
			if (shieldh == 0) {
				health = health - 1;
				a = a - 1;
				setScreen(new hit(this));
				super.render();
			} else {
				shieldh--;
			}
		}
		if (raindrope.overlaps(gun)) {
			coins = coins + 1;
		}
		if (sps2 == 0 || sps3 == 0 || raindrope.overlaps(bucket) || (backGround != backGround3) || raindrope.x <= 0 || raindrope.overlaps(gun) || begin==true) {
			iter3.remove();
		}
	}


//........................................................................................................................................................................
	// отрисовка экрана "Game Over"
	if (health <= 0 || returnp == true) {
		death = 0;
		setScreen(new Level0(this));
		super.render();
		bucket.x = 5;
		bucket.y = 170;
		if (Gdx.input.isTouched()) {
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			if ((touchPos.x >= 400 && touchPos.x <= 450) && (touchPos.y >= 180 && touchPos.y <= 230)) {
				buttons.play();
				health = 7;
				a = 7;
				coins = 0;
				backGround = spawn;
				death = 1;
				returnp = false;
				pause = 0;

			}
		}
	}

	gun.x = 0;
	gun.y = 0;
	if (a == 8 || health == 8) {
		a--;
		health--;
	}
 }
 if(begin==true){
	 mm.render();
 }
 if(exit==true){
	 System.exit(0);
 }
	}

	@Override
	// destroy all textures on the screen
	public void dispose() {
		batch.dispose();
		dropImage.dispose();
		bucketImage.dispose();
		rightImage.dispose();
		sword.dispose();
		backGround.dispose();
		left.dispose();
		fire.dispose();
		heart.dispose();
		knife.dispose();
		bullet.dispose();
		attack.dispose();
		characterleft.dispose();
		door.dispose();
		enter.dispose();
		level2.dispose();
		spawn.dispose();
		coing.dispose();
		npcleft.dispose();
		npcright.dispose();
		text.dispose();
		backGround1.dispose();
		backGround2.dispose();
		cemetery.dispose();
		cemetery2.dispose();
		cemetery3.dispose();
		cemetery4.dispose();
		cemetery5.dispose();
		walkSheet.dispose();
		zombie.dispose();
		up.dispose();
		knifeleft.dispose();
		stairs.dispose();
		shieldhealth.dispose();
		zombielvl3.dispose();
		down.dispose();
	}
}