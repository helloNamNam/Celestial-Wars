package com.mygdx.game.states;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Assets;
import com.mygdx.game.Game;
import com.mygdx.game.entities.EntityManager;
import com.mygdx.game.entities.Player;
import com.mygdx.game.entities.SpaceObject;
import com.mygdx.game.entities.bullets.Bullet;
import com.mygdx.game.entities.enemies.Enemy;

public class PlayState extends State{
	
	public final static float startX = 50;
	public final static float startY = 50;
	
	Player player;
	EntityManager entityManager;
	
	//constructor
	public PlayState(GameStateManager gsm){
		super(gsm);
		entityManager = new EntityManager();
		player = new Player(entityManager, new Vector2(50, 50), 4, -1, Assets.PLAYER, 0);
		entityManager.addPlayer(player);
	}

	//check input from user
	@Override
	public void handleInput(){
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
		if(Gdx.input.isKeyPressed(Keys.Z)){
			player.fire();
		}
		if(Gdx.input.isKeyJustPressed(Keys.X)){
			player.useItem();
		}
//		System.out.println(player.getPos().x + ", " + player.getPos().y);
	}

	//update state
	@Override
	public void update(float dt){
		handleInput();
	}

	//draw texture
	@Override
	public void render(){
		Game.batch.begin();
		entityManager.render();
		entityManager.update();
		
//		updatePlayerBullet();
//		updateEnemyBullet();
//		updateEnemy();
//		updatePlayer();
		
		Game.batch.end();
	}
	
//	public void updateEnemyBullet(){
//		for(Bullet bullet: enemyBullets ){
//			Game.batch.draw(bullet.getTexture(), bullet.getPos().x, bullet.getPos().y);
//			bullet.process();
//		}
//	}
//
//	public void updatePlayerBullet(){
//		for(Bullet bullet: player.getBulletList() ){
//			Game.batch.draw(bullet.getTexture(), bullet.getPos().x, bullet.getPos().y);
//		}
//	}
//	
//	public void updateEnemy(){
//		for(Enemy enemy: enemyUnits){
//			Game.batch.draw(enemy.getTexture(), enemy.getPos().x, enemy.getPos().y);
//		}
//	}
//	
//	public void updatePlayer(){
//		Game.batch.draw(player.getTexture(), player.getPos().x, player.getPos().y);
//	}

	@Override
	public void dispose(){
		
	}
	
	private void checkCollision(SpaceObject object){
//		for(SpaceObject targetObject: objectList){
//			if(!(targetObject instanceof Player)){
//				object.isCollision(targetObject);
//			}
//		}
	}
}
