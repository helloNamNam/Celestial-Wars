package com.mygdx.game;

public class TimeControl implements Runnable {
	
	private float time = 0;
	
	@Override
	public void run() {
		while(true) {
			
			try {
				time ++;
//				System.out.println(time);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public float getTime() {
		return time;
	}

	public void resetTime() {
		time = 0;
	}
}
