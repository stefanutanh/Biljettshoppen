import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testbiljettGUI extends JFrame {
    private JButton button1;
    private JButton button2;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JPanel mainPanel;


    public static void main(String[] args) {
        // Kör programmet på Event Dispatch Thread för säker GUI-uppdatering
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new testbiljettGUI().setVisible(true);
            }
        });
    } // END MAIN


    public testbiljettGUI() {
        // Ställ in JFrame-egenskaper
        setTitle("Biljettshop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        // Skapa panelen
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1, 10, 10)); // 3 rader, 1 kolumn, 10 px mellanrum

        button1 = new JButton("Val 1");
        button2 = new JButton("Val 2");
        comboBox1 = new JComboBox<>(new String[]{"Event 1", "Event 2", "Event 3"});
        comboBox2 = new JComboBox<>(new String[]{"10:00", "15:00", "18:00"});

        //action listeners för knapparna
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainPanel, "Du valde Val 1");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainPanel, "Du valde Val 2");
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedEvent = (String) comboBox1.getSelectedItem();
                JOptionPane.showMessageDialog(mainPanel, "Du valde " + selectedEvent);
            }
        });
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedEvent = (String) comboBox1.getSelectedItem();
                JOptionPane.showMessageDialog(mainPanel, "Du valde " + selectedEvent);
            }
        });

        // Lägg till komponenterna till panelen
        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(comboBox1);
        mainPanel.add(comboBox2);

        // Lägg till panelen till JFrame
        add(mainPanel);
    } // END CONSTRUCTOR
} // END CLASS
