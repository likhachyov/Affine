package modules;

import Interfaces.Figure;
import Interfaces.Marker;
import affines.Affine;
import affines.Rotate;

import java.util.ArrayList;

public class RotateMarker extends Marker {
    public RotateMarker(Figure figure, Affine affine) {
        this.affine = affine;
        this.figure = figure;
        center = figure.getKeyPoints().get(0);
        keyPoints = new ArrayList<>(4);
        keyPoints.add(new MyPoint(center.getX() - size, center.getY() - size));
        keyPoints.add(new MyPoint(center.getX() - size, center.getY() + size));
        keyPoints.add(new MyPoint(center.getX() + size, center.getY() + size));
        keyPoints.add(new MyPoint(center.getX() + size, center.getY() - size));
    }

    @Override
    public void moveMarker(MyPoint from, MyPoint to) {
        int dx = (int) (to.x - from.x);
        int dy = (int) (to.y - from.y);
        int alpha = (int) Math.atan((to.x - from.x)/(to.y - from.y));
        Rotate t = new Rotate(alpha);
        affine.transform(figure, t);
        affine.transform(this, t);
    }
}
