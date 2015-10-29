package com.mygdx.game.states;

import java.util.Stack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameStateManager {

	//use stack to manage states.
	private Stack<State> states;
	
	//constructor.
	public GameStateManager(){
		states = new Stack<State>();
	}
	
	//push state into stack.
	public void push(State state){
		states.push(state);
	}
	
	//pop a top of stack.
	public void pop(State state){
		states.pop();
	}
	
	//set what's next state run.
	public void set(State state){
		states.pop();
		states.push(state);
	}
	
	//update state.
	public void update(float dt){
		states.peek().update(dt);
	}
	
	//render state.
	public void render(SpriteBatch sb){
		states.peek().render(sb);
	}
}
