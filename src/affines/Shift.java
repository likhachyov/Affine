package affines;

import Interfaces.Affine;
import modules.MyPoint;

public class Shift implements Affine {

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
    public void transform(MyPoint point, MyPoint relativeCenter) {
        double oldX = point.x;
        point.x = point.x + (point.y - relativeCenter.y) * shiftY;
        point.y = (oldX - relativeCenter.x) * shiftX + point.y;

    }
}