package modules;

import Interfaces.Figure;
import affines.Affine;
import affines.Rotate;

import java.awt.*;
import java.util.ArrayList;

public class RotateMarker extends Marker {

    public RotateMarker(Figure figure, Affine affine, MyPoint center) {
        this.affine = affine;
        this.figure = figure;
        this.center = center;
        keyPoints = new ArrayList<>(4);
        color = Color.BLUE;
    }

    @Override
    public void moveFigure(MyPoint from, MyPoint to) {
        double dx1 = from.x - figure.getCenter().x;
        double dy1 = from.y - figure.getCenter().y;
        double dx2 = to.x - figure.getCenter().x;
        double dy2 = to.y - figure.getCenter().y;
        double k1 = Math.tan(dy1 / dx1);
        double k2 = Math.tan(dy2 / dx2);
        double alpha = Math.atan((k2 - k1) / (1 + k2 * k1));

//        Rotate rotate = new Rotate((int)Math.ceil(Math.toDegrees( alpha)));
        Rotate rotate = new Rotate(0);
        if (alpha > 0)
            rotate.setAlpha(1);
        else if (alpha < 0)
            rotate.setAlpha(-1);

        affine.transform(figure, rotate);
    }
}
