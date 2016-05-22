package entities;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
    private Vector3f position = new Vector3f(0,5,0);
    private float pitch = 20;
    private float yaw = 0 ;
    private float roll;
    
    private float distanceFromPlayer = 20;
    private float angleAroundPlayer = 0;
    
    private Player player;
    public Camera (){}
    public Camera (Player player)
    {
        this.player = player;
    }
    public void move()
    {
//        calculateZoom();
//        calculatePitch();
//        calculateAngleAroundPlayer();
//        float Hdistance = calculateHdistance();
//        float Vdistance = calculateVdistance();
//        calculateCameraPosition(Hdistance,Vdistance);       
//        this.yaw = player.getRotY()+ angleAroundPlayer;
        
        if(Keyboard.isKeyDown(Keyboard.KEY_W)|| Keyboard.isKeyDown(Keyboard.KEY_UP))
            position.z-=0.2f;
        if(Keyboard.isKeyDown(Keyboard.KEY_X) || Keyboard.isKeyDown(Keyboard.KEY_DOWN))
            if(position.z <= 0)
                position.z+=0.2f;
        if(Keyboard.isKeyDown(Keyboard.KEY_A)|| Keyboard.isKeyDown(Keyboard.KEY_LEFT))
            position.x-=0.2f;
        if(Keyboard.isKeyDown(Keyboard.KEY_D) || Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
            position.x+=0.2f;
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
            position.y+=0.2f;
         if(Keyboard.isKeyDown(Keyboard.KEY_Z))
            if(position.y > 1)		
                position.y-=0.2f;
         if(Keyboard.isKeyDown(Keyboard.KEY_S))
             this.yaw -=0.2f;
               
         
   
        }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }
    
    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
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
    private void calculateCameraPosition(float Hdistance,float Vdistance)
    {
        float theta = player.getRotY() + angleAroundPlayer;
        float offsetX = (float)(Hdistance + Math.sin(Math.toRadians(theta)));
        float offsetZ = (float)(Hdistance + Math.cos(Math.toRadians(theta)));
        position.x = player.getPosition().x - offsetX;
        position.z = player.getPosition().z - offsetZ;
        position.y = player.getPosition().y + Vdistance;
        
    }
    private float calculateHdistance()
    {
        return (float)(distanceFromPlayer * Math.cos(Math.toRadians(pitch)));
    }
    
    private float calculateVdistance()
    {
        return (float)(distanceFromPlayer * Math.sin(Math.toRadians(pitch)));
    }

    private void calculateZoom()
    {
        float zoomLevel = Mouse.getDWheel() *0.1f;
        distanceFromPlayer -= zoomLevel;
    }
    private void calculatePitch()
    {
        if(Mouse.isButtonDown(1))
        {
            float pitchChange = Mouse.getDY() * 0.1f;
             if(position.y > 1)
                pitch -= pitchChange;
        }
    }
    private void calculateAngleAroundPlayer()
    {
        if(Mouse.isButtonDown(0))
        {
            float angleChange = Mouse.getDX() * 0.1f;
            angleAroundPlayer -= angleChange;
        }
    }
}
