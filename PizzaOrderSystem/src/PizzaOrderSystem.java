import javax.swing.*;
import java.awt.event.*;

public class PizzaOrderSystem extends JFrame{
    private JPanel PizzaOrderSystemPanel;
    private JComboBox pizzaSizeChoice;
    private JComboBox pizzaToppingsChoice;
    private JComboBox extraCheeseChoice;
    private JButton calculateButton;
    private JLabel totalLabel;

    public PizzaOrderSystem(){
        setContentPane(PizzaOrderSystemPanel);
        setTitle("Pizza Order System");
        setSize(500, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pizzaSizeChoice.setName("pizzaSizeChoice");
        pizzaToppingsChoice.setName("pizzaSizeChoice");
        extraCheeseChoice.setName("extraCheeseChoice");
        calculateButton.setName("calculateButton");
        totalLabel.setName("totalLabel");
        calculateButton.setText("Calculate Total");
        totalLabel.setText("0");
        DefaultComboBoxModel<Choices.pizzaSizes> CBModelSizes = new DefaultComboBoxModel<>(Choices.pizzaSizes.values());
        pizzaSizeChoice.setModel(CBModelSizes);
        DefaultComboBoxModel<Choices.pizzaToppings> CBModelToppings = new DefaultComboBoxModel<>(Choices.pizzaToppings.values());
        pizzaToppingsChoice.setModel(CBModelToppings);
        DefaultComboBoxModel<Choices.extraCheese> CBModelCheese = new DefaultComboBoxModel<>(Choices.extraCheese.values());
        extraCheeseChoice.setModel(CBModelCheese);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int total = 0;
                String selectedSize = String.valueOf(pizzaSizeChoice.getSelectedItem());
                String extraCheese = String.valueOf(extraCheeseChoice.getSelectedItem());
                switch(selectedSize){
                    case "Small":
                        total += 10;
                        break;
                    case "Medium":
                        total += 15;
                        break;
                    case "Large":
                        total += 20;
                        break;
                }
                total += 2;
                if (extraCheese.equals("Yes")) {
                    total += 3;
                }
                totalLabel.setText(String.valueOf(total));
            }
        });
    }

    static void main(String[] args) {
        new PizzaOrderSystem();
    }
}
