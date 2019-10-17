package affines;

import Interfaces.IAffine;
import modules.MyPoint;

public class Translation implements IAffine {

    private double a, b;

    public Translation(int a, int b) {
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
    public void transform(MyPoint point) {
        point.x += a;
        point.y += b;
    }
}
