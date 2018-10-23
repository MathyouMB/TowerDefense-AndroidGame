package com.example.matthew;

import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

import android.graphics.PointF;



	public class Enemies extends Sprite{
		public PointF location;
	     public float speedx;
	     public float speedy;
	     public boolean active;
		
	     
		public Enemies(float pX, float pY, TextureRegion pTextureRegion, float sX, float sY) {
			super(pX, pY, pTextureRegion);
			this.speedx = sX;
			this.speedy = sY;
			this.active = true;
			
		
			// TODO Auto-generated constructor stub
			
			
			
			this.location = new PointF(pX,pY);
		}
		public void Move(){
			location.x += speedx;
			location.y += speedy;
			
			setPosition(location.x,location.y);
		
			
			
		} 
		
}
