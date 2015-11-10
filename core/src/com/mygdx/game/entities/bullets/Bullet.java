package com.mygdx.game.entities.bullets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.entities.ItemObject;
import com.mygdx.game.entities.SpaceObject;

public class Bullet extends ItemObject{
	

	public Bullet(int id, Vector2 pos, int velocity, double direction, Texture texture, int delay) {
		super(id, pos, velocity, direction, texture, delay);
		width = 50;
		height = 50;
		setBounds(pos.x, pos.y, width, height);
	}

	@Override
	public void update() {
		moveObject();
	}
}