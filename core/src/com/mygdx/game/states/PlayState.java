package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Game;
import com.mygdx.game.entities.Player;

public class PlayState extends State{
	
	private Texture background;
	private Texture stageBG;
	private Player player;
	

	//constructor
	public PlayState(GameStateManager gsm) {
		super(gsm);
		background = new Texture(Gdx.files.internal("play_bg.jpg"));
		stageBG = new Texture(Gdx.files.internal("spc1.jpg"));
		player = new Player(stageBG);
		
	}

	//check input from user
	@Override
	public void handleInput(){}

	//update state
	@Override
	public void update(float dt) {
		handleInput();
		player.update(dt);
		
	}

	//draw texture
	@Override
	public void render(SpriteBatch sb) {
		
		sb.begin();
		sb.draw(background, 0, 0);
		sb.draw(stageBG, 0, 0);
		sb.draw(player.getBody(), player.getPos().x, player.getPos().y);
		sb.end();
	}

	@Override
	public void dispose() {
		
	}

}
