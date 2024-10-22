import javax.swing.*;

public class testbiljettGUI {

    public static void main(String[] args) {
        JFrame frameObj = new JFrame("Biljettbetalning");
        frameObj.setContentPane(new testbiljettGUI().mainPanel);
        frameObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameObj.setSize(600,400);
        frameObj.setVisible(true);
    }

    private JPanel mainPanel;
    private JCheckBox hus1CheckBox;
    private JCheckBox a1000CheckBox;
    private JCheckBox a1800CheckBox;
    private JCheckBox hus2CheckBox;
    private JCheckBox a1500CheckBox;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JCheckBox kortCheckBox;
    private JCheckBox fakturaCheckBox;
    private JButton beställButton;

    public testbiljettGUI() {

    }
}
