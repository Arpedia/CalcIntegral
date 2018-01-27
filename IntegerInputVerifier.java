/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex6;

import java.awt.Toolkit;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author plane
 */
public class IntegerInputVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent jc) {
        boolean verified = false;
        JTextField textField = (JTextField) jc;
        try {
          Integer.parseInt(textField.getText());
          verified = true;
        } catch (NumberFormatException e) {
          UIManager.getLookAndFeel().provideErrorFeedback(jc);
          Toolkit.getDefaultToolkit().beep();
        }
        return verified;
    }
    
}
