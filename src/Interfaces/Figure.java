package Interfaces;

import modules.MyPoint;
import modules.ScreenConverter;

import java.awt.*;
import java.util.ArrayList;

public interface Figure {
    ArrayList<MyPoint> getKeyPoints();

    void draw(ScreenConverter screenConverter, PixelDrawer pd, LineDrawer ld, Color color);
    MyPoint getCenter();
}
