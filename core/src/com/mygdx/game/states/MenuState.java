package com.mygdx.game.states;

import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import java.io.*;

public class MenuState extends State{
	
	SpriteBatch spriteBatch;
	
	private Sprite bg;
	
	private Sprite credit1;
	private Sprite credit2;
	
	private Sprite single1;
	private Sprite single2;
	
	private Sprite multi1;
	private Sprite multi2;
	
	private Sprite help1;
	private Sprite help2;
	
	private Sprite score1;
	private Sprite score2;
	
	private Sprite exit1;
	private Sprite exit2;
	
	private Sprite bg_credit;
	
	private float stateTime;
	private int keyCode=1;
	private int al_sing=0,al_mul=0,al_help=0,al_score=0,al_exite=0,al_cre=0;
	
	private Vector2 mouse = new Vector2(0, 0);

	private float al_credit_state=0f;
	private float helpstate = 0f;
	
	public static Music menu;
	private Sound button;
	private Sound enter;
	private Sprite bg_help;
	private Scanner check;
	
	
	//constructor
	public MenuState(GameStateManager gsm) {
		super(gsm);
		create();
	}
	
	public void create () {
		menu = Gdx.audio.newMusic(Gdx.files.internal("Sounds/menu.mp3"));
		button = Gdx.audio.newSound(Gdx.files.internal("Sounds/button.mp3"));
		enter = Gdx.audio.newSound(Gdx.files.internal("Sounds/Enter.mp3"));
		menu.play();
		menu.setLooping(true);
		spriteBatch = new SpriteBatch();

		bg_help = new Sprite(new Texture(Gdx.files.internal("images/helppic.png")));
		bg_credit = new Sprite(new Texture(Gdx.files.internal("images/Creditpic.png")));
		bg = new Sprite(new Texture(Gdx.files.internal("images/bg.png")));
		credit1 = new Sprite(new  Texture("images/Credit_idle.png"));
		credit2 = new Sprite(new Texture("images/Credit_selected.png"));
		single1 = new Sprite(new  Texture("images/Singleplayer_idle.png"));
		single2 = new Sprite(new  Texture("images/Singleplayer_selected.png"));
		multi1 = new Sprite(new  Texture("images/Multiplayer_idle.png"));
		multi2 = new Sprite(new  Texture("images/Multiplayer_selected.png"));
		exit1 = new Sprite(new  Texture("images/Exit_idle.png"));
		exit2 = new Sprite(new  Texture("images/Exit_selected.png"));
		help1 = new Sprite(new  Texture("images/Help_idle.png"));
		help2 = new Sprite(new  Texture("images/Help_selected.png"));
		credit1 = new Sprite(new  Texture("images/Credit_idle.png"));
		credit2 = new Sprite(new  Texture("images/Credit_selected.png"));
		score1 = new Sprite(new  Texture("images/Highscore_idle.png"));
		score2 = new Sprite(new  Texture("images/Highscore_selected.png"));
		
		bg_help.setBounds(0, 0, bg_help.getRegionWidth(), bg_help.getHeight());
		bg_credit.setBounds(0 , 0,bg_credit.getWidth(),bg_credit.getHeight());
		
		single1.setBounds(30, 380, single1.getWidth(), single1.getHeight());
		single2.setBounds(30,380, single2.getWidth(), single2.getHeight());
		multi1.setBounds(30, 310, multi1.getWidth(), multi1.getHeight());
		multi2.setBounds(30, 310, multi2.getWidth(), multi2.getHeight());
		score1.setBounds(30, 240, score1.getWidth(), score1.getHeight());
		score2.setBounds(30, 240, score2.getWidth(), score2.getHeight());
		help1.setBounds(30, 170, help1.getWidth(), help1.getHeight());
		help2.setBounds(30, 170, help2.getWidth(), help2.getHeight());
		credit1.setBounds(30, 100, credit1.getWidth(), credit1.getHeight());
		credit2.setBounds(30, 100, credit2.getWidth(), credit2.getHeight());
		exit1.setBounds(30, 30, exit1.getWidth(), exit1.getHeight());
		exit2.setBounds(30, 30, exit2.getWidth(), exit2.getHeight());
		
		
		
	
	}

	@Override
	public void handleInput() {
		if(Gdx.input.isKeyJustPressed(Keys.UP)){
			keyCode--;
			button.play();
		}
		if(Gdx.input.isKeyJustPressed(Keys.DOWN)){
			keyCode++;
			button.play();
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)){
			al_credit_state=0;
			helpstate=0;
		}
	}

	@Override
	public void update(float dt) {
		handleInput();
		
	}

	@Override
	public void render() {
		
		
		mouse.x = Gdx.input.getX();
		mouse.y = Gdx.input.getY();
		
		stateTime += Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(0,0,0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		spriteBatch.draw(player.getKeyFrame(stateTime, true), 0, 0);
		
		spriteBatch.begin();
		
		al_sing=0;	al_mul=0;	al_help=0;	al_score=0;	al_exite=0;	al_cre=0;
		
		if(keyCode == 1)	al_sing=1;
		if(keyCode == 2)	al_mul=1;
		if(keyCode == 3)	al_score=1;
		if(keyCode == 4)	al_help=1;
		if(keyCode == 5)	al_cre=1;
		if(keyCode == 6)	al_exite=1;
		
		if(keyCode < 1)	keyCode = 6;
		if(keyCode > 6)	keyCode = 1;
		if(Gdx.input.isKeyJustPressed(Keys.ENTER) && stateTime >=0.5)
		{
			enter.play();
			if (al_sing == 1)
			{
				//go to single player
				menu.dispose();
				gsm.set(new PlayState(gsm));
			}
			if (al_mul == 1)
			{
				//go to multiplayer player
			}
			if (al_score == 1)
			{
				try {
					check = new Scanner(new File("highscore.txt"));
				} catch (Exception e) {
				}
				if(check.hasNext())
				{
					
				}else{
					int num = 0;
				}
				
			}
			if (al_help == 1)
			{
				helpstate = 1;
				//go to help
			}
			if (al_cre == 1)
			{
				al_credit_state =1;
				//go to credit
			}
			if (al_exite == 1)
			{
				//go exit
				Gdx.app.exit();
			}
		
		}
		
		
		
		
		
		single2.setAlpha(al_sing);
		multi2.setAlpha(al_mul);
		score2.setAlpha(al_score);
		help2.setAlpha(al_help);
		credit2.setAlpha(al_cre);
		exit2.setAlpha(al_exite);
		
		
		bg.draw(spriteBatch);
		single1.draw(spriteBatch);
		single2.draw(spriteBatch);
		multi1.draw(spriteBatch);
		multi2.draw(spriteBatch);
		score1.draw(spriteBatch);
		score2.draw(spriteBatch);
		help1.draw(spriteBatch);
		help2.draw(spriteBatch);
		credit1.draw(spriteBatch);
		credit2.draw(spriteBatch);
		exit1.draw(spriteBatch);
		exit2.draw(spriteBatch);
		
		
		
		bg_help.setAlpha(helpstate);
		bg_help.draw(spriteBatch);
		bg_credit.setAlpha(al_credit_state);
		bg_credit.draw(spriteBatch);
		spriteBatch.end();
	}
	
	

	@Override
	public void dispose() {
		
	}
	

}
