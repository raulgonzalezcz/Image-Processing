/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaimagesGUI;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

/**
 *
 * Thanks to,
 * @author Luis
 * edited by Raúl González Cruz
 * email: raul.gonzalezcz@udlap.mx
 */
public class Events {
    public static void changeLabel(JLabel label,String message){
        label.setText(message);
    }
     public static void changeTextField(JFormattedTextField textField,String message){
        textField.setText(message);
    }
}
