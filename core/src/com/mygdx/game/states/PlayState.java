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


public class PlayState extends State{
	
	public final static float startX = 50;
	public final static float startY = 50;
	public static int stage = 1;
	
	public int loop;
	public int counterID;
	
	public Texture background;
	
	public Player player;
	public Enemy enemy;
	public EntityManager entityManager;
	private TimeControl timeControl;
	
	//constructor
	public PlayState(GameStateManager gsm) {
		super(gsm);
		counterID = 6;
		entityManager = new EntityManager();
		player = new Player(entityManager, new Vector2(100, 50), 4, -1, Assets.PLAYER, 0);
		entityManager.addPlayer(player);
		background = loadTexture("playbg.png");
		timeControl = new TimeControl();
		new Thread(timeControl).start();
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
			entityManager.addEnemy(new Enemy(entityManager, counterID, new Vector2(0, 800), 3, 0, Assets.ENEMY, 0));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID, new Vector2(650, 700), 3, 180, Assets.ENEMY, 0));
			counterID++;
		}
		if(timeControl.getTime() >= 65 && timeControl.getTime() <= 75 && timeControl.getTime() % 5 == 0 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID, new Vector2(50, 980), 3, 300, Assets.ENEMY, 0));
			counterID++;
			entityManager.addEnemy(new Enemy(entityManager, counterID, new Vector2(600, 980), 3, 240, Assets.ENEMY, 0));
			counterID++;
		}
		if(timeControl.getTime() == 90 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID, new Vector2(155, 980), 3, 270, Assets.ENEMY, 0));
			counterID++;
		}
		if(timeControl.getTime() == 105 && loop == 1) {
			entityManager.addEnemy(new Enemy(entityManager, counterID, new Vector2(465, 980), 3, 270, Assets.ENEMY, 0));
		}
	}
}
