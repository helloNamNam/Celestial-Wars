package com.mygdx.game.entities.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Assets;
import com.mygdx.game.TimeControl;
import com.mygdx.game.entities.EntityManager;
import com.mygdx.game.entities.SpaceObject;
import com.mygdx.game.entities.Unit;
import com.mygdx.game.entities.bullets.Bullet;
import com.mygdx.game.states.PlayState;

public class Enemy extends Unit{
	
	private EntityManager entityManager;
	private int degree;
	private int count = 0;
	private float random;
	private TimeControl time;
	private Music victory;
	private Music bossdead;
	private Music victorycon;
	private Music nokill;
	
	public Enemy(EntityManager entityManager, int id, int hp, Vector2 pos, double velocity, double direction, TextureRegion texture, float rotate, float xBody, float yBody, float widthBody, float heightBody) {
		super(id, pos, velocity, direction, texture, rotate, xBody, yBody, widthBody, heightBody);
		this.entityManager = entityManager;
		setLastFire(0);
		setHp(hp);
		degree = 0;
	}
	public Enemy(EntityManager entityManager, int id, int hp, Vector2 pos, double velocity, double direction, TextureRegion texture, float rotate, float xBody, float yBody, float widthBody, float heightBody, TimeControl time) {
		super(id, pos, velocity, direction, texture, rotate, xBody, yBody, widthBody, heightBody);
		this.entityManager = entityManager;
		setLastFire(0);
		setHp(hp);
		this.time = time;
	}

	public void fire() {
		victory = Gdx.audio.newMusic(Gdx.files.internal("Sounds/victory.mp3"));
		bossdead = Gdx.audio.newMusic(Gdx.files.internal("Sounds/bossdead.mp3"));
		victorycon = Gdx.audio.newMusic(Gdx.files.internal("Sounds/victorycon.mp3"));
		nokill = Gdx.audio.newMusic(Gdx.files.internal("Sounds/nokillboss.mp3"));
		if(PlayState.stage == 1) {
			fireStageOne();
		}else if(PlayState.stage == 2) {
			fireStageTwo();
		}else if(PlayState.stage == 5) {
			fireStageFive();
		}
	}

	@Override
	public void update() {
		if(PlayState.stage == 2){
			if(getId() == 304){
				if(getPos().y < 650 && getDirection() > 270){
					setVelocity(0);
					setDirection(getDirection()-0.2f);
					setRotate(getRotate()-0.2f);
				}
				if(getDirection() < 270){
					setDirection(90);
					setRotate(180);
					setVelocity(20);
				}
			}
			if(getId() == 325){
				if(getPos().y < 600){
					setRotate(getRotate()-7);
				}
				if(getPos().y >= 600){
					setDirection(getDirection()-3);
					setRotate(getRotate()-7);
					setVelocity(8);
				}else if(getVelocity() == 8){
					setRotate(getRotate()-10);
				}
			}
			if(getId() == 326){
				if(getPos().y < 600){
					setRotate(getRotate()+7);
				}
				if(getPos().y >= 600){
					setDirection(getDirection()+3);
					setRotate(getRotate()+7);
					setVelocity(8);
				}else if(getVelocity() == 8){
					setRotate(getRotate()+10);
				}
			}
			if(getId() == 327 || getId() == 328){
				if(getId() == 327){
					if(getPos().y < 600){
						setRotate(getRotate()-7);
					}
					if(getPos().y >= 600){
						setDirection(5);
						setRotate(getRotate()-15);
						setVelocity(0.1);
					}
					if(getPos().y >= 605){
						setDirection(0);
						setVelocity(10);
					}
				}
				if(getId() == 328){
					if(getPos().y < 600){
						setRotate(getRotate()+7);
					}
					if(getPos().y >= 600){
						setDirection(175);
						setRotate(getRotate()+15);
						setVelocity(0.1);
					}
					if(getPos().y >= 605){
						setDirection(180);
						setVelocity(10);
					}
				}
			}
			if(getId() == 329){
				if(getPos().x >= 400){
					setDirection(getDirection()-3);
					setRotate(getRotate()-3);
				}
			}
			if(getId() == 331){
				if(getPos().y >= 650 && getDirection() < 271){
					setVelocity(0);
					setRotate(getRotate()+3);
					setDirection(getDirection()+3);
				}
				if(getDirection() > 270){
					setVelocity(20);
					setDirection(270);
				}			
			}
			
			if(getId() == 332){
				if(getId() == 332 && getVelocity() > 0 ){
					if(getPos().y < 620 && getDirection() > 268){
						setVelocity(2);
						setDirection(getDirection()-2);
						setRotate(getRotate()-2);
					}
					if(getDirection() <= 270){
						setVelocity(0);
						setDirection(getDirection()-2);
						setRotate(getRotate()-2);
					}
				}
			}
			
			
			if(getId() == 334 || getId() == 335 || getId() == 336){
				if(getId() == 334 && getVelocity() > 0 ){
					if(getPos().y < 760 && getDirection() > 268){
						setVelocity(2);
						setDirection(getDirection()-2);
						setRotate(getRotate()-2);
					}
					if(getDirection() < 270){
						setVelocity(0);
					}
				}
				if(getId() == 335 && getVelocity() > 0 ){
					if(getPos().y < 760 && getDirection() < 272){
						setVelocity(2);
						setDirection(getDirection()+2);
						setRotate(getRotate()+2);
					}
					if(getDirection() > 270){
						setVelocity(0);
					}
				}
				if(getId() == 336 && getVelocity() > 0 ){
					if(getPos().y <= 800){
						setVelocity(0);
					}
				}
			}
			if(getId() == 337){
				if(getPos().y <= 600 && getDirection() == 240){
					setDirection(0);
					setRotate(0-270);
				}
				if(getDirection() == 0){
					random = (float) (Math.random()*8000);
					if(random < 10 && getDirection() == 0){
						float angle = (float) Math.toDegrees(Math.atan2(entityManager.getPlayers().get(0).getPos().y - getPos().y, entityManager.getPlayers().get(0).getPos().x - getPos().x));
				    	if(angle < 0){
				        	angle += 360;
				    	}
				    	setDirection(angle);
						setRotate(angle-270);
						setVelocity(3);
					}
				}
			}
		}
		moveObject(entityManager);
		fire();
	}

	@Override
	public Boolean isCollision(SpaceObject object) {
		return null;
	}

	private void fireStageOne() {
		
		if((getId() >= 6 && getId() <= 15) || (getId() >= 52 && getId() <= 61) || (getId() >= 74 && getId() <= 93)) {
			if(System.currentTimeMillis() - getLastFire() >= 1000) {
				entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 7, 270, Assets.BULLETSTAR, 270));
				setLastFire((long) (System.currentTimeMillis() + Math.random()*250));
			}
		}

		if((getId() >= 16 && getId() <= 21) || (getId() >= 62 && getId() <= 73)) {
			if(System.currentTimeMillis() - getLastFire() >= 500) {
				random = (float) Math.random();
				entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 7, 225 + random*90, Assets.BULLETSTAR, 225 + this.random*90));
				setLastFire((long) (System.currentTimeMillis() + Math.random()*250));
			}
		}

		if(getId() >= 22 && getId() <= 23) {
			if(getPos().y == 607){
				setVelocity(0);
			}
			if(System.currentTimeMillis() - getLastFire() >= 2500) {
				for(int degree = 0; degree < 360; degree += 12) {

					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, degree, Assets.BULLETSTAR, degree));
				}
				setLastFire(System.currentTimeMillis());
				setVelocity(5);
			}
		}

		if(getId() == 24 || getId() == 26) {
			if(getPos().x == 159){
				setVelocity(0);
				if(System.currentTimeMillis() - getLastFire() >= 2500) {
					for(int degree = 0; degree < 360; degree += 12) {

						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, degree, Assets.BULLETSTAR, degree));
					}
					setLastFire(System.currentTimeMillis());
					setDirection(315);
					setVelocity(5);
				}
			}

		}

		if(getId() == 25 || getId() == 27) {
			if(getPos().x == 501){
				setVelocity(0);
				if(System.currentTimeMillis() - getLastFire() >= 2500) {
					for(int degree = 0; degree < 360; degree += 12) {

						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, degree, Assets.BULLETSTAR, degree));
					}
					setLastFire(System.currentTimeMillis());
					setDirection(225);
					setVelocity(5);
				}
			}
		}

		if(getId() >= 28 && getId() <= 37) {
			if(getPos().y == 695 && getId() % 2 == 0){
				setDirection(0);
			}
			if(getPos().y == 695 && getId() % 2 == 1){
				setDirection(180);
			}
			if(System.currentTimeMillis() - getLastFire() >= 1000) {
				entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 7, 270, Assets.BULLETSTAR, 270));
				setLastFire((long) (System.currentTimeMillis() + Math.random()*100));
			}
		}

		if(getId() >= 38 && getId() <= 51) {
			int fireDegree = 105;
			if(getId() % 2 == 0) {
				fireDegree = -105;
			}
			if(System.currentTimeMillis() - getLastFire() >= 1000) {
				entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 7, getDirection() + fireDegree, Assets.BULLETSTAR, 0));
				setLastFire((long) (System.currentTimeMillis() + Math.random()*100));
			}
		}
		//Mini Boss
		if(getId() == 99){
			if(getPos().y == 605 && getRoundFire() == 0){
				setVelocity(0);
			}
			if(getPos().y == 605 && getRoundFire() % 10 < 2) {
				if(System.currentTimeMillis() - getLastFire() >= 1000) {
					for(int i = 0; i < 360; i += 30) {
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 4, i, Assets.BULLETSTAR, i));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, i, Assets.BULLETSTAR, i));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 6, i, Assets.BULLETSTAR, i));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 7, i, Assets.BULLETSTAR, i));
						setLastFire(System.currentTimeMillis());
					}
					setRoundFire(getRoundFire() + 1);
				}
			}
			if(getRoundFire() % 10 >= 2 && getRoundFire() % 10 < 5) {
				if (getPos().x != 212) {
					setDirection(180);
					setVelocity(2);
				}else if(getPos().x == 212 && getRoundFire() % 10 < 5) {
					setVelocity(0);
					if(System.currentTimeMillis() - getLastFire() >= 2500) {
						for(int i = 0; i < 360; i += 12) {
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 1.5, i, Assets.BULLETSTAR, i));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 2, i, Assets.BULLETSTAR, i));
							setLastFire(System.currentTimeMillis());
						}
						setRoundFire(getRoundFire() + 1);
					}
				}
			}
			if(getRoundFire() % 10 >= 5 && getRoundFire() % 10 < 8) {
				if (getPos().x != 412) {
					setDirection(0);
					setVelocity(4);
				}else if(getPos().x == 412 && getRoundFire() % 10 < 8) {
					setVelocity(0);
					if(System.currentTimeMillis() - getLastFire() >= 2500) {
						for(int i = 0; i < 360; i += 12) {
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 1.5, i, Assets.BULLETSTAR, i));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 2, i, Assets.BULLETSTAR, i));
							setLastFire(System.currentTimeMillis());
						}
						setRoundFire(getRoundFire() + 1);
					}
				}
			}
			if(getRoundFire() % 10 >= 8 && getRoundFire() % 10 < 10) {
				if (getPos().x != 312) {
					setDirection(180);
					setVelocity(2);
				}else if(getPos().x == 312 && getRoundFire() % 10 < 10) {
					setVelocity(0);
					if(System.currentTimeMillis() - getLastFire() >= 1500) {
						for(int i = 0; i < 360; i += 30) {
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 4, i, Assets.BULLETSTAR, i));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, i, Assets.BULLETSTAR, i));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 6, i, Assets.BULLETSTAR, i));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 7, i, Assets.BULLETSTAR, i));
							setLastFire(System.currentTimeMillis());
						}
						setRoundFire(getRoundFire() + 1);
					}
				}
			}
			if(getHp() - 1 == 0) {
				time.setTime(900);
			}else if(time.getTime() >= 900) {
				entityManager.clearAll();
				entityManager.addRemove(this);
			}
		}
		//Boss
		if(getId() == 999){
			if(getPos().y == 470){
				setVelocity(0);
			}
			if(getPos().y == 470 && time.getTime() <= 1100 && getRoundFire() % 10 == 0) {
				if(System.currentTimeMillis() - getLastFire() >= 100) {
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 5, degree, Assets.BULLETGREENSH, degree-90));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 5, degree+90, Assets.BULLETGREENSH, degree));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 5, degree+180, Assets.BULLETGREENSH, degree+90));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 5, degree+270, Assets.BULLETGREENSH, degree+180));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 5, 360-degree, Assets.BULLETGREENSH, 360-degree-90));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 5, 360-(degree+90), Assets.BULLETGREENSH, 360-(degree+180)));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 5, 360-(degree+180), Assets.BULLETGREENSH, 360-(degree+270)));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 5, 360-(degree+270), Assets.BULLETGREENSH, 360-(degree+360)));
					setLastFire(System.currentTimeMillis());
				}
				
				if(degree < 360) {
					degree ++;
				}else{
					setRoundFire(getRoundFire() + 1);
					degree = 0;
				}
			}
			if(getRoundFire() % 10 == 1 || getRoundFire() % 10 == 6) {
				if(degree < 6){
					if(System.currentTimeMillis() - getLastFire() >= 100) {
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 10, 240, Assets.BULLETROCKET01, 150));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 10, 255, Assets.BULLETROCKET01, 165));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 10, 270, Assets.BULLETROCKET01, 180));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 10, 285, Assets.BULLETROCKET01, 195));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 10, 300, Assets.BULLETROCKET01, 210));
						setLastFire(System.currentTimeMillis());
						degree++;
					}
				}
				if(degree < 12 && degree > 5){
					if(System.currentTimeMillis() - getLastFire() >= 100) {
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 10, 233, Assets.BULLETROCKET01, 143));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 10, 248, Assets.BULLETROCKET01, 158));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 10, 263, Assets.BULLETROCKET01, 173));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 10, 277, Assets.BULLETROCKET01, 187));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 10, 292, Assets.BULLETROCKET01, 202));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 10, 307, Assets.BULLETROCKET01, 217));
						setLastFire(System.currentTimeMillis());
						degree++;
					}
				}
				if(degree == 12){
					degree = 0;
					setRoundFire(getRoundFire() + 1);
				}
			}
			if(getRoundFire() % 10 == 2 || getRoundFire() % 10 == 8){
				if(degree < 2){
					if(System.currentTimeMillis() - getLastFire() >= 1500) {
						for(int i = 0; i < 360; i += 6) {
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 6, i + degree*3, Assets.BULLETSTAR, i + degree*3));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 7, i + degree*3, Assets.BULLETSTAR, i + degree*3));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 8, i + degree*3, Assets.BULLETSTAR, i + degree*3));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 9, i + degree*3, Assets.BULLETSTAR, i + degree*3));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 10, i + degree*3, Assets.BULLETSTAR, i + degree*3));
						}
						degree++;
						setLastFire(System.currentTimeMillis());
					}
				}else{
					degree = 0;
					setRoundFire(getRoundFire() + 1);
				}
			}
			if(getRoundFire() % 10 == 3 || getRoundFire() % 10 == 7){
				if(degree < 5){
					if(System.currentTimeMillis() - getLastFire() >= 1000) {
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 4, 240, Assets.BULLETGREENBIG, 240));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 4, 260, Assets.BULLETGREENBIG, 260));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 4, 280, Assets.BULLETGREENBIG, 280));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 4, 300, Assets.BULLETGREENBIG, 300));
						degree++;
						for(int i = 0; i < 15; i++){
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETCIRGREEN.getRegionWidth()/2) + 10, (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 2 + Math.random()*4, 225 + Math.random()*90, Assets.BULLETCIRGREEN, 0));
						}
						setLastFire(System.currentTimeMillis());
					}
				}else{
					if(System.currentTimeMillis() - getLastFire() >= 500) {
						setRoundFire(getRoundFire() + 1);
						setLastFire(System.currentTimeMillis());
						degree = 0;
					}
				}
			}
			if(time.getTime() <= 1400 && (getRoundFire() % 10 == 4)){
				if(System.currentTimeMillis() - getLastFire() >= 100) {
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 5, degree, Assets.BULLETGREENSH, degree-90));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 5, degree+60, Assets.BULLETGREENSH, degree-30));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 5, degree+120, Assets.BULLETGREENSH, degree+30));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 5, degree+180, Assets.BULLETGREENSH, degree+90));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 5, degree+240, Assets.BULLETGREENSH, degree+150));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 5, degree+300, Assets.BULLETGREENSH, degree+210));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 5, 360-degree, Assets.BULLETGREENSH, 360-degree-90));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 5, 360-(degree+60), Assets.BULLETGREENSH, 360-(degree+150)));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 5, 360-(degree+120), Assets.BULLETGREENSH, 360-(degree+210)));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 5, 360-(degree+180), Assets.BULLETGREENSH, 360-(degree+270)));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 5, 360-(degree+240), Assets.BULLETGREENSH, 360-(degree+330)));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 5, 360-(degree+300), Assets.BULLETGREENSH, 360-(degree+390)));
					setLastFire(System.currentTimeMillis());
				}
				
				if(degree < 360) {
					degree ++;
				}else{
					setRoundFire(getRoundFire() + 1);
					degree = 0;
				}
			}
			if(getRoundFire() % 10 == 5 || getRoundFire() % 10 == 9){
				if(degree < 7){
					if(System.currentTimeMillis() - getLastFire() >= 500) {
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 4, 240, Assets.BULLETGREENBIG, 240));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 4, 250, Assets.BULLETGREENBIG, 250));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 4, 260, Assets.BULLETGREENBIG, 260));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 4, 270, Assets.BULLETGREENBIG, 270));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 4, 280, Assets.BULLETGREENBIG, 280));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 4, 290, Assets.BULLETGREENBIG, 290));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSONE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSONE.getRegionHeight()/2) + getPos().y), 4, 300, Assets.BULLETGREENBIG, 300));
						degree++;
						setLastFire(System.currentTimeMillis());
					}
				}else{
					setRoundFire(getRoundFire() + 1);
					degree = 0;
				}
			}
			if((time.getTime() >= 1200 && getRoundFire() % 10 == 0) || (time.getTime() > 1400 && getRoundFire() % 10 == 4)){
				setRoundFire(getRoundFire() + 1);
			}
			if(getHp() - 1 == 0 || getHp() - 2 == 0) {
				time.setTime(1600);
				bossdead.play();
				victory.play();
				victorycon.play();
				victorycon.setLooping(true);
				PlayState.getBoss1().dispose();
				PlayState.stage = 2;
			}else if(time.getTime() >= 1600) {
				PlayState.getBoss1().dispose();
				nokill.play();
				entityManager.clearAll();
				entityManager.addRemove(this);
			}
		}
	}
	
	private void fireStageTwo() {
		if(getId() == 301) {
			random = (float) (300 + Math.random()*300);
			if(System.currentTimeMillis() - getLastFire() >= 1000 && getPos().y > random) {
				float angle = (float) Math.toDegrees(Math.atan2(entityManager.getPlayers().get(0).getPos().y - getPos().y, entityManager.getPlayers().get(0).getPos().x - getPos().x));
		    	if(angle < 0){
		        	angle += 360;
		    	}
		    	entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 3, angle, Assets.BULLETCIRGREEN, angle));
		    	entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2)+10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 3, angle, Assets.BULLETCIRGREEN, angle));
		    	entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2)+10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y+10), 3, angle, Assets.BULLETCIRGREEN, angle));
		    	entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y+10), 3, angle, Assets.BULLETCIRGREEN, angle));
				setLastFire(System.currentTimeMillis());
			}
		}
		if(getId() == 302) {
			random = (float) (Math.random()*600 + 250);
			if(System.currentTimeMillis() - getLastFire() >= 1000 && getPos().y < random) {
				float angle = (float) Math.toDegrees(Math.atan2(entityManager.getPlayers().get(0).getPos().y - getPos().y, entityManager.getPlayers().get(0).getPos().x - getPos().x));
		    	if(angle < 0){
		        	angle += 360;
		    	}
		    	random = (float) (angle-40 + Math.random()*80);
		    	entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 2, random, Assets.BULLETSTAR, random));
		    	setLastFire(System.currentTimeMillis());
			}
			
		}
		if(getId() == 303) {
			random = (float) (Math.random()*620 + 40);
			if(System.currentTimeMillis() - getLastFire() >= 500 && getPos().y <= random + 5 && getPos().y >= random - 5) {
				entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 3, 270, Assets.BULLETRED, 270));
				entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y-10), 3, 270, Assets.BULLETRED, 270));
				entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y-20), 3, 270, Assets.BULLETRED, 270));
				entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y-30), 3, 270, Assets.BULLETRED, 270));
		    	setLastFire(System.currentTimeMillis());
			}
			
		}
		if(getId() == 304){
			if(System.currentTimeMillis() - getLastFire() >= 200 && getVelocity() == 0){
				for(int i = 0; i < 360; i += 10){
					entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.MINIBOSS.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2), (Assets.MINIBOSS.getRegionHeight()/2) + getPos().y-30), 3, i, Assets.BULLETLINE, i));
				}
				setLastFire(System.currentTimeMillis());
			}
		}
		if(getId() >= 305 && getId() <= 324){
			if(getId() % 2 == 0){
				random = (float) (Math.random()*160 + 190);
				if(System.currentTimeMillis() - getLastFire() >= 600 ){
					entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENLEAVE.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y-30), 3.5, random, Assets.BULLETGREENLEAVE, (float) (random*Math.random()*10f)));
					setLastFire(System.currentTimeMillis());
				}
			}else{
				if(System.currentTimeMillis() - getLastFire() >= 800){
					entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENLEAVE.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y-30), 2.7, 270, Assets.BULLETREDFLOWER, 270));
					setLastFire(System.currentTimeMillis());
				}
			}
		}
		if(getId() == 325 || getId() == 326){
			if(System.currentTimeMillis() - getLastFire() >= 300){
				float angle = (float) Math.toDegrees(Math.atan2(entityManager.getPlayers().get(0).getPos().y - getPos().y, entityManager.getPlayers().get(0).getPos().x - getPos().x));
		    	if(angle < 0){
		        	angle += 360;
		    	}
				entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMYEIEI.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2), (Assets.ENEMYEIEI.getRegionHeight()/2) + getPos().y-30), 3.5, angle, Assets.BULLETGREENBIG, angle));
				setLastFire(System.currentTimeMillis());
			}
		}
		if(getId() == 327 || getId() == 328){
			if(System.currentTimeMillis() - getLastFire() >= 800 && getVelocity() >= 1){
				float angle = (float) Math.toDegrees(Math.atan2(entityManager.getPlayers().get(0).getPos().y - getPos().y, entityManager.getPlayers().get(0).getPos().x - getPos().x));
		    	if(angle < 0){
		        	angle += 360;
		    	}
				entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMYEIEI.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2), (Assets.ENEMYEIEI.getRegionHeight()/2) + getPos().y-30), 3.5, angle, Assets.BULLETGREENBIG, angle));
				setLastFire(System.currentTimeMillis());
			}else if(System.currentTimeMillis() - getLastFire() >= 300 && getVelocity() < 1){
				for(int i=0; i<=360; i+=30){
					entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMYEIEI.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2), (Assets.ENEMYEIEI.getRegionHeight()/2) + getPos().y-30), 3.5, i, Assets.BULLETGREENBIG, i));
					setLastFire(System.currentTimeMillis());
				}
			}
		}
		if(getId() == 329 && System.currentTimeMillis() - getLastFire() >= 300){
			float angle = (float) Math.toDegrees(Math.atan2(entityManager.getPlayers().get(0).getPos().y - getPos().y, entityManager.getPlayers().get(0).getPos().x - getPos().x));
	    	if(angle < 0){
	        	angle += 360;
	    	}
	    	entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 3, angle, Assets.BULLETCIRGREEN, angle));
	    	entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2)+10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 3, angle, Assets.BULLETCIRGREEN, angle));
	    	entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2)+10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y+10), 3, angle, Assets.BULLETCIRGREEN, angle));
	    	entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y+10), 3, angle, Assets.BULLETCIRGREEN, angle));
			setLastFire(System.currentTimeMillis());
		}
		if(getId() == 330 && System.currentTimeMillis() - getLastFire() >= 1000){
			random = (float) (Math.random()*800);
			if(getPos().y > random){
				float angle = (float) Math.toDegrees(Math.atan2(entityManager.getPlayers().get(0).getPos().y - getPos().y, entityManager.getPlayers().get(0).getPos().x - getPos().x));
		    	if(angle < 0){
		        	angle += 360;
		    	}
		    	entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 3, angle, Assets.BULLETROCKET01, angle+90));
		    	setLastFire(System.currentTimeMillis());
			}
		}
		if(getId() == 331){
			if(getVelocity() == 0 && System.currentTimeMillis() - getLastFire() >= 30){
				int i = (int) (Math.random()*360);
				for(int k = i; k<=360; k+=30){
					entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.MINIBOSS.getRegionWidth()/2) + getPos().x - (Assets.BULLETRED.getRegionWidth()/2), (Assets.MINIBOSS.getRegionHeight()/2) + getPos().y), 3, k, Assets.BULLETRED, k));
			    	setLastFire(System.currentTimeMillis());
				}
			}
		}
		if(getId() == 332){
			if(getVelocity() == 0 && System.currentTimeMillis() - getLastFire() >= 300){
				for(int j = 0; j<=360; j+=30){
					entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.MINIBOSS.getRegionWidth()/2) + getPos().x - (Assets.BULLETRED.getRegionWidth()/2), (Assets.MINIBOSS.getRegionHeight()/2) + getPos().y), 3, count*20+j, Assets.BULLETRED, j));
				}
				setLastFire(System.currentTimeMillis());
				count++;
			}
		}
		if(getId() == 333){
			if(System.currentTimeMillis() - getLastFire() >= 500){
				float angle = (float) Math.toDegrees(Math.atan2(entityManager.getPlayers().get(0).getPos().y - getPos().y, entityManager.getPlayers().get(0).getPos().x - getPos().x));
		    	if(angle < 0){
		        	angle += 360;
		    	}
		    	entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 2, angle, Assets.BULLETCIRGREEN, angle));
		    	entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2)+10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 2, angle, Assets.BULLETCIRGREEN, angle));
		    	entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2)+10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y+10), 2, angle, Assets.BULLETCIRGREEN, angle));
		    	entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y+10), 2, angle, Assets.BULLETCIRGREEN, angle));
				setLastFire(System.currentTimeMillis());
			}
		}
		if(getId() == 334){
			if(System.currentTimeMillis() - getLastFire() >= 1200 && getVelocity() == 0){
				float angle = (float) Math.toDegrees(Math.atan2(entityManager.getPlayers().get(0).getPos().y - getPos().y, entityManager.getPlayers().get(0).getPos().x - getPos().x));
		    	if(angle < 0){
		        	angle += 360;
		    	}
				entityManager.addBullet(new Bullet(entityManager, 398, new Vector2((Assets.BOSSTWOMINI.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2), (Assets.BOSSTWOMINI.getRegionHeight()/2) + getPos().y), 4, angle, Assets.BULLETGREENBIG, angle));
				setLastFire(System.currentTimeMillis());
			}
		}
		if(getId() == 335 && getVelocity() == 0){
			if(System.currentTimeMillis() - getLastFire() >= 500){
				entityManager.addEnemy(new Enemy(entityManager, 337, 20, new Vector2(100, 755), 4, 240, Assets.ENEMY, 240-270, 0, 0, Assets.ENEMY.getRegionWidth(), Assets.ENEMY.getRegionHeight()));
				setLastFire(System.currentTimeMillis());
			}
		}
		if(getId() == 336){
			if(System.currentTimeMillis() - getLastFire() >= 1500){
				for(int i=0; i<360; i+=10){
					entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.BOSSTWO.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2), (Assets.BOSSTWO.getRegionHeight()/2) + getPos().y), 2, i, Assets.BULLETLINE, i));
				}
				setLastFire(System.currentTimeMillis());
			}
		}
	}
	
	private void fireStageFive() {
		
		if((getId() >= 6 && getId() <= 25) || (getId() >= 46 && getId() <= 65)) {
			if(System.currentTimeMillis() - getLastFire() >= 100) {
				float angle = 0;
				for(int i = 0;i<entityManager.getPlayers().size();i++){
					angle = (float) Math.toDegrees(Math.atan2(entityManager.getPlayers().get(i).getPos().y - super.getPos().y, entityManager.getPlayers().get(i).getPos().x - super.getPos().x));
				}
				for(int j = 0;j<9;j++){
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETRED01.getRegionWidth()/2) + 7, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 10, angle+j*360/9, Assets.BULLETRED01, angle+j*360/9 - 90));
					setLastFire((long) (System.currentTimeMillis() + Math.random()*1));
				}
				
			}
		}
		if((getId() >= 26 && getId() <= 27)) {
			if(getPos().y == 608){
				setVelocity(0);
				if(System.currentTimeMillis() - getLastFire() >= 100) {
					if(getId() == 26){
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETRED01.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, degree, Assets.BULLETRED01, degree-90));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETRED01.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, degree+90, Assets.BULLETRED01, degree));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETRED01.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, degree+180, Assets.BULLETRED01, degree+90));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETRED01.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, degree+270, Assets.BULLETRED01, degree+180));
					}else {
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETRED01.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, 360-degree, Assets.BULLETRED01, 360-degree-90));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETRED01.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, 360-(degree+90), Assets.BULLETRED01, 360-(degree+180)));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETRED01.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, 360-(degree+180), Assets.BULLETRED01, 360-(degree+270)));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETRED01.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, 360-(degree+270), Assets.BULLETRED01, 360-(degree+360)));
					}
					setLastFire(System.currentTimeMillis());
				}
				
				if(degree < 360) {
					degree ++;
				}else{
					degree = 0;
				}
			}
		}
		if((getId() >= 28 && getId() <= 29)) {
			if(getPos().y <= 745){
				setVelocity(0);
				if(System.currentTimeMillis() - getLastFire() >= 1000) {
					if(getId() == 28){
						for(int i = 4; i < 8; i++) {
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETREDBIG.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), i, 210 + degree * 45, Assets.BULLETREDBIG, 120 + degree * 45));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETREDBIG.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), i, 225 + degree * 45, Assets.BULLETREDBIG, 135 + degree * 45));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETREDBIG.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), i, 240 + degree * 45, Assets.BULLETREDBIG, 150 + degree * 45));
						}
					}else {
						for(int i = 4; i < 8; i++) {
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETREDBIG.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), i, 330 - degree * 45, Assets.BULLETREDBIG, 240 - degree * 45));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETREDBIG.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), i, 315 - degree * 45, Assets.BULLETREDBIG, 225 - degree * 45));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETREDBIG.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), i, 300 - degree * 45, Assets.BULLETREDBIG, 210 - degree * 45));
						}
					}
					setLastFire(System.currentTimeMillis());
					if(degree < 2) {
						degree ++;
					}else{
						degree = 0;
					}
				}
			}
		}
		if(getId() >= 30 && getId() <= 43) {
			int fireDegree = 105;
			if(getId() % 2 == 0) {
				fireDegree = -105;
			}
			if(System.currentTimeMillis() - getLastFire() >= 1000) {
				entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETREDSMALL.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 7, getDirection() + fireDegree, Assets.BULLETREDSMALL, 0));
				setLastFire((long) (System.currentTimeMillis() + Math.random()*100));
			}
		}
		if(getId() >= 44 && getId() <= 45) {
			if(System.currentTimeMillis() - getLastFire() >= 2000) {
				for(int i = 0; i < 360; i ++) {
					if(i % 20 < 8 && i % 2 == 0) {
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETREDKUNAI.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 4, i, Assets.BULLETREDKUNAI, i - 90));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETREDKUNAI.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, i + 10, Assets.BULLETREDKUNAI, i + 80));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETREDKUNAI.getRegionWidth()/2), (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 6, i, Assets.BULLETREDKUNAI, i - 90));
					}
				}
				setLastFire(System.currentTimeMillis());
			}
		}
		//Mini Boss
		if(getId() == 99){
			if(getPos().y == 605 && getRoundFire() == 0){
				setVelocity(0);
			}
			if(getPos().y == 605 && getRoundFire() % 10 < 2) {
				if(System.currentTimeMillis() - getLastFire() >= 1000) {
					for(int i = 0; i < 360; i += 30) {
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 4, i, Assets.BULLETSTAR, i));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, i, Assets.BULLETSTAR, i));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 6, i, Assets.BULLETSTAR, i));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 7, i, Assets.BULLETSTAR, i));
						setLastFire(System.currentTimeMillis());
					}
					setRoundFire(getRoundFire() + 1);
				}
			}
			if(getRoundFire() % 10 >= 2 && getRoundFire() % 10 < 5) {
				if (getPos().x != 212) {
					setDirection(180);
					setVelocity(2);
				}else if(getPos().x == 212 && getRoundFire() % 10 < 5) {
					setVelocity(0);
					if(System.currentTimeMillis() - getLastFire() >= 2500) {
						for(int i = 0; i < 360; i += 12) {
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 1.5, i, Assets.BULLETSTAR, i));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 2, i, Assets.BULLETSTAR, i));
							setLastFire(System.currentTimeMillis());
						}
						setRoundFire(getRoundFire() + 1);
					}
				}
			}
			if(getRoundFire() % 10 >= 5 && getRoundFire() % 10 < 8) {
				if (getPos().x != 412) {
					setDirection(0);
					setVelocity(4);
				}else if(getPos().x == 412 && getRoundFire() % 10 < 8) {
					setVelocity(0);
					if(System.currentTimeMillis() - getLastFire() >= 2500) {
						for(int i = 0; i < 360; i += 12) {
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 1.5, i, Assets.BULLETSTAR, i));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 2, i, Assets.BULLETSTAR, i));
							setLastFire(System.currentTimeMillis());
						}
						setRoundFire(getRoundFire() + 1);
					}
				}
			}
			if(getRoundFire() % 10 >= 8 && getRoundFire() % 10 < 10) {
				if (getPos().x != 312) {
					setDirection(180);
					setVelocity(2);
				}else if(getPos().x == 312 && getRoundFire() % 10 < 10) {
					setVelocity(0);
					if(System.currentTimeMillis() - getLastFire() >= 1500) {
						for(int i = 0; i < 360; i += 30) {
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 4, i, Assets.BULLETSTAR, i));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, i, Assets.BULLETSTAR, i));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 6, i, Assets.BULLETSTAR, i));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 7, i, Assets.BULLETSTAR, i));
							setLastFire(System.currentTimeMillis());
						}
						setRoundFire(getRoundFire() + 1);
					}
				}
			}
			if(getHp() - 1 == 0 || getHp() - 2 == 0) {
				time.setTime(1030);
			}else if(time.getTime() >= 1030) {
				entityManager.clearAll();
				entityManager.addRemove(this);
			}
		}
		//Boss
		if(getId() == 999){
			if(getPos().y == 470){
				setVelocity(0);
			}
			if(getPos().y == 470 && time.getTime() <= 1100 && getRoundFire() % 10 == 0) {
				if(System.currentTimeMillis() - getLastFire() >= 100) {
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, degree, Assets.BULLETGREENSH, degree-90));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, degree+90, Assets.BULLETGREENSH, degree));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, degree+180, Assets.BULLETGREENSH, degree+90));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, degree+270, Assets.BULLETGREENSH, degree+180));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, 360-degree, Assets.BULLETGREENSH, 360-degree-90));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, 360-(degree+90), Assets.BULLETGREENSH, 360-(degree+180)));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, 360-(degree+180), Assets.BULLETGREENSH, 360-(degree+270)));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, 360-(degree+270), Assets.BULLETGREENSH, 360-(degree+360)));
					setLastFire(System.currentTimeMillis());
				}
				
				if(degree < 360) {
					degree ++;
				}else{
					setRoundFire(getRoundFire() + 1);
					degree = 0;
				}
			}
			if(getRoundFire() % 10 == 1 || getRoundFire() % 10 == 6) {
				if(degree < 6){
					if(System.currentTimeMillis() - getLastFire() >= 100) {
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 240, Assets.BULLETROCKET01, 150));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 255, Assets.BULLETROCKET01, 165));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 270, Assets.BULLETROCKET01, 180));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 285, Assets.BULLETROCKET01, 195));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 300, Assets.BULLETROCKET01, 210));
						setLastFire(System.currentTimeMillis());
						degree++;
					}
				}
				if(degree < 12 && degree > 5){
					if(System.currentTimeMillis() - getLastFire() >= 100) {
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 233, Assets.BULLETROCKET01, 143));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 248, Assets.BULLETROCKET01, 158));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 263, Assets.BULLETROCKET01, 173));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 277, Assets.BULLETROCKET01, 187));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 292, Assets.BULLETROCKET01, 202));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 307, Assets.BULLETROCKET01, 217));
						setLastFire(System.currentTimeMillis());
						degree++;
					}
				}
				if(degree == 12){
					degree = 0;
					setRoundFire(getRoundFire() + 1);
				}
			}
			if(getRoundFire() % 10 == 2 || getRoundFire() % 10 == 8){
				if(degree < 2){
					if(System.currentTimeMillis() - getLastFire() >= 1500) {
						for(int i = 0; i < 360; i += 6) {
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 6, i + degree*3, Assets.BULLETSTAR, i + degree*3));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 7, i + degree*3, Assets.BULLETSTAR, i + degree*3));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 8, i + degree*3, Assets.BULLETSTAR, i + degree*3));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 9, i + degree*3, Assets.BULLETSTAR, i + degree*3));
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETSTAR.getRegionWidth()/2) + 10, (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, i + degree*3, Assets.BULLETSTAR, i + degree*3));
						}
						degree++;
						setLastFire(System.currentTimeMillis());
					}
				}else{
					degree = 0;
					setRoundFire(getRoundFire() + 1);
				}
			}
			if(getRoundFire() % 10 == 3 || getRoundFire() % 10 == 7){
				if(degree < 5){
					if(System.currentTimeMillis() - getLastFire() >= 1000) {
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 4, 240, Assets.BULLETGREENBIG, 240));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 4, 260, Assets.BULLETGREENBIG, 260));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 4, 280, Assets.BULLETGREENBIG, 280));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 4, 300, Assets.BULLETGREENBIG, 300));
						degree++;
						for(int i = 0; i < 15; i++){
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETCIRGREEN.getRegionWidth()/2) + 10, (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 2 + Math.random()*4, 225 + Math.random()*90, Assets.BULLETCIRGREEN, 0));
						}
						setLastFire(System.currentTimeMillis());
					}
				}else{
					if(System.currentTimeMillis() - getLastFire() >= 500) {
						setRoundFire(getRoundFire() + 1);
						setLastFire(System.currentTimeMillis());
						degree = 0;
					}
				}
			}
			if(time.getTime() <= 1400 && (getRoundFire() % 10 == 4)){
				if(System.currentTimeMillis() - getLastFire() >= 100) {
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, degree, Assets.BULLETGREENSH, degree-90));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, degree+60, Assets.BULLETGREENSH, degree-30));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, degree+120, Assets.BULLETGREENSH, degree+30));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, degree+180, Assets.BULLETGREENSH, degree+90));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, degree+240, Assets.BULLETGREENSH, degree+150));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, degree+300, Assets.BULLETGREENSH, degree+210));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, 360-degree, Assets.BULLETGREENSH, 360-degree-90));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, 360-(degree+60), Assets.BULLETGREENSH, 360-(degree+150)));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, 360-(degree+120), Assets.BULLETGREENSH, 360-(degree+210)));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, 360-(degree+180), Assets.BULLETGREENSH, 360-(degree+270)));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, 360-(degree+240), Assets.BULLETGREENSH, 360-(degree+330)));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENSH.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, 360-(degree+300), Assets.BULLETGREENSH, 360-(degree+390)));
					setLastFire(System.currentTimeMillis());
				}
				
				if(degree < 360) {
					degree ++;
				}else{
					setRoundFire(getRoundFire() + 1);
					degree = 0;
				}
			}
			if(getRoundFire() % 10 == 5 || getRoundFire() % 10 == 9){
				if(degree < 7){
					if(System.currentTimeMillis() - getLastFire() >= 500) {
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 4, 240, Assets.BULLETGREENBIG, 240));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 4, 250, Assets.BULLETGREENBIG, 250));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 4, 260, Assets.BULLETGREENBIG, 260));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 4, 270, Assets.BULLETGREENBIG, 270));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 4, 280, Assets.BULLETGREENBIG, 280));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 4, 290, Assets.BULLETGREENBIG, 290));
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBIG.getRegionWidth()/2) + 10, (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 4, 300, Assets.BULLETGREENBIG, 300));
						degree++;
						setLastFire(System.currentTimeMillis());
					}
				}else{
					setRoundFire(getRoundFire() + 1);
					degree = 0;
				}
			}
			if((time.getTime() >= 1200 && getRoundFire() % 10 == 0) || (time.getTime() > 1400 && getRoundFire() % 10 == 4)){
				setRoundFire(getRoundFire() + 1);
			}
			if(getHp() - 1 == 0 || getHp() - 2 == 0) {
				time.setTime(1600);
				PlayState.stage = 2;
			}else if(time.getTime() >= 1600) {
				entityManager.clearAll();
				entityManager.addRemove(this);
			}
		}
	}
}
