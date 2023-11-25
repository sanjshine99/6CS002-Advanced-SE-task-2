/**
 * The Location class represents a specific position in a grid, defined by row and column coordinates.
 * It also includes an optional direction. This class provides methods for obtaining user input,
 * generating string representations, and drawing grid lines for visualization.
 */

package base;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Location extends SpacePlace {
    public int c;
    public int r;
    public DIRECTION d;
    public int tmp;

    public Location(int r, int c) {
        this.r = r;
        this.c = c;
    }

    ;

    public Location(int r, int c, DIRECTION d) {
        this(r, c);
        this.d = d;
    }

    public static int getInt() {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                return Integer.parseInt(r.readLine());
            } catch (Exception e) {
            }
        } while (true);
    }

    public String toString() {
        if (d == null) {
            tmp = c + 1;
            return "(" + (tmp) + "," + (r + 1) + ")";
        } else {
            tmp = c + 1;
            return "(" + (tmp) + "," + (r + 1) + "," + d + ")";
        }
    }

    public void drawGridLines(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        for (tmp = 0; tmp <= 7; tmp++) {
            g.drawLine(20, 20 + tmp * 20, 180, 20 + tmp * 20);
        }
        for (int see = 0; see <= 8; see++) {
            g.drawLine(20 + see * 20, 20, 20 + see * 20, 160);
        }
    }

    public enum DIRECTION {VERTICAL, HORIZONTAL}
}
