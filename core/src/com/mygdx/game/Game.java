package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.StartState;

public class Game extends ApplicationAdapter {
	
	//set size of desktop.
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 960;
	public static final String TITLE = "Celestial Wars";
	
	private SpriteBatch batch;
	private GameStateManager gsm;
	
	//call push function of GameStateManager to push StartState.
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.push(new StartState(gsm));
	}

	//set background's program.
	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
}
