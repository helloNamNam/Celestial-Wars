package com.mygdx.game.entities.enemies;

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
		if(PlayState.stage == 1) {
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
					PlayState.stage = 2;
				}else if(time.getTime() >= 1600) {
					entityManager.clearAll();
					entityManager.addRemove(this);
				}
				System.out.println(time.getTime());
			}
		}
	}

	@Override
	public void update() {
		moveObject(entityManager);
		fire();
	}

	@Override
	public Boolean isCollision(SpaceObject object) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
