package DoublePendulumPck;

import java.awt.image.BufferedImage;

public class Trail {
    private boolean isTrailActive = false;
    private boolean isTrailVaryThroughSpeed = false;
    private boolean isTrailVanishing = false;
    private int TrailColor  = (255 << 16)|(255 << 8)|255;
    //private BufferedImage TrailImage = new BufferedImage();
    private int[][] TrailPointList;


    public void setTrailActive(boolean active){

    }

    public boolean getTrailActive(){
        return isTrailActive;
    }

    public void setTrailVaryThroughSpeed(boolean vary){

    }

    public boolean getTrailVaryThroughSpeed(){
        return isTrailVaryThroughSpeed;
    }

    public void setTrailVanishing(boolean vanishing){

    }

    public boolean getTrailVanishing(){
        return isTrailVanishing;
    }

    public void setTrailColor(int color){

    }

    public int getTrailColor(){
        return TrailColor;
    }

    public void addTrailPointList(int[] point){

    }

    public int[][] getTrailPointList(){
        return TrailPointList;
    }
}
