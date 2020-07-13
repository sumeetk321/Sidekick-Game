package com.mightyfist.sidekickgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Main game class. All user input is handled here.
 * 
 * @author Sumeet Kulkarni
 *
 */

// TODO: Add collision detection for ball and kicker sprite. Add restart
// ability.
public class SidekickGame extends ApplicationAdapter {
	SpriteBatch batch;
	BitmapFont font;
	Kicker[] sidekickers;
	Kicker kicker;
	Target target;
	public static final int NUM_SIDEKICK_TEXTURES = 4;
	ShapeRenderer shapeRenderer;
	static int i = 0;
	double deltaY = -1;
	double deltaX = 0;

	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		target = new Target(new Texture(Gdx.files.internal("red_ball.png")));
		target.setScale(0.1f);
		target.setPosition(25, 200);
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		sidekickers = new Kicker[NUM_SIDEKICK_TEXTURES];
		sidekickers[0] = new Kicker(new Texture(Gdx.files.internal("leftlegback_cropped.PNG")));
		sidekickers[1] = new Kicker(new Texture(Gdx.files.internal("bendingreadystance_cropped.PNG")));
		sidekickers[2] = new Kicker(new Texture(Gdx.files.internal("chamber_crosshands_cropped.PNG")));
		sidekickers[3] = new Kicker(new Texture(Gdx.files.internal("finalkick_cropped.PNG")));

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
		target.update(deltaX, deltaY);
		batch.begin();
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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
		target.draw(batch);
		if (i == 3 && sidekickers[i].getBoundingRectangle().overlaps(target.getBoundingRectangle())) {
			//System.out.println("TOUCHING " + target.getX() + ", " + target.getY());
			if (target.getY() <= -12 && target.getY() >= -70) {
				deltaX = -0.1 * ((target.getY() + 12) * (target.getY() + 70)); // Polynomial. Equal to 0 if kicker kicks at very top or very bottom of ball.
				deltaY = target.getY() / -41; //-41 is the average of -12 and -70. If the kicker kicks at the top (y = -12), deltaY should be low. Same for the bottom.
			}
		}
		if(target.getX()>w||target.getX()<-w||target.getY()>200||target.getY()<-280) {
			
			target.setPosition(25, 200);
			deltaX = 0;
			deltaY = -1;
		}
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
