package MVCPck;

import DoublePendulumPck.Trail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class View {
    private Controller maincontroller;
    private ArrayList<DoublePendulumPropertiesPanel> DoublePendulumPropertiesPanelList = new ArrayList<DoublePendulumPropertiesPanel>();
    private boolean simulationRunning = false;

    private JFrame PendulumInterface = new JFrame("Double Pendulum");
    private JPanel MainPanel = new JPanel(new GridBagLayout());
    private JPanel[] Panels = new JPanel[] {
            new JPanel(new GridBagLayout()),
            new JPanel(),
            new JPanel(new GridBagLayout()),
                new JPanel(new GridBagLayout()),
                new JPanel(new GridBagLayout())};

    private JTextField resistancetext = new JTextField("0",10);
    private JTextField gravitytext = new JTextField("9.81",10);
    private JLabel resistancelabel = new JLabel("Resistance r = ");
    private JLabel gravitylabel = new JLabel("Gravity g = ");
    private JButton newDoublePendulum = new JButton(new NewPendulumButtonAction("New Pendulum", KeyEvent.VK_N));

    private JTabbedPane pendulumTabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
    private JButton startButton = new JButton(new StartButtonAction("Start", KeyEvent.VK_S));
    private JButton pauseButton = new JButton(new PauseButtonAction("Pause", KeyEvent.VK_P));
    private JButton resetButton = new JButton(new ResetButtonAction("Reset", KeyEvent.VK_R));

    private GridBagConstraints imageConstraints = new GridBagConstraints();

    private Timer UpdateTimer;
    private boolean GUIsetup = false;

    private Dimension GUIMinimumSize = new Dimension(1400, 950);

    private Action DeleteAction = new DeletePendulumAction("Delete", KeyEvent.VK_D);
    private FocusListener RealizeProperties = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {

        }
        @Override
        public void focusLost(FocusEvent e) {
            maincontroller.UpdatePendulumProperties(false);
            maincontroller.DrawTick(false);
        }
    };


    public void InitGUI(){
        pauseButton.getAction().setEnabled(false);

        PendulumInterface.setMinimumSize(GUIMinimumSize);
        PendulumInterface.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        PendulumInterface.setContentPane(MainPanel);

        MainPanel.setBackground(Color.decode("0x433f54"));

        resistancelabel.setForeground(Color.decode("0xeeeeee"));
        resistancetext.setForeground(Color.decode("0xeeeeee"));
        resistancetext.setBackground(null);
        gravitylabel.setForeground(Color.decode("0xeeeeee"));
        gravitytext.setForeground(Color.decode("0xeeeeee"));
        gravitytext.setBackground(null);


        //Panel0
        GridBagConstraints PanelConstraints = new GridBagConstraints();
        GridBagConstraints ElementConstraints = new GridBagConstraints();

        imageConstraints.gridx = 0;
        imageConstraints.gridy = 0;
        imageConstraints.fill = GridBagConstraints.BOTH;

        PanelConstraints.fill = GridBagConstraints.BOTH;
        PanelConstraints.gridx = 0;
        PanelConstraints.gridy = 0;
        PanelConstraints.weightx = 0.99;
        PanelConstraints.weighty = 0.5;
        Panels[0].setBackground(Color.decode("0x201e29"));
        MainPanel.add(Panels[0], PanelConstraints);

        //Panel1
        PanelConstraints.gridx = 1;
        PanelConstraints.weightx = 0.00001;
        Panels[1].setBackground(Color.decode("0x433f54"));
        MainPanel.add(Panels[1], PanelConstraints);

        //Panel2
        PanelConstraints.gridx = 2;
        PanelConstraints.weightx = 0.15;
        Panels[2].setBackground(Color.decode("0x302d3d"));
        MainPanel.add(Panels[2], PanelConstraints);

            //Panel3
            PanelConstraints.gridx = 0;
            PanelConstraints.gridy = 0;
            PanelConstraints.weighty = 0.4;
            Panels[3].setBackground(Color.decode("0x302d3d"));
            Panels[2].add(Panels[3], PanelConstraints);

                //Label0
                ElementConstraints.gridx = 0;
                ElementConstraints.gridy = 0;
                ElementConstraints.weightx = 0.01;
                ElementConstraints.weighty = 0.05;
                ElementConstraints.insets = new Insets(10, 20, 0, 20);
                ElementConstraints.anchor = GridBagConstraints.LINE_START;
                Panels[3].add(resistancelabel, ElementConstraints);

                //Label1
                ElementConstraints.gridy = 1;
                Panels[3].add(gravitylabel, ElementConstraints);

                //Textfield0
                ElementConstraints.gridx = 1;
                ElementConstraints.gridy = 0;
                ElementConstraints.weightx = 0.8;
                Panels[3].add(resistancetext, ElementConstraints);

                //Textfield1
                ElementConstraints.gridy = 1;
                Panels[3].add(gravitytext, ElementConstraints);

                //Button0
                ElementConstraints.gridx = 0;
                ElementConstraints.gridy = 2;
                ElementConstraints.weightx = 0.01;
                ElementConstraints.weighty = 0.95;
                ElementConstraints.gridwidth = 3;
                ElementConstraints.ipady = 10;
                ElementConstraints.anchor = GridBagConstraints.CENTER;
                ElementConstraints.fill = GridBagConstraints.HORIZONTAL;
                Panels[3].add(newDoublePendulum, ElementConstraints);

            //Panel4
            PanelConstraints.gridy = 1;
            PanelConstraints.weighty = 0.6;
            Panels[4].setBackground(Color.decode("0x302d3d"));
            Panels[2].add(Panels[4], PanelConstraints);

                //TabbedPane0
                ElementConstraints.gridx = 0;
                ElementConstraints.gridy = 0;
                ElementConstraints.weightx = 0.9;
                ElementConstraints.weighty = 0.7;
                ElementConstraints.gridwidth = 1;
                ElementConstraints.ipady = 0;
                ElementConstraints.fill = GridBagConstraints.BOTH;
                Panels[4].add(pendulumTabbedPane, ElementConstraints);

                //Button0
                ElementConstraints.gridx = 0;
                ElementConstraints.gridy = 1;
                ElementConstraints.weighty = 0.1;
                ElementConstraints.gridwidth = 3;
                ElementConstraints.insets = new Insets(0, 25, 0, 25);
                ElementConstraints.fill = GridBagConstraints.HORIZONTAL;
                Panels[4].add(startButton, ElementConstraints);

                //Button1
                ElementConstraints.gridx = 0;
                ElementConstraints.gridy = 2;
                Panels[4].add(pauseButton, ElementConstraints);

                //Button2
                ElementConstraints.gridx = 0;
                ElementConstraints.gridy = 3;
                Panels[4].add(resetButton, ElementConstraints);

        PendulumInterface.pack();
        PendulumInterface.setVisible(true);
        GUIsetup = true;
    }

    public void setController(Controller maincontroller) {
        this.maincontroller = maincontroller;
    }

    public void setUpTimer(int delay){
        UpdateTimer = new Timer(delay, new TimerAction());
        UpdateTimer.setRepeats(true);
        PendulumInterface.pack();
    }

    public void setPendulumImages(JLabel imgMain){
        Panels[0].add(imgMain, imageConstraints);
        PendulumInterface.repaint();
    }

    public void setDeleteActionEnabled(boolean enabled){
        DeleteAction.setEnabled(enabled);
    }




    public void addDoublePendulum(int index){
        DoublePendulumPropertiesPanelList.add(new DoublePendulumPropertiesPanel());
        pendulumTabbedPane.addTab("Pendulum "+index, DoublePendulumPropertiesPanelList.get(index).getMainTabPendulum());
        pendulumTabbedPane.setSelectedIndex(index);
        PendulumInterface.repaint();
    }

    public void removeDoublePendulum(int index, int count){
        DoublePendulumPropertiesPanelList.remove(index);
        pendulumTabbedPane.remove(index);
        for(int i = index; i < count; i++) {
            pendulumTabbedPane.setTitleAt(i, "Pendulum " + i);
        }
        Panels[0].remove(index);
        PendulumInterface.repaint();
    }

    public String[] getSimulationProperties(){
        maincontroller.checkInputInt(gravitytext.getText(), "gravity");
        maincontroller.checkInputInt(resistancetext.getText(), "resistance");
        return new String[]{gravitytext.getText(), resistancetext.getText()};
    }

    public String[] getPendulumProperties(int index){
        String[] tempPendulumProperties = DoublePendulumPropertiesPanelList.get(index).getPendulumProperties(index);
        return tempPendulumProperties;
    }

    public boolean[] getTrailProperties1(int index){
        boolean[] tempTrailProperties = DoublePendulumPropertiesPanelList.get(index).getTrailProperties1();
        return tempTrailProperties;
    }

    public boolean[] getTrailProperties2(int index){
        boolean[] tempTrailProperties = DoublePendulumPropertiesPanelList.get(index).getTrailProperties2();
        return tempTrailProperties;
    }

    public String getTrailColor1(int index){
        return DoublePendulumPropertiesPanelList.get(index).getTrailColor1();
    }

    public String getTrailColor2(int index){
        return DoublePendulumPropertiesPanelList.get(index).getTrailColor2();
    }




    //Button action
    //creates new double pendulum
    private class NewPendulumButtonAction extends AbstractAction{
        public NewPendulumButtonAction(String name, Integer mnemonic){
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            maincontroller.addDoublePendulum();
            maincontroller.DrawTick(true);
        }
    }

    //Button action
    //creates new double pendulum
    private class StartButtonAction extends AbstractAction{
        public StartButtonAction(String name, Integer mnemonic){
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            maincontroller.UpdatePendulumProperties(simulationRunning);
            simulationRunning = true;
            if(maincontroller.getValueExceptionCount() == 0){
                startButton.getAction().setEnabled(false);
                pauseButton.getAction().setEnabled(true);

                UpdateTimer.start();
                PendulumInterface.repaint();
            }else{
                maincontroller.setValueExceptionCount(0);
            }
        }
    }

    //Button action
    //pauses simulation
    private class PauseButtonAction extends AbstractAction{
        public PauseButtonAction(String name, Integer mnemonic){
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            pauseButton.getAction().setEnabled(false);
            startButton.getAction().setEnabled(true);
            UpdateTimer.stop();
            PendulumInterface.repaint();
        }
    }

    //Button action
    //resets double pendulum simulation
    private class ResetButtonAction extends AbstractAction{
        public ResetButtonAction(String name, Integer mnemonic){
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            simulationRunning = false;
            maincontroller.UpdatePendulumProperties(simulationRunning);
            if(maincontroller.getValueExceptionCount() == 0){
                maincontroller.ResetSimulation();
                maincontroller.DrawTick(true);
            }else{
                maincontroller.setValueExceptionCount(0);
            }
        }
    }

    //Button action
    //deletes selected double pendulum
    private class DeletePendulumAction extends AbstractAction{
        public DeletePendulumAction(String name, Integer mnemonic){
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }
        @Override
        public void actionPerformed(ActionEvent e){
            maincontroller.removeDoublePendulum(pendulumTabbedPane.getSelectedIndex());
            PendulumInterface.repaint();
        }
    }

    //TIMER ACTION
    //Task a timer will run through in a loop after a specified delay
    private class TimerAction extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent e){
            maincontroller.TickSimulation();
        }
    }




    //Inner class
    //creates a new properties-panel for the related double pendulum
    private class DoublePendulumPropertiesPanel {
        private JPanel MainTabPendulum = new JPanel(new GridBagLayout());
        private JButton DeletePendulum = new JButton(DeleteAction);
        private JTextField[] PendulumValuesText = new JTextField[]{
                new JTextField("100",10),
                new JTextField("100",10),
                new JTextField("10",10),
                new JTextField("10",10),
                new JTextField("0",10),
                new JTextField("0",10)
        };
        private JLabel[] PendulumValuesLable = new JLabel[]{
                new JLabel("Rod Length 1: "),
                new JLabel("Rod Length 2: "),
                new JLabel("Mass 1: "),
                new JLabel("Mass 2: "),
                new JLabel("Theta 1: "),
                new JLabel("Theta 2: ")
        };
        private JTabbedPane MassTrails = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        private TrailPane[] TrailValues = new TrailPane[]{
                new TrailPane(),
                new TrailPane()
        };

        DoublePendulumPropertiesPanel(){
            PendulumValuesText[0].addFocusListener(RealizeProperties);
            PendulumValuesText[1].addFocusListener(RealizeProperties);
            PendulumValuesText[4].addFocusListener(RealizeProperties);
            PendulumValuesText[5].addFocusListener(RealizeProperties);

            MainTabPendulum.setBackground(Color.decode("0x3f3b52"));
            for(int i = 0; PendulumValuesLable.length > i; i++){
                PendulumValuesLable[i].setForeground(Color.decode("0xeeeeee"));
                PendulumValuesText[i].setForeground(Color.decode("0xeeeeee"));
                PendulumValuesText[i].setBackground(null);
            }
            GridBagConstraints TabbedPaneMotherConstraints = new GridBagConstraints();

            TabbedPaneMotherConstraints.gridx = 0;
            TabbedPaneMotherConstraints.gridy = 0;
            TabbedPaneMotherConstraints.weightx = 0.5;
            TabbedPaneMotherConstraints.weighty = 0.2;
            TabbedPaneMotherConstraints.gridwidth = 2;
            TabbedPaneMotherConstraints.fill = GridBagConstraints.HORIZONTAL;
            TabbedPaneMotherConstraints.insets = new Insets(8,10,2,10);
            TabbedPaneMotherConstraints.anchor = GridBagConstraints.LINE_START;
            MainTabPendulum.add(DeletePendulum, TabbedPaneMotherConstraints);
            TabbedPaneMotherConstraints.gridy++;
            TabbedPaneMotherConstraints.gridwidth = 1;
            TabbedPaneMotherConstraints.fill = GridBagConstraints.NONE;
            for(int i = 0; i<6; i++){
                MainTabPendulum.add(PendulumValuesLable[i], TabbedPaneMotherConstraints);
                TabbedPaneMotherConstraints.gridy++;
            }
            TabbedPaneMotherConstraints.gridx = 1;
            TabbedPaneMotherConstraints.gridy = 1;
            for(int i = 0; i<6; i++){
                MainTabPendulum.add(PendulumValuesText[i], TabbedPaneMotherConstraints);
                TabbedPaneMotherConstraints.gridy++;
            }
            TabbedPaneMotherConstraints.gridx = 0;
            TabbedPaneMotherConstraints.weighty = 0.8;
            TabbedPaneMotherConstraints.weightx = 0.5;
            TabbedPaneMotherConstraints.gridwidth = 2;
            TabbedPaneMotherConstraints.fill = GridBagConstraints.BOTH;
            MainTabPendulum.add(MassTrails, TabbedPaneMotherConstraints);
            MassTrails.addTab("Trail 1", TrailValues[0].getTrailPropertiesPanel());
            MassTrails.addTab("Trail 2", TrailValues[1].getTrailPropertiesPanel());
        }

        public JPanel getMainTabPendulum(){
            return MainTabPendulum;
        }

        public String[] getPendulumProperties(int index){
            String[] tempPendulumProperties = new String[PendulumValuesText.length];

            for(int i = 0; i < PendulumValuesText.length; i++){
                maincontroller.checkInputInt(PendulumValuesText[i].getText(), PendulumValuesLable[i].getText() + index);
                tempPendulumProperties[i] = PendulumValuesText[i].getText();
            }
            return tempPendulumProperties;
        }

        public boolean[] getTrailProperties1(){
            return TrailValues[0].getTrailProperties();
        }

        public boolean[] getTrailProperties2(){
            return TrailValues[1].getTrailProperties();
        }

        public String getTrailColor1(){
            return TrailValues[0].getTrailColor();
        }

        public String getTrailColor2(){
            return TrailValues[1].getTrailColor();
        }



        private class TrailPane{
            private JPanel TrailPropertiesPanel = new JPanel(new GridBagLayout());
            private JCheckBox[] TrailPropertiesCheckbox = new JCheckBox[]{
                    new JCheckBox("Trail active", false),
                    new JCheckBox("Trail vary with speed", false),
                    new JCheckBox("Trail vanishing", false)
            };
            private JTextField TrailColor = new JTextField("0xffffff", 10);
            private JLabel ColorLabel = new JLabel("Color: ");

            TrailPane(){
                TrailPropertiesPanel.setBackground(Color.decode("0x504b66"));
                ColorLabel.setForeground(Color.decode("0xeeeeee"));
                TrailColor.setForeground(Color.decode("0xeeeeee"));
                TrailColor.setBackground(null);
                for(int i = 0; TrailPropertiesCheckbox.length > i; i++){
                    TrailPropertiesCheckbox[i].setBackground(Color.decode("0x504b66"));
                    TrailPropertiesCheckbox[i].setForeground(Color.decode("0xeeeeee"));
                }
                GridBagConstraints TabbedPaneDaughterConstraints = new GridBagConstraints();

                TabbedPaneDaughterConstraints.gridx = 0;
                TabbedPaneDaughterConstraints.gridy = 0;
                TabbedPaneDaughterConstraints.weightx = 0.5;
                TabbedPaneDaughterConstraints.weighty = 0.5;
                TabbedPaneDaughterConstraints.gridwidth = 1;
                TabbedPaneDaughterConstraints.insets = new Insets(10,10,0,10);
                TabbedPaneDaughterConstraints.anchor = GridBagConstraints.LINE_START;
                for(int i = 0; i<3; i++){
                    TrailPropertiesPanel.add(TrailPropertiesCheckbox[i], TabbedPaneDaughterConstraints);
                    TabbedPaneDaughterConstraints.gridy++;
                }
                TrailPropertiesPanel.add(ColorLabel, TabbedPaneDaughterConstraints);
                TabbedPaneDaughterConstraints.insets = new Insets(10,60,0,10);
                TrailPropertiesPanel.add(TrailColor, TabbedPaneDaughterConstraints);
            }

            public JPanel getTrailPropertiesPanel(){
                return TrailPropertiesPanel;
            }

            public boolean[] getTrailProperties(){
                return new boolean[]{TrailPropertiesCheckbox[0].isSelected(), TrailPropertiesCheckbox[1].isSelected(), TrailPropertiesCheckbox[2].isSelected()};
            }

            public String getTrailColor(){
                maincontroller.checkInputColor(TrailColor.getText(), "Color");
                return TrailColor.getText();
            }
        }
    }
}
