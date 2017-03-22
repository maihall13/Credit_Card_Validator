package com.maia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Maia on 3/22/2017.
 */
public class CCValidator extends JFrame {
    private JPanel mainPanel;
    private JTextField cardNumberTextField;
    private JButton validateButton;
    private JButton quitButton;
    private JLabel validMessageLabel;

    public CCValidator(){
        super("Credit Card Validator");
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ccNumber = cardNumberTextField.getText();

                boolean valid = isVisaCreditCardNumbeValid(ccNumber);

                if(valid){
                    validMessageLabel.setText("Credit card number is valid.");
                }
                else{
                    validMessageLabel.setText("Credit card number is NOT valid.");
                }
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private boolean isVisaCreditCardNumbeValid(String cc) {

        if (!cc.startsWith("4") || (cc.length() != 16)){
            return false;
        }
        int sum = 0;
        for (int i = 0; i < 16 ; i++ ) {
            int thisDigit = Integer.parseInt((cc.substring(i, i+1)));
            if (i % 2 == 1) {
                sum = sum + thisDigit;
            } else {
                int doubled = thisDigit * 2;
                if (doubled > 9 ) {
                    int toAdd = 1 + (doubled % 10);
                    sum = sum + toAdd;
                } else {
                    sum = sum + (thisDigit * 2);
                }
            }
        }
        if (sum % 10 == 0) {
            return true;
        }
        return false;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
