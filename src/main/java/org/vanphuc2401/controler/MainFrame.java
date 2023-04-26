package org.vanphuc2401.controler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener, Runnable {
    private int row;
    private int col;
    private GamePanel gamePanel;
    private JLabel lbScore;
    private JProgressBar progressTime;
    private JLabel lbTime;

    private JButton btnNewGame;
    private JPanel mainPanel;
    private ControlPanel controlPanel;

    public MainFrame(int row, int col, int width, int height) {
        this.row = row;
        this.col = col;
        add(mainPanel = createMainPanel());
        setTitle("Pokemon Game");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(createGraphicsPanel(), BorderLayout.CENTER);
        panel.add(createControlPanel(), BorderLayout.EAST);
        return panel;
    }

    private JPanel createGraphicsPanel() {
        gamePanel = new GamePanel(row, col);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.gray);
        panel.add(gamePanel);
        return panel;
    }

    private JPanel createControlPanel() {
        controlPanel = new ControlPanel();
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.gray);
        panel.add(controlPanel);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void run() {
    }
}