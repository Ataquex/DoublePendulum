package DoublePendulumPck;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Trail {
    private boolean isTrailActive = false;
    private boolean isTrailVaryThroughSpeed = false;
    private boolean isTrailVanishing = false;
    private Color TrailColor  = Color.WHITE;
    private BufferedImage TrailImage = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
    private ArrayList<Integer> TrailPointsX = new ArrayList<>();
    private ArrayList<Integer> TrailPointsY = new ArrayList<>();


    public void setTrailActive(boolean active){
        isTrailActive = active;
    }

    public void setTrailVaryThroughSpeed(boolean vary){
        isTrailVaryThroughSpeed = vary;
    }

    public void setTrailVanishing(boolean vanishing){
        isTrailVanishing = vanishing;
    }

    public void setTrailColor(Color color){
        TrailColor = color;
    }




    public void addTrailPointList(int[] point){
        TrailPointsX.add(point[0]);
        TrailPointsY.add(point[1]);

        if(isTrailVanishing && TrailPointsX.size()>25){
            TrailPointsX.remove(0);
            TrailPointsY.remove(0);
        }
    }

    public void DrawTrail(int anchorX, int anchorY){
        Graphics2D graphics = TrailImage.createGraphics();
        graphics.setStroke(new BasicStroke(2));
        graphics.setColor(TrailColor);

        graphics.setComposite(AlphaComposite.Clear);
        graphics.fillRect(0, 0, TrailImage.getWidth(), TrailImage.getHeight());
        graphics.setComposite(AlphaComposite.SrcOver);

        if(isTrailActive){
            graphics.translate(anchorX, anchorY);

            for(int i = 0; i < TrailPointsX.size()-1; i++) {
                graphics.drawLine(TrailPointsX.get(i), TrailPointsY.get(i), TrailPointsX.get(i + 1), TrailPointsY.get(i + 1));
            }
        }
    }

    public BufferedImage getTrailImage(){
        return TrailImage;
    }

    public void ResetTrail(){
        TrailPointsX.clear();
        TrailPointsY.clear();
    }
}
