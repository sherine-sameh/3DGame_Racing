package engineTest;
import entities.Camera;
import entities.Entity;
import entities.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import models.RawModel;
import models.TextureModel;
import renderEngine.*;
import org.lwjgl.opengl.*;
import org.lwjgl.util.vector.Vector3f;
import shader.*;
import textures.ModelTexture;

public class MainGameLoop {
	
	public static void main(String[] args)
	{DisplayManager.createDisplay();
	Loader loader = new Loader();
	
	RawModel model = ObjLoader.loadObjModel("dragon.obj", loader);
        ModelTexture texture = new ModelTexture(loader.loadTexture("car.png"));
        TextureModel texturedModel = new TextureModel(model,texture);
         Player player = new Player(texturedModel,new Vector3f(0,0,-5),0,0,0,1);        
        Camera camera = new Camera();
        
        List<Entity> allEntities = new ArrayList<Entity>();
        
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            float x = random.nextFloat()*100 ;
            float y = random.nextFloat()*100 ;
            float z = random.nextFloat()*-300;
            allEntities.add(new Entity(texturedModel, new Vector3f(x,y,z),random.nextFloat()*180f,random.nextFloat()*180f,0f,1f));
            
        }
        MasterRenderer renderer = new MasterRenderer();
        while(!Display.isCloseRequested())
	{
                camera.move();
                for (Entity entity:allEntities)
                {
                    renderer.processEntity(entity);
                    entity.incrementAngle(1,1,0);
		
                }
                renderer.render(camera);
		DisplayManager.updateDisplay();

        }
        renderer.cleanUp();
        loader.cleanUp();
	DisplayManager.closeDisplay();
	}
}

	
        
        
