package com.mightyfist.sidekickgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Kicker extends Sprite {
	private boolean visible;
	public Kicker(Texture texture) {
		super(texture);
		setVisible(false);
	}

	
	 public void setVisible(boolean visible){
	        this.visible = visible;
	    }

	    public boolean isVisible(){
	        return visible;
	    }
	

}
