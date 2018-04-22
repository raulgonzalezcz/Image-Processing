/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaimagesGUI;
import java.awt.*;
import javax.swing.*;
/**
 *
 * Thanks to,
 * @author Jack
 * edited by Raúl González Cruz
 * email: raul.gonzalezcz@udlap.mx
 */
public class CPanelIMagen extends JPanel
{

    public Image myimg = null;

    public CPanelIMagen() 
    {
        setBounds(0, 0, 640, 480);//tamaño del panel
      
    }

    public void setImage(Image img)
    {
        this.myimg = img;
        repaint();
    }

    public void paint(Graphics g) 
    {
        if (myimg != null) {
            g.drawImage(myimg, 0, 0, this);
        }
    }


  
}
