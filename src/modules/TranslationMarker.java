package modules;


import Interfaces.Figure;
import Interfaces.Marker;
import affines.Affine;
import affines.Translation;

import java.util.ArrayList;

public class TranslationMarker extends Marker {

    public TranslationMarker(Figure figure, Affine affine) {
        this.affine = affine;
        this.figure = figure;
        center = figure.getCenter();
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
        Translation t = new Translation(dx, dy);
        affine.transform(figure, t);
        affine.transform(this, t);
    }

}
