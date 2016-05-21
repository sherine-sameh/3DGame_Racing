
package entities;
import org.lwjgl.util.vector.Vector3f;
/**
 *
 * @author Myriam
 */
public class Light {
    private Vector3f position ;
    private Vector3f colour ; 
    
    
    public Light (Vector3f position ,Vector3f colour ){
    this.colour=colour ; 
    this.position=position ; 
    
    
    }

    /**
     * @return the position
     */
    public Vector3f getPosition() {
        return position;
    }

    /**
     * @return the colour
     */
    public Vector3f getColour() {
        return colour;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Vector3f position) {
        this.position = position;
    }

    /**
     * @param colour the colour to set
     */
    public void setColour(Vector3f colour) {
        this.colour = colour;
    }
    
    
}
