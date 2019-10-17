package affines;

import Interfaces.IAffine;
import Interfaces.IFigure;

public class Affine {

    public void transform(IFigure figure, IAffine affine) {
       figure.getKeyPoints().forEach(affine::transform);
       affine.transform(figure.getCenter());
    }
}
