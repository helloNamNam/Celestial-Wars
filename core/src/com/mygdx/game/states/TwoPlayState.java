package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Assets;
import com.mygdx.game.TimeControl;
import com.mygdx.game.entities.EntityManager;
import com.mygdx.game.entities.Player;
import com.mygdx.game.entities.enemies.Enemy;

public class TwoPlayState extends State{

	public static int stage = 1;

	public int loop;
	public int counterID;
	
	public Texture background;
	
	public Player player;
	public Enemy enemy;
	public EntityManager entityManager;
	private TimeControl timeControl;
	
	public TwoPlayState(GameStateManager gsm) {
		super(gsm);
		counterID = 6;
		entityManager = new EntityManager();
		player = new Player(entityManager, new Vector2(100, 50), 4, -1, Assets.PLAYER, 0, 15, 28, 12, 12);
		entityManager.addPlayer(player);
		background = loadTexture("playbg.png");
		timeControl = new TimeControl();
		new Thread(timeControl).start();
	}
	
	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
