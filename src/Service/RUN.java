package Service;

import javax.swing.*;

public class RUN {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Mechanical Service");
        jFrame.setContentPane(new GUI().anu());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
