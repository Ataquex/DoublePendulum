package MVCPck;

public class Controller {
    private Model Cmodel;
    private View Cview;


    public Controller(Model cmodel, View cview){
        this.Cmodel = cmodel;
        this.Cview = cview;

        cview.InitGUI();
    }

    public void InitSimulation(){

    }

    public void addDoublePendulum(){

    }

    public void removeDoublePendulum(int pendulumIndex){

    }

    public void UpdateView(Model cmodel){

    }
}
