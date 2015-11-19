package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.Assets;
import com.mygdx.game.Game;
import com.mygdx.game.TimeControl;
import com.mygdx.game.entities.EntityManager;
import com.mygdx.game.entities.Player;
import com.mygdx.game.entities.enemies.Enemy;


public class PlayState extends State {
	
	public static final float pointStartX = 330 - (Assets.PLAYER.getRegionWidth()/2);
	public static final float pointStartY = 25;
	
	public static int stage = 5;
	public static int score = 0;

	public int loop;
	public int counterID;
	private float ran;
	
	public Texture background;
	public Texture backgroundStage;
	
	public Player player;
	public Enemy enemy;
	public EntityManager entityManager;
	public static TimeControl timeControl;
	
	private Stage scoreStage;
	private BitmapFont font;
	private LabelStyle style;
	private Label scoreGame;
	
	private Sprite heartA;
	private Sprite heartB;
	private Sprite heartC;
	
	private Music stage1;
	private Music stage2;
	private Music stage3;
	private Music stage4;
	private Music stage5;
	private Music stage6;
	public static Music boss1;
	public static Music boss2;
	public static Music boss3;
	public static Music boss4;
	public static Music boss5;
	public static Music boss6;
	private Sound alarm;
	private Sound dead;
	
	
	public static Music getBoss2() {
		return boss2;
	}

	public static void setBoss2(Music boss2) {
		PlayState.boss2 = boss2;
	}

	public static Music getBoss3() {
		return boss3;
	}

	public static void setBoss3(Music boss3) {
		PlayState.boss3 = boss3;
	}

	public static Music getBoss4() {
		return boss4;
	}

	public static void setBoss4(Music boss4) {
		PlayState.boss4 = boss4;
	}

	public static Music getBoss5() {
		return boss5;
	}

	public static void setBoss5(Music boss5) {
		PlayState.boss5 = boss5;
	}

	public static Music getBoss6() {
		return boss6;
	}

	public static void setBoss6(Music boss6) {
		PlayState.boss6 = boss6;
	}

	public static Music getBoss1() {
		return boss1;
	}
	
	public static void setBoss1(Music boss1) {
		PlayState.boss1 = boss1;
	}
	
	//constructor
	public PlayState(GameStateManager gsm) {
		super(gsm);
		stage1 = Gdx.audio.newMusic(Gdx.files.internal("Sounds/stage1.mp3"));
		stage2 = Gdx.audio.newMusic(Gdx.files.internal("Sounds/stage2.mp3"));
		stage3 = Gdx.audio.newMusic(Gdx.files.internal("Sounds/stage3.mp3"));
		stage4 = Gdx.audio.newMusic(Gdx.files.internal("Sounds/stage4.mp3"));
		stage5 = Gdx.audio.newMusic(Gdx.files.internal("Sounds/stage5.mp3"));
		stage6 = Gdx.audio.newMusic(Gdx.files.internal("Sounds/stage6.mp3"));
		boss1 = Gdx.audio.newMusic(Gdx.files.internal("Sounds/boss1.mp3"));
		boss2 = Gdx.audio.newMusic(Gdx.files.internal("Sounds/boss2.mp3"));
		boss3 = Gdx.audio.newMusic(Gdx.files.internal("Sounds/boss3.mp3"));
		boss4 = Gdx.audio.newMusic(Gdx.files.internal("Sounds/boss4.mp3"));
		boss5 = Gdx.audio.newMusic(Gdx.files.internal("Sounds/boss5.mp3"));
		boss6 = Gdx.audio.newMusic(Gdx.files.internal("Sounds/boss6.mp3"));
		alarm = Gdx.audio.newSound(Gdx.files.internal("Sounds/alram.mp3"));
		dead = Gdx.audio.newSound(Gdx.files.internal("Sounds/playerdead.mp3"));
		counterID = 6;
		entityManager = new EntityManager();
		player = new Player(entityManager, new Vector2(pointStartX, pointStartY), 4, -1, Assets.PLAYER, 0, 15, 28, 12, 12);
		entityManager.addPlayer(player);
		background = loadTexture("playbg.png");
		backgroundStage = loadTexture("images/stageoneBG.jpg");
		timeControl = new TimeControl();
		new Thread(timeControl).start();
		
		scoreStage = new Stage();
		font = new BitmapFont();
		font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		style = new LabelStyle(font, Color.WHITE);
		
		scoreGame = new Label("0", style);
		scoreGame.setBounds(950, 800, 300, 30);
		scoreGame.setAlignment(Align.right);
		scoreStage.addActor(scoreGame);
		scoreGame.setFontScale(5f);
		Gdx.input.setInputProcessor(scoreStage);
		
		heartA = new Sprite(new  Texture("images/heart.png"));
		heartB = new Sprite(new  Texture("images/heart2.png"));
		heartC = new Sprite(new  Texture("images/heart3.png"));
		
		heartA.setBounds(800, 200, 100, 100);
		heartB.setBounds(925, 200, 100, 100);
		heartC.setBounds(1050, 200, 100, 100);
		timeControl.setTime(1080);
	}

	//check input from user
	@Override
	public void handleInput() {
		if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			player.moveDown();
		}
		if(Gdx.input.isKeyPressed(Keys.UP)) {
			player.moveUp();
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			player.moveRight();
		}
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			player.moveLeft();
		}
		if(Gdx.input.isKeyPressed(Keys.Z)) {
			player.fire();
//			entityManager.addEntity(new Enemy(entityManager, 3, new Vector2((float) (20 + Math.random()*620), 900), 3, 270, Assets.ENEMY));
		}
		if(Gdx.input.isKeyJustPressed(Keys.X)) {
			player.useItem();
		}
		if(Gdx.input.isKeyPressed(Keys.V)) {
			System.out.println(timeControl.getTime());
		}
		if(Gdx.input.isKeyPressed(Keys.ESCAPE)){
			gsm.set(new MenuState(gsm));
			stage1.dispose();
			stage2.dispose();
			stage3.dispose();
			stage4.dispose();
			stage5.dispose();
			stage6.dispose();
			boss1.dispose();
			boss2.dispose();
			boss3.dispose();
			boss4.dispose();
			boss5.dispose();
			boss6.dispose();
			dispose();
		}
//		System.out.println(player.getPos().x + ", " + player.getPos().y);
	}

	//update state
	@Override
	public void update(float dt) {
		loop++;
		if(loop > 5) { 
			loop = 0; 
		} 
		handleInput();
		player.update();
		if(stage == 1) {
			stageOne();
		}else if(stage == 2) {
			stageTwo();
		}else if(stage == 3) {
			stageThree();
		}else if(stage == 4) {
			stageFour();
		}else {
			stageFive();
		}
	}

	//draw texture
	@Override
	public void render() {
		Game.batch.begin();
		Game.batch.draw(backgroundStage, 0, 0);
		entityManager.render();
		entityManager.update();
		Game.batch.draw(background, 0, 0);
		
		heartA.draw(Game.batch);
		heartB.draw(Game.batch);
		heartC.draw(Game.batch);
		
		if (Player.heartPoint == 3)
		{
			heartA.setAlpha(1);
			heartB.setAlpha(1);
			heartC.setAlpha(1);
		}
		if (Player.heartPoint == 2)
		{
			heartA.setAlpha(0);
			heartB.setAlpha(1);
			heartC.setAlpha(1);
		}
		if (Player.heartPoint == 1)
		{
			heartA.setAlpha(0);
			heartB.setAlpha(0);
			heartC.setAlpha(1);
		}
		if (Player.heartPoint == 0)
		{
			dead.play();
			heartA.setAlpha(0);
			heartB.setAlpha(0);
			heartC.setAlpha(0);
			stage1.dispose();
			stage2.dispose();
			stage3.dispose();
			stage4.dispose();
			stage5.dispose();
			stage6.dispose();
			boss1.dispose();
			boss2.dispose();
			boss3.dispose();
			boss4.dispose();
			boss5.dispose();
			boss6.dispose();
			dispose();
			
			gsm.set(new GameoverState(gsm));
		}
		
		Game.batch.end();
		scoreStage.getActors();
//		for(int i = 0; i < scoreStage.getActors().size; i++)
//		{
//			if (scoreStage.getActors().get(i).equals())
//		}
		scoreGame.setText(score+"");
		scoreStage.draw();
	}

	@Override
	public void dispose() {
		
	}
	
	public void stageOne() {
		if(timeControl.getTime() >= 25 && timeControl.getTime() <= 45 && timeControl.getTime() % 5 == 0 && loop == 1) {
			stage1.play();
			stage1.setVolume(0.2f);
			stage1.setLooping(true);
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(0, 800), 3, 0, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(650, 700), 3, 180, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() >= 65 && timeControl.getTime() <= 75 && timeControl.getTime() % 5 == 0 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(50, 980), 3, 300, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(600, 980), 3, 240, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() == 90 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID, 15, new Vector2(155, 980), 3, 270, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() == 125 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID, 15, new Vector2(465, 980), 3, 270, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() == 155 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID, 10, new Vector2(0, 400), 3, 0, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() == 165 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID, 10, new Vector2(660, 400), 3, 180, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() == 175 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID, 10, new Vector2(0, 700), 3, 0, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() == 185 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID, 10, new Vector2(660, 700), 3, 180, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() >= 225 && timeControl.getTime() <= 245 && timeControl.getTime() % 5 == 0 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(125, 980), 3, 270, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(525, 980), 3, 270, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() >= 285 && timeControl.getTime() <= 315 && timeControl.getTime() % 5 == 0 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(0, 200), 3, 60, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(660, 200), 3, 120, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() >= 350 && timeControl.getTime() <= 370 && timeControl.getTime() % 5 == 0 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(0, 800), 3, 0, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(650, 700), 3, 180, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() == 430 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, 99, 540, new Vector2(((620 - Assets.ENEMY.getRegionWidth()) / 2) + 20, 980), 3, 270, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight(), timeControl));
		}
		if(timeControl.getTime() >= 920 && timeControl.getTime() <= 930 && timeControl.getTime() % 5 == 0 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(50, 980), 3, 300, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(300, 980), 3, 240, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(300, 980), 3, 300, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(600, 980), 3, 240, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() >= 950 && timeControl.getTime() <= 970 && timeControl.getTime() % 5 == 0 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(0, 900), 3, 0, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(650, 800), 3, 180, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(0, 700), 3, 0, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(650, 600), 3, 180, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() == 1000 && loop == 1) {
			stage1.dispose();
			alarm.play();
			boss1.play();
			boss1.setVolume((float) 0.2);
			boss1.setLooping(true);
			entityManager.addEnemy(new Enemy(entityManager, 999, 1620, new Vector2(((620 - Assets.BOSSONE.getRegionWidth()) / 2) + 20, 980), 3, 270, Assets.BOSSONE, 0, 65, 45, 225, 230, timeControl));
			counterID = 6;
		}
	}
	public void stageTwo() {
		if(timeControl.getTime() >= 20 && timeControl.getTime() < 90 && timeControl.getTime() % 5 == 0 && loop == 1){
			stage2.play();
			stage2.setVolume(0.2f);
			stage2.setLooping(true);
			entityManager.addEnemy(new Enemy(entityManager, 301, 8, new Vector2(20, 60), 6, 55, Assets.ENEMY, 55-270, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			entityManager.addEnemy(new Enemy(entityManager, 301, 8, new Vector2(640, 60), 6, 125, Assets.ENEMY, 125-270, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
		}
		if(timeControl.getTime() >= 100 && timeControl.getTime() < 200 && timeControl.getTime() % 5 == 0 && loop == 1){
			entityManager.addEnemy(new Enemy(entityManager, 302, 8, new Vector2(-10, 600), 5, 350, Assets.ENEMY, 350-270, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			entityManager.addEnemy(new Enemy(entityManager, 302, 8, new Vector2(-10, 650), 5, 350, Assets.ENEMY, 350-270, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
		}
		if(timeControl.getTime() >= 170 && timeControl.getTime() < 250 && timeControl.getTime() % 5 == 0 && loop == 1){
			entityManager.addEnemy(new Enemy(entityManager, 303, 8, new Vector2(640, 600), 5, 190, Assets.ENEMY, 190-270, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			entityManager.addEnemy(new Enemy(entityManager, 303, 8, new Vector2(640, 500), 5, 190, Assets.ENEMY, 190-270, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
		}
		if(timeControl.getTime() == 200 && loop == 1){
			entityManager.addEnemy(new Enemy(entityManager, 304, 1000, new Vector2(-10, 700), 4, 350, Assets.MINIBOSS02, 350-270, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID = 305;
		}
		if(timeControl.getTime() >= 300 && timeControl.getTime() <= 395 && timeControl.getTime() % 5 == 0 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID, 20, new Vector2(0, 650), 2.5, 0, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			entityManager.addEnemy(new Enemy(entityManager, counterID, 20, new Vector2(650, 550), 2.5, 180, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() >= 440 && timeControl.getTime() <= 600 && timeControl.getTime() % 20 == 0 && loop == 1) {
			if(timeControl.getTime() % 20 == 0 && timeControl.getTime() % 40 != 0 && timeControl.getTime() != 600){
				entityManager.addEnemy(new Enemy(entityManager, 325, 20, new Vector2(0, 100), 6, 75, Assets.ENEMYEIEI, 0, 0, 0, Assets.ENEMYEIEI.getRegionWidth(), Assets.ENEMYEIEI.getRegionHeight()));
			}else if(timeControl.getTime() != 600){
				entityManager.addEnemy(new Enemy(entityManager, 326, 20, new Vector2(660, 100), 6, 105, Assets.ENEMYEIEI, 0, 0, 0, Assets.ENEMYEIEI.getRegionWidth(), Assets.ENEMYEIEI.getRegionHeight()));
			}
			if(timeControl.getTime() == 600){
				entityManager.addEnemy(new Enemy(entityManager, 327, 200, new Vector2(0, 100), 6, 75, Assets.ENEMYEIEI, 0, 0, 0, Assets.ENEMYEIEI.getRegionWidth(), Assets.ENEMYEIEI.getRegionHeight()));
				entityManager.addEnemy(new Enemy(entityManager, 328, 200, new Vector2(660, 100), 6, 105, Assets.ENEMYEIEI, 0, 0, 0, Assets.ENEMYEIEI.getRegionWidth(), Assets.ENEMYEIEI.getRegionHeight()));
			}
		}
		if(timeControl.getTime() >= 630 && timeControl.getTime() <= 710 && timeControl.getTime() % 2 == 0 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, 329, 15, new Vector2(0, 750), 6, 335, Assets.ENEMY, 335+90, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
		}
		if(timeControl.getTime() >= 720 && timeControl.getTime() <= 780 && timeControl.getTime() % 3 == 0 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, 330, 15, new Vector2(600, 800), 5, 270, Assets.ENEMY, 270+90, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
		}
		if(timeControl.getTime() >= 780 && timeControl.getTime() <= 840 && timeControl.getTime() % 3 == 0 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, 330, 15, new Vector2(100, 0), 5, 90, Assets.ENEMY, 90+90, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
		}
		if(timeControl.getTime() == 850 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, 331, 1500, new Vector2(300, 0), 15, 90, Assets.MINIBOSS02, 90+90, 0, 0, Assets.MINIBOSS02.getRegionWidth(), Assets.MINIBOSS02.getRegionHeight()));
		}
		if(timeControl.getTime() == 870 && loop == 1){
			entityManager.addEnemy(new Enemy(entityManager, 332, 150, new Vector2(-10, 700), 4, 350, Assets.MINIBOSS02, 350-270, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
		}
		if(timeControl.getTime() >= 880 && timeControl.getTime() < 950 && timeControl.getTime() % 5 == 0 && loop == 1){
			entityManager.addEnemy(new Enemy(entityManager, 333, 8, new Vector2(100, 0), 6, 90, Assets.ENEMY, 90-270, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
		}
		if(timeControl.getTime() > 1000){
			for(int i=0; i < entityManager.getEnemies().size(); i++){
				if(entityManager.getEnemies().get(i).getId() == 332){
					entityManager.addRemove(entityManager.getEnemies().get(i));
				}
			}
		}
		//Boss and Mini Boss
		if(timeControl.getTime() >= 1000 && timeControl.getTime() <= 1030 && loop == 1){
			if(timeControl.getTime() == 1000){ //mini boss
				entityManager.addEnemy(new Enemy(entityManager, 334, 400, new Vector2(-40, 850), 4, 350, Assets.BOSSTWOMINI, 350-270, 0, 0, Assets.BOSSTWOMINI.getRegionWidth(), Assets.BOSSTWOMINI.getRegionHeight()));
			}
			if(timeControl.getTime() == 1000){ //mini boss
				entityManager.addEnemy(new Enemy(entityManager, 335, 400, new Vector2(580, 850), 4, 190, Assets.BOSSTWOMINI, 190-270, 0, 0, Assets.BOSSTWOMINI.getRegionWidth(), Assets.BOSSTWOMINI.getRegionHeight()));
			}
			if(timeControl.getTime() == 1030){ //boss
				stage2.dispose();
				alarm.play();
				boss2.play();
				boss2.setVolume((float) 0.4);
				boss2.setLooping(true);
				entityManager.addEnemy(new Enemy(entityManager, 336, 1000, new Vector2(180, 850), 3, 270, Assets.BOSSTWO, 270-270, 0, 0, Assets.BOSSTWO.getRegionWidth(), Assets.BOSSTWO.getRegionHeight(), timeControl));
				counterID = 6;
			}
		}		
		if(timeControl.getTime() > 1700){
			entityManager.clearAll();
		}
	}
	public void stageThree() {
		System.out.println(counterID);
		//fall
		if(timeControl.getTime() >= 25 && timeControl.getTime() <= 65 && timeControl.getTime() % 5 == 0 && loop == 1) {
			stage3.play();
			stage3.setVolume(0.4f);
			stage3.setLooping(true);
			counterID = 6;
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(80, 940), 2, 270, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(570, 940), 2, 270, Assets.ENEMY,0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		//shootingstar
		if(timeControl.getTime() ==95 && loop == 1) {
			counterID = 26;
			entityManager.addEnemy(new Enemy(entityManager, counterID,100, new Vector2(648, 700), 3, 210, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() == 140 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID,100, new Vector2(0, 700), 3, 330, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}

		//fall
		if(timeControl.getTime() >= 175 && timeControl.getTime() <= 215 && timeControl.getTime() % 5 == 0 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(80, 940), 2, 270, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(570, 940), 2, 270, Assets.ENEMY,0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}

		//mini boss1
		if(timeControl.getTime() == 245 && loop == 1) {
			counterID = 49;
			entityManager.addEnemy(new Enemy(entityManager, counterID,300, new Vector2(648, 400), 4, 160, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}

		//rising star
		if(timeControl.getTime() >= 465 && timeControl.getTime() <= 545 && timeControl.getTime() % 5 == 0 && loop == 1) {
			counterID = 50;
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(80, 0), 3, 90, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(570, 0), 3, 90, Assets.ENEMY,0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}

		//shooting star
		if(timeControl.getTime() == 565 && loop == 1) {
			counterID = 100;
			entityManager.addEnemy(new Enemy(entityManager, counterID,100, new Vector2(648, 700), 3, 210, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() == 565 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID,100, new Vector2(0, 700), 3, 330, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}

		//radiant star
		if(timeControl.getTime() == 640 && loop == 1) {
			counterID = 102;
			entityManager.addEnemy(new Enemy(entityManager, counterID,100, new Vector2(110, 940), 3, 270, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() == 640 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID,100, new Vector2(540, 940), 3, 270, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}

		//rising star
		if(timeControl.getTime() >= 815 && timeControl.getTime() <= 855 && timeControl.getTime() % 5 == 0 && loop == 1) {
			counterID = 104;
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(80, 0), 3, 90, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(570, 0), 3, 90, Assets.ENEMY,0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}

		//Boss
		if(timeControl.getTime() == 900 && loop == 1) {
			entityManager.clearAll();
		}
		if(timeControl.getTime() == 1000 && loop == 1) {
			stage3.dispose();
			alarm.play();
			boss3.play();
			boss3.setVolume((float) 0.4);
			boss3.setLooping(true);
			counterID = 134;
			entityManager.addEnemy(new Enemy(entityManager, counterID,1080,  new Vector2(240, 940), 4, 270, Assets.BOSSTHREE, 0, 0,0, Assets.BOSSTHREE.getRegionWidth(), Assets.BOSSTHREE.getRegionHeight(), timeControl));
			counterID = 6;
		}
	}
	public void stageFour() {
		
		//enemy flow
		if(timeControl.getTime() >= 25 && timeControl.getTime() <= 65 && timeControl.getTime() % 5 == 0 && loop == 1) {
			stage4.play();
			stage4.setVolume(0.4f);
			stage4.setLooping(true);
			ran = (float) (Math.random()*(-25)-10);
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5 ,new Vector2(0, (float) (Math.random()*100+480)), 3,ran, Assets.ENEMY, ran+90, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			ran = (float) (Math.random()*(25)+180);			
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(650, (float) (Math.random()*100+480)), 3, ran, Assets.ENEMY, ran+90, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}

		//Aimingset
		if(timeControl.getTime() >= 75 && timeControl.getTime() <= 95 && timeControl.getTime() % 5 == 0 && loop == 1) {
			counterID = 24;
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(0, 800), 3, 0, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(650, 700), 3, 180, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() >= 145 && timeControl.getTime() <= 155 && timeControl.getTime() % 5 == 0 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(0, 800), 3, 0, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(650, 700), 3, 180, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}

		//Aimingset
		if(timeControl.getTime() >= 165 && timeControl.getTime() <= 185 && timeControl.getTime() % 5 == 0 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(0, 800), 3, 0, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(650, 700), 3, 180, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() >= 235 && timeControl.getTime() <= 245 && timeControl.getTime() % 5 == 0 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(0, 800), 3, 0, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(650, 700), 3, 180, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}

		//4quater set
		if(timeControl.getTime() == 275 && loop == 1) {
			counterID = 56;
			entityManager.addEnemy(new Enemy(entityManager, counterID,100, new Vector2(155, 940), 2, 270, Assets.ENEMY, 270, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() == 275 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID,100, new Vector2(465, 940), 2, 270, Assets.ENEMY, 270, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}

		if(timeControl.getTime() == 345 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID,100, new Vector2(232, 940), 2, 270, Assets.ENEMY, 270, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() == 345 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID,100, new Vector2(388, 940), 2, 270, Assets.ENEMY, 270, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}

		//enemy flow
		if(timeControl.getTime() >= 405 && timeControl.getTime() <= 445 && timeControl.getTime() % 2 == 0 && loop == 1) {
			counterID= 60;
			ran = (float) (Math.random()*(-25)-10);
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(0, (float) (Math.random()*100+480)-90), 3,ran, Assets.ENEMY, ran+90, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			ran = (float) (Math.random()*(25)+180);			
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(650, (float) (Math.random()*100+480)-90), 3, ran, Assets.ENEMY, ran+90, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}

		//enemy flow
		if(timeControl.getTime() >= 465 && timeControl.getTime() <= 505 && timeControl.getTime() % 2 == 0 && loop == 1) {
			ran = (float) (Math.random()*(-25)-10);
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(0, (float) (Math.random()*100+480)-90), 3,ran, Assets.ENEMY, ran+90, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			ran = (float) (Math.random()*(25)+180);			
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(650, (float) (Math.random()*100+480)-90), 3, ran, Assets.ENEMY, ran+90, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}

		//Spread bull
		if(timeControl.getTime() >= 515 && timeControl.getTime() <= 535 && timeControl.getTime() % 5 == 0 && loop == 1) {
			counterID = 140;
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(0, 800), 3, 0, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID,5, new Vector2(650, 700), 4, 180, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}

		//Spread bull
		if(timeControl.getTime() >= 575 && timeControl.getTime() <= 595 && timeControl.getTime() % 5 == 0 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID,100, new Vector2(0, 800), 4, 0, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID,100, new Vector2(650, 700), 3, 180, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}

		//4quater set
		if(timeControl.getTime() == 635 && loop == 1) {
			counterID = 160;
			entityManager.addEnemy(new Enemy(entityManager, counterID,200, new Vector2(155, 940), 2, 270, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() == 635 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID,200, new Vector2(465, 940), 2, 270, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}

		if(timeControl.getTime() == 705 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID,200, new Vector2(232, 940), 2, 270, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() == 705 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID,200, new Vector2(388, 940), 2, 270, Assets.ENEMY, 0, 0,0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		//Boss
		if(timeControl.getTime() == 1000 && loop == 1) {
			entityManager.clearAll();
		}
		if(timeControl.getTime() == 1100 && loop == 1) {
			stage4.dispose();
			alarm.play();
			boss4.play();
			boss4.setVolume((float) 0.4);
			boss4.setLooping(true);
			counterID = 164;
			entityManager.addEnemy(new Enemy(entityManager, counterID,1080,  new Vector2(150, 940), 4, 270, Assets.BOSSFOUR, 0, 0,0, Assets.BOSSFOUR.getRegionWidth(), Assets.BOSSFOUR.getRegionHeight(), timeControl));
			counterID = 6;
		}
	}
	public void stageFive() {
		
		if(timeControl.getTime() >= 25 && timeControl.getTime() <= 45 && timeControl.getTime() % 5 == 0 && loop == 1) {
			stage5.play();
			stage5.setVolume(0.4f);
			stage5.setLooping(true);
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(0, 800), 3, 0, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(650, 700), 3, 180, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() >= 85 && timeControl.getTime() <= 105 && timeControl.getTime() % 5 == 0 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(0, 100), 3, 0, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(650, 200), 3, 180, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() == 185 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, 26, 30, new Vector2(155, 980), 3, 270, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, 27, 30, new Vector2(465, 980), 3, 270, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() == 225 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, 28, 30, new Vector2(155, 980), 3, 315, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, 29, 30, new Vector2(465, 980), 3, 225, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() >= 330 && timeControl.getTime() <= 360 && timeControl.getTime() % 5 == 0 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(0, 200), 3, 60, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(660, 200), 3, 120, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() == 380 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID, 15, new Vector2(125, 980), 2, 270, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID, 15, new Vector2(495, 980), 2, 270, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() >= 450 && timeControl.getTime() <= 470 && timeControl.getTime() % 5 == 0 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(0, 800), 3, 0, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(650, 700), 3, 180, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() >= 510 && timeControl.getTime() <= 530 && timeControl.getTime() % 5 == 0 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(0, 100), 3, 0, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID, 5, new Vector2(650, 200), 3, 180, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
			counterID++;
		}
		if(timeControl.getTime() == 580 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, 99, 1000, new Vector2(((660 - Assets.ENEMY.getRegionWidth()) / 2) + 20, 980), 3, 270, Assets.ENEMY, 0, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight(), timeControl));
		}
		if(timeControl.getTime() == 1100 && loop == 1) {
			stage5.dispose();
			alarm.play();
			boss5.play();
			boss5.setVolume((float) 0.4);
			boss5.setLooping(true);
			entityManager.addEnemy(new Enemy(entityManager, 999, 2500 , new Vector2(((660 - Assets.BOSSFIVE.getRegionWidth()) / 2) + 20, 980), 3, 270, Assets.BOSSFIVE, 0, 152, 130, 228, 40, timeControl));
			counterID = 6;
		}
	}
}
