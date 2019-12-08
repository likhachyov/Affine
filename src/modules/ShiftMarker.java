package modules;

import Interfaces.Figure;
import affines.Affine;
import affines.Shift;

import java.awt.*;
import java.util.ArrayList;

public class ShiftMarker extends Marker {

    private int index;

    public ShiftMarker(Figure figure, Affine affine, MyPoint center, int index) {
        this.affine = affine;
        this.figure = figure;
        this.center = center;
        keyPoints = new ArrayList<>(4);
        this.index = index;
        color = Color.orange;
    }

    @Override
    public void moveFigure(MyPoint from, MyPoint to) {
        double dx = (to.x - from.x);
        double dy = (to.y - from.y);

        Shift shift = new Shift();
        if (index == 0) {
            if (dx > 0 && dy > 0) {
                shift.setShiftX(-0.01);
                shift.setShiftY(-0.01);
            } else if (dx < 0 && dy < 0) {
                shift.setShiftX(0.01);
                shift.setShiftY(0.01);
            }
        }
        else if (index == 1){
            if (dx <= 0 && dy >= 0){
                shift.setShiftX(-0.01);
                shift.setShiftY(-0.01);
            }
            else if (dx >= 0 && dy <= 0){
                shift.setShiftX(0.01);
                shift.setShiftY(0.01);
            }
        }
        else if (index == 2){
            if (dx > 0 && dy > 0) {
                shift.setShiftX(0.01);
                shift.setShiftY(0.01);
            } else if (dx < 0 && dy < 0) {
                shift.setShiftX(-0.01);
                shift.setShiftY(-0.01);
            }
        }
        else if (index == 3){
            if (dx >= 0 && dy <= 0){
                shift.setShiftX(-0.01);
                shift.setShiftY(-0.01);
            }
            else if (dx <= 0 && dy >= 0){
                shift.setShiftX(0.01);
                shift.setShiftY(0.01);
            }
        }
        affine.transform(figure, shift);
    }
}
