/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Jose
 */
public class AnagramGame extends JFrame {
    private JLabel imageLabel;
    private JButton[] letterButtons;
    private JTextField answerField;
    private String correctWord = "sandía";
    private String[] letters = {"d", "n", "í", "a", "a", "s"};
    
    public AnagramGame() {
        setTitle("Anagram Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Layout
        setLayout(new BorderLayout());
        
        // Image
        imageLabel = new JLabel(new ImageIcon("ruta/a/tu/imagen.png"));
        add(imageLabel, BorderLayout.NORTH);
        
        // Letter Buttons
        JPanel letterPanel = new JPanel();
        letterButtons = new JButton[letters.length];
        List<String> letterList = Arrays.asList(letters);
        Collections.shuffle(letterList);
        for (int i = 0; i < letters.length; i++) {
            letterButtons[i] = new JButton(letterList.get(i));
            letterPanel.add(letterButtons[i]);
        }
        add(letterPanel, BorderLayout.CENTER);
        
        // Answer Field
        answerField = new JTextField(10);
        add(answerField, BorderLayout.SOUTH);
        
        // Verify Button
        JButton verifyButton = new JButton("Verify");
        verifyButton.addActionListener(new VerifyButtonListener());
        add(verifyButton, BorderLayout.EAST);
    }

    private class VerifyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (answerField.getText().equals(correctWord)) {
                JOptionPane.showMessageDialog(null, "Correct!");
            } else {
                JOptionPane.showMessageDialog(null, "Try Again!");
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AnagramGame game = new AnagramGame();
            game.setVisible(true);
        });
    }
}
