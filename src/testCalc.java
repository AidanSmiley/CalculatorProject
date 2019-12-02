import javax.swing.*;

public class testCalc {
    public static void main(String [] args) {
        calculator window = new calculator();
        window.setTitle("Programmer Calculator");
        window.setVisible(true);
        window.setSize(400, 600);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            // Windows LF
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            try {
                // Linux LF
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            } catch (Exception f) {
                // Mac LF
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.mac.MacLookAndFeel ");
                } catch (Exception g) {
                    // Let java set its default
                }
            }
        }
    }
}
