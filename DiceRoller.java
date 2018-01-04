import com.sun.deploy.util.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import static jdk.nashorn.internal.runtime.JSType.isNumber;

public class DiceRoller {
    public static void main(String[] args) {
        /*Have a swing GUI that reads in a number of dice to roll
          Select a radio button for which dice is rolled
          Display total on GUI
          Have Reset button to bring back to original page
         */
        createGUI();
    }

    private static void createGUI(){
        JFrame frame = new JFrame("Dice Roller");
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        frame.setLayout(new GridLayout(1,2));

        //Text Field where number of rolled dice is entered
        //Does Not need an action listener here
        JLabel numDiceLabel = new JLabel("Enter Number of Dice to Roll");
        JTextField numDice = new JTextField("1",3);
        panel.add(numDiceLabel);
        panel.add(numDice);

        //Add Radio Buttons for rolling
        ButtonGroup dieAvailable = new ButtonGroup();
        JLabel dieAvailableLabel = new JLabel("Select the die to roll");

        JRadioButton d4 = new JRadioButton("D4");
        d4.setSelected(true);
        dieAvailable.add(d4);

        JRadioButton d6 = new JRadioButton("D6");
        dieAvailable.add(d6);

        JRadioButton d8 = new JRadioButton("D8");
        dieAvailable.add(d8);

        JRadioButton d10 = new JRadioButton("D10");
        dieAvailable.add(d10);

        JRadioButton d12 = new JRadioButton("D12");
        dieAvailable.add(d12);

        JRadioButton d20 = new JRadioButton("D20");
        dieAvailable.add(d20);

        //Add buttons to panel
        panel2.add(d4);
        panel2.add(d6);
        panel2.add(d8);
        panel2.add(d10);
        panel2.add(d12);
        panel2.add(d20);

        //Area where result is displayed
        JTextField results = new JTextField("Results",7);
        results.setEditable(false);
        panel3.add(results);

        //Need a Button that will submit the information entered
        JButton rollButton = new JButton("Roll Dice");
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numberOfDice = numDice.getText();
                if(isNumber(numberOfDice)){
                    int dice = Integer.parseInt(numberOfDice);

                    if(d4.isSelected()){
                        int total = diceRoller(dice,4);
                        results.setText(""+total);
                    }
                    else if(d6.isSelected()){
                        int total = diceRoller(dice,6);
                        results.setText(""+total);
                    }
                    else if(d8.isSelected()){
                        int total = diceRoller(dice,8);
                        results.setText(""+total);
                    }
                    else if(d10.isSelected()){
                        int total = diceRoller(dice,10);
                        results.setText(""+total);
                    }
                    else if(d12.isSelected()){
                        int total = diceRoller(dice,12);
                        results.setText(""+total);
                    }
                    else{
                        int total = diceRoller(dice,20);
                        results.setText(""+total);
                    }
                }
                else{
                    results.setText("Invalid Number of Dice");
                }
            }
        });
        panel3.add(rollButton);

        //Add panel to frame and set up display
        frame.add(panel);
        frame.add(panel2);
        frame.add(panel3);
        frame.setSize(360,150);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static int diceRoller(int numDice, int diceValue){
        int total = 0;

        for(int i = 0;i<numDice;i++){
            total += getRandomNumber(1,diceValue);
        }

        return total;
    }

    private static int getRandomNumber(int min, int max){
        Random num = new Random();
        int rolled = 0;
        while(rolled == 0) {
            rolled = num.nextInt(((max - min) + 1) + min);
        }
        return rolled;
    }
}
