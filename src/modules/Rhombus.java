package modules;

import Interfaces.IFigure;
import Interfaces.ILineDrawer;
import Interfaces.IPixelDrawer;

import java.awt.*;
import java.util.ArrayList;

public class Rhombus implements IFigure {

    private MyPoint center;
    private ArrayList<MyPoint> keyPoints;

    public Rhombus(MyPoint center, double width, double height) {
        this.center = center;
        keyPoints = new ArrayList<>(4);
        keyPoints.add(new MyPoint(center.getX() - width / 2, center.getY()));
        keyPoints.add(new MyPoint(center.getX(), center.getY() + height / 2));
        keyPoints.add(new MyPoint(center.getX() + width / 2, center.getY()));
        keyPoints.add(new MyPoint(center.getX(), center.getY() - height / 2));
    }

    @Override
    public ArrayList<MyPoint> getKeyPoints() {
        return this.keyPoints;
    }

    @Override
    public void draw(ScreenConverter screenConverter, IPixelDrawer pd, ILineDrawer ld, Color color) {
        for (int i = 0; i < keyPoints.size(); i++) {
            ld.drawLine(pd, screenConverter.realToScreen(keyPoints.get(i)),
                    screenConverter.realToScreen(keyPoints.get((i + 1) % keyPoints.size())), color);
        }
    }

    @Override
    public MyPoint getCenter() {
        return center;
    }
}