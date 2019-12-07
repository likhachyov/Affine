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

public class DrawPanel extends JPanel implements MouseMotionListener {

    private LineDrawer ld;
    private ScreenConverter screenConverter;
    private Figure figure;
    private TranslationMarker transMarker;
    private RotateMarker rotateMarker;
    private Affine affine;

    public DrawPanel(int width, int height) {
        affine = new Affine();
        ld = new WuLineDrawer();
        screenConverter = new ScreenConverter(width, height, width, height);
        figure = new Rhombus(new MyPoint(0, 0), 300, 500);

        transMarker = new TranslationMarker(figure, affine);
        rotateMarker = new RotateMarker(figure, affine);

        setFocusable(true);
        this.addMouseMotionListener(this);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                MyPoint myE = screenConverter.screenToReal(e.getPoint());
                if (transMarker.inside(myE)){
                    transMarker.setCurPoint(myE);
                    transMarker.setFocused(true);
                }
                else
                    transMarker.setFocused(false);
                if (rotateMarker.inside(myE)){
                    rotateMarker.setCurPoint(myE);
                    rotateMarker.setFocused(true);
                }
                else
                    rotateMarker.setFocused(false);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImagePixelDrawer pd = new BufferedImagePixelDrawer(bi);
        if (figure != null)
            figure.draw(screenConverter, pd, ld, Color.RED);
        transMarker.draw(screenConverter, pd, ld, Color.RED);
        rotateMarker.draw(screenConverter, pd, ld, Color.RED);
        g.drawImage(bi, 0, 0, null);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        MyPoint myE = screenConverter.screenToReal(e.getPoint());
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
        if (transMarker.isFocused()){
            transMarker.moveMarker(transMarker.getCurPoint(), myE);
            transMarker.setCurPoint(myE);
        }
        if (rotateMarker.isFocused()) {
            rotateMarker.moveMarker(rotateMarker.getCurPoint(), myE);
            rotateMarker.setCurPoint(myE);
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
