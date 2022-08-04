package MVCPck;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame PendulumInterface = new JFrame("Double Pendulum");
    private JPanel MainPanel = new JPanel(new GridBagLayout());
    private JPanel[] Panels = new JPanel[] {new JPanel(new GridBagLayout()), new JPanel(new GridBagLayout()), new JPanel(new GridBagLayout())};
    private Dimension GUIMinimumSize = new Dimension(1200, 800);

    public void InitGUI(){
        PendulumInterface.setMinimumSize(GUIMinimumSize);
        PendulumInterface.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setBackground(Color.decode("0x00ff00"));

        PendulumInterface.setContentPane(MainPanel);

        /**
         * Panel0
         */
        GridBagConstraints PanelConstraints = new GridBagConstraints();
        PanelConstraints.fill = GridBagConstraints.BOTH;
        PanelConstraints.gridx = 0;
        PanelConstraints.gridy = 0;
        PanelConstraints.weightx = 0.67;
        PanelConstraints.weighty = 0.5;
        Panels[0].setBackground(Color.decode("0xff0000"));
        MainPanel.add(Panels[0], PanelConstraints);

        /**
         * Panel1
         */
        PanelConstraints.gridx = 1;
        PanelConstraints.weightx = 0.008;
        Panels[1].setBackground(Color.decode("0xffff00"));
        MainPanel.add(Panels[1], PanelConstraints);

        /**
         * Panel2
         */
        PanelConstraints.gridx = 2;
        PanelConstraints.weightx = 0.33;
        Panels[2].setBackground(Color.decode("0x0000ff"));
        MainPanel.add(Panels[2], PanelConstraints);

        PendulumInterface.pack();
        PendulumInterface.setVisible(true);
    }
}
