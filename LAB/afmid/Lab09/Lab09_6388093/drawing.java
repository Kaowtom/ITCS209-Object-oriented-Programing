import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class drawing extends JFrame {

public drawing() {

    setSize(new Dimension(500, 500));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}

public void paint(Graphics g) {
	
	head(g);
	eyes(g);
	nose(g);
	mouth(g);
	name(g);
}

public void eyes(Graphics g) {
	g.setColor(Color.white);
	g.fillRect(70, 200, 130, 70);
	g.setColor(Color.white);
	g.fillRect(300, 200, 130, 70);
}

public void head(Graphics g) {
	g.setColor(Color.lightGray);
	g.fillRect(0, 0, 500, 500);
	g.setColor(Color.DARK_GRAY);
	g.fillRect(0, 0, 500, 100);
	g.setColor(Color.DARK_GRAY);
	g.fillRect(0, 100, 50, 50);
	g.setColor(Color.DARK_GRAY);
	g.fillRect(450, 100, 50, 50);
}

public void nose(Graphics g) {
	g.setColor(Color.gray);
	g.fillRect(200, 280, 100, 40);
}

public void mouth(Graphics g) {
	g.setColor(Color.darkGray);
	g.fillRect(150, 350, 200, 35);
}

public void name(Graphics g) {
	String i = "RIP Steve";
	String l = "6388093 Nitit Ngamphotchanamongkol";
	g.drawString(String.valueOf(i), 260, 450);
	g.drawString(String.valueOf(l), 260, 470);
}

public static void main(String arg[]) {

    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            new drawing();
        }
    });
}

}