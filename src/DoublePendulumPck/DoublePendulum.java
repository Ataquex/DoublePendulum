package DoublePendulumPck;

public class DoublePendulum {
    private int RodLength_1 = 100;
    private int RodLength_2 = 100;
    private int PendulumMass_1 = 10;
    private int PendulumMass_2 = 10;
    private int PendulumTheta_1 = 0;
    private int PendulumTheta_2 = 0;
    private Trail MassTrail_1;
    private Trail MassTrail_2;
    private double PendulumAcceleration_1 = 0;
    private double PendulumAcceleration_2 = 0;
    private double PendulumVelocity_1 = 0;
    private double PendulumVelocity_2 = 0;
    private double PendulumPos_1 = 0;
    private double PendulumPos_2 = 0;
    private static int PendulumCount = 0;
    private int PendulumIndex;

    public DoublePendulum(){
        PendulumIndex = PendulumCount;
        PendulumCount++;
    }


    public void setRodLength_1(int length){

    }

    public void setRodLength_2(int length){

    }

    public void setPendulumMass_1(int mass){

    }

    public void setPendulumMass_2(int mass){

    }

    public void setPendulumTheta_1(int theta){

    }

    public void setPendulumTheta_2(int theta){

    }

    public void calculatePendulumDynamics(double gravity, double resistance){

    }
/*
    public int[] getPendulumXY_1(){

    }

    public int[] getPendulumXY_2(){

    }
*/
    public static void removeDoublePendulum(){
        PendulumCount--;
    }

    public static int getDoublePendulumCount(){
        return PendulumCount;
    }

    public int getPendulumIndex(){
        return PendulumIndex;
    }
}
