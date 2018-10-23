package com.example.matthew;

import java.util.ArrayList;
import java.util.Timer;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.handler.timer.ITimerCallback;
import org.anddev.andengine.engine.handler.timer.TimerHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.ui.activity.BaseActivity;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.opengl.font.Font;


import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Display;

public class MainActivity extends BaseGameActivity implements
		IOnSceneTouchListener {

	Camera camera;
	Display display;
	int camerawidth;
	int cameraheight;
	Scene MainScene;
	BitmapTextureAtlas bta;
	TextureRegion backgroundTexture;
	Sprite background;
	TimerHandler Timer;
    public static int gold;
    public static ChangeableText goldLabel;
    Font mFont;
    BitmapTextureAtlas mFontTexture;
	float Timerp2 = 0.001f;
	Sprite current;

	

	Sprite wizardbar;
	TextureRegion wizardbartexture;

	Tower cannon;
	TextureRegion enemy1texture;
	TextureRegion enemy2texture;
	TextureRegion Bullet1texture;
	Enemies enemy1;
	Enemies enemy2;
    int enemycounter;
    int ActiveWizard;
    int Activeprojectile;

	ArrayList<Tower> Towerlist;
    ArrayList<TextureRegion> Wizardlist;
	
	
	
	ArrayList<Enemies> Enemieslist;
	

	
	
	
	
	ArrayList<Bullets> Bulletslist;
	  ArrayList<TextureRegion> projectilelist;

	public void onLoadComplete() {

	}

	public Engine onLoadEngine() {

		display = getWindowManager().getDefaultDisplay();
		camerawidth = display.getWidth();
		cameraheight = display.getHeight();
		camera = new Camera(0, 0, camerawidth, cameraheight);

		return new Engine(new EngineOptions(true, ScreenOrientation.LANDSCAPE,
				new RatioResolutionPolicy(camerawidth, cameraheight), camera)
				.setNeedsSound(true).setNeedsMusic(true));

	}

	public void onLoadResources() {
		bta = new BitmapTextureAtlas(4096, 4096,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		backgroundTexture = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(bta, this, "back.png", 600, 600);
		wizardbartexture = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(bta, this, "le bar.png", 74, 86);
		
		
		
		  Wizardlist = new ArrayList<TextureRegion>();
		Wizardlist.add(BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				bta, this, "another wizard person.png", 1000, 1000));
		Wizardlist.add(BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				bta, this, "green wizard person.png",  1100, 1100));
		Wizardlist.add(BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				bta, this, "le purple wizard.png",  1150, 1150));
		Wizardlist.add(BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				bta, this, "pyromancer.png",  1200, 1200));
		Wizardlist.add(BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				bta, this, "another wizard.png",  1250, 1250));
		Wizardlist.add(BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				bta, this, "the another wizard.png",  1400, 1400));
		Wizardlist.add(BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				bta, this, "some wise green wizard.png",  1450, 1450));
		
		
		projectilelist = new ArrayList<TextureRegion>();
		projectilelist.add(BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				bta, this, "biggger blue thing.png", 2000, 2000));
		projectilelist.add(BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				bta, this, "green small wind mill like bullet.png",  2100, 2100));
		projectilelist.add(BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				bta, this, "purple masn bullet.png",  2150, 2150));
		projectilelist.add(BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				bta, this, "fire ball.png",  2200, 2200));
		projectilelist.add(BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				bta, this, "gray bullet final.png",  2250, 2250));
		projectilelist.add(BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				bta, this, "big red blob.png",  2400, 2400));
		projectilelist.add(BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				bta, this, "the big green bullet thing.png",  2550, 2550));
		
		
		
		
		
		enemy1texture = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				bta, this, "thang3.png", 300, 300);
		enemy2texture = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				bta, this, "thing 2 with dark thing.png",  2500, 2500);
		Bullet1texture = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				bta, this, "biggger blue thing.png", 1, 1);
		mFontTexture = new BitmapTextureAtlas(256,256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		
		mFont = new Font(mFontTexture, Typeface.create(Typeface.DEFAULT, Typeface.BOLD),20,true,Color.YELLOW);
		
		mEngine.getTextureManager().loadTexture(mFontTexture);
		mEngine.getFontManager().loadFont(mFont);
		
		
		mEngine.getTextureManager().loadTexture(bta);

	}

	public Scene onLoadScene() {
		MainScene = new Scene();
		Towerlist = new ArrayList<Tower>();
		Enemieslist = new ArrayList<Enemies>();
		Bulletslist = new ArrayList<Bullets>();
	  
		
		enemycounter = 0;
		ActiveWizard = 0;
		Activeprojectile = 0;
		MainScene.setOnSceneTouchListener(this);
		background = new Sprite(0, 0, backgroundTexture);
		wizardbar = new Sprite(0, 500, wizardbartexture);
		current = new Sprite(1000,550, Wizardlist.get(0));
	
		MainScene.attachChild(current);
		MainScene.attachChild(wizardbar);
		MainScene.attachChild(background);
		//Enemieslist.add(new Enemies(5, 210, enemy1texture));
		// enemy1.setFlippedHorizontal(true);
		Enemieslist.add(new Enemies(-100, 225, enemy2texture, 0.2f,0));
		// enemy2.setFlippedHorizontal(true);
		MainScene.attachChild(Enemieslist.get(Enemieslist.size() - 1));
		
		goldLabel = new ChangeableText(250,20,mFont,"" + ActiveWizard);
		MainScene.attachChild(goldLabel);
		Timer();
		return MainScene; // Loading the background
		
		
		
		
		

	}

	@Override
	public boolean onSceneTouchEvent(Scene touchscene, TouchEvent otherstuff) {
		// TODO Auto-generated method stub

		float x = otherstuff.getX();
		float y = otherstuff.getY();
		float extrax = x % 50;
		float extray = y % 50;
		boolean flag;

		
		if (x < 1024 && y < 499){
				Towerlist.add(new Tower(x - extrax, y - extray, Wizardlist.get(ActiveWizard),ActiveWizard ));
				touchscene.attachChild(Towerlist.get(Towerlist.size() - 1)); 
				
			
			
			for (int i = 0; i < (Towerlist.size()-1); i++) {
				if	((Towerlist.get(i).location.x == (x - extrax)) && (Towerlist.get(i).location.y == (y - extray))){
					MainScene.detachChild(Towerlist.get(i));
					Towerlist.remove(i);
				}
			}
		}

  	  goldLabel.setText(""+ActiveWizard);
		
	if (y > 544 && y < 594) {
		  Enemieslist.add(new Enemies(-500, 400, enemy1texture, 0.2f,0));
		  Enemieslist.add(new Enemies(-250, 400, enemy2texture, 0.5f,0));
		  MainScene.attachChild(Enemieslist.get(Enemieslist.size() - 1));
          MainScene.attachChild(Enemieslist.get(Enemieslist.size() - 2));
		
	  if (x > 278 && x < 328) { //1    //// things are to low.
		  ActiveWizard = 0;
    	  goldLabel.setText(""+ActiveWizard);

    	 MainScene.detachChild(current);
    	 current = new Sprite(899,541, Wizardlist.get(ActiveWizard));
    	
    	 MainScene.attachChild(current);
    	  /////////////////////////////////////////
    	  
	  }
	  
      if (x > 359 && x < 409) { //2
    	  ActiveWizard = 1;
    	
    	  goldLabel.setText(""+ActiveWizard);
    	  MainScene.detachChild(current);
     	 current = new Sprite(899,541, Wizardlist.get(ActiveWizard));
     	 MainScene.attachChild(current);
	  }
      
      if (x > 450 && x < 500) { //3
    	  ActiveWizard = 2;
    	  goldLabel.setText(""+ActiveWizard);
    	  MainScene.detachChild(current);
      	 current = new Sprite(899,541, Wizardlist.get(ActiveWizard));
      	 MainScene.attachChild(current);
	  }
      
      if (x > 530 && x < 580) { //4
    	  ActiveWizard = 3;
    	  goldLabel.setText(""+ActiveWizard);
    	  MainScene.detachChild(current);
      	 current = new Sprite(899,541, Wizardlist.get(ActiveWizard));
      	 MainScene.attachChild(current);
	  }
      
      if (x > 613 && x < 663) { //5
    	  ActiveWizard = 4;
    	  goldLabel.setText(""+ActiveWizard);
    	  MainScene.detachChild(current);
      	 current = new Sprite(899,541, Wizardlist.get(ActiveWizard));
      	 MainScene.attachChild(current);
	  }
      
      if (x > 693 && x < 749) { //6
    	  ActiveWizard = 5;
    	  goldLabel.setText(""+ActiveWizard);
    	  MainScene.detachChild(current);
      	 current = new Sprite(899,541, Wizardlist.get(ActiveWizard));
      	 MainScene.attachChild(current);
	  }
      
      if (x > 777 && x < 827) { //7
    	  ActiveWizard = 6;  
    	  goldLabel.setText(""+ActiveWizard);
    	  MainScene.detachChild(current);
      	 current = new Sprite(899,541, Wizardlist.get(ActiveWizard));
      	 MainScene.attachChild(current);
	  }
      
      if (x > 917 && x < 967) { //current box
		  
	  }
	}
		
		
	
		
		
		//If (!(x>2025||y>200)) || (!(x>0||y>300)) || (!(x<500||y<2025))
		
		
		
		return false;
		
	}

	public void Timer() {
		Timer = new TimerHandler(Timerp2, true, new ITimerCallback() {
			
			@Override
			public void onTimePassed(TimerHandler arg0) {
				updatesprites();
				removesprites();

			}
		});
		getEngine().registerUpdateHandler(Timer);

	}

	public void updatesprites() {
		for (int i = 0; i < (Enemieslist.size()); i++) {
			Enemieslist.get(i).Move();
			

		}
		
		for (int i = 0; i < (Bulletslist.size()); i++) {
			
			Bulletslist.get(i).Move();
			
		
		}
		checkforanewenemy() ;
		
		//collide();
		
	
		lookingforanenemytoshoot();
		
	}

	public void removesprites() {
		for (int i = 0; i < (Enemieslist.size()); i++) {
			if (Enemieslist.get(i).location.x >= 1000.0f) {
				MainScene.detachChild(Enemieslist.get(i));
				Enemieslist.remove(i);
				i = 1000;
				
				
			}
			
			
			

		}
		for (int i = 0; i < (Bulletslist.size()); i++) {
			if (Bulletslist.get(i).location.x >= 1000f  || Bulletslist.get(i).location.y >= 500f || Bulletslist.get(i).location.x <= 0f|| Bulletslist.get(i).location.y <= 0f) {
				MainScene.detachChild(Bulletslist.get(i));
				Bulletslist.remove(i);
				i = 1000;
			}
		}
				
				
				
		
	}
	
	public void checkforanewenemy() {
		if (enemycounter >100000) {
			Enemieslist.add(new Enemies(-500, 210, enemy1texture, 0.2f,0));
			Enemieslist.add(new Enemies(-250, 225, enemy2texture, 0.5f,0));
			MainScene.attachChild(Enemieslist.get(Enemieslist.size() - 1));
            MainScene.attachChild(Enemieslist.get(Enemieslist.size() - 2));
			
			enemycounter = 0;
		}
			enemycounter += 1;
			
			
		}
	
	
	
	
	
	
	
	
	public void lookingforanenemytoshoot(){
		for (int i = 0; i < (Towerlist.size()); i++) {
			if (Towerlist.get(i).bulletcounter >1000 && Enemydistance(Towerlist.get(i)) < 500) {
			
			Bulletslist.add(new Bullets(Towerlist.get(i).location.x, Towerlist.get(i).location.y, projectilelist.get(Towerlist.get(i).NR), fidingangle(Towerlist.get(i))));
			
			MainScene.attachChild(Bulletslist.get(Bulletslist.size() - 1));
			Bulletslist.get(Bulletslist.size()-1).setRotation((float) (Bulletslist.get(Bulletslist.size()-1).angle *( 180 / Math.PI)) - 45 );
			Towerlist.get(i).bulletcounter = 0;
			
	}
		Towerlist.get(i).bulletcounter += 1;
		
	}
		
	}
	public float Enemydistance(Tower Tyler){
		

		int c = 10000;
		int lowerc = 10000;
		
		
		for (int i = 0; i < (Enemieslist.size()); i++) {
			 c = ((int)Tyler.location.x - (int)Enemieslist.get(i).location.x)^2 + ((int)Tyler.location.y - (int)Enemieslist.get(i).location.y)^2  ;
			
			 if (c < lowerc) {
				 
				 lowerc = c;
				 
			
			     
			    
			    
			 }
			
			
			
		}
		return lowerc;
		
		
	}
		
		public float fidingangle(Tower frank){
			
			int c = 10000;
			int lowerc = 10000;
			float angleoflowerc = 0;
			
			
				 c = ((int)frank.location.x - (int)Enemieslist.get(0).location.x)^2 + ((int)frank.location.y - (int)Enemieslist.get(0).location.y)^2  ;
				
				 if (c < lowerc) {
					 
					 lowerc = c;
					 
					float a = lowerc;
				    float b = frank.location.x - Enemieslist.get(0).location.x;
				    
				    angleoflowerc = (float) Math.acos(a/b);  
				    
				    
				 }
				
				
				
			
			return angleoflowerc;
		}
		
		
		public void collide(){
			for (int i = 0; i < (Bulletslist.size()); i++) {
				for (int j = 0; j < (Enemieslist.size()); j++) {
				
					if (Enemieslist.get(j).collidesWith(Bulletslist.get(i))){
						Enemieslist.get(j).active = false;
						MainScene.detachChild(Enemieslist.get(j));
						Enemieslist.remove(j);
						Bulletslist.get(i).active = false;
						MainScene.detachChild(Bulletslist.get(i));
						Bulletslist.remove(i);
						i = 10000;
						j = 10000;
					}
			}
			
		}
		
	}
}



