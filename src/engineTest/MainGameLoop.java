package engineTest;
import entities.Camera;
import entities.Entity;
import models.RawModel;
import models.TextureModel;
import renderEngine.*;
import org.lwjgl.opengl.*;
import org.lwjgl.util.vector.Vector3f;
import shader.*;
import textures.ModelTexture;

public class MainGameLoop {
	
	public static void main(String[] args)
	{
	DisplayManager.createDisplay();
	Loader loader = new Loader();
	StaticShader shader =new StaticShader();
        Renderer renderer = new Renderer(shader);
        float[] vertices = {			
				-0.5f,0.5f,-0.5f,	
				-0.5f,-0.5f,-0.5f,	
				0.5f,-0.5f,-0.5f,	
				0.5f,0.5f,-0.5f,		
				
				-0.5f,0.5f,0.5f,	
				-0.5f,-0.5f,0.5f,	
				0.5f,-0.5f,0.5f,	
				0.5f,0.5f,0.5f,
				
				0.5f,0.5f,-0.5f,	
				0.5f,-0.5f,-0.5f,	
				0.5f,-0.5f,0.5f,	
				0.5f,0.5f,0.5f,
				
				-0.5f,0.5f,-0.5f,	
				-0.5f,-0.5f,-0.5f,	
				-0.5f,-0.5f,0.5f,	
				-0.5f,0.5f,0.5f,
				
				-0.5f,0.5f,0.5f,
				-0.5f,0.5f,-0.5f,
				0.5f,0.5f,-0.5f,
				0.5f,0.5f,0.5f,
				
				-0.5f,-0.5f,0.5f,
				-0.5f,-0.5f,-0.5f,
				0.5f,-0.5f,-0.5f,
				0.5f,-0.5f,0.5f
				
		};
		
		float[] textureCoordinates = {
				
				0,0,
				0,1,
				1,1,
				1,0,			
				0,0,
				0,1,
				1,1,
				1,0,			
				0,0,
				0,1,
				1,1,
				1,0,
				0,0,
				0,1,
				1,1,
				1,0,
				0,0,
				0,1,
				1,1,
				1,0,
				0,0,
				0,1,
				1,1,
				1,0

				
		};
		
		int[] indices = {
				0,1,3,	
				3,1,2,	
				4,5,7,
				7,5,6,
				8,9,11,
				11,9,10,
				12,13,15,
				15,13,14,	
				16,17,19,
				19,17,18,
				20,21,23,
				23,21,22

		};
	RawModel model = loader.loadToVAO(vertices,textureCoordinates,indices);
        ModelTexture texture = new ModelTexture(loader.loadTexture("street.png"));
        TextureModel texturedModel = new TextureModel(model,texture);
        Entity entity = new Entity(texturedModel,new Vector3f(0,0,-5),0,0,0,1);
        Camera camera = new Camera();
        
        while(!Display.isCloseRequested())
	{
                entity.incrementAngle(1,1,0);
		camera.move();
                renderer.prepare();
                shader.start();
                shader.loadViewMatrix(camera);
		renderer.render(entity,shader);
                shader.stop();
		DisplayManager.updateDisplay();

        }
        shader.cleanUp();
	loader.cleanUp();
	
	DisplayManager.closeDisplay();
	}
}
