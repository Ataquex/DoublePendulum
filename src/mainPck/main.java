package mainPck;

import MVCPck.Model;
import MVCPck.View;
import MVCPck.Controller;

import javax.swing.*;

public class main {
    public static void main(String args[]){

        Model mainmodel = new Model();
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                View mainview = new View();
                mainview.InitGUI();
            }
        });

        View mainview = new View();
        Controller maincontroller = new Controller(mainmodel, mainview);
        maincontroller.InitSimulation();
    }
}
