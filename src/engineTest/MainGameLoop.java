package engineTest;
import models.RawModel;
import models.TextureModel;
import renderEngine.*;
import org.lwjgl.opengl.*;
import shader.*;
import textures.ModelTexture;

public class MainGameLoop {
	
	public static void main(String[] args)
	{
	DisplayManager.createDisplay();
	Loader loader = new Loader();
	Renderer renderer = new Renderer();
        StaticShader shader =new StaticShader();
	float[] vertices =
		{
			-0.5f,0.5f,0f, //V0
			-0.5f,-0.5f,0f, //V1
			0.5f,-0.5f,0f, //V2
			0.5f,0.5f,0f,  //V3
		};
	int [] indices = 
		{
		0,1,3,
                3,1,2
		};
        float[] textureCoordinates = {
            0,0,
            0,1,
            1,1,
            1,0
        };
	RawModel model = loader.loadToVAO(vertices,textureCoordinates,indices);
        ModelTexture texture = new ModelTexture(loader.loadTexture("street.png"));
        TextureModel texturedModel = new TextureModel(model,texture);
        
        while(!Display.isCloseRequested())
	{
		renderer.prepare();
                shader.start();
		renderer.render(texturedModel);
                shader.stop();
		DisplayManager.updateDisplay();

        }
        shader.cleanUp();
	loader.cleanUp();
	
	DisplayManager.closeDisplay();
	}
}
