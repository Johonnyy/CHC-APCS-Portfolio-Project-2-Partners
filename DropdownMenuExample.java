package QuickReferencePortfolio;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropdownMenuExample {
    public static void main(String[] args) {
        // Create a new frame
        JFrame frame = new JFrame("Dropdown Menu Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create a dropdown menu (JComboBox)
        String[] options = {"Option 1", "Option 2", "Option 3"};
        JComboBox<String> dropdown = new JComboBox<>(options);

        // Add an ActionListener to handle the dropdown selection
        dropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) dropdown.getSelectedItem();
                JOptionPane.showMessageDialog(frame, "You selected: " + selectedOption);
            }
        });

        // Add the dropdown to the frame
        frame.getContentPane().add(dropdown);
        frame.setVisible(true);
    }
}

