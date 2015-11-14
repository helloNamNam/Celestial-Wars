package com.mygdx.game.entities.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Assets;
import com.mygdx.game.entities.EntityManager;
import com.mygdx.game.entities.SpaceObject;
import com.mygdx.game.entities.Unit;
import com.mygdx.game.entities.bullets.Bullet;

public class Enemy extends Unit{
	
	private EntityManager entityManager;
	
	public Enemy(EntityManager entityManager, int id, Vector2 pos, int velocity, float direction, Texture texture) {
		super(id, pos, velocity, direction, texture);
		this.entityManager = entityManager;
		setLastFire(0);
	}

	public void fire() {
		if(getId() == 3) {
			if(System.currentTimeMillis() - getLastFire() >= 500) {
				entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.ENEMY.getWidth()/2) + getPos().x - (Assets.BULLET.getWidth()/2) + 10, (Assets.ENEMY.getHeight()/2) + getPos().y), 7, 270, Assets.BULLET));
				setLastFire((long) (System.currentTimeMillis() + Math.random()*250));
			}
		}else if(getId() == 4){
			if(System.currentTimeMillis() - getLastFire() >= 200) {
				entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.ENEMY.getWidth()/2) + getPos().x - (Assets.BULLET.getWidth()/2) + 10, (Assets.ENEMY.getHeight()/2) + getPos().y), 7, 225 + Math.random()*90, Assets.BULLET));
				setLastFire((long) (System.currentTimeMillis() + Math.random()*250));
			}
		}
	}
	@Override
	public Boolean isCollision(SpaceObject object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		moveObject(entityManager);
		fire();
	}
}
