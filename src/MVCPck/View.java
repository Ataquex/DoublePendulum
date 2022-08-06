package MVCPck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class View {
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

    private Dimension GUIMinimumSize = new Dimension(1200, 800);

    private Action DeleteAction = new DeletePendulumAction("Delete", KeyEvent.VK_D);


    public void InitGUI(){
        PendulumInterface.setMinimumSize(GUIMinimumSize);
        PendulumInterface.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        PendulumInterface.setContentPane(MainPanel);

        MainPanel.setBackground(Color.decode("0x00ff00"));


        //Panel0
        GridBagConstraints PanelConstraints = new GridBagConstraints();
        GridBagConstraints ElementConstraints = new GridBagConstraints();

        PanelConstraints.fill = GridBagConstraints.BOTH;
        PanelConstraints.gridx = 0;
        PanelConstraints.gridy = 0;
        PanelConstraints.weightx = 0.99;
        PanelConstraints.weighty = 0.5;
        Panels[0].setBackground(Color.decode("0x363636"));
        MainPanel.add(Panels[0], PanelConstraints);

        //Panel1
        PanelConstraints.gridx = 1;
        PanelConstraints.weightx = 0.00001;
        Panels[1].setBackground(Color.decode("0x404040"));
        MainPanel.add(Panels[1], PanelConstraints);

        //Panel2
        PanelConstraints.gridx = 2;
        PanelConstraints.weightx = 0.15;
        Panels[2].setBackground(Color.decode("0x464646"));
        MainPanel.add(Panels[2], PanelConstraints);

            //Panel3
            PanelConstraints.gridx = 0;
            PanelConstraints.gridy = 0;
            PanelConstraints.weighty = 0.3;
            Panels[3].setBackground(Color.decode("0x505050"));
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
            PanelConstraints.weighty = 0.7;
            Panels[4].setBackground(Color.decode("0x606060"));
            Panels[2].add(Panels[4], PanelConstraints);

                //TabbedPane0
                ElementConstraints.gridx = 0;
                ElementConstraints.gridy = 0;
                ElementConstraints.weightx = 0.9;
                ElementConstraints.weighty = 0.9;
                ElementConstraints.gridwidth = 1;
                ElementConstraints.ipady = 0;
                ElementConstraints.fill = GridBagConstraints.BOTH;
                Panels[4].add(pendulumTabbedPane, ElementConstraints);

                    pendulumTabbedPane.addTab("Pendulum", new DoublePendulumPane().getMainTabPendulum());

                //Button0
                ElementConstraints.gridx = 0;
                ElementConstraints.gridy = 1;
                ElementConstraints.weighty = 0.05;
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
    }

    private class NewPendulumButtonAction extends AbstractAction{
        public NewPendulumButtonAction(String name, Integer mnemonic){
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("not supported yet");
        }
    }

    private class StartButtonAction extends AbstractAction{
        public StartButtonAction(String name, Integer mnemonic){
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("not supported yet");
        }
    }

    private class PauseButtonAction extends AbstractAction{
        public PauseButtonAction(String name, Integer mnemonic){
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("not supported yet");
        }
    }

    private class ResetButtonAction extends AbstractAction{
        public ResetButtonAction(String name, Integer mnemonic){
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("not supported yet");
        }
    }

    private class DeletePendulumAction extends AbstractAction{
        public DeletePendulumAction(String name, Integer mnemonic){
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("loesch irgendwas");
        }
    }

    private class DoublePendulumPane{
        private JPanel MainTabPendulum = new JPanel(new GridBagLayout());
        private JButton DeletePendulum = new JButton(DeleteAction);
        private JTextField[] PendulumValues = new JTextField[]{
                new JTextField("100",10),
                new JTextField("100",10),
                new JTextField("10",10),
                new JTextField("10",10),
                new JTextField("0",10),
                new JTextField("0",10)
        };
        private JTabbedPane MassTrails = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        private TrailPane[] TrailValues = new TrailPane[]{
                new TrailPane(),
                new TrailPane()
        };

        DoublePendulumPane(){
            MainTabPendulum.setBackground(Color.decode("0xff0000"));
        }

        public JPanel getMainTabPendulum(){
            return MainTabPendulum;
        }



        private class TrailPane{
            private JPanel TrailPropertiesPanel = new JPanel(new GridBagLayout());
            private JCheckBox[] TrailPropertiesCheckbox = new JCheckBox[]{
                    new JCheckBox("Trail active", false),
                    new JCheckBox("Trail vary with speed", false),
                    new JCheckBox("Trail vanishing", false)
            };
            private JTextField TrailColor = new JTextField("ffffff", 10);

            TrailPane(){
                TrailPropertiesPanel.setBackground(Color.decode("0x0000ff"));
            }

            public JPanel getTrailPropertiesPanel(){
                return TrailPropertiesPanel;
            }
        }
    }
}
