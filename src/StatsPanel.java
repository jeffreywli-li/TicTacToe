import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatsPanel extends JPanel {
    private JLabel labelTurn;
    private JLabel labelWins;
    int player1 = 0;
    int player2 = 0;
    int draws = 0;

    private BoardPanel boardPanel;

    private void Turn() {
        int n = 9;
        for (int i=0; i<n; i++) {
            if (i%2 == 0) {
                ;
            }
            else {
                ;
            }
        }
    }

    public StatsPanel() {

    }
    public StatsPanel(BoardPanel boardPanel) {
        this.setBackground(Color.RED);
        this.setLayout(new GridLayout(1,3));
        this.setMaximumSize(new Dimension(470, 100));
        JButton newButton = new JButton();
        newButton.setText("New Game");
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                BoardPanel boardPanel = new BoardPanel();
                boardPanel.reset();
            }
        });
        this.add(newButton);
        labelTurn = new JLabel();
        labelTurn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        labelTurn.setText("P1's turn");
        this.add(labelTurn);

        labelWins = new JLabel();
        labelWins.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        labelWins.setText("<html>P1's Wins: " + player1 + "<br/>" + "P2's Wins: " + player2 + "<br/>" + "Draws: " + draws + "</html>");
        this.add(labelWins);
    }

    public void setLabelTurnText(String turnText) {
        labelTurn.setText(turnText);
    }
    public void setLabelWinsText(int p1, int p2, int draws) {
        String t = "<html>P1's Wins: " + p1+ "<br/>" + "P2's Wins: " + p2 + "<br/>" + "Draws: " + draws + "</html>";
        labelWins.setText(t);
    }
    public int setPlayer1(){
        player1++;
        return player1;
    }
    public int setPlayer2(){
        player2++;
        return player2;
    }
}
