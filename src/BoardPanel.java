import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardPanel extends JPanel {
    private int player1Wins = 0;
    private int player2Wins = 0;
    private int draws = 0;
    private StatsPanel statsPanel;
    private JButton[] buttons = new JButton[9];
    private int alternate = 0;
    public BoardPanel() {
        this.setLayout(new GridLayout(3,3));
        init();
    }

    public void setStatsPanel(StatsPanel statsPanel) {
        this.statsPanel = statsPanel;
    }

    private void init() {
        int n = 9;
        JButton b = null;
        for (int i=0; i<n; i++) {
            b = new JButton();
            b.setText("");
            b.setPreferredSize(new Dimension(100, 100));
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton jb = (JButton)e.getSource();
                    if (!jb.getText().equals("")) {
                        return;
                    }
                    String currentPlayer = "";
                    if ( alternate%2 == 0 ) {
                        jb.setText("X");
                        currentPlayer = "P1";
                    } else {
                        jb.setText("O");
                        currentPlayer = "P2";
                    }
                    if (currentPlayer.equals("P1")) {
                        statsPanel.setLabelTurnText("P2's turn");
                    } else {
                        statsPanel.setLabelTurnText("P1's turn");
                    }
                    alternate++;
                    if (checkWin()) {
                        JOptionPane.showMessageDialog(null, currentPlayer +" Wins! Game over");
                        if(currentPlayer.equals("P1")) {
                            player1Wins++;
                        } else {
                            player2Wins++;
                        }
                        reset();
                        statsPanel.setLabelWinsText(player1Wins, player2Wins, draws);
                    } else if (alternate == 9){
                        JOptionPane.showMessageDialog(null, "Draw! Game over");
                        draws++;
                        reset();
                        statsPanel.setLabelWinsText(player1Wins, player2Wins, draws);
                    }
                };
            });
            buttons[i]=b;
            this.add(buttons[i]);
        }
    }
    public void reset() {
        for(int i=0; i<9; i++) {
            buttons[i].setText("");
        }
        alternate = 0;
        statsPanel.setLabelTurnText("P1's turn");
    }
    private int[][] checkPoints = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {2,4,6}, {0,4,8}};
    private boolean checkWin() {
        for (int i= 0; i<checkPoints.length; i++) {
            if (checkEquals(checkPoints[i][0], checkPoints[i][1], checkPoints[i][2])) {
                return true;
            }
        }
       return false;
    }
    public boolean checkEquals(int b1, int b2, int b3){
        if(!buttons[b1].getText().equals("")&&buttons[b1].getText().equals(buttons[b2].getText())&&buttons[b2].getText().equals(buttons[b3].getText())) {
            return true;
        }
        return false;
    }
}
