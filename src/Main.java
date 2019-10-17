import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
	// write your code
        JFrame jFrame = new JFrame();

        jFrame.setSize(800, 800);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DrawPanel p = new DrawPanel(800,700);

        jFrame.add(p);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
//        JWindow jw = new JWindow();
//        jw.setBounds(0,0,800,600);
//        jw.setLocationRelativeTo(null);
//        jw.add(new DrawPanel(800,600));
//        jw.show();

    }
}
