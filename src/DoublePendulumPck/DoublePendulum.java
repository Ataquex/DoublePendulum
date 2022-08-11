package DoublePendulumPck;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.Math;

public class DoublePendulum {
    private double RodLength_1 = 200;
    private double RodLength_2 = 200;
    private double PendulumMass_1 = 10;
    private double PendulumMass_2 = 10;
    private double PendulumTheta_1 = 0;
    private double PendulumTheta_2 = 0;
    private double PendulumThetaStandart_1 = 0;
    private double PendulumThetaStandart_2 = 0;

    private Trail MassTrail_1 = new Trail();
    private Trail MassTrail_2 = new Trail();

    private double PendulumAcceleration_1 = 0;
    private double PendulumAcceleration_2 = 0;
    private double PendulumVelocity_1 = 0;
    private double PendulumVelocity_2 = 0;

    private final BufferedImage PendulumImage = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
    private final JLabel ImageLabel = new JLabel();
    private final int[] AnchorTranslation = new int[]{(int)(PendulumImage.getWidth()*0.5), (int)(PendulumImage.getHeight()*0.5)};

    private static int PendulumCount = 0;
    private final int PendulumIndex;

    public DoublePendulum(){
        PendulumIndex = PendulumCount;
        PendulumCount++;
    }


    public void setRodLength_1(double length){

    }

    public void setRodLength_2(double length){

    }

    public void setPendulumMass_1(double mass){

    }

    public void setPendulumMass_2(double mass){

    }

    public void setPendulumTheta_1(double theta){
        PendulumTheta_1 = theta;

    }

    public void setPendulumTheta_2(double theta){
        PendulumTheta_2 = theta;
    }




    public void calculatePendulumDynamics(double gravity, double resistance){
/*
        System.out.println("PendulumIndex = "+PendulumIndex);
        System.out.println("Acceleration 1: "+PendulumAcceleration_1);
        System.out.println("Velocity 1:     "+PendulumVelocity_1);
        System.out.println("Theta 1:        "+PendulumTheta_1);
        System.out.println("Acceleration 2: "+PendulumAcceleration_2);
        System.out.println("Velocity 2:     "+PendulumVelocity_2);
        System.out.println("Theta 2:        "+PendulumTheta_2);
        System.out.println(" ");
 */
        calculateAcceleration(gravity, PendulumVelocity_1, PendulumVelocity_2, PendulumTheta_1, PendulumTheta_2, PendulumMass_1, PendulumMass_2, RodLength_1, RodLength_2);

        PendulumVelocity_1 = PendulumVelocity_1 + PendulumAcceleration_1;
        PendulumVelocity_2 = PendulumVelocity_2 + PendulumAcceleration_2;

        PendulumTheta_1 = PendulumTheta_1 + PendulumVelocity_1;
        PendulumTheta_2 = PendulumTheta_2 + PendulumVelocity_2;
    }

    private void calculateAcceleration(double g, double v1, double v2, double th1, double th2, double m1, double m2, double l1, double l2){
        PendulumAcceleration_1 = (-g * (2 * m1 + m2) * Math.sin(th1) - m2 * g * Math.sin(th1 - 2 * th2) - 2 * Math.sin(th1 - th2) * m2 * (v2 * v2 * l2 + v1 * v1 * l1 * Math.cos(th1 - th2))) / (l1 * (2 * m1 + m2 - m2 * Math.cos(2 * th1 -  2 * th2)));
        PendulumAcceleration_2 = (2 * Math.sin(th1 - th2) * (v1 * v1 * l1 * (m1 + m2) + g * (m1 + m2) * Math.cos(th1) + v2 * v2 * l2 * m2 * Math.cos(th1 - th2))) / (l2 * (2 * m1 + m2 - m2 * Math.cos(2 * th1 - 2 * th2)));
    }

    public void drawPendulum(){
        Graphics2D graphics = PendulumImage.createGraphics();
        graphics.setStroke(new BasicStroke(3));

        graphics.setComposite(AlphaComposite.Clear);
        graphics.fillRect(0, 0, PendulumImage.getWidth(), PendulumImage.getHeight());
        graphics.setComposite(AlphaComposite.SrcOver);

        int x1 = (int)(RodLength_1 * Math.sin(PendulumTheta_1));
        int y1 = (int)(RodLength_1 * Math.cos(PendulumTheta_1));

        int x2 = x1 + ((int)(RodLength_2 * Math.sin(PendulumTheta_2)));
        int y2 = y1 + ((int)(RodLength_2 * Math.cos(PendulumTheta_2)));

        MassTrail_1.addTrailPointList(new int[]{x1, y1});
        MassTrail_2.addTrailPointList(new int[]{x2, y2});
        MassTrail_1.DrawTrail(AnchorTranslation[0], AnchorTranslation[1]);
        MassTrail_2.DrawTrail(AnchorTranslation[0], AnchorTranslation[1]);
        graphics.drawImage(getTrailImage1(), 0, 0, null);
        graphics.drawImage(getTrailImage2(), 0, 0, null);

        graphics.translate(AnchorTranslation[0], AnchorTranslation[1]);

        graphics.drawLine(0, 0, x1, y1);
        graphics.fillOval(x1-5, y1-5, 10, 10);
        graphics.drawLine(x1, y1, x2, y2);
        graphics.fillOval(x2-5, y2-5, 10, 10);
        graphics.dispose();
    }




    public JLabel getPendulumImage(){
        ImageLabel.setIcon(new ImageIcon(PendulumImage));
        return ImageLabel;
    }

    public BufferedImage getTrailImage1(){
        return MassTrail_1.getTrailImage();
    }

    public BufferedImage getTrailImage2(){
        return MassTrail_2.getTrailImage();
    }




    public static void removeDoublePendulum(){
        PendulumCount--;
    }

    public void ResetPendulum(){
        PendulumTheta_1 = PendulumThetaStandart_1;
        PendulumTheta_2 = PendulumThetaStandart_2;
        PendulumVelocity_1 = 0;
        PendulumVelocity_2 = 0;
        PendulumAcceleration_1 = 0;
        PendulumAcceleration_2 = 0;
        MassTrail_1.ResetTrail();
        MassTrail_2.ResetTrail();
    }

    public static int getDoublePendulumCount(){
        return PendulumCount;
    }

    public int getDoublePendulumIndex(){
        return PendulumIndex;
    }
}
