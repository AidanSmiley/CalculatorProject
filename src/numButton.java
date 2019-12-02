import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class numButton extends JButton implements ActionListener {

    String text;
    String expression;
    JTextField input;

    public numButton (String text, String expression, JTextField input) {
        super(text);
        this.text = text;
        this.expression = expression;
        this.input = input;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        expression += this.getText();
        input.setText(expression);
    }
}
