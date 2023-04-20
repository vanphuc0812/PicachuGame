package org.vanphuc2401.controler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener, Runnable {
    private int row;
    private int col;
    private int width;
    private int height;
    private ButtonEvent graphicsPanel;
    private JPanel mainPanel;

    public MainFrame(int row, int col, int width, int height) {
        this.row = row;
        this.col = col;
        this.width = width;
        this.height = height;
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
        return panel;
    }

    private JPanel createGraphicsPanel() {
        graphicsPanel = new ButtonEvent(row, col);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.gray);
        panel.add(graphicsPanel);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }


    @Override
    public void run() {
    }
}