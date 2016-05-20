package entities;

import models.TextureModel;
import org.lwjgl.util.vector.*;

public class Entity {
    private TextureModel model;
    private Vector3f position;
    private float rotX,rotY,rotZ;
    private float scale;
    
    public Entity(TextureModel model , Vector3f position, float rotX,float rotY, float rotZ, float scale)
    {
        this.model = model;
        this.position = position;
        this.rotX = rotX;
        this.rotY = rotY;
        this.rotZ = rotZ;
        this.scale = scale;
                
    }         
    public void incrementPosition(float dx, float dy, float dz)
    {
        position.x +=dx;
        position.y +=dy;
        position.z +=dz;
    }
    public void incrementAngle(float dx,float dy,float dz)
    {
        rotX += dx;
        rotY += dy;
        rotZ += dz;
                
    }

    public TextureModel getModel() {
        return model;
    }

    public Vector3f getPosition() {
        return position;
    }

    public float getRotX() {
        return rotX;
    }

    public float getRotY() {
        return rotY;
    }

    public float getRotZ() {
        return rotZ;
    }

    public float getScale() {
        return scale;
    }

}
