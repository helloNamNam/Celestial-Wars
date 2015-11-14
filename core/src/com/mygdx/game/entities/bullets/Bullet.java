package com.mygdx.game.entities.bullets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.entities.EntityManager;
import com.mygdx.game.entities.ItemObject;

public class Bullet extends ItemObject{
	
	private EntityManager entityManager;
	
	public Bullet(EntityManager entityManager, int id, Vector2 pos, int velocity, double direction, Texture texture) {
		super(id, pos, velocity, direction, texture);
//		setBounds(pos.x, pos.y, texture.getWidth(), texture.getHeight());
	}

	@Override
	public void update() {
		moveObject(entityManager);
	}
}