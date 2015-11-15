package com.mygdx.game.entities.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Assets;
import com.mygdx.game.entities.EntityManager;
import com.mygdx.game.entities.SpaceObject;
import com.mygdx.game.entities.Unit;
import com.mygdx.game.entities.bullets.Bullet;

public class Enemy extends Unit{
	
	private EntityManager entityManager;
	private float random;
	
	public Enemy(EntityManager entityManager, int id, Vector2 pos, int velocity, float direction, TextureRegion texture, float rotate) {
		super(id, pos, velocity, direction, texture, rotate);
		this.entityManager = entityManager;
		setLastFire(0);
	}

	public void fire() {
		if(getId() >= 6 && getId() <= 15) {
			if(System.currentTimeMillis() - getLastFire() >= 500) {
				entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 7, 270, Assets.BULLETLINE, 270));
				setLastFire((long) (System.currentTimeMillis() + Math.random()*250));
			}
		}
		if(getId() >= 16 && getId() <= 21) {
			if(System.currentTimeMillis() - getLastFire() >= 200) {
				this.random = (float) Math.random();
				entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 7, 225 + this.random*90, Assets.BULLETLINE, 225 + this.random*90));
				setLastFire((long) (System.currentTimeMillis() + Math.random()*250));
			}
		}
		if(getId() >= 22 && getId() <= 23) {
			System.out.println(getPos().y);
			if(getPos().y == 607){
				setVelocity(0);
			}
			if(System.currentTimeMillis() - getLastFire() >= 2000) {
				for(int degree = 0; degree < 360; degree += 12) {
					 
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, degree, Assets.BULLETSTAR, degree));
				}
				setLastFire(System.currentTimeMillis());
				setVelocity(5);
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
