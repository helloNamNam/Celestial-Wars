package com.mygdx.game.entities;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.entities.bullets.Bullet;


public class EntityManager {
	public static int score = 0;
	List<Unit> enemies;
	List<SpaceObject> bullets;
	List<Player> players;
	List<SpaceObject> items;
	List<SpaceObject> removeObject;
	public static Sound mondead;
	
	public EntityManager() {
		enemies = new ArrayList<Unit>();
		bullets = new ArrayList<SpaceObject>();
		players = new ArrayList<Player>();
		items = new ArrayList<SpaceObject>();
		removeObject = new ArrayList<SpaceObject>();
		mondead = Gdx.audio.newSound(Gdx.files.internal("Sounds/mondead.mp3"));
	}
	
	public void render() {
		for(SpaceObject bullet: bullets) {
			bullet.render();
		}
		
		for(SpaceObject item: items) {
			item.render();
		}
		
		for(SpaceObject enemy: enemies) {
			enemy.render();
		}
		
		for(Player player: players) {
			player.render();
		}
//		dispose();
	}
	
	public void update() {
//		for(SpaceObject entity: entities) {
//			entity.update();
//		}
		
		int lengthBullets = bullets.size();
		for(int index = 0;index < lengthBullets; ++index) {
			SpaceObject bullet = bullets.get(index);
			bullet.update();
		}
		
		int lengthItems = items.size();
		for(int index = 0;index < lengthItems; ++index) {
			SpaceObject item = items.get(index);
			item.update();
		}
		
		int lengthEnemies = enemies.size();
		for(int index = 0;index < lengthEnemies; ++index) {
			SpaceObject enemy = enemies.get(index);
			enemy.update();
		}
		
		dispose();
		for(Player player: players){
			player.update();
		}
		checkCollision();
	}

	public void addBullet(SpaceObject entity) {
		bullets.add(entity);
	}
	
	public void addEnemy(Unit enemy) {
		enemies.add(enemy);
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public void addItem(SpaceObject item) {
		items.add(item);
	}
	
	public void addRemove(SpaceObject remove){
		removeObject.add(remove);
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public List<Unit> getEnemies() {
		return enemies;
	}

	public void clearAll(){
		for(int i = 0; i < bullets.size(); i++) {
			removeObject.add(bullets.get(i));
		}
		for(int i = 0; i < enemies.size(); i++) {
			removeObject.add(enemies.get(i));
		}
	}
	public void dispose() {
		for(int i = 0; i < bullets.size(); i++) {
			if(bullets.get(i).getPos().x < 0 || bullets.get(i).getPos().x > 660 || bullets.get(i).getPos().y < 0 || bullets.get(i).getPos().y > 960) {
				bullets.remove(bullets.get(i));
			}
		}
		for(int i = 0; i < enemies.size(); i++) {
			if(enemies.get(i).getPos().x < -50 || enemies.get(i).getPos().x > 700 || enemies.get(i).getPos().y < -50 || enemies.get(i).getPos().y > 990) {
				enemies.remove(enemies.get(i));
			}
		}
	}
	
	public void checkCollision(){

		for(int i = 0; i < bullets.size(); i++) {
			if((bullets.get(i).getId() == 2)){
				for(int j = 0; j < enemies.size(); j++) {
					if((enemies.get(j).getId() > 2) && (bullets.get(i).getBounds().overlaps((enemies.get(j).getBounds())))) {
						removeObject.add(bullets.get(i));
						enemies.get(j).setHp(enemies.get(j).getHp() - 1);
						if(enemies.get(j).getId() != 99 && enemies.get(j).getId() != 999){
							score += 100 + Math.random()*50;
						}else{
							score += 200 + Math.random()*50;
						}
						if(enemies.get(j).getHp() == 0 && (enemies.get(j).getId() == 99 || enemies.get(j).getId() == 999)) {
							if(enemies.get(j).getId() == 99) {
								score += 100000;
							}else{
								score += 500000;
							}
							
							clearAll();
						}else if(enemies.get(j).getHp() == 0) {
							score += 500;
							removeObject.add(enemies.get(j));
						}
					}
				}
			}
		}
		
		for(int i = 0; i < enemies.size(); i++) {
			if((enemies.get(i).getId() > 2) && (players.get(0).getBounds().overlaps((enemies.get(i).getBounds())))) {
				if(enemies.get(i).getHp() - 1 == 0) {
					enemies.get(i).setHp(0);
					removeObject.add(enemies.get(i));
				}else {
					enemies.get(i).setHp(enemies.get(i).getHp() - 1);
				}
				players.get(0).die();
			}
		}
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getId() == 1 && (players.get(0).getBounds().overlaps((items.get(i).getBounds())))) {
				players.get(0).heartPoint += 1;
				items.remove(items.get(i));
			}else {
				players.get(0).bulletLevel += 1;
				items.remove(items.get(i));
			}
		}
		for(int i = 0; i < removeObject.size(); i++){
			if(removeObject.get(i) instanceof Bullet) {
				bullets.remove(removeObject.get(i));
			}else {
				enemies.remove(removeObject.get(i));
				mondead.play();
			}
		}
		removeObject.clear();
		for(int i = 0; i < bullets.size(); i++) {
			if((bullets.get(i).getId() > 2) && (players.get(0).getBounds().overlaps((bullets.get(i).getBounds())))) {
				bullets.remove(bullets.get(i));
				players.get(0).die();
			}
		}
	}


}
