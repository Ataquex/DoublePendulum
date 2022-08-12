package MVCPck;

import DoublePendulumPck.DoublePendulum;

import java.util.ArrayList;

public class Model {
    private final ArrayList<DoublePendulum> DoublePendulumList = new ArrayList<>();
    private double PendulumResistance = 0;
    private double PendulumGravity = 1;


    public ArrayList<DoublePendulum> getDoublePendulumList(){
        return DoublePendulumList;
    }

    public void addDoublePendulumList(DoublePendulum doublePendulum){
        DoublePendulumList.add(doublePendulum);
    }

    public void removeDoublePendulumList(int doublePendulumIndex){
        DoublePendulumList.remove(doublePendulumIndex);
    }

    public void setPendulumResistance(double resistance){
        PendulumResistance = resistance;
    }

    public double getPendulumResistance(){
        return PendulumResistance;
    }

    public void setPendulumGravity(double gravity){
        PendulumGravity = (gravity/9.81);
    }

    public double getPendulumGravity(){
        return PendulumGravity;
    }
}
