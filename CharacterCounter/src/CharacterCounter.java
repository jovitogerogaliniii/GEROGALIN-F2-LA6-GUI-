import javax.swing.*;
import java.awt.event.*;

public class CharacterCounter extends JFrame{
    private JPanel CharacterCounterPanel;
    private JTextArea messageTextArea;
    private JTextField characterTextField;
    private JButton countButton;
    private JLabel countLabel;

    public CharacterCounter(){
        setContentPane(CharacterCounterPanel);
        setTitle("Character Counter");
        setSize(400, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        messageTextArea.setName("messageTextArea");
        characterTextField.setName("characterTextField");
        countButton.setName("countButton");
        countLabel.setName("countLabel");
        countButton.setText("Count");
        countLabel.setText("0");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int counter = 0;
                String message = messageTextArea.getText();
                for(int i = 0; i < message.length(); i++){
                    if(Character.toLowerCase(message.charAt(i)) == Character.toLowerCase(characterTextField.getText().charAt(0))){
                        counter++;
                    }
                }
                countLabel.setText(String.valueOf(counter));
            }
        });
    }

    static void main(String[] args) {
        new CharacterCounter();
    }
}
