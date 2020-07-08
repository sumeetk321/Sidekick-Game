package com.mightyfist.sidekickgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/**
 * Main game class. All user input is handled here.
 * @author sumeetkulkarni
 *
 */
public class SidekickGame extends ApplicationAdapter {
	SpriteBatch batch;
	BitmapFont font;
	Kicker[] sidekickers;
	Kicker kicker;
	public static final int NUM_SIDEKICK_TEXTURES = 4;
	ShapeRenderer shapeRenderer;
	static int i = 0;
	private float posX, posY;

	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		sidekickers = new Kicker[NUM_SIDEKICK_TEXTURES];
		sidekickers[0] = new Kicker(new Texture(Gdx.files.internal("leftlegback_cropped.PNG")));
		sidekickers[1] = new Kicker(new Texture(Gdx.files.internal("bendingreadystance_cropped.PNG")));
		sidekickers[2] = new Kicker(new Texture(Gdx.files.internal("chamber_crosshands_cropped.PNG")));
		sidekickers[3] = new Kicker(new Texture(Gdx.files.internal("finalkick_cropped.PNG")));
		posX = w / 4 - sidekickers[0].getWidth() / 2;
		posY = h / 4 - sidekickers[0].getHeight() / 2;
		Gdx.input.setInputProcessor(new InputProcessor() {

			@Override
			public boolean keyDown(int keycode) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean keyTyped(char character) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				if (button == Input.Buttons.LEFT) {
					onMouseDown();
					return true;
				}
				return false;
			}

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer, int button) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean mouseMoved(int screenX, int screenY) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean scrolled(int amount) {
				// TODO Auto-generated method stub
				return false;
			}

		});
	}

	@Override
	public void render() {
		batch.begin();
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		posX = w / 4 - sidekickers[0].getWidth() / 2;
		posY = h / 4 - sidekickers[0].getHeight() / 2;
		sidekickers[i].setScale(0.3f);
		switch (i) {
		case 0:
			sidekickers[i].setPosition(-250, -200);
			break;
		case 1:
			sidekickers[i].setPosition(-150, -200);
			break;
		case 2:
			sidekickers[i].setPosition(-150, -200);
			break;
		case 3:
			sidekickers[i].setPosition(-250, -175);
			break;
		}
		sidekickers[i].draw(batch);

		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}

	private void onMouseDown() {
		i++;
		i %= 4;
	}

}
