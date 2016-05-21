/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import models.TextureModel;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;
import renderEngine.DisplayManager;

/**
 *
 * @author Myriam
 */
public class Player extends Entity {

    private static final float RUN_SPEED=20;
    private static final float TURN_SPEED= 160;      
    private float currentSpeed=0; 
    private float currentTurnSpeed = 0; 
    
    public Player(TextureModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
        super(model, position, rotX, rotY, rotZ, scale);
    }
    
    public void move (){
    checkInputs();
    super.incrementAngle(0, currentTurnSpeed*DisplayManager.getFrameTimeSeconds(),0 );
    float distance =currentTurnSpeed*DisplayManager.getFrameTimeSeconds();
    float dx = (float) (distance * Math.sin(Math.toRadians(super.getRotY())));
    float dz = (float) (distance * Math.cos(Math.toRadians(super.getRotY())));
    super.incrementPosition(dx, 0, dz);
    
    }   
    
    public void checkInputs (){
    if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
    this.currentSpeed=RUN_SPEED;
    }
    else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
    this.currentSpeed= - RUN_SPEED;
    }
    else if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
    this.currentTurnSpeed= - TURN_SPEED;
    }
    else if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
    this.currentTurnSpeed=  TURN_SPEED;
    }
    else currentTurnSpeed=0;
}
}