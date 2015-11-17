package com.mygdx.game.entities;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public abstract class ItemObject extends SpaceObject {
	

	public ItemObject(int id, Vector2 pos, double velocity, double direction, TextureRegion texture, float rotate, float xBody, float yBody, float widthBody, float heightBody) {
		super(id, pos, velocity, direction, texture, rotate, xBody, yBody, widthBody, heightBody);
	}

	@Override
	public Boolean isCollision(SpaceObject object) {
		return null;
	}
}
