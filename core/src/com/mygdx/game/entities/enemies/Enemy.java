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
	private float random;
	private TimeControl time;
	private int count, round, delay;
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
		}else if(PlayState.stage == 3) {
			fireStageThree();
		}else if(PlayState.stage == 4) {
			fireStageFour();
		}else if(PlayState.stage == 5) {
			fireStageFive();
		}
	}

	@Override
	public void update() {
		moveStageTwo();
		moveObject(entityManager);
		fire();
	}

	@Override
	public Boolean isCollision(SpaceObject object) {
		return null;
	}
	
	private void moveStageTwo() {
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
				bossdead.play();
				victory.play();
				PlayState.getBoss1().dispose();
				PlayState.stage = 2;
				time.setTime(0);
			}else if(time.getTime() >= 1600) {
				PlayState.stage = 2;
				PlayState.getBoss1().dispose();
				nokill.play();
				entityManager.clearAll();
				entityManager.addRemove(this);
				time.setTime(0);
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
					entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.MINIBOSS02.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2), (Assets.MINIBOSS02.getRegionHeight()/2) + getPos().y-30), 3, i, Assets.BULLETLINE, i));
				}
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
					entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.MINIBOSS02.getRegionWidth()/2) + getPos().x - (Assets.BULLETRED.getRegionWidth()/2), (Assets.MINIBOSS02.getRegionHeight()/2) + getPos().y), 3, k, Assets.BULLETRED, k));
			    	setLastFire(System.currentTimeMillis());
				}
			}
		}
		if(getId() == 332){
			if(getVelocity() == 0 && System.currentTimeMillis() - getLastFire() >= 300){
				for(int j = 0; j<=360; j+=30){
					entityManager.addBullet(new Bullet(entityManager, 399, new Vector2((Assets.MINIBOSS02.getRegionWidth()/2) + getPos().x - (Assets.BULLETRED.getRegionWidth()/2), (Assets.MINIBOSS02.getRegionHeight()/2) + getPos().y), 3, count*20+j, Assets.BULLETRED, j));
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
			if(getHp() - 1 == 0 || getHp() - 2 == 0) {
				bossdead.play();
				victory.play();
				PlayState.getBoss2().dispose();
				entityManager.clearAll();
				PlayState.stage = 3;
				time.setTime(0);
			}else if(time.getTime() >= 1690) {
				PlayState.stage = 3;
				nokill.play();
				PlayState.getBoss2().dispose();
				entityManager.clearAll();
				entityManager.addRemove(this);
				time.setTime(0);
			}
		}
	}
	private void fireStageThree() {
		if(getId() >=6 && getId() <= 25){
			if(System.currentTimeMillis() - getLastFire() >= 2000) {

				for(int i = 0;i<=8;i++){
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETWATER1.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 3, 225+i*10, Assets.BULLETSTAR, 225+i*10));
				}
				setLastFire(System.currentTimeMillis());
			}
		}
		//shootingstar
		if(getId() == 26){
			if(System.currentTimeMillis() - getLastFire() >= 500) {
				for(int i= 8; i<=40; i++){
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETWATER1.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), i/8, 18+i*2, Assets.BULLETSTAR, 210));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETWATER1.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), i/8, 18-i*2, Assets.BULLETSTAR, 210));
				}
				count++;
				setLastFire((long) (System.currentTimeMillis() + Math.random()*250));
			}
		}
		if(getId() == 27){
			if(System.currentTimeMillis() - getLastFire() >= 500) {
				for(int i= 8; i<=40; i++){
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETWATER1.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), i/8, 162+i*2, Assets.BULLETSTAR, 330));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETWATER1.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), i/8, 162-i*2, Assets.BULLETSTAR, 330));
				}
				count++;
				setLastFire((long) (System.currentTimeMillis() + Math.random()*250));
			}
		}

		//sin

		if(getId() >=28 && getId() <= 47){
			setPos(getPos().x, 400+(float)(Math.sin(count*0.05)*40));
			setRotate((float) (count*0.05));
			count++;
			if(System.currentTimeMillis() - getLastFire() >= 1000) {
				for(int i= 0; i<= 7; i++){
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETWATER1.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 4, i*360/8+360/16*(-(count%2)), Assets.BULLETSTAR, i*360/8+360/16*(-(count%2))));
				}
				setLastFire(System.currentTimeMillis());
			}
			if(System.currentTimeMillis() - getLastFire() >= 2000) {

				for(int i = 0;i<=8;i++){
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETWATER1.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 3, 225+i*10, Assets.BULLETSTAR, 225+i*10));
				}
				setLastFire(System.currentTimeMillis());
			}
		}

		if(getId() == 49){

			if(getPos().x <320){
				setVelocity(0);
			}
			if(System.currentTimeMillis() - getLastFire() >= 70){
				if((System.currentTimeMillis()/100)%40 >= -1){
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((float) ((Assets.PLAYER.getRegionWidth()/2) + getPos().x -8 +(Math.cos(this.count*0.75)*40)), (float) (Assets.PLAYER.getRegionHeight()/2 + getPos().y +Math.sin(this.count*0.75)*40)), 2, this.count*180/Math.PI*0.75, Assets.BULLETSTAR, 0));
					this.count += 1;
				}
				else{
					this.count = 0;
				}
				setLastFire(System.currentTimeMillis()/100000);
			}

		}
		//Rising star
		if(getId() >=50 && getId() <= 99){
			if(getPos().y >= 570){
				if(getId()%2== 0){
					setDirection(45);
					setRotate(45);
				}
				else{
					setDirection(135);
					setRotate(135);
				}
			}
			if(System.currentTimeMillis() - getLastFire() >= 500) {
				float angle = 0;
				for(int i = 0;i<entityManager.getPlayers().size();i++){
					angle = (float) Math.toDegrees(Math.atan2(entityManager.getPlayers().get(i).getPos().y - super.getPos().y, entityManager.getPlayers().get(i).getPos().x - super.getPos().x));
				}
				for(int i= 1; i<=4; i++){
					entityManager.addBullet(new Bullet(entityManager, 1005, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETWATER1.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, angle+i*20, Assets.BULLETSTAR, angle+i*10));
					entityManager.addBullet(new Bullet(entityManager, 1005, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETWATER1.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, angle-i*20, Assets.BULLETSTAR, angle-i*10));
				}
				count++;
				setLastFire((long) (System.currentTimeMillis() + Math.random()*250));
			}
		}
		//shootingstar
		if(getId() == 100){


			if(System.currentTimeMillis() - getLastFire() >= 500) {
				for(int i= 8; i<=40; i++){
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETWATER1.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), i/8, 18+i*2, Assets.BULLETSTAR, 210));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETWATER1.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), i/8, 18-i*2, Assets.BULLETSTAR, 210));
				}
				count++;
				setLastFire((long) (System.currentTimeMillis() + Math.random()*250));
			}
		}
		//mini1
		if(getId() == 101){
			if(System.currentTimeMillis() - getLastFire() >= 500) {
				for(int i= 8; i<=40; i++){
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETWATER1.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), i/8, 162+i*2, Assets.BULLETSTAR, 330));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETWATER1.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), i/8, 162-i*2, Assets.BULLETSTAR, 330));
				}
				count++;
				setLastFire((long) (System.currentTimeMillis() + Math.random()*250));
			}
		}
		//shooting star
		if(getId() >= 102 && getId()<= 103){

			setPos(getPos().x, 400+(float)(Math.sin(count*0.05)*40));
			setRotate((float) (count));
			count++;
			if(System.currentTimeMillis() - getLastFire() >= 500) {
				for(int i= 0; i<= 20; i++){
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETWATER1.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 4, i*360/20+360/16*(-(count%2)), Assets.BULLETSTAR, i*360/20+360/16*(-(count%2))));
				}
				setLastFire(System.currentTimeMillis());
			}
		}
		//Rising star
		if(getId() >=104 && getId() <= 133){
			if(getPos().y >= 570){
				if(getId()%2== 0){
					setDirection(45);
					setRotate(45);
				}
				else{
					setDirection(135);
					setRotate(135);
				}
			}
			if(System.currentTimeMillis() - getLastFire() >= 500) {
				float angle = 0;
				for(int i = 0;i<entityManager.getPlayers().size();i++){
					angle = (float) Math.toDegrees(Math.atan2(entityManager.getPlayers().get(i).getPos().y - super.getPos().y, entityManager.getPlayers().get(i).getPos().x - super.getPos().x));
				}
				for(int i= 1; i<=4; i++){
					entityManager.addBullet(new Bullet(entityManager, 1005, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETWATER1.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, angle+i*20, Assets.BULLETSTAR, angle+i*10));
					entityManager.addBullet(new Bullet(entityManager, 1005, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETWATER1.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, angle-i*20, Assets.BULLETSTAR, angle-i*10));
				}
				count++;
				setLastFire((long) (System.currentTimeMillis() + Math.random()*250));
			}
		}



		//boss
		if(getId() == 134){
			if(getPos().y <= 420){
				setVelocity(0);
			}
			if(getVelocity() == 0 && round ==0){
				if(System.currentTimeMillis() - getLastFire() >= 1000){

					for(int i = 0; i<= 3; i++){
						float ran = (float) (Math.random()*160);
						for(int j = 1;j <= 10;j++){
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2(160*i+ran, Assets.BOSSTHREE.getRegionHeight()/2 + getPos().y), j, 270, Assets.DRAGONHEAD, 0));
							setLastFire(System.currentTimeMillis());
						}
					}
					setLastFire(System.currentTimeMillis());
				}
				if(((int)System.currentTimeMillis()/1000%9 == 0)){
					delay++;
				}
				if(delay == 5){
					round++;
					delay = 0;
				}
			}
			//bacon survival
			if((getVelocity() == 0 && round ==2)){
				if(System.currentTimeMillis() - getLastFire() >= 50&& getVelocity() == 0){
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSTHREE.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) + 10, (Assets.BOSSTHREE.getRegionHeight()/2) + getPos().y), 1, count, Assets.BULLETBLURLINE, count));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSTHREE.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) + 10, (Assets.BOSSTHREE.getRegionHeight()/2) + getPos().y), 1, 180+count, Assets.BULLETBLURLINE, 180+count));
					this.count++;
				}
				//						}

			}
			if((getVelocity() == 0 && round ==1)){

				if(System.currentTimeMillis() - getLastFire() >= 350) {
					if(count%2 == 0){
						for(int i = 0 ; i<12;i++){
							for(int j = 0 ; j<12;j++){
								entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((float) (Math.cos(i*30)*j*2+(Assets.BOSSTHREE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBEAN.getRegionWidth()/2) + 10), ((float) (Math.sin(i*30)*j*2)+Assets.BOSSTHREE.getRegionHeight()/2) + getPos().y), 7, i*30, Assets.BULLETGREENBEAN, i*30));
							}
						}
						setLastFire(System.currentTimeMillis());
						this.count++;
					}else{
						for(int i = 0 ; i<12;i++){
							for(int j = 0 ; j<12;j++){
								entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((float) (Math.cos(i*30)*j*2+(Assets.BOSSTHREE.getRegionWidth()/2) + getPos().x - (Assets.BULLETGREENBEAN.getRegionWidth()/2) + 10), ((float) (Math.sin(i*30)*j*2)+Assets.BOSSTHREE.getRegionHeight()/2) + getPos().y), 7, i*30+15, Assets.BULLETGREENBEAN, i*30+15));
							}
						}
						setLastFire(System.currentTimeMillis());
						this.count++;
					}
				}


				if(((int)System.currentTimeMillis()/1000%9 == 8)){
					delay++;
				}
				if(delay == 5){
					round++;
					delay = 0;
				}

			}
			if(getHp() - 1 == 0 || getHp() - 2 == 0) {
				bossdead.play();
				victory.play();
				PlayState.getBoss3().dispose();
				PlayState.stage = 4;
				time.setTime(0);
			}else if(time.getTime() >= 1600) {
				PlayState.stage = 4;
				nokill.play();
				PlayState.getBoss3().dispose();
				entityManager.clearAll();
				entityManager.addRemove(this);
				time.setTime(0);
			}
		}
	}
	private void fireStageFour() {
		//MAIN
		//Enemy flow
		if(getId() >= 6 && getId() <= 23) {
			if(System.currentTimeMillis() - getLastFire() >= 500) {
				for(int j = 0;j<3;j++){
					double ran = Math.random()*20;
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) + j*10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, ran+260, Assets.BULLETGREENBEAN, (float) (ran+260)-90));
					setLastFire((long) (System.currentTimeMillis() + Math.random()*1));
				}
			}
		}
		//Aimming
		if(getId() >= 24 && getId() <= 55) {									
			if(System.currentTimeMillis() - getLastFire() >= 100) {
				float angle = 0;
				for(int i = 0;i<entityManager.getPlayers().size();i++){
					angle = (float) Math.toDegrees(Math.atan2(entityManager.getPlayers().get(i).getPos().y - super.getPos().y, entityManager.getPlayers().get(i).getPos().x - super.getPos().x));
				}
				for(int j = 0;j<9;j++){
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 10, angle+j*360/9, Assets.BULLETPURLINE, angle+j*360/9));
					setLastFire((long) (System.currentTimeMillis() + Math.random()*1));
				}

			}
		}


		//Spiral from set (4quater set)
		if(getId() >= 56 && getId() <= 59) {
			if(getId() >= 56 && getId() <= 57){
				if(getPos().y == 452){
					setVelocity(0);
				}
			}else if(getId() >= 58 && getId() <= 59){
				if(getPos().y == 552){
					setVelocity(0);
				}

			}
			if(System.currentTimeMillis() - getLastFire() >= 100) {
				if(getId()%2 == 0){
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 7, -count*20, Assets.BULLETCIRGREEN, -count*15));
					setLastFire(System.currentTimeMillis());
					this.count++;
				}else{
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 7, count*20+180, Assets.BULLETCIRGREEN, count*15+180));
					setLastFire(System.currentTimeMillis());
					this.count++;
				}
			}
		}




		//Enemy flow
		if(getId() >= 60 && getId() <= 99) {
			if(System.currentTimeMillis() - getLastFire() >= 1000) {
				for(int j = 0;j<3;j++){
					double ran = Math.random()*20;
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) + j*10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, ran+260, Assets.BULLETGREENBEAN, (float) (ran+260-90)));
					setLastFire((long) (System.currentTimeMillis() + Math.random()*1));
				}	
			}	
		}

		//Enemy flow
		if(getId() >= 100 && getId() <= 139) {
			if(System.currentTimeMillis() - getLastFire() >= 1000) {
				for(int j = 0;j<3;j++){
					double ran = Math.random()*20;
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) + j*10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 5, ran+260, Assets.BULLETGREENBEAN, (float) (ran+260-90)));
					setLastFire((long) (System.currentTimeMillis() + Math.random()*1));
				}
			}					
		}
		//Spread Bullet
		if(getId() >= 140 && getId() <= 149){									
			if(System.currentTimeMillis() - getLastFire() >= 1000) {
				for(int j = 0;j<9;j++){
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 10-j, 270, Assets.BULLETBLUEMENTOS, 270));
					setLastFire((long) (System.currentTimeMillis() + Math.random()*1));
				}
			}
		}

		//Spread Bullet
		if(getId() >= 150 && getId() <= 159){									
			if(System.currentTimeMillis() - getLastFire() >= 1000) {
				for(int j = 0;j<9;j++){
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 10-j, 270, Assets.BULLETBLUEMENTOS, 270));
					setLastFire((long) (System.currentTimeMillis() + Math.random()*1));
				}
			}
		}
		//weird spiral star(4quater set)
		if(getId() >= 160 && getId() <= 161) {

			if(getPos().y >= 450&& getPos().y <= 453){
				setVelocity(0);
			}

			if(getPos().y >= 453&&getPos().y <= 450){
				setVelocity(0);
			}
			if(System.currentTimeMillis() - getLastFire() >= 100) {
				for(int i = 0;i<= 2;i++){
					entityManager.addBullet(new Bullet(entityManager,5, new Vector2((float) ((Assets.PLAYER.getRegionWidth()/2) + getPos().x -8 +(Math.cos(this.count*0.75)*40)), (float) (Assets.PLAYER.getRegionHeight()/2 + getPos().y +Math.sin(this.count*0.75)*40)), 4, (i*120)+this.count*10, Assets.BULLETSTAR, (float) (this.count)));
				}
				if(getId()%2 == 0){
					this.count -= 1;
				}else{
					this.count += 1;
				}
				setLastFire(System.currentTimeMillis());
			}
		}

		//Bacon Aim
		if(getId() >= 162 && getId() <= 163) {
			if(getPos().y >= 552 && getPos().y <= 555){
				setVelocity(0);
			}
			if(System.currentTimeMillis() - getLastFire() >= 50){
				float angle = 80;
				for(int i = 0;i<entityManager.getPlayers().size();i++){
					angle = (float) Math.toDegrees(Math.atan2(entityManager.getPlayers().get(i).getPos().y - super.getPos().y, entityManager.getPlayers().get(i).getPos().x - super.getPos().x));
				}
				entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 1, angle-20, Assets.BULLETLINE, angle-20));
				entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.ENEMY.getRegionWidth()/2) + getPos().x - (Assets.BULLETLINE.getRegionWidth()/2) + 10, (Assets.ENEMY.getRegionHeight()/2) + getPos().y), 1, 20+angle, Assets.BULLETLINE, 20+angle));
			}
		}
		//boss
		if(getId() == 164){
			if(getPos().y == 420){
				setVelocity(0);
			}
			if(getPos().y == 420 && round ==0){
				if(System.currentTimeMillis() - getLastFire() >= 300){
					if((System.currentTimeMillis()/100)%20 >= 10){
						for(int i = 1; i<= 100; i++){
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2(((Assets.BOSSFOUR.getRegionWidth()/2) + getPos().x -8), Assets.BOSSFOUR.getRegionHeight()/2 + getPos().y), 3, Math.tan(System.currentTimeMillis()/20)*20-(10*i), Assets.BULLETPINKTRI, (float)(Math.tan(System.currentTimeMillis()/20)*20-(10*i))));
							setLastFire(System.currentTimeMillis());
						}

					}
				}
				if(((int)System.currentTimeMillis()/1000%9 == 0)){
					delay++;
				}
				if(delay == 5){
					round++;
					delay = 0;
				}
			}
			if((getPos().y == 420 && round ==2)){
				if(System.currentTimeMillis() - getLastFire() >= 50){
					if((System.currentTimeMillis()/100)%8 >= 7){
						for(int j = 1; j<= 70; j++){
							for(int i = 0; i<= 11; i++){
								entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((float) ((Assets.BOSSFOUR.getRegionWidth()/2) + 135 -8 +(Math.cos(j*0.75)*40)), (float) (Assets.BOSSFOUR.getRegionHeight()/2 + 420 +Math.sin(j*0.75)*40)), 3, i*30+this.count*20, Assets.BULLETPINKSTAR, i*30+this.count*20));
								setLastFire(System.currentTimeMillis());
							}
						}
						this.count++;
					}

				}
				if(((int)System.currentTimeMillis()/1000%9 == 9)){
					delay++;
				}
				if(delay == 5){
					round++;
					delay = 0;
				}
			}
			if((getPos().y == 420 && round ==1)){
				if(System.currentTimeMillis() - getLastFire() >= 15){
					if((System.currentTimeMillis()/100)%20 >= 15){
						for(int i = 1; i<= 10; i++){
							entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((float) ((Assets.BOSSFOUR.getRegionWidth()/2) + 135 -8), (float) (Assets.BOSSFOUR.getRegionHeight()/2 + 620 - this.count)), 4, i*36+this.count, Assets.BULLETREDBUTTER, i*36+this.count));
							//								entityManager.addBullet(new Bullet(entityManager, 1, new Vector2((float) ((Assets.BOSSFOUR.getRegionWidth()/2) +  -8), (float) (Assets.BOSSFOUR.getRegionHeight()/2 + 550 - this.count)), 5, i*36+this.count, Assets.BULLETREDBUTTER, i*36+this.count));
							//								entityManager.addBullet(new Bullet(entityManager, 1, new Vector2((float) ((Assets.BOSSFOUR.getRegionWidth()/2) + 185+50 -8), (float) (Assets.BOSSFOUR.getRegionHeight()/2 + 550 - this.count)), 5, i*36+this.count, Assets.BULLETREDBUTTER, i*36+this.count));
							setLastFire(System.currentTimeMillis());
							this.count++;
						}
					}
					else{
						this.count = 0;
					}
					setLastFire(System.currentTimeMillis());
				}
				if(((int)System.currentTimeMillis()/1000%9 == 8)){
					delay++;
				}
				if(delay == 5){
					round++;
					delay = 0;
				}

			}
			if(getHp() - 1 == 0 || getHp() - 2 == 0) {
				bossdead.play();
				victory.play();
				PlayState.getBoss4().dispose();
				PlayState.stage = 5;
				time.setTime(0);
			}else if(time.getTime() >= 1600) {
				PlayState.stage = 5;
				nokill.play();
				PlayState.getBoss4().dispose();
				entityManager.clearAll();
				entityManager.addRemove(this);
				time.setTime(0);
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
			if(getPos().y == 470 && time.getTime() <= 1160 && getRoundFire() % 10 == 0) {
				System.out.println(time.getTime());
				if(System.currentTimeMillis() - getLastFire() >= 20) {
					for(int i = 4; i < 364; i+= 9){
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETPINKTRI.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 20, i + degree, Assets.BULLETPINKTRI, i + degree-90));
					}
					if(System.currentTimeMillis() - getLastFire() >= 100) {
						degree ++;
						setLastFire(System.currentTimeMillis());
					}
				}
				
				if(degree == 360) {
//					setRoundFire(getRoundFire() + 1);
					degree = 0;
				}
			}
			if(getPos().y == 470 && time.getTime() > 1160 && time.getTime() <= 1220 && getRoundFire() % 10 == 0) {
				System.out.println(time.getTime());
				if(System.currentTimeMillis() - getLastFire() >= 20) {
					for(int i = 4; i < 364; i+= 9){
						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETPINKTRI.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 20, i - degree, Assets.BULLETPINKTRI, i - degree-90));
					}
					if(System.currentTimeMillis() - getLastFire() >= 100) {
						degree ++;
						setLastFire(System.currentTimeMillis());
					}
				}
				
				if(degree == 360) {
//					setRoundFire(getRoundFire() + 1);
					degree = 0;
				}
				if(time.getTime() == 1220){
					degree = 0;
					setRoundFire(getRoundFire() + 1);
				}
			}
			if(time.getTime() > 1220 && time.getTime() <= 1720 && getRoundFire() % 10 == 1) {
				if(System.currentTimeMillis() - getLastFire() >= 50) {
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETREDKUNAI.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, degree, Assets.BULLETREDKUNAI, degree-90));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETREDSMALL.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 4, degree, Assets.BULLETREDSMALL, degree-90));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETREDKUNAI.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, degree+120, Assets.BULLETREDKUNAI, degree+30));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETREDSMALL.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 4, degree+120, Assets.BULLETREDSMALL, degree+30));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETREDKUNAI.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 5, degree+240, Assets.BULLETREDKUNAI, degree+150));
					entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETREDSMALL.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 4, degree+240, Assets.BULLETREDSMALL, degree+150));
					setLastFire(System.currentTimeMillis());
				}
				
				if(degree < 360) {
					degree += 4;
				}else{
					degree = 0;
				}
				if(time.getTime() == 1720){
					degree = 0;
					setRoundFire(getRoundFire() + 1);
				}
			}
//			if(getRoundFire() % 10 == 1 || getRoundFire() % 10 == 6) {
//				if(degree < 6){
//					if(System.currentTimeMillis() - getLastFire() >= 100) {
//						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 240, Assets.BULLETROCKET01, 150));
//						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 255, Assets.BULLETROCKET01, 165));
//						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 270, Assets.BULLETROCKET01, 180));
//						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 285, Assets.BULLETROCKET01, 195));
//						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 300, Assets.BULLETROCKET01, 210));
//						setLastFire(System.currentTimeMillis());
//						degree++;
//					}
//				}
//				if(degree < 12 && degree > 5){
//					if(System.currentTimeMillis() - getLastFire() >= 100) {
//						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 233, Assets.BULLETROCKET01, 143));
//						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 248, Assets.BULLETROCKET01, 158));
//						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 263, Assets.BULLETROCKET01, 173));
//						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 277, Assets.BULLETROCKET01, 187));
//						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 292, Assets.BULLETROCKET01, 202));
//						entityManager.addBullet(new Bullet(entityManager, 5, new Vector2((Assets.BOSSFIVE.getRegionWidth()/2) + getPos().x - (Assets.BULLETROCKET01.getRegionWidth()/2), (Assets.BOSSFIVE.getRegionHeight()/2) + getPos().y), 10, 307, Assets.BULLETROCKET01, 217));
//						setLastFire(System.currentTimeMillis());
//						degree++;
//					}
//				}
//				if(degree == 12){
//					degree = 0;
//					setRoundFire(getRoundFire() + 1);
//				}
//			}
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
			if(getHp() - 1 == 0 || getHp() - 2 == 0) {
				bossdead.play();
				victory.play();
				PlayState.getBoss5().dispose();
				time.setTime(1700);
			}else if(time.getTime() >= 1700) {
				nokill.play();
				PlayState.getBoss5().dispose();
				entityManager.clearAll();
				entityManager.addRemove(this);
			}
		}
	}
}
