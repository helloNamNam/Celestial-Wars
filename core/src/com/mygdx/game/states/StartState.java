package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Game;

public class StartState extends State{

	private Texture background;
	private Texture startBtn;
	public StartState(GameStateManager gsm) {
		super(gsm);
		background = new Texture("background_CW.jpg");
		startBtn = new Texture("startBtn.png");
	}

	@Override
	public void handleInput() {
		if(Gdx.input.isKeyPressed(Keys.ANY_KEY)){
			gsm.set(new PlayState(gsm));
			dispose();
		}
	}

	@Override
	public void update(float dt) {
		handleInput();
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.begin();
		sb.draw(background, 0, 0, Game.WIDTH, Game.HEIGHT);
		sb.draw(startBtn, (Game.WIDTH / 2) - (startBtn.getWidth() / 2), 160);
		sb.end();
		
	}
	
	public void dispose(){
		background.dispose();
		startBtn.dispose();
	}

}
