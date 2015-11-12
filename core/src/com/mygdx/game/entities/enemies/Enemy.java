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
	}

	public void fire() {
		if(getId() == 2) {
			if(System.currentTimeMillis() - getLastFire() >= 2500) {
				entityManager.addEntity(new Bullet(2, new Vector2((Assets.ENEMY.getWidth()/2) + getPos().x - (Assets.BULLET.getWidth()/2) + 10, (Assets.ENEMY.getHeight()/2) + getPos().y), 3, 270, Assets.BULLET));
				setLastFire(System.currentTimeMillis());
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
		moveObject();
	}
}
