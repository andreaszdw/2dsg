package de.keinpunkt;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;


public class MainMenuScreen implements Screen {
	
	final GameMain game;
        
	OrthographicCamera camera;
	
	SpriteBatch batch;
	Stage stage;
	TextButton button;
	TextButtonStyle style;
	Skin buttonSkin;
	BitmapFont font;

	public MainMenuScreen(final GameMain gam) {
		game = gam;
		
		batch = new SpriteBatch();
		
		stage = new Stage();
		stage.clear();
		Gdx.input.setInputProcessor(stage);
		font = new BitmapFont();
		
		buttonSkin = new Skin();
		
		style = new TextButtonStyle();
		style.font = font;
		
		button = new TextButton("Drück mich", style); 
		button.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
        button.setHeight(100);
        button.setWidth(100);
        button.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.log("my app", "Pressed"); //** Usually used to start Game, etc. **//
                    return true;
            } 
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("my app", "Released");
            }
        });
        
       stage.addActor(button);
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 600);

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act();
		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		game.font.draw(batch, "Tap anywhere to begin!", 100, 100);
		stage.draw();
		batch.end();

		if (Gdx.input.isTouched()) {
			game.setScreen(new GameScreen(game));
			dispose();
		}
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
		batch.dispose();
	}
}