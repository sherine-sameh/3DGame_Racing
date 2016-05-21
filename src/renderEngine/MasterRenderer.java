package renderEngine;

import entities.Camera;
import entities.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.TextureModel;
import shader.StaticShader;

public class MasterRenderer {
    private StaticShader shader=new StaticShader();
    private EntityRenderer renderer = new EntityRenderer(shader);
    
    private Map<TextureModel,List<Entity>> entities = new HashMap<TextureModel,List<Entity>>();
//    public void render(Light sun , Camera camera)
    public void render(Camera camera){
    renderer.prepare();
    shader.start();
//    shafer.loadLight(sun);
    shader.loadViewMatrix(camera);
    renderer.render(entities);
    shader.stop();
    entities.clear();
    }
    public void processEntity(Entity entity)
    {
        TextureModel entityModel = entity.getModel();
        List<Entity> batch = entities.get(entityModel);
        if (batch!=null)
        {
            batch.add(entity);
        }
        else{
            List<Entity> newBatch = new ArrayList<Entity>();
            newBatch.add(entity);
            entities.put(entityModel, newBatch);
        }
    }
    public void cleanUp()
    {
        shader.cleanUp();
    }
}
