package mainPck;

import MVCPck.Model;
import MVCPck.View;
import MVCPck.Controller;

public class main {
    public static void main(String args[]){

        Model mainmodel = new Model();
        View mainview = new View();
        Controller maincontroller = new Controller(mainmodel, mainview);
        maincontroller.InitSimulation();
    }
}
