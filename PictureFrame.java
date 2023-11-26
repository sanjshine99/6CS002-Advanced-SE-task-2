/**
 * The PictureFrame class represents the graphical user interface for the Abominodo game.
 * It includes methods for drawing the game grid, dominoes, and other graphical elements.
 * The class is responsible for managing the visual representation of the game during different modes.
 * Note: This class could benefit from further refactoring for improved readability and maintainability.
 */

package base;

import java.awt.*;

import javax.swing.*;


public class PictureFrame {
    public int[] reroll = null;
    public Main master = null;
    public DominoPanel dominoPanel;

    public PictureFrame(Main sourceFrame) {
        master = sourceFrame;
        if (dominoPanel == null) {
            JFrame frame = new JFrame("Abominodo");
            dominoPanel = new DominoPanel();
            frame.setContentPane(dominoPanel);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.setVisible(true);
        }
    }

    public void reset() {
        // TODO Auto-generated method stub

    }

    class DominoPanel extends JPanel {
        private static final long serialVersionUID = 4190229282411119364L;

        public void drawGrid(Graphics graphics) {
            for (int area = 0; area < 7; area++) {
                for (int see = 0; see < 8; see++) {
                    drawDigitGivenCentre(graphics, 30 + see * 20, 30 + area * 20, 20,
                            master.grid[area][see]);
                }
            }
        }


        public void drawHeadings(Graphics graphics) {
            for (int area = 0; area < 7; area++) {
                fillDigitGivenCentre(graphics, 10, 30 + area * 20, 20, area + 1);
            }

            for (int see = 0; see < 8; see++) {
                fillDigitGivenCentre(graphics, 30 + see * 20, 10, 20, see + 1);
            }
        }

        public void drawDomino(Graphics graphics, Domino domino) {
            if (domino.isPlaced) {
                final int CELL_WIDTH = 20;
                final int CELL_HEIGHT = 20;
                final int DIGIT_OFFSET = 10;

                int topY = Math.min(domino.verticalPositionY, domino.horizontalPositionY);
                int topX = Math.min(domino.verticalPositionX, domino.horizontalPositionX);
                int width = Math.abs(domino.verticalPositionX - domino.horizontalPositionX) + 1;
                int height = Math.abs(domino.verticalPositionY - domino.horizontalPositionY) + 1;

                graphics.setColor(Color.WHITE);
                graphics.fillRect(topX * CELL_WIDTH, topY * CELL_HEIGHT, width * CELL_WIDTH, height * CELL_HEIGHT);
        graphics.setColor(Color.RED);
        graphics.drawRect(topX * CELL_WIDTH, topY * CELL_HEIGHT, width * CELL_WIDTH, height * CELL_HEIGHT);

                 drawDigitGivenCentre(graphics,
                topX * CELL_WIDTH + DIGIT_OFFSET,
                topY * CELL_HEIGHT + DIGIT_OFFSET,
                CELL_WIDTH,
                domino.highValue,
                Color.BLUE);

               drawDigitGivenCentre(graphics,
                (topX + width) * CELL_WIDTH - DIGIT_OFFSET,
                (topY + height) * CELL_HEIGHT - DIGIT_OFFSET,
                CELL_WIDTH,
                domino.lowValue,
                Color.BLUE);
            }
        }

        private void drawCenteredDigit(Graphics graphics, int x, int y, int diameter, int number, Color fillColor) {
            int radius = diameter / 2;

            graphics.setColor(fillColor);
            graphics.fillOval(x - radius, y - radius, diameter, diameter);

            graphics.setColor(Color.BLACK);
            graphics.drawOval(x - radius, y - radius, diameter, diameter);

            FontMetrics fm = graphics.getFontMetrics();
            String txt = Integer.toString(number);
            graphics.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
        }

        void drawDigitGivenCentre(Graphics graphics, int x, int y, int diameter, int number) {
            drawCenteredDigit(graphics, x, y, diameter, number, Color.BLACK);
        }

        void fillDigitGivenCentre(Graphics graphics, int x, int y, int diameter, int number) {
            drawCenteredDigit(graphics, x, y, diameter, number, Color.GREEN);
        }


        @Override
        protected void paintComponent(Graphics graphics) {
            graphics.setColor(Color.YELLOW);
            graphics.fillRect(0, 0, getWidth(), getHeight());


            Location location = new Location(1, 2);

            if (master.mode == 1) {
                location.drawGridLines(graphics);
                drawHeadings(graphics);
                drawGrid(graphics);
                master.drawGuesses(graphics);
            }
            if (master.mode == 0) {
                location.drawGridLines(graphics);
                drawHeadings(graphics);
                drawGrid(graphics);
                master.drawDominoes(graphics);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            // the application window always prefers to be 202x182
            return new Dimension(202, 182);
        }
    }

}
