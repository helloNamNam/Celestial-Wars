package com.mygdx.game.entities.bullets;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Assets;
import com.mygdx.game.entities.EntityManager;
import com.mygdx.game.entities.ItemObject;
import com.mygdx.game.states.PlayState;

public class Bullet extends ItemObject{
	
	private EntityManager entityManager;
	
	public Bullet(EntityManager entityManager, int id, Vector2 pos, double velocity, double direction, TextureRegion texture, float rotate) {
		super(id, pos, velocity, direction, texture, rotate, 0, 0, texture.getRegionWidth(), texture.getRegionHeight());
//		setBounds(pos.x, pos.y, texture.getWidth(), texture.getHeight());
	}

	@Override
	public void update() {

		if(PlayState.stage == 2){
			if(getId() == 398){
				if(getPos().x > 620){
					if(getDirection() < 90){
						setDirection(180 - getDirection());
					}else{
						setDirection(180 + 360 - getDirection());
					}
				}
				if(getPos().x < 20){
					if(getDirection() < 180){
						setDirection(180 - getDirection());
					}else{
						setDirection(360 - getDirection() - 180);
					}
				}
				if(getPos().y < 25){
					if(getDirection() < 270){
						setDirection(270 - getDirection() + 90);
					}else{
						setDirection(90 - getDirection() - 270);
					}
				}
			}

		if(getId() == 1005){
			if(System.currentTimeMillis()/100%6 ==0){
				int ran = (int) (Math.random()*3);
				if(ran == 0){
					setTexture(Assets.BULLETWATER1);
				}
				if(ran == 1){
					setTexture(Assets.BULLETWATER2);
				}
				if(ran == 2){
					setTexture(Assets.BULLETWATER3);
				}
				else{
					setTexture(Assets.BULLETWATER4);
				}	
				setRotate(ran);
			}
		}
		}
		moveObject(entityManager);
	}
}