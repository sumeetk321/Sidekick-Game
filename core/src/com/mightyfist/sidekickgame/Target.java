package com.mightyfist.sidekickgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Represents the target red ball sprite. Bounded by a rectangle.
 * 
 * @author Sumeet Kulkarni
 *
 */
public class Target extends Sprite {
	private boolean visible;
	private int weight = 1;
	public Target(Texture texture) {
		super(texture);
		setVisible(false);
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isVisible() {
		return visible;
	}

	public void update(int delta) {
		this.setY(this.getY()-weight*delta);
	}
}
