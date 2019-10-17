package affines;

import Interfaces.IAffine;
import modules.MyPoint;

public class Scale implements IAffine {

    private double a, b;

    public Scale(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Scale() {
        this.a = 1;
        this.b = 1;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public void transform(MyPoint point) {
        point.x *= a;
        point.y *= b;
    }
}