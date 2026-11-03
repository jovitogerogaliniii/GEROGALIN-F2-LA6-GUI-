import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class SimpleCalculator extends JFrame{
    private JPanel SimpleCalculatorPanel;
    private JTextField tfNumber1;
    private JTextField tfNumber2;
    private JComboBox cbOperations;
    private JButton btnCompute;
    private JLabel lblResult;
    double result;

    public SimpleCalculator(){
        setContentPane(SimpleCalculatorPanel);
        setTitle("Pizza Order System");
        setSize(550, 150);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        SimpleCalculatorPanel.setName("SimpleCalculatorPanel");
        tfNumber1.setName("tfNumber1");
        tfNumber2.setName("tfNumber2");
        cbOperations.setName("cbOperations");
        btnCompute.setName("btnCompute");
        lblResult.setName("lblResult");
        btnCompute.setText("Compute Result");

        DefaultComboBoxModel<Character> cbModel = new DefaultComboBoxModel<>();
        cbModel.addElement('+');
        cbModel.addElement('-');
        cbModel.addElement('*');
        cbModel.addElement('/');
        cbOperations.setModel(cbModel);

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double a = Double.parseDouble(tfNumber1.getText());
                    double b = Double.parseDouble(tfNumber2.getText());
                    String op = String.valueOf(cbOperations.getSelectedItem());
                    switch(op){
                        case "+":
                            result = a + b;
                            break;
                        case "-":
                            result = a-b;
                            break;
                        case "*":
                            result = a*b;
                            break;
                        case "/":
                            if (b == 0){
                                JOptionPane.showMessageDialog(
                                        SimpleCalculator.this,
                                        "Cannot Divide by Zero!",
                                        "Math Error",
                                        JOptionPane.ERROR_MESSAGE
                                );
                                lblResult.setText("ERROR");
                                return;
                            }
                            result = a/b;
                            break;
                    }

                    lblResult.setText(String.valueOf(result));
                    try (FileWriter fw = new FileWriter("results.txt", true); BufferedWriter bw = new BufferedWriter(fw)) {
                         String entry = a + " " + op + " " + b + " = " + result;

                         bw.write(entry);
                         bw.newLine();
                    } catch (IOException ioException) {
                        JOptionPane.showMessageDialog(
                                SimpleCalculator.this,
                                "Error writing output to log file!",
                                "Disk Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } catch(NumberFormatException nfe){
                    tfNumber1.setText("");
                    tfNumber2.setText("");
                    JOptionPane.showMessageDialog(
                            SimpleCalculator.this,
                            "Invalid character detected! Please enter numbers only.",
                            "Format Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }

    static void main(String[] args) {
        new SimpleCalculator();
    }
}
