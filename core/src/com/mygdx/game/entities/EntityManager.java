package com.mygdx.game.entities;

import java.util.ArrayList;
import java.util.List;


public class EntityManager {
	
	List<SpaceObject> enemies;
	List<SpaceObject> bullets;
	List<Player> players;
	List<SpaceObject> removeObject;
	
	public EntityManager() {
		enemies = new ArrayList<SpaceObject>();
		bullets = new ArrayList<SpaceObject>();
		players = new ArrayList<Player>();
		
	}
	
	public void render() {
		for(SpaceObject bullet: bullets) {
			bullet.render();
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
//		System.out.println("add Bullet");
		bullets.add(entity);
	}
	
	public void addEnemy(SpaceObject enemy) {
		enemies.add(enemy);
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public void dispose() {
		for(int i = 0; i < bullets.size(); i++) {
			if(bullets.get(i).getPos().x < -50 || bullets.get(i).getPos().x > 700 || bullets.get(i).getPos().y < -50 || bullets.get(i).getPos().y > 990) {
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
			if((bullets.get(i).getId() == 1)){
				for(int j = 0; j < enemies.size(); j++) {
					if((enemies.get(j).getId() > 2) && (bullets.get(i).getBounds().overlaps((enemies.get(j).getBounds())))) {
						System.out.println("Hits by bullet's player!!");
						bullets.remove(bullets.get(i));
						enemies.remove(enemies.get(j));
//						players.remove(players.get(0));
					}
				}
			}
		}
		
		for(int i = 0; i < enemies.size(); i++) {
			if((enemies.get(i).getId() > 1) && (players.get(0).getBounds().overlaps((enemies.get(i).getBounds())))) {
				System.out.println("Bound!!");
				enemies.remove(enemies.get(i));
//				players.remove(players.get(0));
			}
		}
		
		for(int i = 0; i < bullets.size(); i++) {
			if((bullets.get(i).getId() > 1) && (players.get(0).getBounds().overlaps((bullets.get(i).getBounds())))) {
				System.out.println("Bound!!");
				bullets.remove(bullets.get(i));
//				players.remove(players.get(0));
			}
		}
	}
}
