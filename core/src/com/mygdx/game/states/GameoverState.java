package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Game;
import com.mygdx.game.entities.EntityManager;
import com.mygdx.game.entities.Player;

public class GameoverState extends State {
	private Sprite gameover;
	SpriteBatch spriteBatch;
	private Music sad;
	

	public GameoverState(GameStateManager gsm) {
		super(gsm);
		create();
		// TODO Auto-generated constructor stub
	}
	public void create(){
		spriteBatch = new SpriteBatch();
		sad = Gdx.audio.newMusic(Gdx.files.internal("Sounds/Gameover.mp3"));
		sad.play();
		gameover = new Sprite(new Texture(Gdx.files.internal("images/Gameover.png")));
		gameover.setBounds(0, 0, gameover.getRegionWidth(), gameover.getHeight());
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)){
			sad.dispose();
			Player.heartPoint = 3;
			gsm.set(new MenuState(gsm));
		}

	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		handleInput();

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		spriteBatch.begin();
		gameover.draw(spriteBatch);
		spriteBatch.end();

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
