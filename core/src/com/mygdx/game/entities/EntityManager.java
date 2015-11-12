package com.mygdx.game.entities;

import java.util.ArrayList;
import java.util.List;

import com.mygdx.game.entities.SpaceObject;


public class EntityManager {
	
	List<SpaceObject> entities;
	List<Player> players;
	List<SpaceObject> removeObject;
	
	public EntityManager() {
		entities = new ArrayList<SpaceObject>();
		players = new ArrayList<Player>();
		
	}
	
	public void render() {
		for(SpaceObject entity: entities) {
			entity.render();
		}
		for(Player player: players) {
			player.render();
		}
//		dispose();
	}
	
	public void update() {
		for(SpaceObject entity: entities) {
			entity.update();
		}
		dispose();
		for(Player player: players){
			player.update();
		}
		checkCollision();
	}
	
	public void addEntity(SpaceObject entity) {
//		System.out.println("add Bullet");
		entities.add(entity);
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public void dispose() {
		for(int i = 0; i < entities.size(); i++) {
			if(entities.get(i).getPos().x < -50 || entities.get(i).getPos().x > 700 || entities.get(i).getPos().y < -50 || entities.get(i).getPos().y > 990) {
				entities.remove(entities.get(i));
			}
		}
	}
	
	public void checkCollision(){
		for(int i = 0; i < entities.size(); i++){
			if((entities.get(i).getId() > 1) && (players.get(0).getBounds().overlaps((entities.get(i).getBounds())))){
				System.out.println("Bound!!");
//				entities.remove(entities.get(i));
//				players.remove(players.get(0));
			}
		}
	}
}
