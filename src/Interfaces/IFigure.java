package Interfaces;

import modules.MyPoint;
import modules.ScreenConverter;

import java.awt.*;
import java.util.ArrayList;

public interface IFigure {
    ArrayList<MyPoint> getKeyPoints();

    void draw(ScreenConverter screenConverter, IPixelDrawer pd, ILineDrawer ld, Color color);
    MyPoint getCenter();
}
