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
    private JComboBox comboBoxRow;
    private JComboBox comboBoxSeat;
    private JComboBox comboBoxNumberTickets;
    private JCheckBox kortCheckBox;
    private JButton beställButton;
    private JComboBox<String> comboBoxTimeEvent;
    private JComboBox<String> comboBoxByggnad;
    private JComboBox comboBoxPaymentOptions;

    public testbiljettGUI() {

        beställButton.addActionListener(e -> {
            String building = (String) comboBoxByggnad.getSelectedItem();
            String row = (String) comboBoxRow.getSelectedItem();
            String seat = (String) comboBoxSeat.getSelectedItem();
            String numberTickets = (String) comboBoxNumberTickets.getSelectedItem();
            String timeEvent = (String) comboBoxTimeEvent.getSelectedItem();
            String paymentOptions = (String) comboBoxPaymentOptions.getSelectedItem();
            int numTickets = Integer.parseInt((String) comboBoxNumberTickets.getSelectedItem());


            JOptionPane.showMessageDialog(mainPanel, "Du har beställt " + numTickets + " biljett(er) till rad " + row + ", plats " + seat + " i " +building + " kl " +timeEvent + "\nStämmer det?");
        });

    }

}
