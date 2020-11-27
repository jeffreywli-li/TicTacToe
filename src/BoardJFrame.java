import javax.swing.*;
import java.awt.*;

public class BoardJFrame extends JFrame {
    private StatsPanel statsPanel;
    private BoardPanel boardPanel;

    public BoardJFrame() {
        boardPanel = new BoardPanel();
        statsPanel = new StatsPanel(boardPanel);
        boardPanel.setStatsPanel(statsPanel);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.getContentPane().add(statsPanel, BorderLayout.NORTH);
        this.getContentPane().add(boardPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        pack();
        setBounds(480,580,480,480);
        setVisible(true);
    }
    public static void main(String[] args) {
        new BoardJFrame();
    }
}
