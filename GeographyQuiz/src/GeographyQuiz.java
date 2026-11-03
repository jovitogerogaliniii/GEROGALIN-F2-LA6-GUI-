import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeographyQuiz extends JFrame{
    private JPanel panel1;
    private JPanel panel12;
    private JPanel panel13;
    private JPanel panel14;
    private JTextField question1TextField;
    private JTextField question2TextField;
    private JTextField question3TextField;
    private JPanel wrapperPanel;
    private JButton nextButton;
    private JButton backButton;
    private JPanel panelContainers;
    private JLabel scoreLabel;
    private int currentIndex = 1;
    private int score = 0;
    private final boolean[] pointQuestion = new boolean[3];

    public GeographyQuiz(){
        setContentPane(wrapperPanel);
        setTitle("Geography Quiz");
        setSize(400, 200);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel1.setName("panel1");
        panel12.setName("panel12");
        panel13.setName("panel13");
        panel14.setName("panel14");
        question1TextField.setName("question1TextField");
        question2TextField.setName("question2TextField");
        question3TextField.setName("question3TextField");
        nextButton.setName("nextButton");
        backButton.setName("backButton");
        nextButton.setText("Next");
        backButton.setText("Back");
        backButton.setVisible(false);

        CardLayout panelManager = (CardLayout) panelContainers.getLayout();
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentIndex++;
                if(currentIndex > 1){
                    backButton.setVisible(true);
                }
                if(currentIndex == 4){
                    nextButton.setVisible(false);
                }
                if (question1TextField.getText().equals("Paris")){
                    if(!pointQuestion[0]){
                        score++;
                        pointQuestion[0] = true;
                    }
                   scoreLabel.setText(String.valueOf(score) + "/3");
                }
                if (question2TextField.getText().equals("Tokyo")){
                    if(!pointQuestion[1]){
                        score++;
                        pointQuestion[1] = true;
                    }
                    scoreLabel.setText(String.valueOf(score) + "/3");
                }
                if (question3TextField.getText().equals("Berlin")){
                    if(!pointQuestion[2]){
                        score++;
                        pointQuestion[2] = true;
                    }
                    scoreLabel.setText(String.valueOf(score) + "/3");
                }
                panelManager.show(panelContainers, "Card" + currentIndex);
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentIndex--;
                if(currentIndex == 1){
                    backButton.setVisible(false);
                }
                if(currentIndex < 4){
                    nextButton.setVisible(true);
                }
                panelManager.show(panelContainers, "Card" + currentIndex);
            }
        });
    }


    static void main(String[] args) {
        new GeographyQuiz();
    }
}
