package com.mygdx.game.entities;

import java.util.ArrayList;
import java.util.List;

import com.mygdx.game.entities.bullets.Bullet;
//import com.mygdx.game.entities.bullets.StandardBullet;


public class EntityManager {
	
	List<SpaceObject> entities;
	List<Player> players;
	
	public EntityManager() {
		entities = new ArrayList<SpaceObject>();
		players = new ArrayList<Player>();
	}
	
	public void render(){
		for(SpaceObject entity: entities){
			entity.render();
		}
		for(Player player: players){
			player.render();
		}
	}
	
	public void update(){
		for(SpaceObject entity: entities){
			entity.update();
		}
//		for(Player player: players){
//			player.render();
//		}
	}
	
	public void addEntity(SpaceObject entity){
//		System.out.println("add Bullet");
		entities.add(entity);
	}
	
	public void addPlayer(Player player){
		players.add(player);
	}
	
}
