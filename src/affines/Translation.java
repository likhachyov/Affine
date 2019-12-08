package affines;

import Interfaces.Affine;
import modules.MyPoint;

public class Translation implements Affine {

    private double a, b;

    public Translation(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Translation() {
        this.a = 0;
        this.b = 0;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public void transform(MyPoint point, MyPoint relativeCenter) {
        point.x += a;
        point.y += b;
    }
}
