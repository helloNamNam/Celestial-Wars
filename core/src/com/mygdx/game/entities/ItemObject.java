package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Assets;

public abstract class ItemObject extends SpaceObject {
	
	

	public ItemObject(int id, Vector2 pos, int velocity, double direction, Texture texture, int delay) {
		super(id, pos, velocity, direction, texture, delay);
	}

	@Override
	public Boolean isCollision(SpaceObject object) {
		return null;
	}
}
