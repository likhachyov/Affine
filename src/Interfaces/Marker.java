package Interfaces;

import affines.Affine;
import modules.MyPoint;
import modules.ScreenConverter;

import java.awt.*;
import java.util.ArrayList;

public abstract class Marker implements Figure {

    private boolean focused;

    public void setFocused(boolean focused) {
        this.focused = focused;
    }

    public int size = 20;
    private MyPoint curPoint;

    public Figure figure;
    public Affine affine;
    public MyPoint center;
    public ArrayList<MyPoint> keyPoints;

    public void setCenter(MyPoint center) {
        this.center = center;
    }

    @Override
    public MyPoint getCenter() {
        return center;
    }

    public ArrayList<MyPoint> getKeyPoints() {
        return keyPoints;
    }

    public void setCurPoint(MyPoint curPoint) {
        this.curPoint = curPoint;
    }

    public MyPoint getCurPoint() {
        return curPoint;
    }

    @Override
    public void draw(ScreenConverter screenConverter, PixelDrawer pd, LineDrawer ld, Color color) {
        for (int i = 0; i < keyPoints.size(); i++) {
            ld.drawLine(pd, screenConverter.realToScreen(keyPoints.get(i)),
                    screenConverter.realToScreen(keyPoints.get((i + 1) % keyPoints.size())), color);
        }
        Point r = screenConverter.realToScreen(center);
        pd.drawPixel(r.x, r.y, color);
    }

    public abstract void moveMarker(MyPoint from, MyPoint to);

    public boolean inside(MyPoint point) {
        if (point.x >= center.x - size && point.x <= center.x + size &&
                point.y <= center.y + size && point.y >= center.y - size)
            return point.x >= center.x - size && point.x <= center.x + size &&
                    point.y <= center.y + size && point.y >= center.y - size;
        else
            return false;
    }

    public boolean isFocused() {
        return focused;
    }
}
