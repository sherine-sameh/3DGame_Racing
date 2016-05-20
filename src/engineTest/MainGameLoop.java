package engineTest;
import renderEngine.*;
import org.lwjgl.opengl.*;
import shader.*;

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
	RawModel model = loader.loadToVAO(vertices,indices);
	while(!Display.isCloseRequested())
	{
		renderer.prepare();
                shader.start();
		renderer.render(model);
                shader.stop();
		DisplayManager.updateDisplay();

        }
        shader.cleanUp();
	loader.cleanUp();
	
	DisplayManager.closeDisplay();
	}
}
