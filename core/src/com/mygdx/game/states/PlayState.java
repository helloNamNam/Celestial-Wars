package com.mygdx.game.states;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.entities.Bullet;
import com.mygdx.game.entities.Player;

public class PlayState extends State{
	
	private Texture background;
	private Texture stageBG;
	private Texture bulletTexture;
	private Player player;
	private Bullet testBullet;
	private long lastFire;

	ArrayList<Bullet> bulletmanager = new ArrayList<Bullet>();
	//constructor
	public PlayState(GameStateManager gsm){
		super(gsm);
		background = new Texture(Gdx.files.internal("play_bg.jpg"));
		stageBG = new Texture(Gdx.files.internal("playbg.jpg"));
		bulletTexture = new Texture(Gdx.files.internal("Bullets_test.png"));
		player = new Player(stageBG);
		testBullet = new Bullet(player.getPos(), new Rectangle(20, 0, 0, 0));
	}

	//check input from user
	@Override
	public void handleInput(){}

	//update state
	@Override
	public void update(float dt){
		handleInput();
		player.update(dt);
		testBullet.update();
		
		if(Gdx.input.isKeyPressed(Keys.Z)){
			if(System.currentTimeMillis() - lastFire >= 50){ 
				Bullet mybullet = new Bullet(player.getPos(), new Rectangle(0, 20, 0, 0));
				bulletmanager.add(mybullet);
				lastFire = System.currentTimeMillis();
			}
		}
	}

	//draw texture
	@Override
	public void render(SpriteBatch sb){
		sb.begin();
		sb.draw(background, 0, 0);
		sb.draw(stageBG, 20, 20);
		sb.draw(player.getBody(), player.getPos().x, player.getPos().y);
//		sb.draw(bulletTexture, testBullet.bulletLocation.x, testBullet.bulletLocation.y);
		int cnt = 0;
		while(cnt < bulletmanager.size()){
			Bullet currentbullet = bulletmanager.get(cnt);
			currentbullet.update();
			if(currentbullet.bulletLocation.y > 0 && currentbullet.bulletLocation.y < stageBG.getHeight() - bulletTexture.getHeight() + 20){
				sb.draw(bulletTexture, currentbullet.bulletLocation.x, currentbullet.bulletLocation.y);
			}
			cnt++;
		}
		sb.end();
		
		
	}

	@Override
	public void dispose(){
		
	}

}
