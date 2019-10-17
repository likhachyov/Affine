package affines;

import Interfaces.IAffine;
import modules.MyPoint;

public class Shift implements IAffine {

    private double shiftX, shiftY;

    public Shift(double shiftX, double shiftY) {
        this.shiftX = shiftX;
        this.shiftY = shiftY;
    }

    public Shift() {
        this.shiftX = 0;
        this.shiftY = 0;
    }

    public void setShiftX(double shiftX) {
        this.shiftX = shiftX;
    }

    public void setShiftY(double shiftY) {
        this.shiftY = shiftY;
    }

    @Override
    public void transform(MyPoint point) {
        point.x = point.x + point.y * shiftY;
        point.y = point.x * shiftX + point.y;

    }
}