package Interfaces;

import modules.MyPoint;
import modules.ScreenConverter;

import java.awt.*;
import java.util.ArrayList;

public interface Figure {
    ArrayList<MyPoint> getKeyPoints();

    void draw(ScreenConverter screenConverter, PixelDrawer pd, LineDrawer ld, Color color);

    MyPoint getCenter();

    default MyPoint getCenterOnLine(MyPoint p1, MyPoint p2){
        double dx = (p1.x - p2.x);
        double dy = (p1.y - p2.y);
        return new MyPoint(dx / 2, dy / 2);
    }
}
