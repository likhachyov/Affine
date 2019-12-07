package drawers;

import Interfaces.LineDrawer;
import Interfaces.PixelDrawer;

import java.awt.*;

public class BresenhamLineDrawer implements LineDrawer {
    @Override
    public void drawLine(PixelDrawer pd, Point p1, Point p2, Color color) {
        int dx = (p2.x - p1.x >= 0 ? 1 : -1);
        int dy = (p2.y - p1.y >= 0 ? 1 : -1);

        int lengthX = Math.abs(p2.x - p1.x);
        int lengthY = Math.abs(p2.y - p1.y);

        int length = Math.max(lengthX, lengthY);
        int x = p1.x;
        int y = p1.y;
        int d;  // для учета погрешности

        if (lengthY <= lengthX) {
            d = -lengthX;
            for (int i = 0; i <= length; i++) {
                pd.drawPixel(x, y, color);
                x += dx;
                d += 2 * lengthY;
                if (d > 0) {
                    d -= 2 * lengthX;
                    y += dy;
                }
            }
        } else {
            d = -lengthY;
            for (int i = 0; i <= length; i++) {
                pd.drawPixel(x, y, color);
                y += dy;
                d += 2 * lengthX;
                if (d > 0) {
                    d -= 2 * lengthY;
                    x += dx;
                }
            }
        }
    }
}

