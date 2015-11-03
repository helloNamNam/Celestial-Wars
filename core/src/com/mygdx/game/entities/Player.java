package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Game;

public class Player extends SpaceObject{
	
	private Rectangle pos;
	private Texture body;
	private Texture playArea;
	private long lastFire;
	
	//Constructor
	public Player(Texture playArea){
		this.playArea = playArea;
		body = new Texture("Bitsprite.png");
		pos = new Rectangle();
		pos.x = (Game.WIDTH / 2) - (playArea.getWidth() / 2);
		pos.y = 23;
	}
	
	//update check input
	public void update(float dt){
		move();
//		if(Gdx.input.isKeyPressed(Keys.Z)){ 
//			if(System.currentTimeMillis() - lastFire >= 250){ 
//				fire(); 
//			} 
//		}
		if(Gdx.input.isKeyPressed(Keys.X)){ useItem(); }
	}
	
	//call when player fire
	public void fire(){ 
		System.out.println("Fire !!!");
	}
	//call when player move
	public void move(){
		if(Gdx.input.isKeyPressed(Keys.LEFT)){ pos.x -= 200 * Gdx.graphics.getDeltaTime(); }
		if(Gdx.input.isKeyPressed(Keys.RIGHT)){ pos.x += 200 * Gdx.graphics.getDeltaTime(); }
		if(Gdx.input.isKeyPressed(Keys.DOWN)){ pos.y -= 200 * Gdx.graphics.getDeltaTime(); }
		if(Gdx.input.isKeyPressed(Keys.UP)){ pos.y += 200 * Gdx.graphics.getDeltaTime(); }
		
		if(pos.x < 23){ pos.x = 23; }
		if(pos.x > playArea.getWidth() - body.getWidth() + 17){ pos.x = playArea.getWidth() - body.getWidth() + 17; }
		if(pos.y < 23){ pos.y = 23; }
		if(pos.y > playArea.getHeight() - body.getHeight() + 17){ pos.y = playArea.getHeight() - body.getHeight() + 17; }
	}
	public void die(){}
	public void born(){}
	public void useItem(){ System.out.println("Use item");}
	//getter of Body
	public Texture getBody() {
		return body;
	}
	//getter of Position
	public Rectangle getPos() {
		return pos;
	}
	
}
