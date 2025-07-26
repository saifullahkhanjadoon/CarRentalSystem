
package Model;

import java.awt.Color;
import java.awt.Font;

public class JButton extends javax.swing.JButton{
    public JButton(String text,int textsize){
        super(text);
        setBackground(Color.black);
        setFont(new Font("SansSerif",Font.BOLD,textsize));
        setForeground(Color.white);
        setBorder(null);
}
}
