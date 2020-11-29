import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardPanel extends JPanel {
    private int player1Wins = 0; //setting the player wins
    private int player2Wins = 0;
    private int draws = 0;
    private StatsPanel statsPanel; //creating a new statsPanel variable
    private JLabel[] labels = new JLabel[9]; //setting an array of 9 values for the amount of labels in the game
    private int alternate = 0; //giving an int variable to determine player turn as well as number of wins and draws
    public BoardPanel() {
        this.setLayout(new GridLayout(3,3)); //setting the board up
        init();
    }

    /**
     *
     * @param statsPanel sets the parameters of the statsPanel in this class as well as allowing
     *                   it to be called in order to change the player turn as well as the number
     *                   of wins and draws
     */
    public void setStatsPanel(StatsPanel statsPanel) {
        this.statsPanel = statsPanel;
    }

    /**
     * creates the 9 labels for the TTT game as well as giving each of
     * those labels properties that follow the rules of the game
     *
     * this function also sets up the statsPanel to display player turn
     * and player wins as well as draws
     */
    private void init() {
        int n = 9; //sets the number of labels in the game
        JLabel b = null;
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        for (int i=0; i<n; i++) {
            b = new JLabel();
            b.setFont(new Font("Arial", Font.PLAIN, 40)); //setting font for it to be slightly more aesthetic
            b.setText("");
            b.setHorizontalAlignment(SwingConstants.CENTER);
            if (i == 0 || i == 1 || i == 3 || i == 4) {
                b.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.BLACK));
            } else if (i == 2 || i == 5) {
                b.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
            } else if (i == 6 || i == 7) {
                b.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
            } else if (i == 8){
                b.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
            }
            b.setPreferredSize(new Dimension(100, 100));
            b.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JLabel jb = (JLabel)e.getSource();
                    if (!jb.getText().equals("")) {
                        return;                         //stops after there is some text on the labels
                    }
                    String currentPlayer = "";
                    if ( alternate%2 == 0 ) {
                        jb.setText("X");
                        currentPlayer = "P1";
                    } else {
                        jb.setText("O");
                        currentPlayer = "P2";                           //this entire section is giving the labels properties after clicking
                    }
                    if (currentPlayer.equals("P1")) {
                        statsPanel.setLabelTurnText("P2's turn");
                    } else {
                        statsPanel.setLabelTurnText("P1's turn");
                    }
                    alternate++;
                    if (checkWin()) {
                        JOptionPane.showMessageDialog(null, currentPlayer +" Wins! Game over"); //ends the game as well as resets the board
                        if(currentPlayer.equals("P1")) {
                            player1Wins++;
                        } else {
                            player2Wins++;
                        }
                        reset();
                        statsPanel.setLabelWinsText(player1Wins, player2Wins, draws);
                    } else if (alternate == 9){
                        JOptionPane.showMessageDialog(null, "Draw! Game over"); //same thing
                        draws++;
                        reset();
                        statsPanel.setLabelWinsText(player1Wins, player2Wins, draws);
                    }
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
            });
            labels[i]=b;
            this.add(labels[i]);
        }
    }

    /**
     * reset's the labels to be clear as well as sets the statsPanel display to show that it is P1's turn again
     */
    public void reset() {
        for(int i=0; i<9; i++) {
            labels[i].setText("");
        }
        alternate = 0;
        statsPanel.setLabelTurnText("P1's turn");
    }

    private int[][] checkPoints = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {2,4,6}, {0,4,8}}; //conditions that need to be achieved to win the game

    /**
     * this function uses the checkEquals function to check each of the
     * win conditions and if the win conditions are met that means a player has won
     *
     * @return's the function to be true or false depending on whether the game's win
     * conditions have been met
     */
    private boolean checkWin() {
        for (int i= 0; i<checkPoints.length; i++) {
            if (checkEquals(checkPoints[i][0], checkPoints[i][1], checkPoints[i][2])) {
                return true;
            }
        }
       return false;
    }

    /**
     * sets up the rules of the game by giving the arrays rules to follow under the parameters
     * which are defined to be each of the labels used
     */
    public boolean checkEquals(int b1, int b2, int b3){
        if(!labels[b1].getText().equals("")&&labels[b1].getText().equals(labels[b2].getText())&&labels[b2].getText().equals(labels[b3].getText())) {
            return true;
        }
        return false;
    }
}
