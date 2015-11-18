package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Game;

public class StartState extends State{

	private Texture background;
	private Texture startBtn;
	private float time = 0;
	
	//constructor
	public StartState(GameStateManager gsm) {
		super(gsm);
		background = loadTexture("backgroundCW.jpg");
		startBtn = loadTexture("startBtn.png");
	}

	//check input from user and go to next state
	@Override
	public void handleInput() {
		if(Gdx.input.isKeyPressed(Keys.ANY_KEY)) {
//			gsm.set(new PlayState(gsm));
			gsm.set(new MenuState(gsm));
			dispose();
		}
	}

	//update state. (wait input)
	@Override
	public void update(float dt) {
		handleInput();
	}

	//draw texture
	@Override
	public void render() {
		Game.batch.begin();
		Game.batch.draw(background, 0, 0, Game.WIDTH, Game.HEIGHT);
		if(time % 100 <= 50) {
			Game.batch.draw(startBtn, (Game.WIDTH / 2) - (startBtn.getWidth() / 2), 160);
		}
		time++;
		
		Game.batch.end();
	}
	
	//remove
	public void dispose() {
		background.dispose();
		startBtn.dispose();
	}

}
