import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SudokuGame extends JFrame {

    JTextField[][] cells = new JTextField[9][9];

    int[][] solution = {
        {5,3,4,6,7,8,9,1,2},
        {6,7,2,1,9,5,3,4,8},
        {1,9,8,3,4,2,5,6,7},
        {8,5,9,7,6,1,4,2,3},
        {4,2,6,8,5,3,7,9,1},
        {7,1,3,9,2,4,8,5,6},
        {9,6,1,5,3,7,2,8,4},
        {2,8,7,4,1,9,6,3,5},
        {3,4,5,2,8,6,1,7,9}
    };

    int[][] puzzle = {
        {5,3,0,0,7,0,0,0,0},
        {6,0,0,1,9,5,0,0,0},
        {0,9,8,0,0,0,0,6,0},
        {8,0,0,0,6,0,0,0,3},
        {4,0,0,8,0,3,0,0,1},
        {7,0,0,0,2,0,0,0,6},
        {0,6,0,0,0,0,2,8,0},
        {0,0,0,4,1,9,0,0,5},
        {0,0,0,0,8,0,0,7,9}
    };

    public SudokuGame() {
        setTitle("Sudoku Game");
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(9, 9));

        Font font = new Font("Arial", Font.BOLD, 20);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j] = new JTextField();
                cells[i][j].setHorizontalAlignment(JTextField.CENTER);
                cells[i][j].setFont(font);

                if (puzzle[i][j] != 0) {
                    cells[i][j].setText(String.valueOf(puzzle[i][j]));
                    cells[i][j].setEditable(false);
                    cells[i][j].setBackground(Color.LIGHT_GRAY);
                }

                gridPanel.add(cells[i][j]);
            }
        }

        JPanel buttonPanel = new JPanel();

        JButton checkBtn = new JButton("Check");
        JButton resetBtn = new JButton("Reset");

        buttonPanel.add(checkBtn);
        buttonPanel.add(resetBtn);

        add(gridPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Check Button Action
        checkBtn.addActionListener(e -> checkSolution());

        // Reset Button Action
        resetBtn.addActionListener(e -> resetGame());

        setVisible(true);
    }

    void checkSolution() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String text = cells[i][j].getText();

                if (text.isEmpty() || Integer.parseInt(text) != solution[i][j]) {
                    JOptionPane.showMessageDialog(this, "❌ Incorrect Solution!");
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(this, "✅ Correct Solution!");
    }

    void resetGame() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (puzzle[i][j] == 0) {
                    cells[i][j].setText("");
                }
            }
        }
    }

    public static void main(String[] args) {
        new SudokuGame();
    }
}