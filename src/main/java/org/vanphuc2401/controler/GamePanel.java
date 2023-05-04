package org.vanphuc2401.controler;

import org.vanphuc2401.model.Matrix;
import org.vanphuc2401.model.Point;
import org.vanphuc2401.service.GameService;
import org.vanphuc2401.utils.IconUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel implements ActionListener, Serializable {
    private static final long serialVersionUID = 1905122041950251207L;
    private final int row;
    private final int col;
    private final List<Point> selectedPoint = new ArrayList<>();
    private final GameService gameService;
    private JButton[][] buttons;
    private Matrix matrix;


    public GamePanel(int row, int col) {
        this.row = row;
        this.col = col;
        gameService = new GameService(row, col);
        setLayout(new GridLayout(row + 2, col + 2, IconUtil.BOUND, IconUtil.BOUND));
        setBackground(IconUtil.BACK_GROUND_COLOR);
        setPreferredSize(new Dimension((IconUtil.SIZE + IconUtil.BOUND) * col, (IconUtil.SIZE + IconUtil.BOUND)
                * row));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setAlignmentY(Component.CENTER_ALIGNMENT);

        newGame();
    }

    public void newGame() {
        matrix = gameService.createRandomMatrix(this.row, this.col);
        addArrayButton();
        gameService.setButtons(buttons);
    }

    private void addArrayButton() {
        buttons = new JButton[row + 2][col + 2];
        matrix.getPointList().forEach(point -> {
            buttons[point.getX()][point.getY()] = createButton(point.getX() + "," + point.getY());
            if (point.getIcon() != null)
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
        JButton btn = (JButton) e.getSource();
        String action = btn.getActionCommand();
        int x = Integer.parseInt(action.substring(0, action.indexOf(",")));
        int y = Integer.parseInt(action.substring(action.indexOf(",") + 1, action.length()));
        if (selectedPoint.size() < 2) {

            Point point = gameService.getPoint(x, y);
            if (point != null) {
                selectedPoint.add(point);
            }
        }
        if (selectedPoint.size() >= 2) {
            Point[] results = gameService.checkTwoPoint(selectedPoint.get(0), selectedPoint.get(1));
            if (results != null) {
                drawLine(results);
                selectedPoint.forEach(p -> {
                    p.removeIcon();
                    setDisable(buttons[p.getX()][p.getY()]);
                });
            }
            selectedPoint.clear();
        }
    }

    private void setDisable(JButton btn) {
        btn.setIcon(null);
        btn.setBackground(IconUtil.BACK_GROUND_COLOR);
        btn.setEnabled(false);
    }

    private void drawLine(Point[] points) {
    }

}