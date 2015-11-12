package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class Unit extends SpaceObject {


	public Unit(int id, Vector2 pos, int velocity, float direction, Texture texture) {
		super(id, pos, velocity, direction, texture);
	}

	private int hp;
	private long lastFire;
	
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
	
	
}
