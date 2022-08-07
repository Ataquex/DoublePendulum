package MVCPck;

import DoublePendulumPck.DoublePendulum;

import java.util.ArrayList;

public class Controller {
    private Model Cmodel;
    private View Cview;


    public Controller(Model cmodel, View cview){
        this.Cmodel = cmodel;
        this.Cview = cview;
        addDoublePendulum();
        Cview.setDeleteActionEnabled(false);
    }

    public void InitSimulation(){
        Cview.setUpTimer(100);
    }

    public void addDoublePendulum(){
        DoublePendulum tempPendulum = new DoublePendulum();

        Cmodel.addDoublePendulumList(tempPendulum);
        Cview.addDoublePendulum(tempPendulum.getPendulumIndex());
        Cview.setDeleteActionEnabled(true);
    }

    public void removeDoublePendulum(int pendulumIndex){
        if(DoublePendulum.getDoublePendulumCount()>1) {
            DoublePendulum.removeDoublePendulum();
            Cmodel.removeDoublePendulumList(pendulumIndex);
            Cview.removeDoublePendulum(pendulumIndex, DoublePendulum.getDoublePendulumCount());
            if(DoublePendulum.getDoublePendulumCount()<2){
                Cview.setDeleteActionEnabled(false);
            }
        }else{
            Cview.setDeleteActionEnabled(false);
        }
    }

    public void TickSimulation(){
        ArrayList<DoublePendulum> tempList = Cmodel.getDoublePendulumList();
        double g = Cmodel.getPendulumGravity();
        double r = Cmodel.getPendulumResistance();
        for(int i = 0; i < tempList.size(); i++){
            tempList.get(i).calculatePendulumDynamics(g,r);
        }
    }
}
