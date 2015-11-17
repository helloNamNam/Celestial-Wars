package com.mygdx.game.entities.bullets;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.entities.EntityManager;
import com.mygdx.game.entities.ItemObject;

public class Bullet extends ItemObject{
	
	private EntityManager entityManager;
	
	public Bullet(EntityManager entityManager, int id, Vector2 pos, double velocity, double direction, TextureRegion texture, float rotate) {
		super(id, pos, velocity, direction, texture, rotate, 0, 0, texture.getRegionWidth(), texture.getRegionHeight());
//		setBounds(pos.x, pos.y, texture.getWidth(), texture.getHeight());
	}

	@Override
	public void update() {
		moveObject(entityManager);
	}
}