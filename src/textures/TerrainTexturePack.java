package textures;

public class TerrainTexturePack {
    private TerrainTexture bgTexture,rTexture,gTexture,bTexture ;

    public TerrainTexturePack(TerrainTexture bgTexture, TerrainTexture rTexture, TerrainTexture gTexture, TerrainTexture bTexture) {
        this.bgTexture = bgTexture;
        this.rTexture = rTexture;
        this.gTexture = gTexture;
        this.bTexture = bTexture;
    }

    public TerrainTexture getBgTexture() {
        return bgTexture;
    }

    public TerrainTexture getrTexture() {
        return rTexture;
    }

    public TerrainTexture getgTexture() {
        return gTexture;
    }

    public TerrainTexture getbTexture() {
        return bTexture;
    }

}
