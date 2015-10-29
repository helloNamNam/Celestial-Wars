package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Game;
import com.mygdx.game.states.PlayState;

public class Player extends SpaceObject{
	
	private Rectangle pos;
	private Texture body;
	private Texture playArea;
	
	//Constructor
	public Player(Texture playArea){
		this.playArea = playArea;
		body = new Texture("Bitsprite.png");
		pos = new Rectangle();
		pos.x = (Game.WIDTH / 2) - (playArea.getWidth() / 2);
		pos.y = 0;
	}
	
	//update check input
	public void update(float dt){
		move();
	}
	
	//call when player fire
	public void fire(){}
	//call when player move
	public void move(){
		if(Gdx.input.isKeyPressed(Keys.LEFT)){ pos.x -= 200 * Gdx.graphics.getDeltaTime(); }
		if(Gdx.input.isKeyPressed(Keys.RIGHT)){ pos.x += 200 * Gdx.graphics.getDeltaTime(); }
		if(Gdx.input.isKeyPressed(Keys.DOWN)){ pos.y -= 200 * Gdx.graphics.getDeltaTime(); }
		if(Gdx.input.isKeyPressed(Keys.UP)){ pos.y += 200 * Gdx.graphics.getDeltaTime(); }
		
		if(pos.x < 0){ pos.x = 0; }
		if(pos.x > playArea.getWidth() - body.getWidth()){ pos.x = playArea.getWidth() - body.getWidth(); }
		if(pos.y < 0){ pos.y = 0; }
		if(pos.y > playArea.getHeight() - body.getHeight()){ pos.y = playArea.getHeight() - body.getHeight(); }
	}
	public void die(){}
	public void born(){}
	public void useItem(){}
	//getter of Body
	public Texture getBody() {
		return body;
	}
	//getter of Position
	public Rectangle getPos() {
		return pos;
	}
	
}
