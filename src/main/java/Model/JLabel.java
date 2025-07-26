package Model;

import java.awt.Font;


@SuppressWarnings("serial")
public class JLabel extends javax.swing.JLabel {
    
    public JLabel(String text, int fontSize) {
        super(text);
        setFont(new Font("SansSerif", Font.BOLD, fontSize));
        setHorizontalAlignment(javax.swing.JLabel.CENTER);
        setOpaque(false); // Background null is not necessary; setOpaque(false) works better
    }
}
