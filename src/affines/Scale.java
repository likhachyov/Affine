package affines;

import Interfaces.Affine;
import modules.MyPoint;

public class Scale implements Affine {

    private double a, b;

    public Scale(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Scale() {
        this.a = 1;
        this.b = 1;
    }



    @Override
    public void transform(MyPoint point, MyPoint relativeCenter) {
        point.x *= a;
        point.y *= b;
    }
}