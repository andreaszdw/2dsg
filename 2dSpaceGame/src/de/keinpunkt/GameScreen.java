package de.keinpunkt;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.Input.Keys;

public class GameScreen implements Screen, InputProcessor {
  	final GameMain game;

	OrthographicCamera camera;

	public GameScreen(final GameMain gam) {
		this.game = gam;

		// create the camera and the SpriteBatch
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		
		// Inputprocessor
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render(float delta) {
		// clear the screen with a dark blue color. The
		// arguments to glClearColor are the red, green
		// blue and alpha component in the range [0,1]
		// of the color to be used to clear the screen.
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// tell the camera to update its matrices.
		camera.update();

		// tell the SpriteBatch to render in the
		// coordinate system specified by the camera.
		game.batch.setProjectionMatrix(camera.combined);

		game.batch.begin();
		game.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		camera.setToOrtho(false, width, height);
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
	
	// implemention InputProssor starts here
	@Override 
	public boolean mouseMoved (int screenX, int screenY) {
		return false;
	}
	
	@Override 
	public boolean touchDown (int screenX, int screenY, int pointer, int button) {
		return true;
	}
	
	@Override 
	public boolean touchDragged (int screenX, int screenY, int pointer) {
		return true;
	}
	
	@Override 
	public boolean touchUp (int screenX, int screenY, int pointer, int button) {
		return true;
	}
	
	@Override 
	public boolean keyDown (int keycode) {
		System.out.println("KeyDown: " + Keys.toString(keycode));
		
		/*if (Keys.toString(keycode) == "+") {
			System.out.println("+");
		}
		
		if  (Keys.toString(keycode) == "-") {
			System.out.println("-");
		}*/
		return false;
	}
	
	@Override 
	public boolean keyUp (int keycode) {
		return false;
	}
	
	@Override 
	public boolean keyTyped (char character) {

		System.out.println("KeyTyped: " + character);
		return false;
	}
	
	@Override 
	public boolean scrolled (int amount) {
		return false;
	}

}