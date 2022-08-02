package MVCPck;

import javax.swing.*;

public class View {
    private JFrame PendulumInterface;
    private int[] GUIProperties = new int[] {400, 400};

    public void InitGUI(){
        PendulumInterface = new JFrame();
        PendulumInterface.setSize(GUIProperties[0], GUIProperties[1]);
        PendulumInterface.setVisible(true);
    }
}
