package MVCPck;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame PendulumInterface = new JFrame("Double Pendulum");
    private JPanel MainPanel = new JPanel(new GridBagLayout());
    private JPanel[] Panels = new JPanel[] {
            new JPanel(new GridBagLayout()),
            new JPanel(),
            new JPanel(new GridBagLayout()),
                new JPanel(new GridBagLayout()),
                new JPanel()};
    private JTextField resistancetext = new JTextField("testtesttesttest");
    private JTextField gravitytext = new JTextField("testtesttest");
    private JLabel resistancelabel = new JLabel("Resistance r = ");
    private JLabel gravitylabel = new JLabel("Gravity g = ");
    private JButton newDoublePendulum = new JButton("New DoublePendulum");
    private Dimension GUIMinimumSize = new Dimension(1200, 800);


    public void InitGUI(){
        PendulumInterface.setMinimumSize(GUIMinimumSize);
        PendulumInterface.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        PendulumInterface.setContentPane(MainPanel);

        MainPanel.setBackground(Color.decode("0x00ff00"));

        //resistancetext.set

        //Panel0
        GridBagConstraints PanelConstraints = new GridBagConstraints();
        GridBagConstraints ElementConstraints = new GridBagConstraints();

        PanelConstraints.fill = GridBagConstraints.BOTH;
        PanelConstraints.gridx = 0;
        PanelConstraints.gridy = 0;
        PanelConstraints.weightx = 0.9;
        PanelConstraints.weighty = 0.5;
        Panels[0].setBackground(Color.decode("0x7d8eff"));
        MainPanel.add(Panels[0], PanelConstraints);

        //Panel1
        PanelConstraints.gridx = 1;
        PanelConstraints.weightx = 0.008;
        Panels[1].setBackground(Color.decode("0x6973b5"));
        MainPanel.add(Panels[1], PanelConstraints);

        //Panel2
        PanelConstraints.gridx = 2;
        PanelConstraints.weightx = 0.2;
        Panels[2].setBackground(Color.decode("0x5a618f"));
        MainPanel.add(Panels[2], PanelConstraints);

            //Panel3
            PanelConstraints.gridx = 0;
            PanelConstraints.gridy = 0;
            PanelConstraints.weighty = 0.3;
            Panels[3].setBackground(Color.decode("0xff0000"));
            Panels[2].add(Panels[3], PanelConstraints);

                //Label0
                ElementConstraints.gridx = 0;
                ElementConstraints.gridy = 0;
                ElementConstraints.weightx = 0.1;
                ElementConstraints.weighty = 0.05;
                ElementConstraints.insets = new Insets(20, 20, 0, 20);
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
                ElementConstraints.weightx = 0.1;
                ElementConstraints.weighty = 0.95;
                ElementConstraints.gridwidth = 3;
                ElementConstraints.anchor = GridBagConstraints.CENTER;
                ElementConstraints.ipady = 0;
                ElementConstraints.fill = GridBagConstraints.HORIZONTAL;
                Panels[3].add(newDoublePendulum, ElementConstraints);

            //Panel4
            PanelConstraints.gridy = 1;
            PanelConstraints.weighty = 0.7;
            Panels[4].setBackground(Color.decode("0x00ff00"));
            Panels[2].add(Panels[4], PanelConstraints);

        PendulumInterface.pack();
        PendulumInterface.setVisible(true);
    }
}
