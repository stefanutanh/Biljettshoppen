import javax.swing.*;

public class testbiljettGUI {

    public static void main(String[] args) {
        JFrame frameObj = new JFrame("Biljettbetalning");
        frameObj.setContentPane(new testbiljettGUI().mainPanel);
        frameObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameObj.setSize(600,400);
        frameObj.setVisible(true);
    }//END MAIN

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
        beställButton.addActionListener(e -> {
            boolean hus1Vald = hus1CheckBox.isSelected();
            boolean kortBetalning = kortCheckBox.isSelected();
            String eventTid = (String) comboBox1.getSelectedItem();

            if (hus1Vald && kortBetalning) {
                JOptionPane.showMessageDialog(mainPanel, "Du valde hus 1 och betalning med kort vid " + eventTid);
            }
        });
    }

}
