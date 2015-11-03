package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.math.Vector2;

public abstract class SpaceObject {
	
//	private Texture texture;
//	private Vector2 pos, direction;
	
	private float dx;
	private float dy;
	
	private float radians;
	private float speed;
	
//	public SpaceObject(Texture texture, Vector2 pos, Vector2 direction){
//		this.texture = texture;
//		this.pos = pos;
//		this.direction = direction;
//	}
//
//	public Vector2 getPosition() {
//		return pos;
//	}
//
//	public void setDirection(float x, float y) {
//		direction.set(x, y);
//		direction.scl(Gdx.graphics.getDeltaTime());
//	}
}
