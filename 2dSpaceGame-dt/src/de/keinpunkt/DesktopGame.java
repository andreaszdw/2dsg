package de.keinpunkt;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class DesktopGame {
	public static void main (String[] args) {
		new LwjglApplication(new Game(), "2dSpaceGame", 800, 600);
	}

}
