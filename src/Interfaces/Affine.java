package Interfaces;

import modules.MyPoint;

public interface Affine {

    void transform(MyPoint point, MyPoint relativeCenter);
}
