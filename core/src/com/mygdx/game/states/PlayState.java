package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Assets;
import com.mygdx.game.Game;
import com.mygdx.game.entities.EntityManager;
import com.mygdx.game.entities.Player;
import com.mygdx.game.entities.enemies.Enemy;

public class PlayState extends State{
	
	public final static float startX = 50;
	public final static float startY = 50;
	
	private Texture background;
	
	public Player player;
	public Enemy enemy;
	public EntityManager entityManager;
	
	//constructor
	public PlayState(GameStateManager gsm) {
		super(gsm);
		entityManager = new EntityManager();
		player = new Player(entityManager, new Vector2(100, 50), 4, -1, Assets.PLAYER);
		enemy = new Enemy(entityManager, 2, new Vector2(100, 600), 0, 0, Assets.ENEMY);
		entityManager.addEntity(enemy);
		entityManager.addPlayer(player);
		background = loadTexture("playbg.png");
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
		}
		if(Gdx.input.isKeyJustPressed(Keys.X)) {
			player.useItem();
		}
		for(int i = 0; i*0.01 < 50; i++){
			enemy.fire();
		}
//		System.out.println(player.getPos().x + ", " + player.getPos().y);
	}

	//update state
	@Override
	public void update(float dt) {
		handleInput();
		player.update();
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
}
