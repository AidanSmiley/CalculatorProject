import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;


public class calculator extends JFrame implements ActionListener, MouseListener{

    JPanel calcPane;

    String expressionString = "";

    //labels for the hex, dec, oct, bin conversion
    JButton hexButton;
    JButton decButton;
    JButton octButton;
    JButton binButton;

    //text fields for where the actual conversions go
    JLabel hexText;
    JLabel decText;
    JLabel octText;
    JLabel binText;

    //text fields for where numbers are input
    JTextField inputHistory;
    JTextField input;

    //all the buttons :\
    JButton wordButton;
    JButton dummy1;
    JButton dummy2;
    JButton dummy3;
    JButton dummy4;


    //1st row
    JButton lshButton;
    JButton rshButton;
    JButton orButton;
    JButton xorButton;
    JButton notButton;
    JButton andButton;

    //2nd row
    JButton secondButton;
    JButton modButton;
    JButton ceButton;
    JButton clearButton;
    JButton deleteButton;
    JButton divideButton;

    //3rd row
    JButton AButton;
    JButton BButton;
    JButton sevenButton;
    JButton eightButton;
    JButton nineButton;
    JButton multiplyButton;

    //4th row
    JButton CButton;
    JButton DButton;
    JButton fourButton;
    JButton fiveButton;
    JButton sixButton;
    JButton minusButton;

    //5th row
    JButton EButton;
    JButton FButton;
    JButton oneButton;
    JButton twoButton;
    JButton threeButton;
    JButton plusButton;

    //6th row
    JButton openParaButton;
    JButton closeParaButton;
    JButton signButton;
    JButton zeroButton;
    JButton dotButton;
    JButton equalsButton;

    GridBagConstraints c = new GridBagConstraints();

    //set up all the buttons
    public calculator() {

        //setLayout(new GridBagLayout());

        calcPane = new JPanel(new GridBagLayout());
        calcPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);



        //input related things
        inputHistory = new JTextField(50);
        input = new JTextField(50);

        //programming conversions
        hexButton = new JButton("HEX");
        hexText = new JLabel("0");

        decButton = new JButton("DEC");
        decText = new JLabel("0");

        octButton = new JButton("OCT");
        octText = new JLabel("0");

        binButton = new JButton("BIN");
        binText = new JLabel("0");

        //buttons :(
        wordButton = new JButton("QWORD");
        dummy1 = new JButton("...");
        dummy2 = new JButton("..");
        dummy3 = new JButton("MS");
        dummy4 = new JButton("M*");


        lshButton = new JButton("Lsh");
        rshButton = new JButton("Rsh");
        orButton = new JButton("Or");
        xorButton = new JButton("Xor");
        notButton = new JButton("Not");
        andButton = new JButton("And");

        secondButton = new JButton("2nd");
        modButton = new JButton("Mod");
        ceButton = new JButton("CE");
        clearButton = new JButton("C");
        deleteButton = new JButton("Del");
        divideButton = new JButton("/");

        AButton = new JButton("A");
        BButton = new JButton("B");
        sevenButton = new JButton("7");
        eightButton = new JButton("8");
        nineButton = new JButton("9");
        multiplyButton = new JButton("*");

        CButton = new JButton("C");
        DButton = new JButton("D");
        fourButton = new JButton("4");
        fiveButton = new JButton("5");
        sixButton = new JButton("6");
        minusButton = new JButton("-");

        EButton = new JButton("E");
        FButton = new JButton("F");
        oneButton = new JButton("1");
        twoButton = new JButton("2");
        threeButton = new JButton("3");
        plusButton = new JButton("+");

        openParaButton = new JButton("(");
        closeParaButton = new JButton(")");
        signButton = new JButton("+/-");
        zeroButton = new JButton("0");
        dotButton = new JButton(".");
        equalsButton = new JButton("=");

        //input history and input line
        c.gridx = 5;
        c.gridy = 0;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(inputHistory, c);

        c.gridx = 5;
        c.gridy = 1;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(input, c);

        //hex dec etc conversions
        c.gridx = 0;
        c.gridy = 2;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(hexButton, c);

        c.gridx = 1;
        c.gridy = 2;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(hexText, c);

        c.gridx = 0;
        c.gridy = 3;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(decButton, c);

        c.gridx = 1;
        c.gridy = 3;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(decText, c);

        c.gridx = 0;
        c.gridy = 4;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(octButton, c);

        c.gridx = 1;
        c.gridy = 4;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(octText, c);

        c.gridx = 0;
        c.gridy = 5;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(binButton, c);

        c.gridx = 1;
        c.gridy = 5;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(binText, c);

        //row with word and dummies
        c.gridx = 0;
        c.gridy = 6;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(dummy1, c);

        c.gridx = 1;
        c.gridy = 6;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(dummy2, c);

        c.gridx = 2;
        c.gridy = 6;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(wordButton, c);

        c.gridx = 3;
        c.gridy = 6;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(dummy3, c);

        c.gridx = 4;
        c.gridy = 6;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(dummy4, c);

        //row 1
        c.gridx = 0;
        c.gridy = 7;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(lshButton, c);

        c.gridx = 1;
        c.gridy = 7;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(rshButton, c);

        c.gridx = 2;
        c.gridy = 7;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(orButton, c);

        c.gridx = 3;
        c.gridy = 7;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(xorButton, c);

        c.gridx = 4;
        c.gridy = 7;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(notButton, c);

        c.gridx = 5;
        c.gridy = 7;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(andButton, c);

        //row 2
        c.gridx = 0;
        c.gridy = 8;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(secondButton, c);

        c.gridx = 1;
        c.gridy = 8;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(modButton, c);

        c.gridx = 2;
        c.gridy = 8;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(ceButton, c);

        c.gridx = 3;
        c.gridy = 8;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(clearButton, c);

        c.gridx = 4;
        c.gridy = 8;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(deleteButton, c);

        c.gridx = 5;
        c.gridy = 8;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(divideButton, c);

        //row 3
        c.gridx = 0;
        c.gridy = 9;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(AButton, c);

        c.gridx = 1;
        c.gridy = 9;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(BButton, c);

        c.gridx = 2;
        c.gridy = 9;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(sevenButton, c);

        c.gridx = 3;
        c.gridy = 9;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(eightButton, c);

        c.gridx = 4;
        c.gridy = 9;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(nineButton, c);

        c.gridx = 5;
        c.gridy = 9;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(multiplyButton, c);

        //row 4
        c.gridx = 0;
        c.gridy = 10;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(CButton, c);

        c.gridx = 1;
        c.gridy = 10;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(DButton, c);

        c.gridx = 2;
        c.gridy = 10;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(fourButton, c);

        c.gridx = 3;
        c.gridy = 10;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(fiveButton, c);

        c.gridx = 4;
        c.gridy = 10;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(sixButton, c);

        c.gridx = 5;
        c.gridy = 10;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(minusButton, c);

        //row 5
        c.gridx = 0;
        c.gridy = 11;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(EButton, c);

        c.gridx = 1;
        c.gridy = 11;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(FButton, c);

        c.gridx = 2;
        c.gridy = 11;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(oneButton, c);

        c.gridx = 3;
        c.gridy = 11;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(twoButton, c);

        c.gridx = 4;
        c.gridy = 11;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(threeButton, c);

        c.gridx = 5;
        c.gridy = 11;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(plusButton, c);

        //row 6
        c.gridx = 0;
        c.gridy = 12;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(openParaButton, c);

        c.gridx = 1;
        c.gridy = 12;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(closeParaButton, c);

        c.gridx = 2;
        c.gridy = 12;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(signButton, c);

        c.gridx = 3;
        c.gridy = 12;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(zeroButton, c);

        c.gridx = 4;
        c.gridy = 12;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(dotButton, c);

        c.gridx = 5;
        c.gridy = 12;
        //c.weightx = .5;
        //c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        calcPane.add(equalsButton, c);

        add(calcPane);

        oneButton.addActionListener(this);
        twoButton.addActionListener(this);
        threeButton.addActionListener(this);
        fourButton.addActionListener(this);
        fiveButton.addActionListener(this);
        sixButton.addActionListener(this);
        sevenButton.addActionListener(this);
        eightButton.addActionListener(this);
        nineButton.addActionListener(this);
        zeroButton.addActionListener(this);
        plusButton.addActionListener(this);
        equalsButton.addActionListener(this);
        minusButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        openParaButton.addActionListener(this);
        closeParaButton.addActionListener(this);
        clearButton.addActionListener(this);



    }




    @Override
    public void actionPerformed(ActionEvent e) {
        int result = 0;

        if (e.getSource() == oneButton) {
            expressionString = expressionString + oneButton.getText();
            input.setText(expressionString);

        }
        else if (e.getSource() == twoButton) {
            expressionString = expressionString + twoButton.getText();
            input.setText(expressionString);

        }
        else if (e.getSource() == threeButton) {
            expressionString = expressionString + threeButton.getText();
            input.setText(expressionString);

        }
        else if (e.getSource() == fourButton) {
            expressionString = expressionString + fourButton.getText();
            input.setText(expressionString);

        }
        else if (e.getSource() == fiveButton) {
            expressionString = expressionString + fiveButton.getText();
            input.setText(expressionString);

        }
        else if (e.getSource() == sixButton) {
            expressionString = expressionString + sixButton.getText();
            input.setText(expressionString);

        }
        else if (e.getSource() == sevenButton) {
            expressionString = expressionString + sevenButton.getText();
            input.setText(expressionString);

        }
        else if (e.getSource() == eightButton) {
            expressionString = expressionString + eightButton.getText();
            input.setText(expressionString);

        }
        else if (e.getSource() == nineButton) {
            expressionString = expressionString + nineButton.getText();
            input.setText(expressionString);

        }
        else if (e.getSource() == zeroButton) {
            expressionString = expressionString + zeroButton.getText();
            input.setText(expressionString);

        }
        else if (e.getSource() == plusButton) {
            expressionString = expressionString + " " + plusButton.getText() + " ";
            input.setText(expressionString);
        }
        else if (e.getSource() == equalsButton) {
            result = evaluateExpression(expressionString);
            input.setText(Integer.toString(result));
            decText.setText(Integer.toString(result));
            hexText.setText(Integer.toHexString(result));
            octText.setText(Integer.toOctalString(result));
            binText.setText(Integer.toBinaryString(result));
        }
        else if (e.getSource() == multiplyButton) {
            expressionString += " " + multiplyButton.getText() + " ";
            input.setText(expressionString);
        }
        else if (e.getSource() == divideButton) {
            expressionString += " " + divideButton.getText() + " ";
            input.setText(expressionString);
        }
        else if (e.getSource() == minusButton) {
            expressionString += " " + minusButton.getText() + " ";
            input.setText(expressionString);
        }
        else if (e.getSource() == openParaButton) {
            expressionString += openParaButton.getText();
            input.setText(expressionString);
        }
        else if (e.getSource() == closeParaButton) {
            expressionString += closeParaButton.getText();
            input.setText(expressionString);
        }
        else if (e.getSource() == clearButton) {
            expressionString = " ";
            input.setText(expressionString);
        }

        c.gridx = 5;
        c.gridy = 1;
        c.weightx = .5;
        c.weighty = .5;
        calcPane.add(input);

        c.gridx = 5;
        c.gridy = 0;
        c.weightx = .5;
        c.weighty = .5;
        inputHistory.setText(expressionString);
        calcPane.add(inputHistory, c);

        add(calcPane);

        System.out.println(expressionString);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static int evaluateExpression(String expression) {
        //operandstack to store operands
        Stack<Integer> operandStack = new Stack<>();

        //operatorStack to store operators
        Stack<Character> operatorStack = new Stack<>();

        //insert blanks around (,), +, -, /, and *
        expression = insertBlanks(expression);

        //extract operands and operators
        String[] tokens = expression.split(" ");

        //phase 1 scan tokens
        for (String token: tokens) {
            if (token.length() == 0) { //blank space
                continue; //back to for loop
            } else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                // process all +, -, *, / in the top of the operator stack
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' ||
                        operatorStack.peek() == '-' ||
                        operatorStack.peek() == '*' ||
                        operatorStack.peek() == '/')) {
                    processAnOperator(operandStack, operatorStack);
                }

                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                //process any mult and divide in top of operator stack
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' ||
                        operatorStack.peek() == '/')) {
                    processAnOperator(operandStack, operatorStack);
                }

                //push the * or / onto the operator stack
                operatorStack.push(token.charAt(0));
            } else if (token.trim().charAt(0) == '(') {
                operatorStack.push('(');
            } else if (token.trim().charAt(0) == ')') {
                //process all operators in stack util seeing )
                while (operandStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);
                }

                operatorStack.push(token.charAt(0));
            } else { //operand scanned
                //push operand to the stack
                operandStack.push(new Integer(token));
            }
        } //end for loop

        //phase 2 process all remaining operators
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }

        //return answer
        return operandStack.pop();
    }

    public static void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();

        if (op == '+') {
            operandStack.push(op2 + op1);
        }
        else if (op == '-') {
            operandStack.push(op2 - op1);
        }
        else if (op == '*') {
            operandStack.push(op2 * op1);
        }
        else if (op == '/') {
            operandStack.push(op2 / op1);
        }
    }

    public static String insertBlanks(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')' ||
                    s.charAt(i) == '+' || s.charAt(i) == '-' ||
                    s.charAt(i) == '*' || s.charAt(i) == '/') {
                result += " " + s.charAt(i) + " ";
            }
            else {
                result += s.charAt(i);
            }
        }

        return result;
    }
}
