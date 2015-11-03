package com.mygdx.game.entities;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bullet {

	public Vector2  bulletLocation = new Vector2(0, 0);
	public Vector2 bulletVelocity = new Vector2(0, 0);
	
	public Bullet(Rectangle shipposition, Rectangle velocity){
		bulletLocation = new Vector2(shipposition.x + 10, shipposition.y + 30);
		bulletVelocity = new Vector2(velocity.x, velocity.y);
	}
	
	public void update(){
		bulletLocation.x += bulletVelocity.x;
		bulletLocation.y += bulletVelocity.y;
	}
	
}
