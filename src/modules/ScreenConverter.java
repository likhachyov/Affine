package modules;

import java.awt.*;

public class ScreenConverter {
    private double realWidth, realHeight;
    private int screenWidth, screenHeight;
    private int screenCenterX, screenCenterY;


    public ScreenConverter(double realWidth, double realHeight, int screenWidth, int screenHeight) {
        this.realWidth = realWidth;
        this.realHeight = realHeight;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.screenCenterX = screenWidth / 2;
        this.screenCenterY = screenHeight / 2;
    }

    public Point realToScreen(MyPoint p) {
        int x = (int) (screenCenterX + screenWidth * p.getX() / realWidth);
        int y = (int) (screenCenterY - screenHeight * p.getY() / realHeight);
        return new Point(x, y);
    }

    public MyPoint screenToReal(Point p) {
        double x = (p.x - screenCenterX) * realWidth / screenWidth;
        double y = (screenCenterY - p.y) * realHeight / screenHeight;
        return new MyPoint(x, y);
    }
}
