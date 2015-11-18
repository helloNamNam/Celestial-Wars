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

public class TwoPlayState extends State{

	public static int stage = 1;

	public int loop;
	public int counterID;
	
	public Texture background;
	public Texture backgroundStage;
	
	public Player player;
	public Player playerTwo;
	public Enemy enemy;
	public EntityManager entityManager;
	private TimeControl timeControl;
	
	public TwoPlayState(GameStateManager gsm) {
		super(gsm);
		counterID = 6;
		entityManager = new EntityManager();
		player = new Player(entityManager, new Vector2(100, 50), 4, -1, Assets.PLAYER, 0, 15, 28, 12, 12);
		playerTwo = new Player(entityManager, new Vector2(600, 50), 4, -1, Assets.PLAYER, 0, 15, 28, 12, 12);
		entityManager.addPlayer(player);
		entityManager.addPlayer(playerTwo);
		background = loadTexture("playbg.png");
		backgroundStage = loadTexture("images/stageoneBG.jpg");
		timeControl = new TimeControl();
		new Thread(timeControl).start();
	}
	
	@Override
	public void handleInput() {
		if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			playerTwo.moveDown();
		}
		if(Gdx.input.isKeyPressed(Keys.UP)) {
			playerTwo.moveUp();
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			playerTwo.moveRight();
		}
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			playerTwo.moveLeft();
		}
		if(Gdx.input.isKeyPressed(Keys.CONTROL_RIGHT)) {
			playerTwo.fire();
		}
		if(Gdx.input.isKeyPressed(Keys.S)) {
			player.moveDown();
		}
		if(Gdx.input.isKeyPressed(Keys.W)) {
			player.moveUp();
		}
		if(Gdx.input.isKeyPressed(Keys.D)) {
			player.moveRight();
		}
		if(Gdx.input.isKeyPressed(Keys.A)) {
			player.moveLeft();
		}
		if(Gdx.input.isKeyPressed(Keys.CONTROL_LEFT)) {
			player.fire();
		}
		
	}

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
		}else if(stage == 5) {
			stageFive();
		}
		
	}

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
	
	public void stageFive() {
		if(timeControl.getTime() >= 25 && timeControl.getTime() <= 45 && timeControl.getTime() % 5 == 0 && loop == 1) {
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
			entityManager.addEnemy(new Enemy(entityManager, 999, 2500 , new Vector2(((660 - Assets.BOSSFIVE.getRegionWidth()) / 2) + 20, 980), 3, 270, Assets.BOSSFIVE, 0, 152, 130, 228, 40, timeControl));
		}
	}
}
