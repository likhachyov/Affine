package affines;

import Interfaces.Figure;
import modules.MyPoint;

public class Affine {

    public void transform(Figure figure, Interfaces.Affine affine) {
        for (MyPoint keyPoint : figure.getKeyPoints()) {
            affine.transform(keyPoint, figure.getCenter());
        }
        affine.transform(figure.getCenter(), figure.getCenter());
    }
}
