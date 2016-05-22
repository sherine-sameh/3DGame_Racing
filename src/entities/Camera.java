package entities;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
    private Vector3f position = new Vector3f(0,1,0);
    private float pitch;
    private float yaw;
    private float roll;
    
    public void move()
    {
    if(Keyboard.isKeyDown(Keyboard.KEY_W)|| Keyboard.isKeyDown(Keyboard.KEY_UP))
        position.z-=0.1f;
    if(Keyboard.isKeyDown(Keyboard.KEY_X) || Keyboard.isKeyDown(Keyboard.KEY_DOWN))
	if(position.z <= 0)
            position.z+=0.1f;
    if(Keyboard.isKeyDown(Keyboard.KEY_A)|| Keyboard.isKeyDown(Keyboard.KEY_LEFT))
	position.x-=0.1f;
    if(Keyboard.isKeyDown(Keyboard.KEY_D) || Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
	position.x+=0.1f;
    if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
	position.y+=0.1f;
     if(Keyboard.isKeyDown(Keyboard.KEY_Z))
        if(position.y > 1)		
            position.y-=0.1f;
    }
    public Vector3f getPosition() {
        return position;
    }

    public float getPitch() {
        return pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public float getRoll() {
        return roll;
    }
    
    
}
