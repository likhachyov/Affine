package modules;


import Interfaces.IFigure;
import Interfaces.IMarker;
import affines.Affine;
import affines.Translation;

public class TranslationMarker extends IMarker {

    public TranslationMarker(IFigure figure, Affine affine) {
        super(figure, affine);
    }

    @Override
    public void moveMarker(MyPoint from, MyPoint to) {
        int dx = (int) (to.x - from.x);
        int dy = (int) (to.y - from.y);System.out.println(dx);
        Translation t = new Translation(dx, dy);
        affine.transform(figure, t);
        affine.transform(this, t);
    }

}
