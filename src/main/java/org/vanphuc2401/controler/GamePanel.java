package org.vanphuc2401.controler;

import org.vanphuc2401.model.Matrix;
import org.vanphuc2401.service.GameService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class GamePanel extends JPanel implements ActionListener, Serializable {
    private static final long serialVersionUID = 1905122041950251207L;
    private int row;
    private int col;
    private int bound = 2;
    private int size = 50;
    private GameService gameService = new GameService();
    private Matrix matrix;
    private Color backGroundColor = Color.lightGray;

    public GamePanel(int row, int col) {
        this.row = row;
        this.col = col;

        setLayout(new GridLayout(row + 2, col + 2, bound, bound));
        setBackground(backGroundColor);
        setPreferredSize(new Dimension((size + bound) * col, (size + bound)
                * row));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setAlignmentY(Component.CENTER_ALIGNMENT);

        newGame();
    }

    public void newGame() {
        matrix = gameService.createRandomMatrix(this.row, this.col);
        addArrayButton();

    }

    private void addArrayButton() {
        matrix.getPointList().stream().forEach(point -> {
            JButton button = createButton(point.getX() + "," + point.getY());
            if (point.getIcon() != null)
                //            buttons[point.getX()][point.getY()].setIcon(point.getIcon());
                button.setText(String.valueOf(point.getIcon().getIconNumber()));

            add(button);
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
        JButton btn = (JButton) e.getSource();
        String action = btn.getActionCommand();
        int x = Integer.parseInt(action.substring(0, action.indexOf(",")));
        int y = Integer.parseInt(action.substring(action.indexOf(",") + 1, action.length()));
        System.out.println("(" + x + "," + y + ")");
    }
}