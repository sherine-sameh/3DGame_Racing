package engineTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.*;
import models.*;
import renderEngine.*;
import textures.*;

import org.lwjgl.opengl.*;
import org.lwjgl.util.vector.Vector3f;


public class MainGameLoop {
	
	public static void main(String[] args)
	{	DisplayManager.createDisplay();
		Loader loader = new Loader();
		
                TerrainTexture bgTexture = new TerrainTexture (loader.loadTexture("grass.png"));
                TerrainTexture rTexture = new TerrainTexture (loader.loadTexture("mud.png"));
                TerrainTexture gTexture = new TerrainTexture (loader.loadTexture("grass.png"));
                TerrainTexture bTexture = new TerrainTexture (loader.loadTexture("path.png"));
                
                TerrainTexturePack texturePack = new TerrainTexturePack(bgTexture,rTexture,gTexture,bTexture);
                TerrainTexture blendMap = new TerrainTexture (loader.loadTexture("blendMap_.png"));	
	
		RawModel TreeRawModel = ObjLoader.loadObjModel("tree_.obj", loader);
		TexturedModel TreeModel = new TexturedModel(TreeRawModel,new ModelTexture(loader.loadTexture("tree_.png")));
		List<Entity> entities = new ArrayList<Entity>();
		Random random = new Random();
		for(int i=0;i<500;i++){
			entities.add(new Entity(TreeModel, new Vector3f(random.nextFloat()*800 - 400,0,random.nextFloat() * -600),-180,0,0,3));
		}
		
		Light light = new Light(new Vector3f(20000,20000,2000),new Vector3f(1,1,1));
		
		Terrain terrain = new Terrain(1,0,loader,texturePack,blendMap);
		Terrain terrain2 = new Terrain(1,0,loader,texturePack,blendMap);
		
                
		RawModel model = ObjLoader.loadObjModel("Porsche.obj", loader);
		TexturedModel texturedModel = new TexturedModel(model,new ModelTexture(loader.loadTexture("Porsche_.png")));
		
                Player player = new Player(texturedModel,new Vector3f(0,0.8f,-20),-180,0,0,1);        
         	
		Camera camera = new Camera(player);
		MasterRenderer renderer = new MasterRenderer();
		
		while(!Display.isCloseRequested()){
			renderer.processEntity(player);
		        renderer.processTerrain(terrain);
			renderer.processTerrain(terrain2);
			for(Entity entity:entities){
                            renderer.processEntity(entity);
			}
			renderer.render(light, camera);
			camera.move();
                        player.move();
			
                        DisplayManager.updateDisplay();
		}

		renderer.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
        }
}