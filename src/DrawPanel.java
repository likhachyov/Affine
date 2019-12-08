import Interfaces.Figure;
import Interfaces.LineDrawer;
import affines.Affine;
import drawers.BufferedImagePixelDrawer;
import drawers.WuLineDrawer;
import modules.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DrawPanel extends JPanel implements MouseMotionListener {

    private LineDrawer ld;
    private ScreenConverter screenConverter;
    private Figure figure;
    private Affine affine;
    private ArrayList<Marker> markers;

    public DrawPanel(int width, int height) {
        affine = new Affine();
        ld = new WuLineDrawer();
        screenConverter = new ScreenConverter(width, height, width, height);
        figure = new Rhombus(new MyPoint(0, 0), 300, 500);

        markers = new ArrayList<>();
        markers.add(new TranslationMarker(figure, affine));
        markers.add(new RotateMarker(figure, affine, figure.getKeyPoints().get(0)));
        markers.add(new RotateMarker(figure, affine, figure.getKeyPoints().get(1)));
        markers.add(new RotateMarker(figure, affine, figure.getKeyPoints().get(2)));
        markers.add(new RotateMarker(figure, affine, figure.getKeyPoints().get(3)));
        markers.add(new ShiftMarker(figure, affine, figure.getKeyPoints().get(4), 0));
        markers.add(new ShiftMarker(figure, affine, figure.getKeyPoints().get(5), 1));
        markers.add(new ShiftMarker(figure, affine, figure.getKeyPoints().get(6), 2));
        markers.add(new ShiftMarker(figure, affine, figure.getKeyPoints().get(7), 3));

        setFocusable(true);
        this.addMouseMotionListener(this);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                MyPoint pressedPoint = screenConverter.screenToReal(e.getPoint());

                for (Marker marker : markers) {
                    if (marker.inside(pressedPoint)) {
                        marker.setCurPoint(pressedPoint);
                        marker.setFocused(true);
                    } else
                        marker.setFocused(false);
                }
            }
        });
        addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (e.getPreciseWheelRotation() < 0) {
                    screenConverter.increaseRealSize(5);
                } else {
                    screenConverter.increaseRealSize(-5);
                }
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImagePixelDrawer pd = new BufferedImagePixelDrawer(bi);

        if (figure != null)
            figure.draw(screenConverter, pd, ld, Color.RED);

        markers.forEach(marker ->
                marker.draw(screenConverter, pd, ld, Color.RED));

        g.drawImage(bi, 0, 0, null);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        MyPoint startDraggPoint = screenConverter.screenToReal(e.getPoint());
//        System.out.println("eX");
//        System.out.println(myE.x);
//        System.out.println("eY");
//        System.out.println(myE.y);
//        System.out.println("curX");
//        System.out.println(transMarker.getCurPoint().x);
//        System.out.println("curY");
//        System.out.println(transMarker.getCurPoint().y);
//        System.out.println("cx");
//        System.out.println(transMarker.getCenter().x);
//        System.out.println("cy");
//        System.out.println(transMarker.getCenter().y);
        for (Marker marker :
                markers) {
            if (marker.isFocused()) {
                marker.moveFigure(marker.getCurPoint(), startDraggPoint);
                marker.setCurPoint(startDraggPoint);
                break;
            }
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
