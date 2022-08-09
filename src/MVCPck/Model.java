package MVCPck;

import DoublePendulumPck.DoublePendulum;

import java.util.ArrayList;

public class Model {
    private ArrayList<DoublePendulum> DoublePendulumList = new ArrayList<DoublePendulum>();
    private double PendulumResistance = 0;
    private double PendulumGravity = 1;


    public ArrayList<DoublePendulum> getDoublePendulumList(){
        return DoublePendulumList;
    }

    public void addDoublePendulumList(DoublePendulum doublePendulum){
        DoublePendulumList.add(doublePendulum);
    }

    public void removeDoublePendulumList(int doublePendulumIndex){

    }

    public void setPendulumResistance(int resistance){

    }

    public double getPendulumResistance(){
        return PendulumResistance;
    }

    public void setPendulumGravity(double gravity){

    }

    public double getPendulumGravity(){
        return PendulumGravity;
    }
}
