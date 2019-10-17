package affines;

import Interfaces.IAffine;
import modules.MyPoint;

public class Rotate implements IAffine {

    private double alpha;

    public Rotate(int alpha) {
        this.alpha = Math.toRadians(alpha);
    }

    public Rotate() {
        this.alpha = Math.toRadians(0);
    }

    public void setAlpha(int alpha) {
        this.alpha = Math.toRadians(alpha);
    }

    @Override
    public void transform(MyPoint point) {
        point.x= point.x * Math.cos(alpha) - point.y * Math.sin(alpha);
        point.y = point.x * Math.sin(alpha) + point.y * Math.cos(alpha);

    }
}