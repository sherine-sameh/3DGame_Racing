package entities;

import models.TexturedModel;
import org.lwjgl.util.vector.*;

public class Entity {
    private TexturedModel model;
    private Vector3f position;
    private float rotX,rotY,rotZ;
    private float scale;
    
    public Entity(TexturedModel model , Vector3f position, float rotX,float rotY, float rotZ, float scale)
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

    public TexturedModel getModel() {
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

    public void setModel(TexturedModel model) {
        this.model = model;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public void setRotX(float rotX) {
        this.rotX = rotX;
    }

    public void setRotY(float rotY) {
        this.rotY = rotY;
    }

    public void setRotZ(float rotZ) {
        this.rotZ = rotZ;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
    

}
