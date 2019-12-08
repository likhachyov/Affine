package affines;

import Interfaces.Affine;
import modules.MyPoint;

public class Rotate implements Affine {

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
    public void transform(MyPoint point, MyPoint relativeCenter) {
        double oldX = point.x;
        point.x = (point.x - relativeCenter.x) * Math.cos(alpha) - (point.y - relativeCenter.y) * Math.sin(alpha) + relativeCenter.x;
        point.y = (oldX - relativeCenter.x) * Math.sin(alpha) + (point.y - relativeCenter.y) * Math.cos(alpha) + relativeCenter.y;
    }
}