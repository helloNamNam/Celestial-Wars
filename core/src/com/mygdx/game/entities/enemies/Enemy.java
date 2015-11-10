package com.mygdx.game.entities.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.entities.Unit;

public abstract class Enemy extends Unit{
	

	public Enemy(int id, Vector2 pos, int velocity, float direction, Texture texture, int delay) {
		super(id, pos, velocity, direction, texture, delay);
	}

	public abstract void process();
}
