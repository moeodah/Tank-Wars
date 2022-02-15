import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.awt.Dimension;

public class Test extends JFrame
{  
    private Image img = Toolkit.getDefaultToolkit().getImage("/Images/Rocket.png");

     public Test()
    {   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel icon = new JLabel();
        this.setContentPane(icon);
        this.setContentPane(new JPanel() {

            // Setting the Background Image for the JFrame
            @Override
            public void paintComponent(Graphics g) {
               super.paintComponent(g);
               g.drawImage(img, 0, 0, 20, 20, this);
            }
         });
        this.add(icon);
        pack();
 
        setVisible(true);
    }
 
    public static void main(String[] args)
    {   new Test();
    }
 
}