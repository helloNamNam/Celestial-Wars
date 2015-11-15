package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Assets;
import com.mygdx.game.entities.bullets.Bullet;

public class Player extends Unit {

	public final static int playerID = 1;
	public final static int startBulletLevel = 1;
	public int bulletLevel;
//	public final int WIDTH = 50;
//	public final int HEIGHT = 50;
//	public final float SPEED = 200;
	
	EntityManager entityManager;
	
	public Player(EntityManager entityManager, Vector2 pos, int velocity, float direction, TextureRegion texture, float rotate) {
		super(playerID, pos, velocity, direction, texture, rotate);
		setHp(5);
//		setBounds(pos.x, pos.y, texture.getRegionWidth(), texture.getRegionHeight());
		setLastFire(0);
		this.entityManager = entityManager;
		bulletLevel = startBulletLevel;
	}

	public void fire() {
		if(bulletLevel == 1) {
			addBulletone();
		}else if(bulletLevel == 2) {
			addBullettwo();
		}else {
			addBulletthree();
		}
	}
	
	public void useItem() {
		bulletLevel ++;
		if(bulletLevel > 3){ bulletLevel = 1; }
	}

	@Override
	public void update() {
		moveOut();
	}
	
	public void moveUp() {
		setPos(getPos().x, getPos().y + getVelocity());
	}
	
	public void moveDown() {
		setPos(getPos().x, getPos().y - getVelocity());
	}
	
	public void moveRight() {
		setPos(getPos().x + getVelocity(), getPos().y);
	}
	
	public void moveLeft() {
		setPos(getPos().x - getVelocity(), getPos().y);
	}
	
	private void moveOut() {
		if(getPos().x < 20) { setPos(20, getPos().y); }
		if(getPos().x > 640) { setPos(640, getPos().y); }
		if(getPos().y < 20) { setPos(getPos().x, 20); }
		if(getPos().y > 890) { setPos(getPos().x, 890); }
	}
	
	private void addBulletone() {
		if(System.currentTimeMillis() - getLastFire() >= 50) {
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) + 10, (Assets.PLAYER.getRegionHeight()/2) + getPos().y), 50, 90, Assets.REDBEAM, 0));
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) - 10, (Assets.PLAYER.getRegionHeight()/2) + getPos().y), 50, 90, Assets.REDBEAM, 0));
			setLastFire(System.currentTimeMillis());
		}
	}
	
	private void addBullettwo() {
		if(System.currentTimeMillis() - getLastFire() >= 50) {
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) + 30, (Assets.PLAYER.getRegionHeight()) + getPos().y), 20, 66, Assets.BULLETCIRGREEN, 66));
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) + 10, (Assets.PLAYER.getRegionHeight()/2) + getPos().y), 50, 90, Assets.REDBEAM, 0));
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) - 10, (Assets.PLAYER.getRegionHeight()/2) + getPos().y), 50, 90, Assets.REDBEAM, 0));
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) - 30, (Assets.PLAYER.getRegionHeight()) + getPos().y), 20, 114, Assets.BULLETCIRGREEN, 114));
			setLastFire(System.currentTimeMillis());
		}
	}
	
	private void addBulletthree() {
		if(System.currentTimeMillis() - getLastFire() >= 10) {
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) - 15, (Assets.PLAYER.getRegionHeight()/2) + getPos().y), 50, 90, Assets.REDBEAM, 0));
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2), (Assets.PLAYER.getRegionHeight()/2) + getPos().y), 50, 90, Assets.REDBEAM, 0));
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) + 15, (Assets.PLAYER.getRegionHeight()/2) + getPos().y), 50, 90, Assets.REDBEAM, 0));
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) + 30, (Assets.PLAYER.getRegionHeight()) + getPos().y), 20, 66, Assets.BULLETCIRGREEN, 66));
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2), (Assets.PLAYER.getRegionHeight()/2) + getPos().y), 50, 90, Assets.REDBEAM, 0));
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) - 30, (Assets.PLAYER.getRegionHeight()) + getPos().y), 20, 114, Assets.BULLETCIRGREEN, 114));
			setLastFire(System.currentTimeMillis());
		}
	}

	@Override
	public Boolean isCollision(SpaceObject object) {
		// TODO Auto-generated method stub
		return null;
	}
}
