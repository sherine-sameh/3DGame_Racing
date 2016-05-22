package entities;

import models.TexturedModel;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;
import renderEngine.DisplayManager;

public class Player extends Entity {

    private static final float RUN_SPEED = 20;
    private static final float TURN_SPEED= 160;      
    private float currentSpeed = 0; 
    private float currentTurnSpeed = 0; 
    int i =0 ;

    public Player(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
        super(model, position, rotX, rotY, rotZ, scale);
        
    }
    
    public void move()
    {
    if(Keyboard.isKeyDown(Keyboard.KEY_UP))
    {
        if(this.getRotY()!= 0.0f)
            super.setRotY(0.0f);
        super.incrementPosition(0, 0, -0.2f);
    }
    if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
    {
        if(this.getRotY()!= 180.0f)
            super.setRotY(180.0f);
        super.incrementPosition(0, 0, 0.2f);
    }
    if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
    {
        if(this.getRotY()!= 90.0f)
             super.setRotY(90.0f);
        super.incrementPosition(-0.2f, 0, 0);
    }
    if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
    {
        if(this.getRotY()!= -90.0f)
             super.setRotY(-90.0f);
        super.incrementPosition(0.2f, 0, 0);
    }
    if(Keyboard.isKeyDown(Keyboard.KEY_R)){
        super.incrementAngle(0, 0.3f, 0);      
    }
    }
   
//    public void move (){
//    checkInputs();
//    super.incrementAngle(0,currentTurnSpeed * DisplayManager.getFrameTimeSeconds(),0 );
//    float distance = currentSpeed*DisplayManager.getFrameTimeSeconds();
//    float dx = (float) (distance * Math.sin(Math.toRadians(super.getRotY())));
//    float dz = (float) (distance * Math.cos(Math.toRadians(super.getRotY())));
//    super.incrementPosition(dx, 0, dz);
//    }
 
    //currentTurnSpeed * DisplayManager.getFrameTimeSeconds()
//    public void checkInputs (){
//    if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
//    this.currentSpeed=RUN_SPEED;
//    }
//    else if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
//    this.currentSpeed= -RUN_SPEED;
//    }
//    else currentSpeed=0;
//     if (Keyboard.isKeyDown(Keyboard.KEY_UP )){
//    this.currentTurnSpeed= -TURN_SPEED;
//    }
//    else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
//    this.currentTurnSpeed=  TURN_SPEED;
//    }
//    else currentTurnSpeed=0;
//}
    
}