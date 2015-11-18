package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Assets;
import com.mygdx.game.Game;
import com.mygdx.game.TimeControl;
import com.mygdx.game.entities.EntityManager;
import com.mygdx.game.entities.Player;
import com.mygdx.game.entities.enemies.Enemy;


public class PlayState extends State {
	
	public static int stage = 1;

	public int loop;
	public int counterID;
	
	public Texture background;
	public Texture backgroundStage;
	
	public Player player;
	public Enemy enemy;
	public EntityManager entityManager;
	private TimeControl timeControl;
	
	//constructor
	public PlayState(GameStateManager gsm) {
		super(gsm);
		counterID = 6;
		entityManager = new EntityManager();
		player = new Player(entityManager, new Vector2(330 - (Assets.PLAYER.getRegionWidth()/2), 25), 4, -1, Assets.PLAYER, 0, 15, 28, 12, 12);
		entityManager.addPlayer(player);
		background = loadTexture("playbg.png");
		backgroundStage = loadTexture("images/stageoneBG.jpg");
		timeControl = new TimeControl();
		new Thread(timeControl).start();
//		timeControl.setTime(980);
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
		
		Game.batch.end();
	}

	@Override
	public void dispose() {
		
	}
	
	public void stageOne() {
		if(timeControl.getTime() >= 25 && timeControl.getTime() <= 45 && timeControl.getTime() % 5 == 0 && loop == 1) {
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
			entityManager.addEnemy(new Enemy(entityManager, 999, 1620, new Vector2(((620 - Assets.BOSSONE.getRegionWidth()) / 2) + 20, 980), 3, 270, Assets.BOSSONE, 0, 65, 45, 225, 230, timeControl));
			counterID = 6;
		}
	}
}
