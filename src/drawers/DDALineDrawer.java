package drawers;

import Interfaces.LineDrawer;
import Interfaces.PixelDrawer;

import java.awt.*;

public class DDALineDrawer implements LineDrawer {
    @Override
    public void drawLine(PixelDrawer pd, Point p1, Point p2, Color color) {
        double dx = Math.abs(p2.x - p1.x);
        double dy = Math.abs(p2.y - p1.y);
        double D = Math.max(dx, dy);

        if (D == 0) {
            pd.drawPixel(p1.x, p1.y, color);
        }
        double stepX = dx / D;
        double stepY = dy / D;

        for (int i = 0; i <= D; i++) {
            pd.drawPixel(
                    (int) (p1.x + i*stepX),
                    (int) (p1.y + i*stepY),
                    color);
        }
    }
}
