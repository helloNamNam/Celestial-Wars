package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public abstract class ItemObject extends SpaceObject {
	

	public ItemObject(int id, Vector2 pos, int velocity, double direction, TextureRegion texture, float rotate) {
		super(id, pos, velocity, direction, texture, rotate);
	}

	@Override
	public Boolean isCollision(SpaceObject object) {
		return null;
	}
}
