package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Game;

public abstract class SpaceObject {
	
	private int id;
	private Vector2 pos;
	private int velocity;
	private double direction;
	private Texture texture;
	private int delay;
	private Rectangle bounds;
	public float width, height;

	public SpaceObject(int id, Vector2 pos, int velocity, double direction, Texture texture, int delay){
		this.id = id;
		this.pos = pos;
		this.velocity = velocity;
		this.direction = direction;
		this.texture = texture;
		bounds = new Rectangle(pos.x, pos.y, width, height);
	}
	
	public abstract Boolean isCollision(SpaceObject object);
	public abstract void update();
	
	public void moveObject(){
		pos.x += velocity * MathUtils.cosDeg((float) direction);
		pos.y += velocity * MathUtils.sinDeg((float) direction);
	}
	
	public Vector2 getPos() {
		return pos;
	}
	
	public void setPos(float x, float y) {
		pos.set(x, y);
		bounds.setX(x);
		bounds.setY(y);
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public void setBounds(float x, float y, float width, float height) {
		bounds.set(x, y, width, height);
		pos.set(x, y);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public double getDirection() {
		return direction;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public void render(){
		Game.batch.draw(texture, pos.x, pos.y);
	}
}
