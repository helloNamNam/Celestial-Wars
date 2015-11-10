package com.mygdx.game.entities;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Assets;
import com.mygdx.game.Game;
import com.mygdx.game.entities.bullets.Bullet;

import javafx.geometry.Pos;
//import com.mygdx.game.entities.bullets.StandardBullet;
//import com.mygdx.game.entities.bullets.ThreeColBullet;

public class Player extends Unit{

	public final static int playerID = 1;
	public final static int startBulletLevel = 1;
	public int bulletLevel;
//	public final int WIDTH = 50;
//	public final int HEIGHT = 50;
//	public final float SPEED = 200;
	
	EntityManager entityManager;
	
	public Player(EntityManager entityManager, Vector2 pos, int velocity, float direction, Texture texture, int delay) {
		super(playerID, pos, velocity, direction, texture, delay);
		height = 50;
		width = 50;
		setHp(5);
		setBounds(50, 50, width, height);
		setLastFire(0);
		this.entityManager = entityManager;
		bulletLevel = startBulletLevel;
	}

	public void fire(){
//		Bullet bullet;
		if(bulletLevel == 1){
			if(System.currentTimeMillis() - getLastFire() >= 50){
				entityManager.addEntity(new Bullet(1, new Vector2((Assets.PLAYER.getWidth()/2) + getPos().x, Assets.PLAYER.getHeight() + getPos().y), 20, 90, Assets.BULLET, 0));
				setLastFire(System.currentTimeMillis());
			}
		}else if(bulletLevel == 2){
			if(System.currentTimeMillis() - getLastFire() >= 50){
				entityManager.addEntity(new Bullet(1, new Vector2((Assets.PLAYER.getWidth()/2) + getPos().x + 30, Assets.PLAYER.getHeight() + getPos().y), 20, 45, Assets.BULLET, 0));
				entityManager.addEntity(new Bullet(1, new Vector2((Assets.PLAYER.getWidth()/2) + getPos().x, Assets.PLAYER.getHeight() + getPos().y), 20, 90, Assets.BULLET, 0));
				entityManager.addEntity(new Bullet(1, new Vector2((Assets.PLAYER.getWidth()/2) + getPos().x - 30, Assets.PLAYER.getHeight() + getPos().y), 20, 135, Assets.BULLET, 0));
				setLastFire(System.currentTimeMillis());
			}
		}else{
			if(System.currentTimeMillis() - getLastFire() >= 50){
				entityManager.addEntity(new Bullet(1, new Vector2((Assets.PLAYER.getWidth()/2) + getPos().x - 15, Assets.PLAYER.getHeight() + getPos().y), 20, 90, Assets.BULLET, 0));
				entityManager.addEntity(new Bullet(1, new Vector2((Assets.PLAYER.getWidth()/2) + getPos().x, Assets.PLAYER.getHeight() + getPos().y), 20, 90, Assets.BULLET, 0));
				entityManager.addEntity(new Bullet(1, new Vector2((Assets.PLAYER.getWidth()/2) + getPos().x + 15, Assets.PLAYER.getHeight() + getPos().y), 20, 90, Assets.BULLET, 0));
				entityManager.addEntity(new Bullet(1, new Vector2((Assets.PLAYER.getWidth()/2) + getPos().x + 30, Assets.PLAYER.getHeight() + getPos().y), 20, 45, Assets.BULLET, 0));
				entityManager.addEntity(new Bullet(1, new Vector2((Assets.PLAYER.getWidth()/2) + getPos().x, Assets.PLAYER.getHeight() + getPos().y), 20, 90, Assets.BULLET, 0));
				entityManager.addEntity(new Bullet(1, new Vector2((Assets.PLAYER.getWidth()/2) + getPos().x - 30, Assets.PLAYER.getHeight() + getPos().y), 20, 135, Assets.BULLET, 0));
				setLastFire(System.currentTimeMillis());
			}
		}
	}
	
	public void useItem() {
		bulletLevel ++;
		if(bulletLevel > 3){ bulletLevel = 1; }
	}

	@Override
	public Boolean isCollision(SpaceObject object) {
		return getBounds().overlaps(object.getBounds());
	}

	@Override
	public void update() {
		
	}
	
	public void moveUp(){
		getPos().y += getVelocity();
	}
	
	public void moveDown(){
		getPos().y -= getVelocity();
	}
	
	public void moveRight(){
		getPos().x += getVelocity();
	}
	
	public void moveLeft(){
		getPos().x -= getVelocity();
	}
}
