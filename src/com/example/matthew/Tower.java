package com.example.matthew;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

import android.graphics.PointF;

public class Tower extends Sprite{
	public PointF location;
    int bulletcounter;
    int fireDelay;
    int NR ;
    
    
	public Tower(float pX, float pY, TextureRegion pTextureRegion,int Activewizard) {
		super(pX, pY, pTextureRegion);
		bulletcounter = 0;
		fireDelay = 100;
		// TODO Auto-generated constructor stub
		location = new PointF(pX,pY);
		NR = Activewizard;
		
		
	}
	
	
	
	
	

}
