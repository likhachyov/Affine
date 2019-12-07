package affines;

import Interfaces.Figure;
import Interfaces.Marker;

public class Affine {

    public void transform(Figure figure, Interfaces.Affine affine) {
       figure.getKeyPoints().forEach(affine::transform);
       affine.transform(figure.getCenter());
    }
}
