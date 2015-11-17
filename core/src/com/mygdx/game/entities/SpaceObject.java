package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Game;

public abstract class SpaceObject {
	
	private int id;
	private Vector2 pos;
	private double velocity;
	private double direction;
	private TextureRegion texture;
	private Rectangle bounds;
	private float xBody;
	private float yBody;
	private float widthBody;
	private float heightBody;
	private float rotate;

	public SpaceObject(int id, Vector2 pos, double velocity, double direction, TextureRegion texture, float rotate, float xBody, float yBody, float widthBody, float heightBody) {
		this.id = id;
		this.pos = pos;
		this.velocity = velocity;
		this.direction = direction;
		this.texture = texture;
		this.rotate = rotate;
		this.xBody = xBody;
		this.yBody = yBody;
		this.setWidthBody(widthBody);
		this.setHeightBody(heightBody);
		bounds = new Rectangle(pos.x + xBody, pos.y + yBody, widthBody, heightBody);
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
		bounds.x = x + xBody;
		bounds.y = y + yBody;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getVelocity() {
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
		Game.batch.draw(texture, pos.x, pos.y, texture.getRegionWidth()/2, texture.getRegionHeight()/2, texture.getRegionWidth(), texture.getRegionHeight(), 1, 1, rotate);
	}

	public float getWidthBody() {
		return widthBody;
	}

	public void setWidthBody(float widthBody) {
		this.widthBody = widthBody;
	}

	public float getHeightBody() {
		return heightBody;
	}

	public void setHeightBody(float heightBody) {
		this.heightBody = heightBody;
	}
}
