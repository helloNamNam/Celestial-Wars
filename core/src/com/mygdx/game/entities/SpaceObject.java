package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Game;

public abstract class SpaceObject {
	
	private int id;
	private Vector2 pos;
	private int velocity;
	private double direction;
	private Texture texture;
	private Rectangle bounds;

	public SpaceObject(int id, Vector2 pos, int velocity, double direction, Texture texture) {
		this.id = id;
		this.pos = pos;
		this.velocity = velocity;
		this.direction = direction;
		this.texture = texture;
		bounds = new Rectangle(pos.x, pos.y, texture.getWidth(), texture.getHeight());
		System.out.println(bounds.toString());
	}

	public abstract Boolean isCollision(SpaceObject object);
	public abstract void update();
	
	public void moveObject(EntityManager entityManager) {
		pos.x += velocity * MathUtils.cosDeg((float) direction);
		pos.y += velocity * MathUtils.sinDeg((float) direction);
		setPos(pos.x, pos.y);
	}
	
	public Vector2 getPos() {
		return pos;
	}
	
	public void setPos(float x, float y) {
		pos.set(x, y);
		bounds.x = x;
		bounds.y = y;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
//	public void setBounds(float x, float y, float width, float height) {
//		bounds.set(x, y, width, height);
//	}
	
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

	public void render() {
		Game.batch.draw(texture, pos.x, pos.y);
	}
}
