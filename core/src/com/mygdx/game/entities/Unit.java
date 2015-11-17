package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public abstract class Unit extends SpaceObject {
	
	private int hp;
	private long lastFire;
	private int roundFire;

	public Unit(int id, Vector2 pos, double velocity, double direction, TextureRegion texture, float rotate, float xBody, float yBody, float widthBody, float heightBody) {
		super(id, pos, velocity, direction, texture, rotate, xBody, yBody, widthBody, heightBody);
		lastFire = 0;
		roundFire = 0;
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public long getLastFire() {
		return lastFire;
	}

	public void setLastFire(long lastFire) {
		this.lastFire = lastFire;
	}
	
	public int getRoundFire() {
		return roundFire;
	}

	public void setRoundFire(int roundFire) {
		this.roundFire = roundFire;
	}
	
}
