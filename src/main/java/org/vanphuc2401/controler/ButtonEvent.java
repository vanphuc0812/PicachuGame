package org.vanphuc2401.controler;

import org.vanphuc2401.model.Matrix;
import org.vanphuc2401.service.MatrixService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class ButtonEvent extends JPanel implements ActionListener, Serializable {
    private static final long serialVersionUID = 1905122041950251207L;
    private int row;
    private int col;
    private int bound = 2;
    private int size = 50;
    private JButton[][] buttons;
    private MatrixService matrixService = new MatrixService();
    private Matrix matrix;
    private Color backGroundColor = Color.lightGray;

    public ButtonEvent(int row, int col) {
        this.row = row;
        this.col = col;

        setLayout(new GridLayout(row, col, bound, bound));
        setBackground(backGroundColor);
        setPreferredSize(new Dimension((size + bound) * col, (size + bound)
                * row));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setAlignmentY(Component.CENTER_ALIGNMENT);

        newGame();

    }

    public void newGame() {
        matrix = matrixService.createRandomMatrix(this.row, this.col);
        addArrayButton();

    }

    private void addArrayButton() {
        buttons = new JButton[row][col];
        matrix.getPointList().stream().forEach(point -> {
            buttons[point.getX()][point.getY()] = createButton(point.getX() + "," + point.getY());
            buttons[point.getX()][point.getY()].setIcon(point.getIcon());
            add(buttons[point.getX()][point.getY()]);
        });
    }

    private JButton createButton(String action) {
        JButton btn = new JButton();
        btn.setActionCommand(action);
        btn.setBorder(null);
        btn.addActionListener(this);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Do nothing
    }
}