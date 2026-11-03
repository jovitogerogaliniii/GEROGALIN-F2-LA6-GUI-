import javax.swing.*;
import java.awt.event.*;

public class NumberCounter extends JFrame{
    private JPanel NumberCounterPanel;
    private JButton increaseButton;
    private JButton decreaseButton;
    private JLabel countLabel;

    public NumberCounter(){
        setContentPane(NumberCounterPanel);
        setTitle("Number Counter");
        setSize(400, 200);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        increaseButton.setName("increaseButton");
        decreaseButton.setName("decreaseButton");
        countLabel.setName("countLabel");
        increaseButton.setText("Increase");
        decreaseButton.setText("Decrease");
        countLabel.setText("0");
        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(countLabel.getText());
                countLabel.setText(String.valueOf(++n));
            }
        });
        decreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(countLabel.getText());
                countLabel.setText(String.valueOf(--n));
            }
        });
    }


    public static void main(String[] args) {
        new NumberCounter();
    }
}
