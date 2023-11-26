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
    public DominoPanel dp;

    public void PictureFrame(Main sf) {
        master = sf;
        if (dp == null) {
            JFrame f = new JFrame("Abominodo");
            dp = new DominoPanel();
            f.setContentPane(dp);
            f.pack();
            f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            f.setVisible(true);
        }
    }

    public void reset() {
        // TODO Auto-generated method stub

    }

    class DominoPanel extends JPanel {
        private static final long serialVersionUID = 4190229282411119364L;

        public void drawGrid(Graphics g) {
            for (int area = 0; area < 7; area++) {
                for (int see = 0; see < 8; see++) {
                    drawDigitGivenCentre(g, 30 + see * 20, 30 + area * 20, 20,
                            master.grid[area][see]);
                }
            }
        }


        public void drawHeadings(Graphics g) {
            for (int area = 0; area < 7; area++) {
                fillDigitGivenCentre(g, 10, 30 + area * 20, 20, area + 1);
            }

            for (int see = 0; see < 8; see++) {
                fillDigitGivenCentre(g, 30 + see * 20, 10, 20, see + 1);
            }
        }

        public void drawDomino(Graphics g, Domino domino) {
            if (domino.isPlaced) {
                int y = Math.min(domino.verticalPositionY, domino.horizontalPositionY);
                int x = Math.min(domino.verticalPositionX, domino.horizontalPositionX);
                int w = Math.abs(domino.verticalPositionX - domino.horizontalPositionX) + 1;
                int h = Math.abs(domino.verticalPositionY - domino.horizontalPositionY) + 1;
                g.setColor(Color.WHITE);
                g.fillRect(20 + x * 20, 20 + y * 20, w * 20, h * 20);
                g.setColor(Color.RED);
                g.drawRect(20 + x * 20, 20 + y * 20, w * 20, h * 20);
                drawDigitGivenCentre(g, 30 + domino.horizontalPositionX * 20, 30 + domino.horizontalPositionY * 20, 20, domino.highValue,
                        Color.BLUE);
                drawDigitGivenCentre(g, 30 + domino.verticalPositionX * 20, 30 + domino.verticalPositionY * 20, 20, domino.lowValue,
                        Color.BLUE);
            }
        }

        void drawDigitGivenCentre(Graphics g, int x, int y, int diameter, int number) {
            int radius = diameter / 2;
            g.setColor(Color.BLACK);
            FontMetrics fm = g.getFontMetrics();
            String txt = Integer.toString(n);
            g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
        }

        void fillDigitGivenCentre(Graphics g, int x, int y, int diameter, int number) {
            int radius = diameter / 2;
            g.setColor(Color.GREEN);
            g.fillOval(x - radius, y - radius, diameter, diameter);
            g.setColor(Color.BLACK);
            g.drawOval(x - radius, y - radius, diameter, diameter);
            FontMetrics fm = g.getFontMetrics();
            String txt = Integer.toString(n);
            g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
        }

        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.YELLOW);
            g.fillRect(0, 0, getWidth(), getHeight());


            Location l = new Location(1, 2);

            if (master.mode == 1) {
                l.drawGridLines(g);
                drawHeadings(g);
                drawGrid(g);
                master.drawGuesses(g);
            }
            if (master.mode == 0) {
                l.drawGridLines(g);
                drawHeadings(g);
                drawGrid(g);
                master.drawDominoes(g);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            // the application window always prefers to be 202x182
            return new Dimension(202, 182);
        }
    }

}
