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
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kotcrab.vis.ui.VisUI;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.kotcrab.vis.ui.widget.VisTextButton;
import com.kotcrab.vis.ui.widget.VisTable;


public class MainMenuScreen implements Screen {
	
	final GameMain game;
        
	OrthographicCamera camera;
	
	SpriteBatch batch;
	Stage stage;
	TextButton button;
	TextButtonStyle style;
	Skin skin;
	BitmapFont font;

	public MainMenuScreen(final GameMain gam) {
		game = gam;
		
		batch = new SpriteBatch();
		
		VisUI.load(new Skin(Gdx.files.internal("assets/neutralizer/neutralizer-ui.json")));
        stage = new Stage(new ScreenViewport());
        
        VisTable root = new VisTable();
        root.setFillParent(true);
        stage.addActor(root);
		
		//stage = new Stage();
		//stage.clear();
		Gdx.input.setInputProcessor(stage);
		font = new BitmapFont();
		
		skin = new Skin(Gdx.files.internal("assets/shadeui/uiskin.json")); //new Skin();
		
		//style = new TextButtonStyle();
		//style.font = font;
		
		/*button = new TextButton("Push", skin); 
		button.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
        //button.setHeight(100);
        //button.setWidth(100);
        button.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.log("my app", "Pressed"); 
                    return true;
            } 
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("my app", "Released");
    			//game.setScreen(new GameScreen(game));
    			//dispose();
            }
        });*/
        
        //stage.addActor(button);
		
		VisTextButton textButton = new VisTextButton("INITIATE");
        textButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
            	
            	System.out.println("pushed ");
            }
        });
		
		root.row();
		root.add(textButton);
		
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 600);
		
		//System.getProperty("user.home");
		String currentUsersHomeDir = System.getProperty("user.home");
		System.out.println(currentUsersHomeDir);

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act();
		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		//game.font.draw(batch, "Tap anywhere to begin!", 100, 100);
		stage.draw();
		batch.end();

		/*if (Gdx.input.isTouched()) {
			game.setScreen(new GameScreen(game));
			dispose();
		}*/
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