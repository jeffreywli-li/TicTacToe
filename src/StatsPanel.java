import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatsPanel extends JPanel {
    private JLabel labelTurn; //creating labels for the player turn and player wins and draws
    private JLabel labelWins;
    int player1 = 0; //setting the initial display of the number of wins and draws
    int player2 = 0;
    int draws = 0;

    private BoardPanel boardPanel;

    /**
     * sets the entire stats panel at the top of the frame to keep track of
     * player turn and player wins and total draws
     *
     * there is also a button that calls the reset function in BoardPanel
     * and it is used to reset the board and make a new game
     */
    public StatsPanel(BoardPanel boardPanel) {
        this.setLayout(new GridLayout(1,3));
        this.setMaximumSize(new Dimension(470, 100));
        JButton newButton = new JButton();
        newButton.setText("New Game");
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boardPanel.reset();
            }
        });
        this.add(newButton);
        labelTurn = new JLabel();
        labelTurn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        labelTurn.setText("P1's turn");
        labelTurn.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(labelTurn);

        labelWins = new JLabel();
        labelWins.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        labelWins.setText("<html>P1's Wins: " + player1 + "<br/>" + "P2's Wins: " + player2 + "<br/>" + "Draws: " + draws + "</html>");
        labelWins.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(labelWins);
    }

    /**
     * shows the player turn's text on the label which is used in
     * the BoardPanel as a function
     */
    public void setLabelTurnText(String turnText) {
        labelTurn.setText(turnText);
    }

    /**
     * when called to BoardPanel, this function along with it's parameters
     * allows the program to keep track of the number of wins and draws
     * that have occurred in the game
     */
    public void setLabelWinsText(int p1, int p2, int draws) {
        String t = "<html>P1's Wins: " + p1+ "<br/>" + "P2's Wins: " + p2 + "<br/>" + "Draws: " + draws + "</html>";
        labelWins.setText(t);
    }
}
