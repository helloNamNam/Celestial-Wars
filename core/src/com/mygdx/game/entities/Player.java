package com.mygdx.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Assets;
import com.mygdx.game.entities.bullets.Bullet;
import com.mygdx.game.states.PlayState;
import java.io.*;
import java.util.Scanner;

public class Player extends Unit {

	public final static int playerID = 1;
	public final static int startBulletLevel = 1;
	public static int heartPoint = 99;
	public int bulletLevel;
	private Sound shoot;
//	public final int WIDTH = 50;
//	public final int HEIGHT = 50;
//	public final float SPEED = 200;
	
	EntityManager entityManager;
	private Scanner check;
	
	public Player(EntityManager entityManager, Vector2 pos, int velocity, float direction, TextureRegion texture, float rotate, float xBody, float yBody, float widthBody, float heightBody) {
		super(playerID, pos, velocity, direction, texture, rotate, xBody, yBody, widthBody, heightBody);
		setHp(1);
		shoot = Gdx.audio.newSound(Gdx.files.internal("Sounds/shoot.mp3"));
//		setBounds(pos.x, pos.y, texture.getRegionWidth(), texture.getRegionHeight());
		setLastFire(0);
		this.entityManager = entityManager;
		bulletLevel = startBulletLevel;
	}

	public void fire() {
		shoot.play(1f);
		if(bulletLevel == 1) {
			addBulletone();
		}else if(bulletLevel == 2) {
			addBullettwo();
		}else {
			addBulletthree();
		}
	}
	
	public void useItem() {
		bulletLevel ++;
		if(bulletLevel > 3){ bulletLevel = 1; }
	}

	public void die(){
		heartPoint --;
		if(heartPoint > 0){
			setPos(PlayState.pointStartX, PlayState.pointStartY);
			setHp(1);
		}else{
			File outFile = new File("highscore.txt");
			FileWriter fileWriter = null;
			try {
				fileWriter = new FileWriter(outFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			PrintWriter printWriter= new PrintWriter(fileWriter);
			String content = (PlayState.score+"");
			try {
				check = new Scanner(new File("highscore.txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			if (check.hasNext())
			{
				String num = check.next();
				if(PlayState.score >= Integer.parseInt(num))
				{
					printWriter.println(PlayState.score);
				}
				else
				{
					printWriter.println(num);
				}
			}else
			{
				printWriter.println(content);
			}
			printWriter.close();
		}
	}
	@Override
	public void update() {
		moveOut();
	}
	
	public void moveUp() {
		setPos(getPos().x, (float) (getPos().y + getVelocity()));
	}
	
	public void moveDown() {
		setPos(getPos().x, (float) (getPos().y - getVelocity()));
	}
	
	public void moveRight() {
		setPos((float) (getPos().x + getVelocity()), getPos().y);
	}
	
	public void moveLeft() {
		setPos((float) (getPos().x - getVelocity()), getPos().y);
	}
	
	private void moveOut() {
		if(getPos().x < 20) { setPos(20, getPos().y); }
		if(getPos().x > 640) { setPos(640, getPos().y); }
		if(getPos().y < 20) { setPos(getPos().x, 20); }
		if(getPos().y > 890) { setPos(getPos().x, 890); }
	}
	
	private void addBulletone() {
		if(System.currentTimeMillis() - getLastFire() >= 50) {
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2 + getPos().x) - (Assets.BULLETLEVEL11.getRegionWidth()/2) - 10, Assets.PLAYER.getRegionHeight()/2 + getPos().y), 50, 90, Assets.BULLETLEVEL11, 0));
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2 + getPos().x) - (Assets.BULLETLEVEL12.getRegionWidth()/2) + 10, Assets.PLAYER.getRegionHeight()/2 + getPos().y), 50, 90, Assets.BULLETLEVEL12, 0));
			setLastFire(System.currentTimeMillis());
		}
	}
	
	private void addBullettwo() {
		if(System.currentTimeMillis() - getLastFire() >= 100) {
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2 + getPos().x) - (Assets.BULLETLEVEL23.getRegionWidth()/2) - 50, Assets.PLAYER.getRegionHeight()/2 + getPos().y), 70, 90, Assets.BULLETLEVEL23, 0));
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2 + getPos().x) - (Assets.BULLETLEVEL21.getRegionWidth()/2) - 15, Assets.PLAYER.getRegionHeight()/2 + getPos().y), 50, 90, Assets.BULLETLEVEL21, 0));
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2 + getPos().x) - (Assets.BULLETLEVEL22.getRegionWidth()/2) + 15, Assets.PLAYER.getRegionHeight()/2 + getPos().y), 50, 90, Assets.BULLETLEVEL22, 0));
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2 + getPos().x) - (Assets.BULLETLEVEL24.getRegionWidth()/2) + 50, Assets.PLAYER.getRegionHeight()/2 + getPos().y), 70, 90, Assets.BULLETLEVEL24, 0));
			setLastFire(System.currentTimeMillis());
		}
	}
	
	private void addBulletthree() {
		if(System.currentTimeMillis() - getLastFire() >= 100) {
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2 + getPos().x) - (Assets.BULLETLEVEL35.getRegionWidth()/2) - 60, Assets.PLAYER.getRegionHeight()/2 + getPos().y + 40), 50, 90, Assets.BULLETLEVEL35, 0));
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2 + getPos().x) - (Assets.BULLETLEVEL33.getRegionWidth()/2) - 50, Assets.PLAYER.getRegionHeight()/2 + getPos().y + 20), 50, 90, Assets.BULLETLEVEL33, 0));
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2 + getPos().x) - (Assets.BULLETLEVEL31.getRegionWidth()/2) - 15, Assets.PLAYER.getRegionHeight()/2 + getPos().y), 50, 90, Assets.BULLETLEVEL31, 0));
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2 + getPos().x) - (Assets.BULLETLEVEL32.getRegionWidth()/2) + 15, Assets.PLAYER.getRegionHeight()/2 + getPos().y), 50, 90, Assets.BULLETLEVEL32, 0));
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2 + getPos().x) - (Assets.BULLETLEVEL34.getRegionWidth()/2) + 50, Assets.PLAYER.getRegionHeight()/2 + getPos().y + 20), 50, 90, Assets.BULLETLEVEL34, 0));
			entityManager.addBullet(new Bullet(entityManager, 2, new Vector2((Assets.PLAYER.getRegionWidth()/2 + getPos().x) - (Assets.BULLETLEVEL36.getRegionWidth()/2) + 60, Assets.PLAYER.getRegionHeight()/2 + getPos().y + 40), 50, 90, Assets.BULLETLEVEL36, 0));
			setLastFire(System.currentTimeMillis());
		}
	}

	@Override
	public Boolean isCollision(SpaceObject object) {
		// TODO Auto-generated method stub
		return null;
	}
}
