package modules;

import Interfaces.Figure;
import Interfaces.LineDrawer;
import Interfaces.PixelDrawer;
import affines.Affine;
import modules.MyPoint;
import modules.ScreenConverter;

import java.awt.*;
import java.util.ArrayList;

public abstract class Marker implements Figure {

    private boolean focused;
    protected Color color = Color.RED;
    public void setFocused(boolean focused) {
        this.focused = focused;
    }

    public int size = 10;
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
        keyPoints.clear();
        keyPoints.add(new MyPoint(center.getX() - size, center.getY() - size)); //  каждый пересчитываем. где рисовать маркер
        keyPoints.add(new MyPoint(center.getX() - size, center.getY() + size));
        keyPoints.add(new MyPoint(center.getX() + size, center.getY() + size));
        keyPoints.add(new MyPoint(center.getX() + size, center.getY() - size));
        for (int i = 0; i < keyPoints.size(); i++) {
            ld.drawLine(pd, screenConverter.realToScreen(keyPoints.get(i)),
                    screenConverter.realToScreen(keyPoints.get((i + 1) % keyPoints.size())), this.color);
        }
    }

    public abstract void moveFigure(MyPoint from, MyPoint to);

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
