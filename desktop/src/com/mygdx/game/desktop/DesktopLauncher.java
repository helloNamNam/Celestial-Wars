package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		//config size of desktop and position when program is run.
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = Game.TITLE;
		cfg.width = Game.WIDTH;
		cfg.height = Game.HEIGHT;
		cfg.x = -1;
		cfg.y = 20;
		new LwjglApplication(new Game(), cfg);
	}
}
