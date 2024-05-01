package ProjManagerPackage.RptStatusElem;

import ProjManagerPackage.AccMgmtElem.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author PC
 */
public class TableHeader_StuIntake extends JLabel{

    public TableHeader_StuIntake(String text){
        super(text);
        setOpaque(true);
        setBackground(new Color(197, 197, 197));
        setFont(new java.awt.Font("Dubai Medium", 0, 20));
        setForeground(new Color(0, 0, 0));
        setBorder(new EmptyBorder(10, 5, 10, 5));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(0, 0, 0));
        g2.drawLine(0, getHeight() -1, getWidth(), getHeight() -1);
        super.paintComponent(g); 
    }
    
    
}
