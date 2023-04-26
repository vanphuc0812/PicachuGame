package org.vanphuc2401.controler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel implements ActionListener {

    private JLabel lbScore;
    private JProgressBar progressTime;
    private JButton btnNewGame;

    public ControlPanel() {
        lbScore = new JLabel("0");
        progressTime = new JProgressBar(0, 100);
        progressTime.setValue(100);

        //tạo Panel chứa Score và Time
        JPanel panelLeft = new JPanel(new GridLayout(2, 1, 5, 5));
        panelLeft.add(new JLabel("Score:"));
        panelLeft.add(new JLabel("Time:"));

        JPanel panelCenter = new JPanel(new GridLayout(2, 1, 5, 5));
        panelCenter.add(lbScore);
        panelCenter.add(progressTime);

        JPanel panelScoreAndTime = new JPanel(new BorderLayout(5, 0));
        panelScoreAndTime.add(panelLeft, BorderLayout.WEST);
        panelScoreAndTime.add(panelCenter, BorderLayout.CENTER);

        // tạo Panel mới chứa panelScoreAndTime và nút New Game
        JPanel panelControl = new JPanel(new BorderLayout(10, 10));
        panelControl.setBorder(new EmptyBorder(10, 3, 5, 3));
        panelControl.add(panelScoreAndTime, BorderLayout.CENTER);
        panelControl.add(btnNewGame = createButton("New Game"),
                BorderLayout.PAGE_END);

        setBorder(new TitledBorder("Good luck"));
        add(panelControl, BorderLayout.PAGE_START);

    }
    

    private JButton createButton(String buttonName) {
        JButton btn = new JButton(buttonName);
        btn.addActionListener(this);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
