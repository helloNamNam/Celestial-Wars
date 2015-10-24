package com.mygdx.game.states;

public abstract class State {

	private GameStateManager gsm;
	
	public State(GameStateManager gsm){
		this.gsm = gsm;
	}
	
	public abstract void handleInput();
	public abstract void update(float dt);
	public abstract void render(SpriteBatch sb);
}
