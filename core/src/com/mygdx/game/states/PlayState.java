package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Game;

public class PlayState extends State{
	
	private Texture pic;
	private Rectangle p1;

	public PlayState(GameStateManager gsm) {
		super(gsm);
		pic = new Texture(Gdx.files.internal("Bitsprite.png"));
		p1 = new Rectangle();
		p1.x = (Game.WIDTH / 2) - (pic.getWidth() / 2);
		p1.y = 0;
	}

	@Override
	public void handleInput() {	
		
	}

	@Override
	public void update(float dt) {
		handleInput();
		
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.begin();
		sb.draw(pic, p1.x, p1.y);
		sb.end();
		
		if(Gdx.input.isKeyPressed(Keys.LEFT)){ p1.x -= 200 * Gdx.graphics.getDeltaTime(); }
		if(Gdx.input.isKeyPressed(Keys.RIGHT)){ p1.x += 200 * Gdx.graphics.getDeltaTime(); }
		if(Gdx.input.isKeyPressed(Keys.DOWN)){ p1.y -= 200 * Gdx.graphics.getDeltaTime(); }
		if(Gdx.input.isKeyPressed(Keys.UP)){ p1.y += 200 * Gdx.graphics.getDeltaTime(); }
		
		if(p1.x < 0){ p1.x = 0; }
		if(p1.x > Game.WIDTH - pic.getWidth()){ p1.x = Game.WIDTH - pic.getWidth(); }
		if(p1.y < 0){ p1.y = 0; }
		if(p1.y > Game.HEIGHT - pic.getHeight()){ p1.y = Game.HEIGHT - pic.getHeight(); }
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
