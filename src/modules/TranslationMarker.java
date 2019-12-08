package modules;


import Interfaces.Figure;
import affines.Affine;
import affines.Translation;

import java.awt.*;
import java.util.ArrayList;

public class TranslationMarker extends Marker {

    public TranslationMarker(Figure figure, Affine affine) {
        this.affine = affine;
        this.figure = figure;
        center = figure.getCenter();
        keyPoints = new ArrayList<>(4);
        color = Color.GREEN;
    }

    @Override
    public void moveFigure(MyPoint from, MyPoint to) {
        double dx =  (to.x - from.x);
        double dy =  (to.y - from.y);
        Translation t = new Translation(dx, dy);
        affine.transform(figure, t);
    }

}
