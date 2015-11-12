package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public abstract class State {

	protected GameStateManager gsm;
	
	public State(GameStateManager gsm) {
		this.gsm = gsm;
	}
	
	public abstract void handleInput();
	public abstract void update(float dt);
	public abstract void render();
	public abstract void dispose();
	
	public Texture loadTexture(String filePath) {
		Gdx.app.log("Load Texture", filePath);
		return new Texture(filePath);
	}
	
}
