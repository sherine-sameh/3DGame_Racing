package engineTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.*;
import models.*;
import renderEngine.*;

import org.lwjgl.opengl.*;
import org.lwjgl.util.vector.Vector3f;
import textures.ModelTexture;

public class MainGameLoop {
	
	public static void main(String[] args)
	{	DisplayManager.createDisplay();
		Loader loader = new Loader();
		
		
		RawModel TreeRawModel = ObjLoader.loadObjModel("tree.obj", loader);
		TexturedModel TreeModel = new TexturedModel(TreeRawModel,new ModelTexture(loader.loadTexture("tree.png")));
		List<Entity> entities = new ArrayList<Entity>();
		Random random = new Random();
		for(int i=0;i<500;i++){
			entities.add(new Entity(TreeModel, new Vector3f(random.nextFloat()*800 - 400,0,random.nextFloat() * -600),0,0,0,3));
		}
		
		Light light = new Light(new Vector3f(0,0,0),new Vector3f(1,1,1));
		
		Terrain terrain = new Terrain(0,0,loader,new ModelTexture(loader.loadTexture("grass.png")));
		Terrain terrain2 = new Terrain(1,0,loader,new ModelTexture(loader.loadTexture("grass.png")));
		
                
		RawModel model = ObjLoader.loadObjModel("bunny.obj", loader);
		TexturedModel texturedModel = new TexturedModel(model,new ModelTexture(loader.loadTexture("white.png")));
		Player player = new Player(texturedModel,new Vector3f(0,0,-300),0,0,0,3);        
         
		Camera camera = new Camera();	
		MasterRenderer renderer = new MasterRenderer();
		
		while(!Display.isCloseRequested()){
			camera.move();
                        renderer.processEntity(player);
		        player.move();
			renderer.processTerrain(terrain);
			renderer.processTerrain(terrain2);
			for(Entity entity:entities){
                            renderer.processEntity(entity);
			}
			renderer.render(light, camera);
			DisplayManager.updateDisplay();
		}

		renderer.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
        }
}
