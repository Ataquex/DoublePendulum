package MVCPck;

import DoublePendulumPck.DoublePendulum;

import java.awt.*;
import java.util.ArrayList;

public class Controller {
    private Model Cmodel;
    private View Cview;
    private int ValueExceptionCount;


    public Controller(Model cmodel, View cview){
        this.Cmodel = cmodel;
        this.Cview = cview;
        addDoublePendulum();
        DrawTick(false);
        Cview.setDeleteActionEnabled(false);
    }

    public int getValueExceptionCount(){
        return ValueExceptionCount;
    }

    public void setValueExceptionCount(int exceptions){
        ValueExceptionCount = exceptions;
    }

    public void InitSimulation(){
        Cview.setUpTimer(30);
    }

    public void addDoublePendulum(){
        DoublePendulum tempPendulum = new DoublePendulum();

        Cmodel.addDoublePendulumList(tempPendulum);
        Cview.addDoublePendulum(tempPendulum.getDoublePendulumIndex());
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
        DrawTick(true);
    }

    public void DrawTick(boolean drawMass){
        ArrayList<DoublePendulum> tempList = Cmodel.getDoublePendulumList();
        for(int i = 0; i < tempList.size(); i++) {
            tempList.get(i).drawPendulum(drawMass);
            Cview.setPendulumImages(tempList.get(i).getPendulumImage());
        }
    }

    public void ResetSimulation(){
        ArrayList<DoublePendulum> tempList = Cmodel.getDoublePendulumList();
        for(int i = 0; i < tempList.size(); i++){
            tempList.get(i).ResetPendulum();
        }
    }

    public void UpdatePendulumProperties(boolean running){
        String[] tempSimulationProperties = Cview.getSimulationProperties();
        ArrayList<DoublePendulum> tempList = Cmodel.getDoublePendulumList();

        for(int i = 0; i < tempList.size(); i++) {
            Cview.getPendulumProperties(i);
            Cview.getTrailProperties1(i);
            Cview.getTrailProperties2(i);
            Cview.getTrailColor1(i);
            Cview.getTrailColor2(i);
        }


        if(ValueExceptionCount == 0){
            Cmodel.setPendulumGravity(Double.parseDouble(tempSimulationProperties[0]));
            Cmodel.setPendulumResistance(Double.parseDouble(tempSimulationProperties[1]));

            for(int i = 0; i < tempList.size(); i++) {
                String[] tempPendulumProperties = Cview.getPendulumProperties(i);
                boolean[] tempTrailProperties1 = Cview.getTrailProperties1(i);
                boolean[] tempTrailProperties2 = Cview.getTrailProperties2(i);
                String tempColor1 = Cview.getTrailColor1(i);
                String tempColor2 = Cview.getTrailColor2(i);


                tempList.get(i).setRodLength_1(Double.parseDouble(tempPendulumProperties[0]));
                tempList.get(i).setRodLength_2(Double.parseDouble(tempPendulumProperties[1]));
                tempList.get(i).setPendulumMass_1(Double.parseDouble(tempPendulumProperties[2]));
                tempList.get(i).setPendulumMass_2(Double.parseDouble(tempPendulumProperties[3]));
                if(running == false) {
                    tempList.get(i).setPendulumThetaStandard_1(Double.parseDouble(tempPendulumProperties[4]));
                    tempList.get(i).setPendulumThetaStandard_2(Double.parseDouble(tempPendulumProperties[5]));
                    tempList.get(i).setPendulumTheta_1(Double.parseDouble(tempPendulumProperties[4]));
                    tempList.get(i).setPendulumTheta_2(Double.parseDouble(tempPendulumProperties[5]));
                }

                tempList.get(i).setMassTrail_1Properties(tempColor1, tempTrailProperties1);
                tempList.get(i).setMassTrail_2Properties(tempColor2, tempTrailProperties2);
            }
        }
    }




    public void checkInputInt(String checkint, String exceptionValue){
        try{
            double test = Double.parseDouble(checkint);
        }catch(NumberFormatException e){
            System.out.println("invalid input at:    "+exceptionValue+" "+checkint);
            ValueExceptionCount++;
        }
    }

    public void checkInputColor(String checkcolor, String exceptionValue){
        try{
            Color test = Color.decode(checkcolor);
        }catch(NumberFormatException e){
            System.out.println("Invalid Color at:    "+exceptionValue+" "+checkcolor);
            ValueExceptionCount++;
        }
    }
}
