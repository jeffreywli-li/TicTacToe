import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class TTTGame extends JFrame {
    /**
     * this sets the frame up for the entire game to be played with all the
     * different classes put together with the title of the game and a
     * unchangeable frame size
     */
    public TTTGame() {
        BoardPanel boardPanel = new BoardPanel();
        StatsPanel statsPanel = new StatsPanel(boardPanel);
        boardPanel.setStatsPanel(statsPanel);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.getContentPane().add(statsPanel, BorderLayout.NORTH); //set's the StatsPanel at the top of the frame
        this.getContentPane().add(boardPanel, BorderLayout.SOUTH); //set's the TTT board at the bottom of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); //makes the frame a fixed size
        setTitle("Tic Tac Toe"); //setting the title of the GUI to TTT
        setBounds(480,580,480,480);
        setVisible(true);
    }
    public static void main(String[] args) {
        new TTTGame();
    }
}