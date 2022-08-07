package MVCPck;

import DoublePendulumPck.DoublePendulum;

public class Controller {
    private Model Cmodel;
    private View Cview;


    public Controller(Model cmodel, View cview){
        this.Cmodel = cmodel;
        this.Cview = cview;
    }

    public void InitSimulation(){

    }

    public void addDoublePendulum(){
        DoublePendulum tempPendulum = new DoublePendulum();

        Cmodel.addDoublePendulumList(tempPendulum);
        Cview.addDoublePendulum(tempPendulum.getPendulumIndex());
    }

    public void removeDoublePendulum(int pendulumIndex){
        DoublePendulum.removeDoublePendulum();
        Cmodel.removeDoublePendulumList(pendulumIndex);
        Cview.removeDoublePendulum(pendulumIndex, DoublePendulum.getDoublePendulumCount());
    }

    public void UpdateView(Model cmodel){

    }
}
