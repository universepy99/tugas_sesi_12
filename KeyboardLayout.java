import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyboardLayout extends JFrame implements ActionListener {

    private JTextField textField;
    private JButton[] buttons;

    public KeyboardLayout() {
        setTitle("Keyboard Layout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create text field
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        add(textField, BorderLayout.NORTH);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 7, 5, 5));

        // Create buttons
        buttons = new JButton[32];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 14));
            buttonPanel.add(buttons[i]);
        }

        // Set button text
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0) {
                    if (j == 0 || j == 6) {
                        buttons[index].setText("");
                    } else {
                        buttons[index].setText(String.valueOf(j + 1));
                        index++;
                    }
                } else if (i == 1) {
                    if (j == 0 || j == 6) {
                        buttons[index].setText("");
                    } else {
                        buttons[index].setText(String.valueOf(j + 7));
                        index++;
                    }
                } else if (i == 2) {
                    if (j == 0 || j == 6) {
                        buttons[index].setText("");
                    } else {
                        buttons[index].setText(String.valueOf(j + 14));
                        index++;
                    }
                } else {
                    if (j == 0) {
                        buttons[index].setText("=");
                    } else if (j == 1) {
                        buttons[index].setText("%");
                    } else if (j == 2) {
                        buttons[index].setText("Mod");
                    } else if (j == 3) {
                        buttons[index].setText("Exit");
                    } else {
                        buttons[index].setText("");
                    }
                    index++;
                }
            }
        }

        // Add action listeners to buttons
        for (JButton button : buttons) {
            button.addActionListener(this);
        }

        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String text = button.getText();

        if (!text.isEmpty()) {
            textField.setText(textField.getText() + text);
        }
    }

    public static void main(String[] args) {
        new KeyboardLayout();
    }
}