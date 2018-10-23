package com.example.matthew;

import org.anddev.andengine.entity.sprite.Sprite;
	import org.anddev.andengine.opengl.texture.region.TextureRegion;
    import android.graphics.PointF;
public class Bullets extends Sprite{
	public PointF location;
	float angle;
	 public float speedx;
     public float speedy;
	public boolean active;

	public Bullets(float pX, float pY, 
			TextureRegion pTextureRegion,float angle2) {
		super(pX, pY, pTextureRegion);
		// TODO Auto-generated constructor stub
		
		
		
		
	    this.angle =  angle2;
	    this.active = true;
	    this.speedx = (float) (Math.sin(angle)*0.2);
	    this.speedy = (float) (Math.cos(angle)*0.2);
		this.location = new PointF(pX,pY);
	}
	public void Move(){
		this.location.x += this.speedx;
		this.location.y -= this.speedy;
		
		this.setPosition(this.location.x,this.location.y);
	}
	

}
